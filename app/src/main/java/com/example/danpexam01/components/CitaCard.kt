package com.example.danpexam01.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.danpexam01.models.CitaWithPacienteAndMedico

@Composable
fun CitaCard(
    cita: CitaWithPacienteAndMedico,
    navController: NavHostController? = null
) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = {
                navController?.navigate("detail_screen/${cita.cita.idCita}")
            })
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
        ) {
            Image(
                painter = rememberAsyncImagePainter("https://img.freepik.com/vector-premium/perfil-medico-icono-servicio-medico_617655-48.jpg"),
                contentDescription = "Imagen de la cita",
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp),
                alignment = Alignment.CenterStart
            )
            Column(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)
            ) {
                Text(
                    text = cita.medico.nombre,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Especialidad: ${cita.medico.especialidad}",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Fecha: ${cita.cita.fecha}",
                    color = Color.White
                )
                Text(
                    text = "Hora: ${cita.cita.hora}",
                    color = Color.White
                )
            }
        }
    }
}