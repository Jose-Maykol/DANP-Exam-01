package com.example.danpexam01.screens

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.danpexam01.models.Paciente
import com.example.danpexam01.viewModels.PacienteViewModel
import com.example.danpexam01.viewModels.PacienteViewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun LoginScreen(
    navController: NavHostController? = null
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current
    val mPacienteViewModel: PacienteViewModel = viewModel(
        factory = PacienteViewModelFactory(context.applicationContext as Application)
    )
    val paciente: Paciente? by mPacienteViewModel.pacienteLiveData.observeAsState(null)
    mPacienteViewModel.getPacienteByEmail(email)

    val pacienteId: MutableStateFlow<Int?> = MutableStateFlow(null)
    val sharedPreferences = context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Inicio de sesión",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(4.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(4.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                mPacienteViewModel.getPacienteByEmail(email)
                if (paciente != null) {
                    if (paciente?.password == password) {
                        sharedPreferences.edit().putInt("userId", paciente?.idPaciente!!).apply()
                        Log.i("LoginScreen", "userId: ${paciente?.idPaciente!!}")
                        navController?.navigate("home_screen")
                    } else {
                        Toast.makeText(context, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Usuario no encontrado", Toast.LENGTH_SHORT).show()
                }
                navController?.navigate("home_screen")
            },
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(4.dp))
        ) {
            Text(text = "Iniciar sesión")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController?.navigate("register_screen")
            },
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(4.dp))
        ) {
            Text(text = "Registrarse")
        }
    }
}