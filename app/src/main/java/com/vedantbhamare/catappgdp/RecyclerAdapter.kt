package com.vedantbhamare.catappgdp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdapter(val cats: List<CatModel>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    lateinit var context: Context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var breed: TextView = view.findViewById(R.id.breed)
        var img: ImageView = view.findViewById(R.id.catImg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.breed.text = cats[position].name
        Glide.with(context).load(cats[position].image?.url).centerCrop().into(holder.img)
        holder.img.setOnClickListener {
            context.startActivity(Intent(context, CatInfo::class.java).apply {
                putExtra("catinfo", cats[position])
                putExtra("imgUrl", cats[position].image?.url)
            })
        }
    }

    override fun getItemCount(): Int {
        return cats.size
    }

}