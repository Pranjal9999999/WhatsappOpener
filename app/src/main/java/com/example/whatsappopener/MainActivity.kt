package com.example.whatsappopener

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.text.isDigitsOnly

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var number:String
        if(intent.action== Intent.ACTION_PROCESS_TEXT)
        {
            number=intent.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT).toString()

        }
        if(!number.isDigitsOnly())
        {
            Toast.makeText(this,"Please check the number", Toast.LENGTH_SHORT).show()

        }
        else
            startWhatsapp(number)

    }
    private fun startWhatsapp(number :String)
    {
        val intent= Intent(Intent.ACTION_VIEW)
        intent.setPackage("com.whatsapp")
        intent.data= Uri.parse("https://api.whatsapp.com/send?phone=$number")
        if(packageManager.resolveActivity(intent,0)!=null)
            startActivity(intent)
        else
            Toast.makeText(this,"Install whatsapp",Toast.LENGTH_SHORT).show()
        finish()
    }
}