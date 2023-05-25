package com.example.danpexam01.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.danpexam01.models.Paciente
import kotlinx.coroutines.flow.Flow

@Dao
interface PacienteDao {
    @Insert
    suspend fun insertPaciente(paciente: Paciente)

    @Query("SELECT * FROM pacientes")
    fun getAllPacientes(): LiveData<List<Paciente>>

}
