package com.nailtonvital.fiap

import com.nailtonvital.fiap.screens.CollaboratorsScreen
import LoginScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nailtonvital.fiap.screens.AdminScreen
import com.nailtonvital.fiap.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ){
                        composable(route="login"){LoginScreen(navController)}
                        composable(route="collaborators"){ CollaboratorsScreen(navController) }
                        composable(route="admin"){ AdminScreen(navController)}
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AdminScreenPreview() {
    AdminScreen(navController = rememberNavController())
}
@Preview(showBackground = true)
@Composable
fun CollaboratorsScreenPreview() {
    CollaboratorsScreen(navController = rememberNavController())
}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}
