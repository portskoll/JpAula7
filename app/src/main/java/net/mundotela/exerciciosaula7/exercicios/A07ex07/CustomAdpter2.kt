package net.mundotela.exerciciosaula7.exercicios.A07ex07

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


class CustomAdpter2(private val context: Context, var dataset: ArrayList<Produto>) : RecyclerView.Adapter<CustomAdpter2.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo = view.findViewById<TextView>(R.id.itemTxtTitulo_ex7)
        val valor = view.findViewById<TextView>(R.id.itemTxtDescricao_ex7)
        val foto = view.findViewById<ImageView>(R.id.item_img_ex7)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itens_produtos,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titulo.text = dataset[position].titulo
        holder.valor.text = dataset[position].descricao
        try {
            Glide.with(context)
                .load(dataset[position].foto)
                .centerCrop()
                .placeholder(R.drawable.progressbaranimation)
                .error(R.drawable.try_later)
                .into(holder.foto)
        } catch (e: Exception) {
            Log.e("TAGImage", "Erro ao carregar imagem", e)
        }

    }

}
