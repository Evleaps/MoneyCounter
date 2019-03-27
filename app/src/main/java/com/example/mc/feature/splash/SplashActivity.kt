package com.example.mc.feature.splash

import android.os.Bundle
import com.example.mc.R
import com.example.mc.core.presentation.BaseActivity
import com.example.mc.core.router.IRouter
import com.example.mc.core.router.Router
import org.koin.android.ext.android.inject

class SplashActivity : BaseActivity<SplashContract.Presenter>(), SplashContract.View {

    override val presenter: SplashPresenter by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}
