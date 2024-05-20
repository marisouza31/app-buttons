package com.example.app1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.app1.ui.theme.App1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App1Theme {
                App()
            }
        }
    }
}

@Composable
private fun App() {
    var userName by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título acima da imagem
            Text(
                text = "atividade de pam 2",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(18.dp)
            )

            // Cabeçalho com a logo da Etec
            Image(
                painter = painterResource(id = R.drawable.logo_etec),
                contentDescription = "Logo da Etec ZL",
                modifier = Modifier.size(167.dp)
            )

            // TextField para o nome do usuário
            TextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text("Nome do Usuário") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            // Botões coloridos
            ActionButton(
                text = "Nota I",
                buttonColors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.d("Nota", "nota I")
            }

            ActionButton(
                text = "Nota R",
                buttonColors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.d("Nota", "nota R")
            }

            ActionButton(
                text = "Nota B",
                buttonColors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.d("Nota", "nota B")
            }

            ActionButton(
                text = "Nota MB",
                buttonColors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Log.d("Nota", "nota MB")
            }
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit
) {
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Composable
@Preview(showBackground = true)
fun AppPreview() {
    App1Theme {
        App()
    }
}

