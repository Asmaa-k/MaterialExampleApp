package com.example.materialdesignexample.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDialog
import androidx.fragment.app.Fragment
import com.example.materialdesignexample.R
import com.example.materialdesignexample.util.LanguageUtil
import com.example.materialdesignexample.util.Util
import com.google.android.material.bottomsheet.BottomSheetDialog

class SettingsFragment : Fragment() {
    lateinit var langCard: View
    lateinit var themCard: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        langCard = view.findViewById(R.id.ll_lang)
        themCard = view.findViewById(R.id.ll_theme)
        languageSetUP()
        themeSetUp()
        return view
    }

    fun languageSetUP() {
        langCard.setOnClickListener {
            val dialog: AppCompatDialog
            val context: Context = activity as Context
            dialog = BottomSheetDialog(context)
            val contentView = LayoutInflater.from(context).inflate(R.layout.dialog_app_lang, null)
            dialog.setContentView(contentView)
            contentView.findViewById<ImageView>(R.id.iv_close).setOnClickListener {
                dialog.dismiss()
            }
            val radioGroupTheme = contentView.findViewById<RadioGroup>(R.id.lan_group)
            val ar = contentView.findViewById<RadioButton>(R.id.lan_ar)
            val en = contentView.findViewById<RadioButton>(R.id.lan_en)
            if (LanguageUtil.isAr()) {
                ar.isChecked = true
            } else {
                en.isChecked = true
            }

            radioGroupTheme.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    (R.id.lan_ar) -> {
                        LanguageUtil.setAppLanguage(context, LanguageUtil.LANG_AR)
                        refresh()
                        dialog.dismiss()
                    }
                    (R.id.lan_en) -> {
                        LanguageUtil.setAppLanguage(context, LanguageUtil.LANG_EN)
                        refresh()
                        dialog.dismiss()
                    }
                }
            }
            dialog.show()
        }
    }

    fun themeSetUp() {
        themCard.setOnClickListener {
            val dialog: AppCompatDialog
            val context: Context = activity as Context
            dialog = BottomSheetDialog(context)
            val contentView = LayoutInflater.from(context).inflate(R.layout.dialog_app_theme, null)
            dialog.setContentView(contentView)
            contentView.findViewById<ImageView>(R.id.iv_close).setOnClickListener {
                dialog.dismiss()
            }
            val radioGroupTheme = contentView.findViewById<RadioGroup>(R.id.themeGroup)
            val light = contentView.findViewById<RadioButton>(R.id.themeLight)
            val dark = contentView.findViewById<RadioButton>(R.id.themeDark)
            if (Util.isDarkMode(context)) {
                dark.isChecked = true
            } else {
                light.isChecked = true
            }

            radioGroupTheme.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    (R.id.themeDark) -> {
                        Util.setTheme(
                            AppCompatDelegate.MODE_NIGHT_YES,
                            Util.THEME_DARK
                        )
                        dialog.dismiss()
                    }
                    (R.id.themeLight) -> {
                        Util.setTheme(
                            AppCompatDelegate.MODE_NIGHT_NO,
                            Util.THEME_LIGHT
                        )
                        dialog.dismiss()
                    }
                }
            }
            dialog.show()
        }
    }

    fun refresh() {
        activity?.finish()
        startActivity(activity?.intent)
    }
}