package com.example.todolisttutorial

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.todolisttutorial.databinding.TaskItemCellBinding
import java.time.format.DateTimeFormatter

class ItemAtividadeViewHolder(
    private val context: Context,
    private val binding: TaskItemCellBinding,
    private val clickListener: TaskItemClickListener
): RecyclerView.ViewHolder(binding.root)
{
    private val timeFormat = DateTimeFormatter.ofPattern("HH:mm")
    private var isExpanded = false

    fun bindTaskItem(itemAtividade: ItemAtividade)
    {
        binding.name.text = itemAtividade.name
        binding.taskDescription.text = itemAtividade.desc
        binding.responsavelText.text = itemAtividade.resp
        binding.expandButton.rotation =  -90f
        binding.cardDescription.visibility = View.GONE

        // Expandir botao
        binding.expandButton.setOnClickListener{
            isExpanded = !isExpanded
            binding.cardDescription.visibility = if(isExpanded) View.VISIBLE else View.GONE
            binding.expandButton.rotation = if (isExpanded) 0f else -90f
        }

        //deletar atividade
        binding.deleteBtn.setOnClickListener{
            clickListener.deleteTaskItem(itemAtividade)
        }

        binding.taskCellContainer.setOnClickListener{
            clickListener.editTaskItem(itemAtividade)
        }

        if(itemAtividade.dueTime != null)
            binding.dueTime.text = timeFormat.format(itemAtividade.dueTime)
        else
            binding.dueTime.text = ""
    }
}