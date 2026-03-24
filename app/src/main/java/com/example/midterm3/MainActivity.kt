package com.example.midterm3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.midterm3.ui.theme.Midterm3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Midterm3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StudentScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

private val students = listOf(
    "Alice","Bob","Charlie","Dana","Eric",
    "Fatima","Grace","Hiro","Isabel","Jack",
    "Karen","Luis","Maya","Nate","Olivia",
    "Priya","Quinn","Ravi","Sara","Tom", "Pardesh",
)

@Composable
fun StudentScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "CS 501 Midterm pt.3 ",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(students.size) { index ->
                val name = students[index]
                StudentCard(
                    index = index + 1,
                    name = name
                )
            }
        }
    }
}

@Composable
fun StudentCard(
    index: Int,
    name: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = index.toString(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = name,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudentPreview() {
    Midterm3Theme {
        StudentScreen()
    }
}
