package com.acabes.mvvmapp.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acabes.mvvmapp.R
import com.acabes.mvvmapp.model.HarryPotterCharacter
import com.squareup.picasso.Picasso

class MyAdapter(private val items: List<HarryPotterCharacter>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image=itemView.findViewById<ImageView>(R.id.item_img)
        val charName=itemView.findViewById<TextView>(R.id.item_name)
        val species=itemView.findViewById<TextView>(R.id.item_species)
        val wizard=itemView.findViewById<TextView>(R.id.item_wizard)
        val student=itemView.findViewById<TextView>(R.id.item_student)
        val staff=itemView.findViewById<TextView>(R.id.item_staff)
        val house=itemView.findViewById<TextView>(R.id.item_house)
        val ancestry=itemView.findViewById<TextView>(R.id.item_ancestry)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.list_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items[position]
        val errorImg=R.drawable.error
        holder.charName.text=item.name
        holder.species.text=item.species
        holder.ancestry.text=item.ancestry
        holder.student.text=item.hogwartsStudent
        holder.house.text=item.house
        holder.staff.text=item.hogwartsStaff
        holder.wizard.text=item.wizard.toString()
        Picasso.get()
            .load(item.image)
            .error(errorImg)
            .into(holder.image)
    }

    override fun getItemCount(): Int =items.size
}
