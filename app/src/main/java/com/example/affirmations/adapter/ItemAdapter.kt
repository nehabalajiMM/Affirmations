package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.data.DataSource

class ItemAdapter(private val context: Context):
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.text_view)
    }

    val affirmations = DataSource().affirmations

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(setLayoutInflater(parent))
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = affirmations.get(position)
        holder.textView.text =  context.getString(item)
    }

    override fun getItemCount(): Int {
        return affirmations.size
    }

    inline fun setLayoutInflater(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
    }
}