package com.example.composetodo.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composetodo.model.Task
import com.example.composetodo.ui.theme.ComposeTodoTheme
import com.example.composetodo.ui.theme.ThemePreview

@Composable
fun TaskStats(
    tasks: List<Task>,
    modifier: Modifier = Modifier
) {
    val completedTasks = tasks.count { it.isCompleted }
    val totalTasks = tasks.size

    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "任务进度",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$completedTasks",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "/",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "$totalTasks",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

@Composable
@ThemePreview
private fun TaskStatsPreview() {
    ComposeTodoTheme {
        Surface {
            TaskStats(
                tasks = listOf(
                    Task(title = "任务1", isCompleted = true),
                    Task(title = "任务2", isCompleted = true),
                    Task(title = "任务3", isCompleted = false),
                    Task(title = "任务4", isCompleted = false)
                )
            )
        }
    }
} 