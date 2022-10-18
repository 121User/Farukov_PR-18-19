package com.example.farukov_pr_18_19

import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)

        //val webView: WebView = findViewById(R.id.webView)

        val intent = intent
        //получаем строку и формируем имя ресурса
        val resName = "n" + intent.getIntExtra("title", 0)

        val context: Context = baseContext

        //читаем текстовый файл из ресурсов по имени
        val text: String = readRawTextFile(
            context, resources.getIdentifier(
                resName,
                "raw", "com.example.farukov_pr_18_19"
            )
        )

        //webView.loadDataWithBaseURL(null, text, "text/html", "en_US", null)
        //webView.loadDataWithBaseURL("file:///android_res/drawable/kotlin.png", "", "image/jpeg", null, "file:///android_res/drawable/kotlin.png");
// Для изменения TextView2
        when(intent.getIntExtra("title", 0)){
            0 -> title2.text = "Kotlin"
            1 -> title2.text = "Python"
            2 -> title2.text = "C#"
            3 -> title2.text = "Pascal"
            4 -> title2.text = "PHP"
            5 -> title2.text = "C++"
            6 -> title2.text = "Java"
            7 -> title2.text = "JavaScript"
        }
        title3.text = text
// Для изменения ImageView
        var imageView: ImageView
        imageView = findViewById(R.id.imageView)

        when(intent.getIntExtra("title", 0)){
            0 -> imageView.setImageResource(R.drawable.kotlin)
            1 -> imageView.setImageResource(R.drawable.python)
            2 -> imageView.setImageResource(R.drawable.c_)
            3 -> imageView.setImageResource(R.drawable.pascal)
            4 -> imageView.setImageResource(R.drawable.php)
            5 -> imageView.setImageResource(R.drawable.c__)
            6 -> imageView.setImageResource(R.drawable.java)
            7 -> imageView.setImageResource(R.drawable.javascript)
        }
        imageView.width
    }

    //читаем текст из raw-ресурсов
    private fun readRawTextFile(context: Context, resId: Int): String {
        val inputStream: InputStream = context.resources.openRawResource(resId)
        val inputReader = InputStreamReader(inputStream)
        val buffReader = BufferedReader(inputReader)
        var line: String?
        val builder = StringBuilder()
        try {
            while (buffReader.readLine().also { line = it } != null) {
                builder.append(line)
                builder.append("\n")
            }
        } catch (e: IOException) {
            return e.localizedMessage
        }
        return builder.toString()
    }
}