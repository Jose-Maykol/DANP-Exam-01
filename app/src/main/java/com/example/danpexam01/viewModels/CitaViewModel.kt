package com.example.danpexam01.viewModels

import android.app.Application
import androidx.lifecycle.*
import com.example.danpexam01.DatabaseCitas
import com.example.danpexam01.models.CitaWithPacienteAndMedico
import com.example.danpexam01.models.Cita
import com.example.danpexam01.repositories.CitaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CitaViewModel(application: Application) : AndroidViewModel(application) {

    val allCitas: LiveData<List<Cita>>
    val allCitasComplete: LiveData<List<CitaWithPacienteAndMedico>>
    private val repository: CitaRepository

    init {
        val citaDao = DatabaseCitas.getDatabase(application).citaDao()
        repository = CitaRepository(citaDao)
        allCitas = repository.allCitas
        allCitasComplete = repository.allCitasComplete
    }

    suspend fun getCita(idCita: Int): LiveData<CitaWithPacienteAndMedico> {
        return withContext(Dispatchers.IO) {
            repository.getCita(idCita)
        }
    }
}

class CitaViewModelFactory(
    private val application: Application
    ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CitaViewModel::class.java)) {
            return CitaViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}