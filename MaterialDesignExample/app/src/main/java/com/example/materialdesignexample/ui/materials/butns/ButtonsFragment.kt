package com.example.materialdesignexample.ui.materials.butns

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.materialdesignexample.R
import com.google.android.material.button.MaterialButtonToggleGroup


class ButtonsFragment : Fragment() {
    lateinit var toggleBtnGroup: MaterialButtonToggleGroup
    lateinit var testText: TextView
    lateinit var btnNormal : Button; lateinit var btnNormalIcon : Button
    lateinit var btnOutLine : Button; lateinit var btnOutLineIcon : Button
    lateinit var btnText : Button; lateinit var btnTextIcon : Button
    lateinit var textFormat: TextFormat
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_buttons, container, false)
        toggleBtnGroup = v.findViewById(R.id.groupBtn)
        testText = v.findViewById(R.id.test_txt)
        btnNormal = v.findViewById(R.id.normalBtn)
        btnNormalIcon = v.findViewById(R.id.normalBtnIcn)
        btnOutLine = v.findViewById(R.id.outlineBtn)
        btnOutLineIcon = v.findViewById(R.id.outlineBtnIcn)
        btnText = v.findViewById(R.id.txtBtn)
        btnTextIcon = v.findViewById(R.id.txtBtnIcn)
        textFormat =
            TextFormat(false, false, false)

        setUpOtherBtns()
        toggleListenerSetUp()

        return v
    }

    private fun setUpOtherBtns(){
        btnNormal.setOnClickListener { Toast.makeText(activity, btnNormal.text, Toast.LENGTH_SHORT).show() }
        btnNormalIcon.setOnClickListener { Toast.makeText(activity, btnNormalIcon.text, Toast.LENGTH_SHORT).show() }
        btnOutLine.setOnClickListener { Toast.makeText(activity, btnOutLine.text, Toast.LENGTH_SHORT).show() }
        btnOutLineIcon.setOnClickListener { Toast.makeText(activity, btnOutLineIcon.text, Toast.LENGTH_SHORT).show() }
        btnText.setOnClickListener { Toast.makeText(activity, btnText.text, Toast.LENGTH_SHORT).show() }
        btnTextIcon.setOnClickListener { Toast.makeText(activity, btnTextIcon.text, Toast.LENGTH_SHORT).show() }

    }
    private fun toggleListenerSetUp() {
        //We are adding a button checked listener to the toggle group
        toggleBtnGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if (isChecked) {
                val testString = testText.text
                val spanString = SpannableString(testString)
                spanString.setSpan(UnderlineSpan(), 0, spanString.length, 0)

                when (checkedId) {
                    R.id.italic -> {
                        textFormat.isIalic = true
                        spanString.setSpan(StyleSpan(Typeface.ITALIC), 0, spanString.length, 0)
                    }

                    R.id.bold -> {
                        textFormat.isBold = true
                        spanString.setSpan(StyleSpan(Typeface.BOLD), 0, spanString.length, 0)
                    }
                    R.id.underline -> {
                        textFormat.isUnderline = true
                        spanString.setSpan(UnderlineSpan(), 0, spanString.length, 0)
                    }
                }
                testText.text = spanString
            } else {
                //Something is unchecked

                when (checkedId) {
                    R.id.italic -> {
                        textFormat.isIalic = false
                        resetText()
                    }
                    R.id.bold -> {
                        textFormat.isBold = false
                        resetText()
                    }
                    R.id.underline -> {
                        textFormat.isUnderline = false
                        resetText()
                    }
                }

            }
        }
    }

    fun resetText(){
        val testString = activity?.getString(R.string.test_txt)
        val spanString = SpannableString(testString)
        spanString.setSpan(UnderlineSpan(), 0, spanString.length, 0)
        if(textFormat.isIalic){
            spanString.setSpan(StyleSpan(Typeface.ITALIC), 0, spanString.length, 0)
        }
        if(textFormat.isBold){
            spanString.setSpan(StyleSpan(Typeface.BOLD), 0, spanString.length, 0)
        }
        if(textFormat.isUnderline){
            spanString.setSpan(UnderlineSpan(), 0, spanString.length, 0)
        }
        testText.text = spanString
    }
}