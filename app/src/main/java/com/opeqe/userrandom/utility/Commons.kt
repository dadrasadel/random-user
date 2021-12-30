package com.opeqe.userrandom.utility

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.bilerplatemvvm.R

import com.muddzdev.styleabletoastlibrary.StyleableToast


object Commons {
     fun showErrorMessage(message:String,context: Context){
        StyleableToast.Builder(context)
            .text(message)
            .textColor(ContextCompat.getColor(context, R.color.colorwhite))
            .backgroundColor(ContextCompat.getColor(context, R.color.colorRedToast))
            .iconStart(R.drawable.ic_toast_cancel)
            .font(R.font.comet_font)
            .show()
    }
     fun showMessage(message:String,context: Context){
        StyleableToast.Builder(context)
            .text(message)
            .textColor(ContextCompat.getColor(context, R.color.colorwhite))
            .backgroundColor(ContextCompat.getColor(context, R.color.colorGreenToast))
            .iconStart(R.drawable.ic_baseline_check_circle_24)
            .font(R.font.comet_font)
            .show()
    }
}