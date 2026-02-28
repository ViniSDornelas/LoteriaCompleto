package com.example.loteriaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var numerosViews: List<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSortear = findViewById<Button>(R.id.btnSortear)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        numerosViews = listOf(
            findViewById(R.id.num1),
            findViewById(R.id.num2),
            findViewById(R.id.num3),
            findViewById(R.id.num4),
            findViewById(R.id.num5),
            findViewById(R.id.num6)
        )

        btnSortear.setOnClickListener { sortearNumeros() }
        btnLimpar.setOnClickListener { limparNumeros() }
    }

    private fun sortearNumeros() {
        val numeros = (1..60).shuffled().take(6).sorted()
        for (i in numeros.indices) {
            numerosViews[i].text = numeros[i].toString()
        }
    }

    private fun limparNumeros() {
        numerosViews.forEach { it.text = "" }
    }
}
