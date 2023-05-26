import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import com.example.danpexam01.models.Paciente
import java.util.*

@Composable
fun HacerCita(
    navController: NavHostController) {
    var fecha by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }
    var isEditando by remember { mutableStateOf(false) }
    var textButton by remember { mutableStateOf("Guardar") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Crear una cita",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                    ) },
                backgroundColor = Color.Transparent,
                contentColor = Color.White,
                modifier = Modifier.padding(top = 15.dp),
                elevation = 0.dp,
                actions = {
                    IconButton(
                        onClick = {
                            navController?.navigate("hacerCita_screen")}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add"
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(12.dp)
        ) {
            formCita()
        }
    }
}
@Composable
fun formCita(){
    var paciente: Paciente
    var idPaciente by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var fechaNacimiento by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var doctor by remember { mutableStateOf("") }
    var fechaCita by remember { mutableStateOf("") }
    var horaCita by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(14.dp)
    ) { /*nombre = paciente.nombre
        apellido = paciente.apellido
        genero = paciente.genero
        fechaNacimiento = paciente.fechaNacimiento
        telefono = paciente.telefono
        direccion = paciente.direccion
        email = paciente.email*/

        ElegirDoctor(doctor)
        DatePicker(fechaCita)
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        DateTimePicker(horaCita)
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
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.align(Alignment.Center)) {
            OutlinedTextField(
                value = fecha,
                onValueChange = { fecha = it },
                readOnly = true,
                label = { Text(text = "Fecha de la cita") }
            )
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(4.dp)
                    .clickable {
                        cDatePickerDialog.show()
                    }
            )
        }
    }
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
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.align(Alignment.Center)) {
            OutlinedTextField(
                value = hora,
                onValueChange = { hora = it },
                readOnly = true,
                label = { Text(text = "Hora de la cita") }
            )
            Icon(
                imageVector = Icons.Filled.DateRange,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(4.dp)
                    .clickable {
                        timePickerDialog.show()
                    }
            )
        }
    }
}

@Composable
fun ElegirDoctor(doctor: String) {
    var expanded by remember { mutableStateOf(false) }
    val doctoresCombo = arrayOf("Dr. Daniel Ventura", "Dra. Rafaela Vera", "Dra. Carmen Expresso", "Dr. Manuel Carrasco", "Dr. Carlos Conde")
    var doctor by remember { mutableStateOf("") }
    var textfieldSize by remember { mutableStateOf("")}

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(Modifier.padding(1.dp)) {
        OutlinedTextField(
            value = doctor,
            onValueChange = { doctor = it },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size
                        .toSize()
                        .toString()
                },
            label = {Text("Label")},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(IntrinsicSize.Max)
        ) {
            doctoresCombo.forEach { label ->
                DropdownMenuItem(onClick = {
                    doctor = label
                    expanded = false
                }) {
                    Text(text = label)
                }
            }
        }
    }
}

/*fun agregarCita(idPaciente: String, listaPacientes: MutableList<Paciente>, listaCita: MutableList<Cita>) {
    listaPacientes.add(Cita())
}*/
fun agregarCita(prueba:String) {

}