package com.example.apitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val count_tv = findViewById<TextView>(R.id.textView01)
        val btn_test = findViewById<Button>(R.id.button3)
        var counter = 0
        var result = ""




        btn_test.setOnClickListener{
            counter++
            count_tv.text = counter.toString()
            Thread({
                var result = CallAPI()
                Log.d("res", result!!)
            }).start()
        }
    }

    fun CallAPI(): String? {
        var responseStr  = ""
        val url = URL("https://was.aglcms.com/api/AGLCS/Example")
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"  // optional default is GET

            println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

            inputStream.bufferedReader().use {
                it.lines().forEach { line ->
                    println(line)
                }
            }
        }

        return  responseStr
    }
}