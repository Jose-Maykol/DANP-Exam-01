package com.example.danpexam01.repositories

import androidx.lifecycle.LiveData
import com.example.danpexam01.daos.CitaDao
import com.example.danpexam01.models.Cita

class CitaRepository (private val citaDao: CitaDao) {

    val allCitas: LiveData<List<Cita>> = citaDao.getAllCitas()

    suspend fun insertCita(cita: Cita) {
        citaDao.insertCita(cita)
    }
}