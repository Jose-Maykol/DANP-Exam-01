package com.example.danpexam01.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.danpexam01.models.Cita
import kotlinx.coroutines.flow.Flow

@Dao
interface CitaDao {
    @Insert
    suspend fun insertCita(cita: Cita)

    @Query("SELECT * FROM citas")
    fun getAllCitas(): LiveData<List<Cita>>

    @Query("SELECT * FROM citas " +
            "INNER JOIN pacientes ON citas.idPaciente = pacientes.idPaciente " +
            "INNER JOIN medicos ON citas.idMedico = medicos.idMedico")
    fun getAllCitasComplete(): LiveData<List<CitaWithPacienteAndMedico>>
}