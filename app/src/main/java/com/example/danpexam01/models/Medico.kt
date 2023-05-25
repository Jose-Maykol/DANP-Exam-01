package com.example.danpexam01.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicos")
data class Medico(
    @PrimaryKey(autoGenerate = true)
    val idMedico: Int = 0,
    val nombre: String,
    val apellido: String,
    val especialidad: String,
    val hospital: String,
    val telefono: String,
    val email: String,
    val password: String
)