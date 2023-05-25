package com.example.danpexam01

import MedicoDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.danpexam01.daos.CitaDao
import com.example.danpexam01.daos.PacienteDao
import com.example.danpexam01.models.Cita
import com.example.danpexam01.models.Medico
import com.example.danpexam01.models.Paciente

@Database(entities = [Paciente::class, Cita::class, Medico::class], version = 1)
abstract class DatabaseCitas : RoomDatabase() {
    abstract fun pacienteDao(): PacienteDao
    abstract fun citaDao(): CitaDao
    abstract fun medicoDao(): MedicoDao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseCitas? = null

        fun getDatabase(context: Context): DatabaseCitas {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseCitas::class.java,
                    "my_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}