package com.example.todolisttutorial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolisttutorial.databinding.TaskItemCellBinding

class ItemAtividadeAdapter(
    private val itemAtividades: List<ItemAtividade>,
    private val clickListener: TaskItemClickListener
): RecyclerView.Adapter<ItemAtividadeViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAtividadeViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = TaskItemCellBinding.inflate(from, parent, false)
        return ItemAtividadeViewHolder(parent.context, binding, clickListener)
    }

    override fun onBindViewHolder(holder: ItemAtividadeViewHolder, position: Int) {
        holder.bindTaskItem(itemAtividades[position])
    }


    override fun getItemCount(): Int = itemAtividades.size
}