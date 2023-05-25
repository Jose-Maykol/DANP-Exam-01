package com.example.danpexam01.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.danpexam01.DatabaseCitas
import com.example.danpexam01.models.Medico
import com.example.danpexam01.repositories.MedicoRepository

class MedicoViewModel (application: Application) : AndroidViewModel(application){
    val allMedicos: LiveData<List<Medico>>
    private val repository: MedicoRepository

    init {
        val medicoDao = DatabaseCitas.getDatabase(application).medicoDao()
        repository = MedicoRepository(medicoDao)
        allMedicos = repository.allMedicos
    }
}