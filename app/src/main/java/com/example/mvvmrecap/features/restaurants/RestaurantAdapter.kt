package com.example.mvvmrecap.features.restaurants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmrecap.data.Restaurant
import com.example.mvvmrecap.databinding.RestaurantItemBinding

class RestaurantAdapter: ListAdapter<Restaurant, RestaurantAdapter.RestaurantViewHolder >(RestaurantComperator()) {




    inner class RestaurantViewHolder(private val binding: RestaurantItemBinding):
        RecyclerView.ViewHolder(binding.root) {

            fun bind(restaurant: Restaurant){
                binding.apply {
                    Glide.with(itemView)
                        .load(restaurant.logo)
                        .into(imageViewLogo)


                    textViewName.text= restaurant.name
                    textViewAddress.text = restaurant.address
                    textViewType.text = restaurant.type

                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding =
            RestaurantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class RestaurantComperator : DiffUtil.ItemCallback<Restaurant>(){
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant) =
            oldItem.name==oldItem.name



        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant)=
            oldItem == newItem
        }

    }





