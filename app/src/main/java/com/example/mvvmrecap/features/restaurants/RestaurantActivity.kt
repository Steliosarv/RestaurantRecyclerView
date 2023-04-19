package com.example.mvvmrecap.features.restaurants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmrecap.R
import com.example.mvvmrecap.databinding.ActivityRestaurantBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {


    private val viewModel: RestaurantViewModel by viewModels()
    private lateinit var binding: ActivityRestaurantBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerView()

    }


    private fun setRecyclerView(){

        val restaurantAdapter = RestaurantAdapter()
        binding.apply {
            recyclerView.apply {
                adapter = restaurantAdapter
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@RestaurantActivity)
            }


            viewModel.restaurants.observe(this@RestaurantActivity) { restaurants ->

                restaurantAdapter.submitList(restaurants)

            }

        }

    }
}