package com.example.danpexam01.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "citas",
    foreignKeys = [
        ForeignKey(entity = Paciente::class, parentColumns = ["idPaciente"], childColumns = ["idPaciente"]),
        ForeignKey(entity = Medico::class, parentColumns = ["idMedico"], childColumns = ["idMedico"])
    ])
data class Cita (
    @PrimaryKey(autoGenerate = true)
    val idCita: Int = 0,
    val idPaciente: Int,
    val idMedico: Int,
    val fecha: String,
    val hora: String
)