package com.lsb.usandosqlite.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.lsb.usandosqlite.R
import com.lsb.usandosqlite.entity.Cadastro

class ElementoListaAdapter(val context: Context, val registros: MutableList<Cadastro>): BaseAdapter() {
    override fun getCount(): Int {
        return registros.size
    }

    override fun getItem(pos: Int): Any? {
        return registros.get(pos)
    }

    override fun getItemId(pos: Int): Long {
        return registros.get(pos).id.toLong()
    }

    override fun getView(
        pos: Int,
        p1: View?,
        p2: ViewGroup?
    ): View? {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = inflater.inflate(R.layout.elemento_lista, null)

        val ivIconeElementoLista = view.findViewById<ImageView>(R.id.ivIconeElementoLista)
        val tvNomeElementoLista = view.findViewById<TextView>(R.id.tvNomeElementoLista)
        val tvTelefoneElementoLista = view.findViewById<TextView>(R.id.tvTelefoneElementoLista)
        val btEditarElementoLista = view.findViewById<ImageButton>(R.id.btEditarElementoLista)

        tvNomeElementoLista.text = registros[pos].nome
        tvTelefoneElementoLista.text = registros[pos].telefone

        return view
    }
}