package com.example.danpexam01.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.danpexam01.DatabaseCitas
import com.example.danpexam01.models.Paciente
import com.example.danpexam01.repositories.PacienteRepository

class PacienteViewModel(application: Application) : AndroidViewModel(application) {
    val allPacientes: LiveData<List<Paciente>>
    private val repository: PacienteRepository

    init {
        val pacienteDao = DatabaseCitas.getDatabase(application).pacienteDao()
        repository = PacienteRepository(pacienteDao)
        allPacientes = repository.allPacientes
    }
    
}
