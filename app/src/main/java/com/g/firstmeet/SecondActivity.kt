package com.g.firstmeet

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast



class SecondActivity : AppCompatActivity() {


    private lateinit var mEditTxt2: EditText
    private lateinit var saveBtn: Button
    private lateinit var infoTv: String
    private lateinit var txtInfo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        mEditTxt2 = findViewById<EditText>(R.id.edtTxtSecond)
        saveBtn = findViewById<Button>(R.id.btnSave2)

        saveBtn.setOnClickListener {

            backInfo()
        }
            infoTv = intent.getStringExtra("text")
            mEditTxt2.setText(infoTv)

        }

        private fun backInfo (){
             txtInfo = mEditTxt2.text.toString()

            if (notNull(txtInfo)){
                setResult(Activity.RESULT_OK, Intent(this, MainActivity::class.java).putExtra("Changing", txtInfo))
                finish()
            } else{
                Toast.makeText(this, "Пожалуйста заполните поле", Toast.LENGTH_LONG).show()
            }
        }

    private fun notNull(text: String?):Boolean{
        return text != null

    }
}
