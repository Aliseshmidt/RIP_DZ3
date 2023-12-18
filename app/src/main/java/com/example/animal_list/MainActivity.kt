package com.example.planet_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder

data class Planet(val name: String, val url: String)

class MainActivity : AppCompatActivity() {

    private lateinit var planets: List<Planet>
    private lateinit var rv: RecyclerView
    private lateinit var adapter: PlanetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.recycler)
        adapter = PlanetAdapter(planets)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter

        loadData()
    }

    private fun loadData() {
        val resultString = application.assets
            .open("planets.json")
            .bufferedReader()
            .use { it.readText() }
        val gson = GsonBuilder().create()
        planets = gson.fromJson(resultString, Array<Planet>::class.java).toList()
        adapter.updateData(planets)
    }
}