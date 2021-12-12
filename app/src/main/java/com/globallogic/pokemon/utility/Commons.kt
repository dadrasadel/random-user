package com.globallogic.pokemon.utility

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.view.Window
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.bilerplatemvvm.R
import com.google.android.material.bottomsheet.BottomSheetBehavior

import com.google.android.material.bottomsheet.BottomSheetDialog
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