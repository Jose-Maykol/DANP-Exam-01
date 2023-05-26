package com.example.danpexam01.screens

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.danpexam01.components.CitaCard
import com.example.danpexam01.viewModels.CitaViewModel
import com.example.danpexam01.viewModels.CitaViewModelFactory

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
    val userId = sharedPreferences.getInt("userId", 0)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "TUS CITAS",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                    ) },
                backgroundColor = Color.Transparent,
                contentColor = Color.White,
                modifier = Modifier.padding(top = 32.dp),
                elevation = 0.dp,
                actions = {
                    IconButton(
                        onClick = { navController?.navigate("hacerCita_screen")}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Logout"
                        )
                    }
                }
            )
        }
    ) {
        val context = LocalContext.current
        val mCitaViewModel: CitaViewModel = viewModel(
            factory = CitaViewModelFactory(context.applicationContext as Application)
        )

        val citas = mCitaViewModel.allCitasComplete.observeAsState(listOf()).value

        val citasFiltradas = citas.filter { cita ->
            cita.paciente.idPaciente == userId
        }

        if (citasFiltradas.isEmpty()) {
            Text(
                text = "No hay citas",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(citasFiltradas) { cita ->
                CitaCard(
                    cita = cita,
                    navController = navController
                )
            }
        }
    }
}