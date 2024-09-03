package com.nailtonvital.fiap.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Administrador(modifier: Modifier = Modifier) {
    val selectedTabIndex = remember { mutableStateOf(0) }

    Box(
        modifier = modifier
            .requiredWidth(393.dp)
            .requiredHeight(852.dp)
            .background(Color(0xff161616))
    ) {
        Column {
            // Barra de Navegação (Voltar, Colaboradores e Benefícios)
            NavigationBar(selectedTabIndex)

            // Conteúdo da aba selecionada
            when (selectedTabIndex.value) {
                0 -> ColaboradoresContent()
                1 -> BeneficiosContent()
            }

            // Rodapé com botões
            BottomButtons()
        }
    }
}

@Composable
fun NavigationBar(selectedTabIndex: androidx.compose.runtime.MutableState<Int>) {
    Column {
        // Botão de Voltar e Título
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Voltar",
                tint = Color.White,
                modifier = Modifier.clickable { /* Navegar de volta */ }
            )
            Spacer(modifier = Modifier.width(8.dp))

        }

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
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Divider(
                        color = if (selectedTabIndex.value == index) Color(0xffd41854) else Color(0xff949494),
                        thickness = 2.dp,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun ColaboradoresContent() {
    Column(
        verticalArrangement = Arrangement.spacedBy(7.dp),
        modifier = Modifier.padding(horizontal = 39.dp, vertical = 16.dp)
    ) {
        // Lista de colaboradores
        CollaboratorRow("Nailton Vital", 1500)
        CollaboratorRow("Clark Kent", 1500)
        CollaboratorRow("Michael Jackson", 1500)
        CollaboratorRow("Albert Einstein", 1500)
        CollaboratorRow("Barry Allen", 1500)
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

@Composable
fun CollaboratorRow(name: String, points: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1F1F1F))
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = name,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium
            )
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = points.toString(),
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Pontos",
                    color = Color(0xff838383),
                    fontSize = 12.sp
                )
            }
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
        CustomButton(text = "Adicionar empresa")
        CustomButton(text = "Adicionar colaborador")
        CustomButton(text = "Adicionar benefícios")
    }
}

@Composable
fun CustomButton(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Color(0xffd41854))
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(widthDp = 393, heightDp = 852)
@Composable
private fun AdministradorPreview() {
    Administrador()
}
