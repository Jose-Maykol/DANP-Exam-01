package com.example.danpexam01.repositories

import androidx.lifecycle.LiveData
import com.example.danpexam01.daos.CitaDao
import com.example.danpexam01.models.CitaWithPacienteAndMedico
import com.example.danpexam01.models.Cita

class CitaRepository (private val citaDao: CitaDao) {

    val allCitas: LiveData<List<Cita>> = citaDao.getAllCitas()
    val allCitasComplete: LiveData<List<CitaWithPacienteAndMedico>> = citaDao.getAllCitasComplete()

    suspend fun insertCita(cita: Cita) {
        citaDao.insertCita(cita)
    }

    suspend fun getCita(idCita: Int): LiveData<CitaWithPacienteAndMedico> {
        return citaDao.getCita(idCita)
    }
}