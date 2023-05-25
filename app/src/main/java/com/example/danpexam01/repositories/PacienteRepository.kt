package com.example.danpexam01.repositories

import androidx.lifecycle.LiveData
import com.example.danpexam01.daos.PacienteDao
import com.example.danpexam01.models.Paciente

class PacienteRepository(private val pacienteDao: PacienteDao) {
    val allPacientes: LiveData<List<Paciente>> = pacienteDao.getAllPacientes()

    suspend fun insertPaciente(paciente: Paciente) {
        pacienteDao.insertPaciente(paciente)
    }
}