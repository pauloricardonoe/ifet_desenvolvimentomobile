package com.example.atividade2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val EdtQtd = findViewById<EditText>(R.id.EdtQtd)
        val CbUnDestino = findViewById<Spinner>(R.id.CbUnDestino)
        val CbUnOrigem = findViewById<Spinner>(R.id.CbUnOrigem)
        val BtCalcular = findViewById<Button>(R.id.BtCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        val adapter =
            ArrayAdapter.createFromResource(this, R.array.unidmedidas, android.R.layout.simple_spinner_dropdown_item)

        CbUnDestino.adapter = adapter
        CbUnOrigem.adapter = adapter

        BtCalcular.setOnClickListener {
            val sQuantidade = EdtQtd.text.toString()
            if (sQuantidade.isEmpty()) {
                Toast.makeText(this, "Informe a Quantidade Corretamente", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var resultado: Double = sQuantidade.toDouble()
            val origem = CbUnOrigem.selectedItem.toString()
            val destino = CbUnDestino.selectedItem.toString()

            val toMetro = when (origem) {
                "MM" -> 0.001
                "CM" -> 0.01
                "DM" -> 0.1
                "M" -> 1
                "DAM" -> 10
                "HM" -> 100
                "KM" -> 1000
                else -> 0
            }

            val toDestino = when (destino) {
                "MM" -> 1000
                "CM" -> 100
                "DM" -> 10
                "M" -> 1
                "DAM" -> 0.1
                "HM" -> 0.01
                "KM" -> 0.001
                else -> 0
            }

            resultado *= toMetro.toDouble() * toDestino.toDouble()

            tvResultado.text = resultado.toString()
        }
    }
}