package com.nadyaka.multiscreen

import android.R
import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast


class MainActivity : ListActivity() {
    val countries = arrayOf("Аргентина", "Бразилия", "Чили", "Колумбия", "Уругвай")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter: ArrayAdapter<String>
        adapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1, countries)
        listAdapter = adapter

        val listener = AdapterView.OnItemClickListener(){ adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
            val text = countries[i]
            val intent: Intent? = when (i){
                0 -> {
                    Intent(this, Argentina::class.java)
                }
                1 -> {
                    Intent(this, Brazilia::class.java)
                }
                2 -> {
                    Intent(this, Chili::class.java)
                }
                3 -> {
                    Intent(this, Columbia::class.java)
                }
                else -> {
                    Toast.makeText(this, "No intent for this item", Toast.LENGTH_LONG).show()
                    null
                }
            }
            intent?.let {
                startActivity(intent)
                Toast.makeText(this, text, Toast.LENGTH_LONG).show()
            }
        }

        listView.setOnItemClickListener(listener)

    }
}