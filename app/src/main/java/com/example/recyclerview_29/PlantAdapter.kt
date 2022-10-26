package com.example.recyclerview_29

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_29.databinding.PlantItemBinding

class PlantAdapter : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    private val plantList = ArrayList<Plant>()

    class PlantViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = PlantItemBinding.bind(item)
        fun bind(plant: Plant) {
            binding.imageViewPlant.setImageResource(plant.imageId)
            binding.textViewTitle.text = plant.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind(plantList[position])
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addPlant(plant: Plant){
        plantList.add(plant)
        notifyDataSetChanged()
    }
}