package com.example.materialdesignexample.util

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import com.example.materialdesignexample.MyApplication
import java.util.*


class LanguageUtil {

    companion object {
        val LANG_AR = "ar"
        val LANG_EN = "en"
        val KEY_LANG = "prefs.lang"
        val KEY_SELECTED = "prefs.lang.selected"
        fun customConfig(context: Context, lang: String): Context {
            // Configuration.setLocale is added after 17 and Configuration.locale is deprecated after 24
            val local = Locale(lang)
            if (Build.VERSION.SDK_INT >= 17) {
                val config = Configuration()
                config.setLocale(local)
                config.setLayoutDirection(local)
                return context.createConfigurationContext(config)
            } else {
                val res = context.resources
                val config = Configuration(res.configuration)
                config.setLocale(local)
                config.setLayoutDirection(local)
                res.updateConfiguration(config, res.displayMetrics)
                return context
            }
        }

        fun isAr(): Boolean {
            return LANG_AR == getAppLang()
        }

        fun getAppLang(): String? {
            var lang = MyApplication.getSharedPrefernces(KEY_LANG).getString(KEY_SELECTED, LANG_EN)
            if (lang == null || lang.isEmpty()) {
                lang = Locale.getDefault().displayLanguage
            }
            return lang
        }

        fun setAppLanguage(context: Context, lang: String) {
            MyApplication.saveSharedLangPrefrence(lang)
            switchTo(context, lang)
        }

        fun switchTo(context: Context, lang: String) {
            val locale = Locale(lang)
            Locale.setDefault(locale)
            customConfig(context, lang)

        }
    }
}