package com.example.todolisttutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolisttutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TaskItemClickListener
{
    private lateinit var binding: ActivityMainBinding
    private lateinit var atividadeViewModel: AtividadeViewModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        atividadeViewModel = ViewModelProvider(this).get(AtividadeViewModel::class.java)
        binding.newTaskButton.setOnClickListener {
            NovaAtividade(null).show(supportFragmentManager, "newTaskTag")
        }
        setRecyclerView()
    }

    private fun setRecyclerView()
    {
        val mainActivity = this
        atividadeViewModel.itemsAtividade.observe(this){
            binding.todoListRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = ItemAtividadeAdapter(it, mainActivity)
            }
        }
    }

    override fun editTaskItem(itemAtividade: ItemAtividade)
    {
        NovaAtividade(itemAtividade).show(supportFragmentManager,"newTaskTag")
    }

    override fun deleteTaskItem(itemAtividade: ItemAtividade) {
        atividadeViewModel.deleteTaskItem(itemAtividade.id)
    }


}







