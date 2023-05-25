package com.example.danpexam01.repositories

import androidx.lifecycle.LiveData
import com.example.danpexam01.daos.MedicoDao
import com.example.danpexam01.models.Medico

class MedicoRepository( private val medicoDao: MedicoDao) {

    val allMedicos: LiveData<List<Medico>> = medicoDao.getAllMedicos()

    suspend fun insertMedico(medico: Medico) {
        medicoDao.insertMedico(medico)
    }
}