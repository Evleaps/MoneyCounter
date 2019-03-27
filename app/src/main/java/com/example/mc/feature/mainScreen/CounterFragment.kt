package com.example.mc.feature.mainScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mc.R
import com.example.mc.common.LOG_PREFIX
import com.example.mc.core.presentation.BaseFragment
import org.koin.android.ext.android.inject

class CounterFragment : BaseFragment<CounterContract.Presenter>(), CounterContract.View {

    override val presenter: CounterPresenter by inject()

    companion object {
        @JvmStatic val TAG = LOG_PREFIX + CounterFragment::class.java.simpleName
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_counter, container, false)

        return rootView
    }

    override fun showTotal() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}