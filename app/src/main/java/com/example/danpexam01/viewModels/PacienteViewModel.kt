package com.example.danpexam01.viewModels

import android.app.Application
import androidx.lifecycle.*
import com.example.danpexam01.DatabaseCitas
import com.example.danpexam01.models.Paciente
import com.example.danpexam01.repositories.PacienteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PacienteViewModel(application: Application) : AndroidViewModel(application) {
    val allPacientes: LiveData<List<Paciente>>
    private val repository: PacienteRepository

    init {
        val pacienteDao = DatabaseCitas.getDatabase(application).pacienteDao()
        repository = PacienteRepository(pacienteDao)
        allPacientes = repository.allPacientes
    }

    fun insertPaciente(paciente: Paciente) {
        viewModelScope.launch (Dispatchers.IO){
            repository.insertPaciente(paciente)
        }
    }
}

class PacienteViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PacienteViewModel::class.java)) {
            return PacienteViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
