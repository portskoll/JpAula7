package net.mundotela.exerciciosaula7.exercicios.A08ex04

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import net.mundotela.exerciciosaula7.R

class CustonAdpeter3(private val context: Context, var dataset: ArrayList<UserRandom>) : RecyclerView.Adapter<CustonAdpeter3.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nome = view.findViewById<TextView>(R.id.item_txt_nome_lista_ru)
        val email = view.findViewById<TextView>(R.id.item_txt_email_lista_ru)
        val img = view.findViewById<ImageView>(R.id.item_img_lista_ru)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tens_lista_random_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nome.text = dataset[position].nome
        holder.email.text = dataset[position].email
        try {
            Glide.with(context)
                .load(dataset[position].foto)
                .centerCrop()
                .placeholder(R.drawable.progressbaranimation)
                .error(R.drawable.try_later)
                .into(holder.img)
        } catch (e: Exception) {
            Log.e("TAGImage", "Erro ao carregar imagem", e)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}
