package com.example.planet_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PlanetAdapter(var planetList: List<Planet>) : RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder>() {

    class PlanetViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val planetName: TextView = view.findViewById(R.id.planet_name)
        val planetImage: ImageView = view.findViewById(R.id.planet_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.planet_item, parent, false)
        return PlanetViewHolder(view)
    }

    override fun getItemCount() = planetList.size

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        holder.planetName.text = planetList[position].name
        Picasso.get().load(planetList[position].imageUrl).into(holder.planetImage)
    }

    fun updateData(newPlanetList: List<Planet>) {
        planetList = newPlanetList
        notifyDataSetChanged()
    }
}