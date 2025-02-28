package com.example.todolisttutorial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalTime
import java.util.*

class AtividadeViewModel: ViewModel()
{
    var itemsAtividade = MutableLiveData<MutableList<ItemAtividade>>()

    init {
        itemsAtividade.value = mutableListOf()
    }

    // Função para criar nova atividade
    fun addTaskItem(newTask: ItemAtividade)
    {
        val list = itemsAtividade.value
        list!!.add(newTask)
        itemsAtividade.postValue(list)
    }

    // Função para deletar atividade
    fun deleteTaskItem(id: UUID) {
        val list = itemsAtividade.value ?: return // Verifica se a lista não é nula
        val updatedList = list.filter { it.id != id }.toMutableList() // Filtra e remove o item
        itemsAtividade.postValue(updatedList) // Atualiza a LiveData
    }

    // Função para editar uma atividade
    fun updateTaskItem(id: UUID, name: String, desc: String, resp: String, dueTime: LocalTime?)
    {
        val list = itemsAtividade.value
        val task = list!!.find { it.id == id }!!
        task.name = name
        task.desc = desc
        task.resp = resp
        task.dueTime = dueTime
        itemsAtividade.postValue(list)
    }

}