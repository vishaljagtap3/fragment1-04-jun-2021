package com.bitcodetech.fragment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListPopupWindow
import android.widget.TextView
import androidx.fragment.app.Fragment


class TextCaseSwitcherFragment : Fragment() {

    val TEXT_CASE_UPPER = 1
    val TEXT_CASE_LOWER = 2

    lateinit var txtInfo: TextView
    var textCase = TEXT_CASE_UPPER

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        txtInfo = TextView(context);
        txtInfo.layoutParams = ViewGroup.LayoutParams(
            ListPopupWindow.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        txtInfo.textSize = 30F
        txtInfo.text = "BITCODE-ANDROID"
        //txtInfo.paddingLeft = TypedValue.complexToDimension(30, TypedValue.COMPLEX_UNIT_DIP) as Int
        txtInfo.setOnClickListener(TxtInfoClickListener())
        return txtInfo
    }

    var text : String = ""
    get() = field
    set(value) {
        if( textCase == TEXT_CASE_UPPER) field = value.toString().toUpperCase() else field = value.toString().toLowerCase()
        txtInfo.text = field
    }

    inner private class TxtInfoClickListener : View.OnClickListener {
        override fun onClick(v: View?) {
            when( textCase ) {
                TEXT_CASE_UPPER -> {
                    txtInfo.text = txtInfo.text.toString().toLowerCase()
                    textCase = TEXT_CASE_LOWER
                }
                TEXT_CASE_LOWER -> {
                    txtInfo.text = txtInfo.text.toString().toUpperCase()
                    textCase = TEXT_CASE_UPPER
                }
            }
        }
    }
}









