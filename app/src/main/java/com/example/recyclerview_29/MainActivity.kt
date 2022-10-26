package com.example.recyclerview_29

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerview_29.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    private val imageIdList = listOf(
        R.drawable.plant_1,
        R.drawable.plant_2,
        R.drawable.plant_3,
        R.drawable.plant_4,
        R.drawable.plant_5,
        R.drawable.plant_6
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        binding.recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        binding.recyclerView.adapter = adapter
        binding.buttonAdd.setOnClickListener {
            if (index > 5){
                index = 0
            }
            val plant = Plant(imageIdList[index], "Plant $index")
            adapter.addPlant(plant)
            index++
        }
    }
}