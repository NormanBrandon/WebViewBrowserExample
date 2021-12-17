package com.nprmanbrandons11.webview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabColorSchemeParams








class MainActivity : AppCompatActivity() {
    //private val DISTILER ="chrome-distiller://https://shugar.app/politica_de_privacidad/"
    private val BASE_URL = "https://shugar.app/politica_de_privacidad/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn :Button = findViewById(R.id.button);
        val btn2 :Button = findViewById(R.id.button2);
        val btn3 :Button = findViewById(R.id.button3);
        val wb : WebView = findViewById(R.id.wb)
        wb.webChromeClient = object: WebChromeClient(){

        }
        wb.webViewClient = object : WebViewClient(){


        }
        val settings = wb.settings
        settings.javaScriptEnabled = true



        btn.setOnClickListener {
            wb.loadUrl(BASE_URL)
            Toast.makeText(this,"web launch",Toast.LENGTH_SHORT).show()
        }
        btn2.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(BASE_URL))
            this.startActivity(Intent.createChooser(browserIntent, "Choose browser"))
            //startActivity(browserIntent)

        }
        btn3.setOnClickListener {

            val colorInt: Int = Color.parseColor("#FF0000") //red

            val defaultColors = CustomTabColorSchemeParams.Builder()
                .setToolbarColor(colorInt)
                .build()

            val builder = CustomTabsIntent.Builder()
            builder.setDefaultColorSchemeParams(defaultColors)

            val customTabsIntent = builder.build()
            builder.setUrlBarHidingEnabled(false)
            customTabsIntent.launchUrl(this, Uri.parse(BASE_URL))

        }


    }


}