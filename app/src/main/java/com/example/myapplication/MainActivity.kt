package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainMenu()
                }
            }
        }
    }
}

@Composable
fun MainMenu() {
    var currentScreen by remember { mutableStateOf("menu") }

    when (currentScreen) {
        "menu" -> MenuScreen(onScreenSelected = { currentScreen = it })
        "task1" -> ArticleScreen(onBack = { currentScreen = "menu" })
        "task2" -> TaskManagerScreen(onBack = { currentScreen = "menu" })
        "task3" -> QuadrantScreen(onBack = { currentScreen = "menu" })
        "task4" -> InfoScreen(onBack = { currentScreen = "menu" })
    }
}

@Composable
fun MenuScreen(onScreenSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Выберите задание",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { onScreenSelected("task1") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📖 Задание 1: Compose Article")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { onScreenSelected("task2") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("✅ Задание 2: Task Manager")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { onScreenSelected("task3") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🔲 Задание 3: Compose Quadrant")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { onScreenSelected("task4") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("👤 Задание 4: My Information")
        }
    }
}

@Composable
fun ArticleScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = onBack,
            modifier = Modifier.padding(8.dp)
        ) {
            Text("← Назад к меню")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.image1),
                    contentDescription = "Изображение для статьи",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Jetpack Compose tutorial",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app's UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI's construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun TaskManagerScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = onBack) {
            Text("← Назад к меню")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFF6750A4), shape = MaterialTheme.shapes.medium)
            ) {
                Text(
                    text = "✓",
                    color = Color.White,
                    fontSize = 48.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "All tasks completed",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Nice work!",
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun QuadrantScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = onBack) {
            Text("← Назад к меню")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                modifier = Modifier.weight(1f)
            ) {
                QuadrantCard(
                    title = "Text composable",
                    description = "Displays text and follows the recommended Material Design guidelines.",
                    backgroundColor = Color(0xFFEADDFF),
                    modifier = Modifier.weight(1f)
                )
                QuadrantCard(
                    title = "Image composable",
                    description = "Creates a composable that lays out and draws a given Painter class object.",
                    backgroundColor = Color(0xFFD0BCFF),
                    modifier = Modifier.weight(1f)
                )
            }

            Row(
                modifier = Modifier.weight(1f)
            ) {
                QuadrantCard(
                    title = "Row composable",
                    description = "A layout composable that places its children in a horizontal sequence.",
                    backgroundColor = Color(0xFFB69DF8),
                    modifier = Modifier.weight(1f)
                )
                QuadrantCard(
                    title = "Column composable",
                    description = "A layout composable that places its children in a vertical sequence.",
                    backgroundColor = Color(0xFFF6EDFF),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun QuadrantCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize(),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = description,
                textAlign = TextAlign.Justify,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun InfoScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onBack,
            modifier = Modifier.align(Alignment.Start)
        ) {
            Text("← Назад к меню")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color(0xFF6750A4), shape = MaterialTheme.shapes.medium)
        ) {
            Text(
                text = "👤",
                fontSize = 48.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Долгополов Олег Юрьевич ПИз-231",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Студент / Разработчик",
            fontSize = 18.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Увлекаюсь Android-разработкой и Jetpack Compose. Создаю современные приложения с красивым UI.",
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainMenu() {
    MyApplicationTheme {
        MainMenu()
    }
}
