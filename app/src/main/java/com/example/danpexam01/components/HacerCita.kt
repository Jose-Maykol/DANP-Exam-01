import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.danpexam01.models.Paciente
import java.util.*

@Composable
fun HacerCita(listaPacientes: MutableList<Paciente>) {
    var fecha by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }
    var isEditando by remember { mutableStateOf(false) }
    var textButton by remember { mutableStateOf("Guardar") }

}

@Composable
fun formCita(paciente: Paciente){

    var idPaciente by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var fechaNacimiento by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var fechaCita by remember { mutableStateOf("") }
    var horaCita by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(12.dp)
    ) {
        nombre = paciente.nombre
        apellido = paciente.apellido
        genero = paciente.genero
        fechaNacimiento = paciente.fechaNacimiento
        telefono = paciente.telefono
        direccion = paciente.direccion
        email = paciente.email

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = descripcion,
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Text),
            singleLine = true,
            maxLines = 1,
            onValueChange = { descripcion = it },
            label = { Text(text = "Motivo de cita") }
        )
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        DatePicker(fechaCita)
        DateTimePicker(horaCita)
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
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