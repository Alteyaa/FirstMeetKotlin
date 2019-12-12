package com.g.firstmeet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var mEditText: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEditText = findViewById<EditText>(R.id.edtText)
        val saveBtn = findViewById<Button>(R.id.btnSave)



        saveBtn.setOnClickListener {

            val mEdittextInfo = mEditText?.getText().toString()

            if (mEdittextInfo.equals("")) {
                mEditText?.error = "Field is empty"
                Toast.makeText(applicationContext, "Please enter some message! ", Toast.LENGTH_SHORT).show()

            } else {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("Text", mEdittextInfo)
                startActivity(intent)

            }

            var intent = intent
            val txtInfo = intent.getStringExtra("SomeText")

            val resultTv = findViewById<TextView>(R.id.resultTv)
            resultTv.text = "Text:  " + txtInfo

        }
    }
}