package com.example.todolisttutorial

interface TaskItemClickListener
{
    fun editTaskItem(itemAtividade: ItemAtividade)
    fun deleteTaskItem(itemAtividade: ItemAtividade)
}