package com.example.challenge.utils

import android.content.Context
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.example.challenge.BuildConfig

object Extensions {
    fun String.isEmailValid(): Boolean {
        return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    fun String.isPasswordValid(): Boolean {
        return !TextUtils.isEmpty(this) && this.length >= 6
    }

    fun String.isUsernameValid(): Boolean {
        return !TextUtils.isEmpty(this) && this.length >= 3
    }

    fun Context.showLongToast(message: String) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_LONG
        ).show()
    }

    fun String.baseImageUrl(): String {
        return BuildConfig.BASE_IMAGE_URL + this
    }
}