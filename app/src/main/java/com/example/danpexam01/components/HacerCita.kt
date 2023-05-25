package com.example.danpexam01.components

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.danpexam01.models.Paciente
import java.lang.reflect.Modifier
import java.util.*
import java.util.Calendar;


@Composable
fun HacerCita(listaPacientes: MutableList<Paciente>) {
    var fecha by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }
    var isEditando by remember { mutableStateOf(false) }
    var textButton by remember { mutableStateOf("Guardar") }

}

@Composable
fun formCita(paciente: Paciente){
    var idPaciente: String,
    var nombre: String,
    var apellido: String,
    var genero: String,
    var fechaNacimiento: String,
    var telefono: String,
    var direccion: String,
    var email: String,
    var descripcion: String
    var fechaCita: String,
    var horaCita: String,

    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(12.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()
        ) {
            nombre = paciente.nombre,
            apellido = paciente.apellido,
            genero = paciente.genero,
            fechaNacimiento = paciente.fechaNacimiento,
            telefono = paciente.telefono,
            direccion = paciente.direccion,
            email = paciente.email
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = descripcion,
                keyboardOptions = KeyboardOptions(keyboardType =
                KeyboardType.Text),
                singleLine = true,
                maxLines = 1,
                onValueChange = descripcion,
                label = { Text(text = "Motivo de cita") }
            )
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            DatePicker(fechaCita)
            DateTimePicker(horaCita)
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
        }
    }
}
@Composable
fun DatePicker(fecha: String) {
    var fecha by remember { mutableStateOf("") }
    val year: Int
    val month: Int
    val day: Int
    val cCalendar = Calendar.getInstance()
    year = cCalendar.get(Calendar.YEAR)
    month = cCalendar.get(Calendar.MONTH)
    day = cCalendar.get(Calendar.DAY_OF_MONTH)
    val cDatePickerDialog = DatePickerDialog(
        LocalContext.current,
        { DatePicker, year: Int, month: Int, day: Int ->
            fecha = "$day/${month + 1}/$year"
        }, year, month, day
    )
    cDatePickerDialog.show()
}


@Composable
fun DateTimePicker(hora: String) {
    var hora by remember { mutableStateOf("") }
    val horas: Int
    val minutos: Int
    val c = Calendar.getInstance()
    horas = c.get(Calendar.HOUR_OF_DAY)
    minutos = c.get(Calendar.MINUTE)
    val timePickerDialog = TimePickerDialog(LocalContext.current,
        { DateTimePicker, horas, minutos ->
            hora = "$horas:$minutos"
        }, horas, minutos, false
    )
    timePickerDialog.show()
}

