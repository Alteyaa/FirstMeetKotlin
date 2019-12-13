package com.g.firstmeet

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var mEditText: EditText
    private lateinit var sendText: String
    private lateinit var txtInfo: String
    private val REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEditText = findViewById<EditText>(R.id.edtText)
        val saveBtn = findViewById<Button>(R.id.btnSave)



        saveBtn.setOnClickListener {

          send()
        }
    }
        private fun send(){
        sendText = mEditText.text.toString()
        if (notNull(sendText)){
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("text", sendText)
                startActivityForResult(intent, REQUEST_CODE)
            } else{
                Toast.makeText(this, "Пожалуйста, заполните поле", Toast.LENGTH_LONG).show()
            }
        }

        private fun notNull(text: String):Boolean{
            return text != ""
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
                txtInfo = data!!.getStringExtra("returnText")
                if (!sendText.equals(txtInfo)){
                    Toast.makeText(this, "Данные из Second Activity были изменены с $sendText на $txtInfo", Toast.LENGTH_LONG).show()
                }
            }
}}