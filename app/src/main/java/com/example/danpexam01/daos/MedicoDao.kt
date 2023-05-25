package com.example.danpexam01.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.danpexam01.models.Medico

@Dao
interface MedicoDao {
    @Insert
    suspend fun insertMedico(medico: Medico)

    @Query("SELECT * FROM medicos")
    fun getAllMedicos(): LiveData<List<Medico>>
}