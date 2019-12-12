package com.g.firstmeet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {


    private var mEditTxt2: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


          mEditTxt2 = findViewById<EditText>(R.id.edtTxtSecond)
        val saveBtn2 = findViewById<Button>(R.id.btnSave2)


        saveBtn2.setOnClickListener {

            val txtInfo = mEditTxt2?.getText().toString()

            if (txtInfo.equals("")) {
                mEditTxt2?.error = "Field is empty"
                Toast.makeText(applicationContext, "Please enter some message! ", Toast.LENGTH_SHORT).show()

            } else {
                val intent = Intent(this@SecondActivity, MainActivity::class.java)
                intent.putExtra("SomeText", txtInfo)
                startActivity(intent)
            }
            var intent = intent
            val mEditTextInfo = intent.getStringExtra("Text")

            val infoTv = findViewById<TextView>(R.id.txtInfo)
            infoTv.text = "Text:" + mEditTextInfo
        }

    }
}
