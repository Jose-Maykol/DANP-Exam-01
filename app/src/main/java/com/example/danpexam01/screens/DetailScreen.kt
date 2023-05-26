package com.example.danpexam01.screens

import android.app.Application
import android.content.res.Resources.Theme
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.danpexam01.models.Cita
import com.example.danpexam01.models.CitaWithPacienteAndMedico
import com.example.danpexam01.viewModels.CitaViewModel
import com.example.danpexam01.viewModels.CitaViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun DetailScreen(
    navController: NavHostController,
    id: Int
) {
    val context = LocalContext.current
    val mCitaViewModel: CitaViewModel = viewModel(
        factory = CitaViewModelFactory(context.applicationContext as Application)
    )
    var cita by remember(id) {
        mutableStateOf<LiveData<CitaWithPacienteAndMedico>?>(null)
    }

    Log.i("DetailScreen", "id: $id")
    Log.i("DetailScreen", "cita: $cita")

    LaunchedEffect(id) {
        val fetchedCita = mCitaViewModel.getCita(idCita = id)
        cita = fetchedCita
    }

    if (cita != null) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 100.dp, horizontal = 50.dp)
                .border(1.dp, MaterialTheme.colors.primary),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Image(
                painter = rememberAsyncImagePainter("https://img.freepik.com/vector-premium/perfil-medico-icono-servicio-medico_617655-48.jpg"),
                contentDescription = "Imagen de la cita",
                modifier = Modifier
                    .height(300.dp)
                    .width(300.dp),
                alignment = Alignment.CenterStart
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Detalles de la cita",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp),
                color = MaterialTheme.colors.primary,
                style = TextStyle(fontSize = 20.sp)
            )

            Text(
                text = "Médico: ${cita!!.value?.medico?.nombre}",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp),
                style = TextStyle(fontSize = 20.sp)
            )

            Text(
                text = "Especialidad: ${cita!!.value?.medico?.especialidad}",
                modifier = Modifier.padding(bottom = 8.dp),
                style = TextStyle(fontSize = 20.sp)
            )

            Text(
                text = "Paciente: ${cita!!.value?.paciente?.nombre} ${cita!!.value?.paciente?.apellido}",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp),
                style = TextStyle(fontSize = 20.sp)
            )

            Text(
                text = "Fecha: ${cita!!.value?.cita?.fecha}",
                modifier = Modifier.padding(bottom = 8.dp),
                style = TextStyle(fontSize = 20.sp)
            )

            Text(
                text = "Hora: ${cita!!.value?.cita?.hora}",
                modifier = Modifier.padding(bottom = 8.dp),
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }

}