package com.example.regularnotes

import android.content.Intent


interface OnClickInterface {

    fun createIntent(): Intent

    fun goToActivity(intent: Intent)

}