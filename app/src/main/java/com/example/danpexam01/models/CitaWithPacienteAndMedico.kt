package com.example.danpexam01.models

import androidx.room.Embedded
import androidx.room.Ignore
import androidx.room.Relation
import com.example.danpexam01.models.Cita
import com.example.danpexam01.models.Medico
import com.example.danpexam01.models.Paciente

data class CitaWithPacienteAndMedico(
    @Embedded val cita: Cita,
    @Relation(
        parentColumn = "idPaciente",
        entityColumn = "idPaciente"
    )
    val paciente: Paciente,
    @Relation(
        parentColumn = "idMedico",
        entityColumn = "idMedico"
    )
    val medico: Medico
)