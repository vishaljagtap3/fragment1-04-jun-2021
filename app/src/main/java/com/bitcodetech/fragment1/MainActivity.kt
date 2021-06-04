package com.bitcodetech.fragment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    lateinit var edtText: EditText
    lateinit var btnSetText: Button

    lateinit var tcsFragment1: TextCaseSwitcherFragment
    lateinit var tcsFragment2: TextCaseSwitcherFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        edtText = findViewById(R.id.edtText)
        btnSetText = findViewById(R.id.btnSetText)

        //obtain references to the fragments which are already part of activity
        tcsFragment1 =
            supportFragmentManager.findFragmentById(R.id.tcsFragment1) as TextCaseSwitcherFragment
        tcsFragment2 =
            supportFragmentManager.findFragmentById(R.id.tcsFragment2) as TextCaseSwitcherFragment

        btnSetText.setOnClickListener(BtnSetTextClickListener())
    }

    inner private class BtnSetTextClickListener : View.OnClickListener {
        override fun onClick(v: View?) {
            tcsFragment1.text = edtText.text.toString()
            tcsFragment2.text = edtText.text.toString()
        }
    }
}