package com.example.farukov_pr_18_19

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //Создаем массив разделов:
    private val titles = arrayOf(
        "1. Kotlin",
        "2. Python",
        "3. C#",
        "4. Pascal",
        "5. PHP",
        "6. C++",
        "7. Java",
        "8. JavaScript"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.listView)
        listView.adapter = ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1, titles)
        listView.isTextFilterEnabled = true

        listView.onItemClickListener =
            OnItemClickListener { a, v, position, id ->
                val intent = Intent()
                intent.setClass(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("title", position)

                startActivity(intent)
            }
    }
}