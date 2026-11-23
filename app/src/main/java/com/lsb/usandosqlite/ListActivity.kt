package com.lsb.usandosqlite

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SimpleCursorAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lsb.usandosqlite.adapter.ElementoListaAdapter
import com.lsb.usandosqlite.database.DatabaseHandler
import com.lsb.usandosqlite.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private lateinit var banco: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        banco = DatabaseHandler.getInstance(this)

        montarListaInicial()
    }

    private fun montarListaInicial() {
        /*val registros = listOf<String>(
            "Brasil",
            "Argentina",
            "Paraguai",
            "Uruguai"
        )

        val adapter = ArrayAdapter(
            this, //quem esta mantendo a tela
            android.R.layout.simple_list_item_1, //destino dos dados
            registros //origem dos dados
        )

        binding.lvCadastro.adapter = adapter

         */

        /*val registros = banco.listarCursor()

        val adapter = SimpleCursorAdapter(
            this,
            android.R.layout.simple_list_item_1,
            registros,
            arrayOf("nome"),
            intArrayOf(android.R.id.text1),
            0
        )

        binding.lvCadastro.adapter = adapter*/

        val registros = banco.listar()

        val adapter = ElementoListaAdapter(this, registros)

        binding.lvCadastro.adapter = adapter

    }
}