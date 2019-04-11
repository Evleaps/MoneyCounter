package com.example.mc.feature.splashScreen

import android.os.Bundle
import com.example.mc.R
import com.example.mc.core.presentation.BaseActivity
import com.example.mc.core.presentation.Layout
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.android.support.SupportAppNavigator

@Layout(R.layout.layout_container)
class SplashActivity : BaseActivity<SplashContract.Presenter>(), SplashContract.View {

    override val presenter: SplashPresenter by inject()
    private val navigator = SupportAppNavigator(this, R.id.mainContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.setNavigator(navigator)
    }
}
