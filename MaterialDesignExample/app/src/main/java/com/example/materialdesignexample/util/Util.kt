package com.example.materialdesignexample.util

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import com.example.materialdesignexample.MyApplication

class Util {
    companion object {
        val KEY_THEME = "prefs.theme"
        val KEY_DARK = "prefs.dark"
        const val THEME_LIGHT = 0
        const val THEME_DARK = 1

        fun isDarkMode(context: Context): Boolean {
            val nightModeFlags =
                context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            return Configuration.UI_MODE_NIGHT_YES == nightModeFlags
        }

        fun setTheme(themeMode: Int, prefsMode: Int) {
            AppCompatDelegate.setDefaultNightMode(themeMode)
            saveTheme(prefsMode)
        }

        fun saveTheme(prefsMode: Int) {
            MyApplication.saveSharedPrefernces(prefsMode)
        }
    }
}