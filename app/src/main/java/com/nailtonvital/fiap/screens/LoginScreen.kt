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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF161616))
            .padding(32.dp)
    ) {
        // Texto "LOGIN" alinhado ao topo e centro horizontalmente
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {
            Text(
                text = "AdoteESG",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,

                )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Entrar como:",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,

            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("admin")},
                colors = ButtonDefaults.buttonColors(Color(0xFF161616)),
                modifier = Modifier
                    .fillMaxWidth() // Faz o botão ocupar a largura máxima disponível
                    .border(
                        BorderStroke(2.dp, Color.White),
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                Text(text = "Administrador", fontSize = 16.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { navController.navigate("collaborators")},
                colors = ButtonDefaults.buttonColors(Color(0xFF161616)),
                modifier = Modifier
                    .fillMaxWidth() // Faz o botão ocupar a largura máxima disponível
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
