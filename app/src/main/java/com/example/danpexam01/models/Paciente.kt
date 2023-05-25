package com.example.danpexam01.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pacientes")
data class Paciente (
    @PrimaryKey(autoGenerate = true)
    val idPaciente: Int = 0,
    val nombre: String,
    val apellido: String,
    val fechaNacimiento: String,
    val genero: String,
    val direccion: String,
    val telefono: String,
    val email: String,
    val password: String
)