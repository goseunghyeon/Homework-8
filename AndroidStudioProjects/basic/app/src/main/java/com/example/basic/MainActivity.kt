package com.example.basic

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import android.widget.Toast.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun loadDate(): MutableList<Memo> {
            val data:MutableList<Memo> = mutableListOf()
            for(no in 1..100){
                val title="this is kotlin android ${no+1}"
                val date=System.currentTimeMillis()
                var memo=Memo(no,title, date)
                data.add(memo)
            }
            return data;
        }

    }

}
