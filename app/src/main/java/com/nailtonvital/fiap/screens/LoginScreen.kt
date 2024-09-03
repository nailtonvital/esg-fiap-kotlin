package com.nailtonvital.fiap.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    LoginScreen(navController = rememberNavController())
}
@Composable
fun LoginScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF161616))
            .padding(32.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top, // Garante que o conteúdo fique no topo
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter) // Alinha o Column no topo central da tela
                .padding(top = 32.dp) // Espaçamento do topo
        ) {
            // Título "AdoteESG"
            Text(
                text = "AdoteESG",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )

            // Espaçamento entre o título e o próximo texto
            Spacer(modifier = Modifier.height(250.dp))

            // Texto "Entrar como:"
            Text(
                text = "Entrar como:",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )

            // Espaçamento entre o texto e o primeiro botão
            Spacer(modifier = Modifier.height(25.dp))

            // Botão "Administrador"
            Button(
                onClick = { navController.navigate("admin") },
                colors = ButtonDefaults.buttonColors(Color(0xFF161616)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .border(
                        BorderStroke(2.dp, Color.White),
                        shape = RoundedCornerShape(8.dp)

                    )
            ) {
                Text(text = "Administrador", fontSize = 16.sp, color = Color.White)
            }

            // Espaçamento entre os botões
            Spacer(modifier = Modifier.height(12.dp))

            // Botão "Colaborador"
            Button(
                onClick = { navController.navigate("collaborators") },
                colors = ButtonDefaults.buttonColors(Color(0xFF161616)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .border(
                        BorderStroke(2.dp, Color.White),
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                Text(text = "Colaborador", fontSize = 16.sp, color = Color.White)
            }
        }
    }
}

