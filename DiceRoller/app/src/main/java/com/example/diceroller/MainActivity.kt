package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // chamada do botão para o método rollDice
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // dado inicial antes de qualquer clique
        rollDice()
    }

    // método para definição da imagem a partir do número gerado
    private fun rollDice() {
        // dado instanciado da classe Dice
        val dice = Dice(6)
        // variável com resultado do método roll
        val diceRoll = dice.roll()
        // atribuição do imageView à variável diceImage
        val diceImage: ImageView = findViewById(R.id.imageView)
        /* estrutura condicional para alocação de imagem na váriavel drawableResource a partir do
         resultado do método roll armazenado em diceRoll
         */
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // atribuição do diceImage a partir do drawableResource
        diceImage.setImageResource(drawableResource)
        // chamada para mostrar o número
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
        // descrição do texto com o resultado do método roll
        resultTextView.contentDescription = diceRoll.toString()
    }
}

// Classe dado
class Dice(private val numberOfSides: Int) {
    // função para execução de número aleatório
    fun roll(): Int {
        return (1..numberOfSides).random()
    }
}