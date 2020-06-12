package com.example.materialdesignexample

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import com.example.materialdesignexample.util.LanguageUtil
import com.example.materialdesignexample.util.Util


class MyApplication : Application() {
   init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
    
    companion object {
        lateinit var Instance: MyApplication

        fun saveSharedPrefernces(value: Int) {
            val editor = Instance.getSharedPreferences(Util.KEY_THEME, Context.MODE_PRIVATE).edit()
            editor.putInt(Util.KEY_DARK, value)
            editor.apply()
        }

        fun saveSharedLangPrefrence(value: String){
            val editor = Instance.getSharedPreferences(LanguageUtil.KEY_LANG, Context.MODE_PRIVATE).edit()
            editor.putString(LanguageUtil.KEY_SELECTED, value)
            editor.apply()
        }

        fun getSharedPrefernces(name: String) : SharedPreferences {
            return Instance.getSharedPreferences(name, Context.MODE_PRIVATE)
        }

        fun setTheme() {
            if (getSavedTheme() == 1) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        private fun getSavedTheme(): Int {
            return getSharedPrefernces(Util.KEY_THEME).getInt(Util.KEY_DARK, 0)
        }
    }

    override fun onCreate() {
        super.onCreate()
        Instance = this
        setTheme()
    }


}