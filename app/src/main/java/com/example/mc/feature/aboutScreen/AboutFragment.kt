package com.example.mc.feature.aboutScreen

import com.example.mc.R
import com.example.mc.core.presentation.BaseFragment
import com.example.mc.core.presentation.Layout
import kotlinx.android.synthetic.main.fragment_about_card_version.*
import org.koin.android.ext.android.inject

@Layout(R.layout.fragment_about)
class AboutFragment : BaseFragment<AboutContract.Presenter>(), AboutContract.View {
    override val presenter: AboutPresenter by inject()

    override fun displayApplicationVersion(version: String) {
        about_version.text = getString(R.string.app_version, version)
    }
}
