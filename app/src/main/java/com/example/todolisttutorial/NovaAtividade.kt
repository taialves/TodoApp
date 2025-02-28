package com.example.todolisttutorial

import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.todolisttutorial.databinding.FragmentNewTaskSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.time.LocalTime

class NovaAtividade(var itemAtividade: ItemAtividade?) : BottomSheetDialogFragment()
{
    private lateinit var binding: FragmentNewTaskSheetBinding
    private lateinit var atividadeViewModel: AtividadeViewModel
    private var dueTime: LocalTime? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (itemAtividade != null)
        {
            binding.taskTitle.text = "Editar Atividade"
            val editable = Editable.Factory.getInstance()
            binding.name.text = editable.newEditable(itemAtividade!!.name)
            binding.desc.text = editable.newEditable(itemAtividade!!.desc)
            binding.responsavel.text = editable.newEditable((itemAtividade!!.resp))
            if(itemAtividade!!.dueTime != null){
                dueTime = itemAtividade!!.dueTime!!
                updateTimeButtonText()
            }
        }
        else
        {
            binding.taskTitle.text = "Nova Atividade"
        }

        atividadeViewModel = ViewModelProvider(activity).get(AtividadeViewModel::class.java)
        binding.saveButton.setOnClickListener {
            saveAction()
        }
        binding.timePickerButton.setOnClickListener {
            openTimePicker()
        }
    }

    private fun openTimePicker() {
        if(dueTime == null)
            dueTime = LocalTime.now()
        val listener = TimePickerDialog.OnTimeSetListener{ _, selectedHour, selectedMinute ->
            dueTime = LocalTime.of(selectedHour, selectedMinute)
            updateTimeButtonText()
        }
        val dialog = TimePickerDialog(activity, listener, dueTime!!.hour, dueTime!!.minute, true)
        dialog.setTitle("Task Due")
        dialog.show()

    }

    private fun updateTimeButtonText() {
        binding.timePickerButton.text = String.format("%02d:%02d",dueTime!!.hour,dueTime!!.minute)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewTaskSheetBinding.inflate(inflater,container,false)
        return binding.root
    }


    private fun saveAction()
    {
        val name = binding.name.text.toString()
        val desc = binding.desc.text.toString()
        val responsavel = binding.responsavel.text.toString()

        if(itemAtividade == null)
        {
            val newTask = ItemAtividade(name,desc,responsavel,dueTime)
            atividadeViewModel.addTaskItem(newTask)
        }
        else
        {
            atividadeViewModel.updateTaskItem(itemAtividade!!.id, name, desc,responsavel, dueTime)
        }
        binding.name.setText("")
        binding.desc.setText("")
        dismiss()
    }

}








