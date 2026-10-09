package com.example.myapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Toast
import android.net.Uri

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)

        val buttonOpen = findViewById<Button>(R.id.buttonOpen)

        buttonOpen.setOnClickListener {
            val text = editText.text.toString()
            if (text.isEmpty()) {
                Toast.makeText(this, "Введите текст", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("message", text)
            startActivity(intent)
        }

        val buttonCall = findViewById<Button>(R.id.buttonCall)

        buttonCall.setOnClickListener {
            val phone = editText.text.toString().trim()
            if (phone.isEmpty()) {
                Toast.makeText(this, "Введите номер", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val uri = Uri.parse("tel:$phone")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        val buttonShare = findViewById<Button>(R.id.buttonShare)

        buttonShare.setOnClickListener {
            val text = editText.text.toString().trim()
            if (text.isEmpty()) {
                Toast.makeText(this, "Введите текст", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, text)
            startActivity(Intent.createChooser(intent, "Поделиться через"))
        }
    }
}