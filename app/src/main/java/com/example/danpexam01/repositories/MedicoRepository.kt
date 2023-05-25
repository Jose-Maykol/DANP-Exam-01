package com.example.danpexam01.repositories

import MedicoDao
import androidx.lifecycle.LiveData
import com.example.danpexam01.models.Medico

class MedicoRepository( private val medicoDao: MedicoDao) {

    val allMedicos: LiveData<List<Medico>> = medicoDao.getAllMedicos()

    suspend fun insertMedico(medico: Medico) {
        medicoDao.insertMedico(medico)
    }
}