package com.example.navigationdrawer.features.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationdrawer.R
import com.example.navigationdrawer.databinding.ItemGridCardBinding
import com.example.navigationdrawer.databinding.ItemLinearCardBinding

class PokemonListAdapter(
    @LayoutRes private var itemViewType: Int = R.layout.item_linear_card
) : ListAdapter<Pokemon, RecyclerView.ViewHolder>(
    object : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

    }
) {
    inner class GridViewHolder(private val binding: ItemGridCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pokemon) {
            binding.pokemon = item
        }
    }

    inner class LinearViewHolder(private val binding: ItemLinearCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pokemon) {
            binding.pokemon = item
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (itemViewType == R.layout.item_grid_card) {
            val binding = ItemGridCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return GridViewHolder(binding)
        } else {

            val binding = ItemLinearCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return LinearViewHolder(binding)

        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is GridViewHolder -> {
                holder.bind(getItem(position))
            }
            is LinearViewHolder -> {
                holder.bind(getItem(position))
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return itemViewType
    }

    fun setItemViewType(@LayoutRes itemViewType: Int){
        this.itemViewType = itemViewType
        notifyItemRangeChanged(0 , itemCount - 1)

    }
}