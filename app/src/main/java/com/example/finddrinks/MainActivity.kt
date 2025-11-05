package com.example.finddrinks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findBeer = findViewById<Button>(R.id.find_beer)
        findBeer.setOnClickListener {
            val beerColor = findViewById<Spinner>(R.id.beer_color)
            val color = beerColor.selectedItem
            val beerList = getBeers(color.toString())
            val beers = beerList.reduce { str, item -> str + '\n' + item }
            val brands = findViewById<TextView>(R.id.brands)
            brands.text = beers
        }
    }
    fun getBeers(color: String): List<String> {
        return when (color) {
            "Light" -> listOf("Mojito", "Gin and Tonic", "White Whiskey")
            "Amber" -> listOf("Whiskey on the rocks", "Irish coffee", "Apple cider")
            "Brown" -> listOf("Classic whiskey", "Cognac", "Rum and Cola")
            else -> listOf("Bourbon", "Dark rum", "Port")
        }
    }
}