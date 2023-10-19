package com.example.myapplication.adapter.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ContainerItemListBinding
import com.example.myapplication.model.RadioItems

class MyViewHolder( val binding: ContainerItemListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun setupUI(item: RadioItems, position: Int) {
        binding.rdButton.text = item.descricao
        binding.rdButton.isChecked = item.isSelected
        binding.rdButton.id = position
    }
}