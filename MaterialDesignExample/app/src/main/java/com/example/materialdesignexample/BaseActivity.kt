package com.example.materialdesignexample

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.materialdesignexample.util.LanguageUtil


abstract class BaseActivity : AppCompatActivity() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(
            LanguageUtil.customConfig(
                base, LanguageUtil.getAppLang() ?: LanguageUtil.LANG_EN
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}