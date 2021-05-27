




package com.example.basic

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        to1.text = intent.getStringExtra("form1")
        to2.text = "${intent.getIntExtra("form2", 0)}"

        btn2.setOnClickListener {
            val returnIntent= Intent()
            returnIntent.putExtra("toyou",sub.text.toString())
            setResult(Activity.RESULT_OK,returnIntent)
            finish()
        }

    }


}