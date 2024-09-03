package com.nailtonvital.fiap.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
import kotlin.random.Random

@Preview(showBackground = true)
@Composable
fun CollaboratorsScreenPreview() {
    CollaboratorsScreen(navController = rememberNavController())
}
@Composable
fun CollaboratorsScreen(navController: NavController) {
    val activitiesMap = mapOf(
        "Cultivo de Horta Doméstica" to Random.nextInt(1, 100),
        "Separação de Lixo para Reciclagem" to Random.nextInt(1, 100),
        "Hábitos Alimentares Saudáveis" to Random.nextInt(1, 100),
        "Prática de Atividades Físicas" to Random.nextInt(1, 100),
        "Participação em Projetos de Voluntariado" to Random.nextInt(1, 100)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF161616))
            .padding(14.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(bottom = 80.dp),

        ) {
            IconButton(
                onClick = { navController.navigateUp() },
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically // Centraliza o texto em relação ao ícone
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // Espaçamento entre o ícone e o texto
                    Text(
                        text = "Voltar",
                        color = Color.White
                    )

                }
            }
            Text(
                text = "Suas Atividades",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Pontuação total: 1982",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth() // Usa a largura disponível
            )
            Divider(
                color = Color.White,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth() // Linha ocupa toda a largura disponível
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(16.dp)) // Espaçamento entre o texto e a lista de atividades
            ActivitiesList(activitiesMap = activitiesMap) // Supondo que com.nailtonvital.fiap.screens.ActivitiesList seja uma função composable que renderiza a lista
        }

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color(0xFFD41854)),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Adicionar atividade", fontSize = 16.sp, color = Color.White)
        }
    }
}


@Composable
fun Activities(activity: String, points: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)

            .border(
                width = 1.dp,
                color = Color.DarkGray,
                shape = RoundedCornerShape(8.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(Alignment.Start)
                .padding(start = 12.dp, bottom = 18.dp, top = 18.dp)
        ) {
            Text(
                text = activity,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                maxLines = Int.MAX_VALUE,
                overflow = androidx.compose.ui.text.style.TextOverflow.Visible
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.padding(end = 12.dp, bottom = 18.dp, top = 18.dp)
        ) {
            Text(
                text = points.toString(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
            Text(
                text = "Pontos",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun ActivitiesList(activitiesMap: Map<String, Int>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(activitiesMap.entries.toList()) { entry ->
            Activities(activity = entry.key, points = entry.value)

        }
    }
}
