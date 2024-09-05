package com.nailtonvital.fiap.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun AdminScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val selectedTabIndex = remember { mutableStateOf(0) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xff161616))  // Fundo escuro, estilo igual ao da CollaboratorsScreen
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp)
        ) {
            // Botão de voltar igual ao da CollaboratorsScreen
            IconButton(
                onClick = { navController.navigateUp() },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
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

            Spacer(modifier = Modifier.height(16.dp))

            // Abas e conteúdo selecionado
            NavigationBar(selectedTabIndex, navController)

            // Conteúdo da aba selecionada
            when (selectedTabIndex.value) {
                0 -> ColaboradoresContent(
                    listOf(
                        "Nailton Vital" to 1500,
                        "Clark Kent" to 1500,
                        "Michael Jackson" to 1500,
                        "Albert Einstein" to 1500,
                        "Barry Allen" to 1500
                    )
                )
                1 -> BeneficiosContent()
            }

            Spacer(modifier = Modifier.height(20.dp)) // Espaçamento entre a lista e os botões

            // Rodapé com botões
            BottomButtons()
        }
    }
}

@Composable
fun NavigationBar(selectedTabIndex: androidx.compose.runtime.MutableState<Int>, navController: NavHostController) {
    Column {
        // Abas (Colaboradores e Benefícios)
        val tabs = listOf("Colaboradores", "Benefícios")
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            tabs.forEachIndexed { index, tab ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .clickable { selectedTabIndex.value = index }
                ) {
                    Text(
                        text = tab,
                        color = Color.White,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .height(2.dp)
                            .background(
                                if (selectedTabIndex.value == index) Color(0xffd41854) else Color(0xff949494)
                            )
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun ColaboradoresContent(colaboradores: List<Pair<String, Int>>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(7.dp),
        modifier = Modifier
            .padding(horizontal = 39.dp, vertical = 16.dp)
    ) {
        // Exibir cada colaborador e seus pontos
        colaboradores.forEach { (name, points) ->
            CollaboratorRow(name, points)
        }
    }
}

@Composable
fun BeneficiosContent() {
    Column(
        verticalArrangement = Arrangement.spacedBy(7.dp),
        modifier = Modifier.padding(horizontal = 39.dp, vertical = 16.dp)
    ) {
        // Lista de benefícios
        CollaboratorRow("Voluntariado", 1500)
        CollaboratorRow("Separação de lixo", 482)
        CollaboratorRow("Lorem Ipsum", 482)
        CollaboratorRow("Lorem Ipsum", 482)
    }
}

// Função CollaboratorRow com estilo de borda arredondada e espaçamento
@Composable
fun CollaboratorRow(name: String, points: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .border(
                width = 1.dp,
                color = Color.DarkGray,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp),  // Espaçamento interno
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Nome do colaborador
        Text(
            text = name,
            color = Color.White,
            fontSize = 17.sp
        )

        // Pontuação
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = points.toString(),
                color = Color.White,
                fontSize = 12.sp
            )
            Text(
                text = "Pontos",
                color = Color(0xff838383),
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun BottomButtons() {
    Column(
        verticalArrangement = Arrangement.spacedBy(14.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 50.dp)
    ) {
        // Botão 1 - Adicionar empresa
        CustomStyledButton(text = "Adicionar empresa")

        // Botão 2 - Adicionar colaborador
        CustomStyledButton(text = "Adicionar colaborador")

        // Botão 3 - Adicionar benefícios
        CustomStyledButton(text = "Adicionar benefícios")
    }
}

// Função para aplicar o estilo solicitado aos botões
@Composable
fun CustomStyledButton(text: String) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(Color(0xFFD41854)),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(vertical = 1.dp)  // Espaçamento entre os botões
    ) {
        Text(text = text, fontSize = 16.sp, color = Color.White)
    }
}

@Preview(widthDp = 393, heightDp = 852)
@Composable
fun AdminScreenPreview() {
    AdminScreen(navController = rememberNavController())
}
