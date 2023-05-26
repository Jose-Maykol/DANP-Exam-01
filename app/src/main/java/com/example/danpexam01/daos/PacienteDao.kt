package com.example.danpexam01.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.danpexam01.models.Paciente

@Dao
interface PacienteDao {
    @Insert
    suspend fun insertPaciente(paciente: Paciente)

    @Query("SELECT * FROM pacientes")
    fun getAllPacientes(): LiveData<List<Paciente>>

    @Query("SELECT * FROM pacientes WHERE email=:email")
    fun getPacienteByEmail(email: String): Paciente?
}
