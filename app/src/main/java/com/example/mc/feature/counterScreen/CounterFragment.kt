package com.example.mc.feature.counterScreen

import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GravityCompat
import com.example.mc.R
import com.example.mc.core.presentation.BaseFragment
import com.example.mc.core.presentation.Layout
import com.example.mc.feature.common.dialogs.showGiveDefaultPayment
import com.example.mc.feature.common.dialogs.showGivePayment
import com.example.mc.feature.common.dialogs.showIncorrectNumberDialog
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_counter_container.*
import kotlinx.android.synthetic.main.fragment_counter_content.*
import org.koin.android.ext.android.inject

@Layout(R.layout.fragment_counter_container)
class CounterFragment : BaseFragment<CounterContract.Presenter>(), CounterContract.View, NavigationView.OnNavigationItemSelectedListener {

    override val presenter: CounterPresenter by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        payment_btn.setOnClickListener {
            presenter.addRegularPayment()
        }

        payment_btn.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> payment_btn_animation.startRippleAnimation()
                MotionEvent.ACTION_UP -> payment_btn_animation.stopRippleAnimation()
                else -> {}
            }
             v?.onTouchEvent(event) ?: true
        }

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun showGiveDefaultPaymentDialog() {
        showGiveDefaultPayment(context!!) { monthPayment ->
            presenter.saveDefaultPayment(monthPayment)
        }
    }

    override fun showGivePaymentDialog() {
        showGivePayment(context!!) { monthPayment ->
            presenter.addNewPayment(monthPayment)
        }
    }

    override fun showIncorrectCodeDialog(isDefaultPayment: Boolean) {
        showIncorrectNumberDialog(context!!) {
            if (isDefaultPayment) showGiveDefaultPaymentDialog()
            else showGivePaymentDialog()
        }
    }

    override fun showTotal(total: Long) {
        totalPayments.text = context?.getString(R.string.totalInRub, total.toString())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.default_payment_menu -> presenter.onDefaultPaymentBtn()
        }

        drawerlayout.closeDrawer(GravityCompat.START)
        return true
    }
}
