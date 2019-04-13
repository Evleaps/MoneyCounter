package com.example.mc.common.utils

import android.content.Context

data class AlertParamsItem(
    val context: Context,
    val titleResId: Int,
    val msgResId: Int,
    val posBtnResId: Int,
    val negBtnResId: Int
)