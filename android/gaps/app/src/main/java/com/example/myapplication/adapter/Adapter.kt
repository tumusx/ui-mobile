package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MainActivity
import com.example.myapplication.adapter.viewHolder.MyViewHolder
import com.example.myapplication.databinding.ContainerItemListBinding
import com.example.myapplication.model.RadioItems

class Adapter : RecyclerView.Adapter<MyViewHolder>() {
    private var oldList = emptyList<RadioItems>()
    private var lastCheckedRadioButton: RadioButton? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ContainerItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setupUI(oldList[position], position)

        holder.binding.rdButton.isChecked = lastCheckedRadioButton?.id == holder.binding.rdButton.id

        holder.binding.rdButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                if (lastCheckedRadioButton != null && lastCheckedRadioButton != buttonView) {
                    lastCheckedRadioButton?.isChecked = false
                }
                lastCheckedRadioButton = buttonView as RadioButton
            }
            MainActivity.lista[position].isSelected = isChecked
        }
    }

    override fun getItemCount() = oldList.size

    fun updateList(newList: List<RadioItems>) {
        oldList = newList
        notifyDataSetChanged()
    }

}