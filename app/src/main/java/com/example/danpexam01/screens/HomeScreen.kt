package com.example.danpexam01.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.danpexam01.components.CitaCard
import com.example.danpexam01.models.Cita

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Nombre de la aplicacion :'v",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                    ) },
                backgroundColor = Color.Transparent,
                contentColor = Color.White,
                modifier = Modifier.padding(top = 32.dp),
                elevation = 0.dp,
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Logout"
                        )
                    }
                }
            )
        }
    ) {
        val citas = listOf(
            Cita(1, "Paciente 1", "2023-05-25", "10:00 AM"),
            Cita(2, "Paciente 2", "2023-05-26", "11:30 AM"),
            Cita(3, "Paciente 3", "2023-05-27", "2:15 PM"),
            Cita(4, "Paciente 4", "2023-05-28", "4:45 PM"),
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(citas) { cita ->
                CitaCard(cita)
            }
        }
    }
}