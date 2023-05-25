package com.example.danpexam01.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.danpexam01.DatabaseCitas
import com.example.danpexam01.daos.CitaDao
import com.example.danpexam01.models.Cita
import com.example.danpexam01.repositories.CitaRepository
import kotlinx.coroutines.launch

class CitaViewModel(application: Application) : AndroidViewModel(application) {

    val allCitas: LiveData<List<Cita>>
    private val repository: CitaRepository

    init {
        val citaDao = DatabaseCitas.getDatabase(application).citaDao()
        repository = CitaRepository(citaDao)
        allCitas = repository.allCitas
    }

}