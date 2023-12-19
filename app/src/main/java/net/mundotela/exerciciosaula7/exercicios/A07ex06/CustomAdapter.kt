package net.mundotela.exerciciosaula7.exercicios.A07ex06

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import net.mundotela.exerciciosaula7.R


class CustomAdapter(var arr: Array<String>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView = view.findViewById<TextView>(R.id.itemTextView)
            val item = view.findViewById<FrameLayout>(R.id.itemFrame)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.text_row_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = arr[position]
        holder.item.setOnClickListener(){
            holder.textView.text = "Clicou : ${arr[position]}"
        }
    }

    override fun getItemCount(): Int {
        return arr.size
    }

}
