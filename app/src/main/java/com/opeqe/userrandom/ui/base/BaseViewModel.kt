package com.opeqe.userrandom.ui.base

import android.util.Log
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {
    fun useHooking(): Boolean {
        try {
            throw Exception()
        } catch (e: Exception) {
            var zygoteInitCallCount = 0
            var isHookDetecting = false
            for (stackTraceElement in e.stackTrace) {
                if (stackTraceElement.className == "com.android.internal.os.ZygoteInit") {
                    zygoteInitCallCount++
                    if (zygoteInitCallCount == 2) {
                        Log.wtf("HookDetection", "Substrate is active on the device.")
                        isHookDetecting = true
                    }
                }
                if (stackTraceElement.className == "com.saurik.substrate.MS$2" && stackTraceElement.methodName == "invoked") {
                    Log.wtf(
                        "HookDetection",
                        "A method on the stack trace has been hooked using Substrate."
                    )
                    isHookDetecting = true
                }
                if (stackTraceElement.className == "de.robv.android.xposed.XposedBridge" && stackTraceElement.methodName == "main") {
                    Log.wtf("HookDetection", "Xposed is active on the device.")
                    isHookDetecting = true
                }
                if (stackTraceElement.className == "de.robv.android.xposed.XposedBridge" && stackTraceElement.methodName == "handleHookedMethod") {
                    Log.wtf(
                        "HookDetection",
                        "A method on the stack trace has been hooked using Xposed."
                    )
                    isHookDetecting = true
                }
            }
            return isHookDetecting
        }
    }
}