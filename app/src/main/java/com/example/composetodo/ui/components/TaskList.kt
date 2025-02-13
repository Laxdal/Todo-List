package com.example.composetodo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.composetodo.model.Task
import com.example.composetodo.ui.theme.ComposeTodoTheme
import com.example.composetodo.ui.theme.ThemePreview

@Composable
fun TaskList(
    tasks: List<Task>,
    onTaskCheckedChange: (Task, Boolean) -> Unit,
    onDeleteTask: (Task) -> Unit,
    onToggleHighlight: (Task) -> Unit,
    onTogglePin: (Task) -> Unit
) {
    val sortedTasks = tasks.sortedWith(
        compareByDescending<Task> { it.isPinned }
            .thenBy { it.isCompleted }
            .thenBy { it.createdAt }
    )
    
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(
            items = sortedTasks,
            key = { task -> task.id }
        ) { task ->
            TaskItem(
                task = task,
                onTaskCheckedChange = { isChecked ->
                    onTaskCheckedChange(task, isChecked)
                },
                onDeleteTask = { onDeleteTask(task) },
                onToggleHighlight = { onToggleHighlight(task) },
                onTogglePin = { onTogglePin(task) }
            )
        }
    }
}

@Composable
@ThemePreview
private fun TaskListPreview() {
    ComposeTodoTheme {
        Surface {
            TaskList(
                tasks = listOf(
                    Task(title = "完成Android项目", isCompleted = true),
                    Task(title = "学习Jetpack Compose", isCompleted = false),
                    Task(title = "准备技术分享", isCompleted = false)
                ),
                onTaskCheckedChange = { _, _ -> },
                onDeleteTask = { _ -> },
                onToggleHighlight = { _ -> },
                onTogglePin = { _ -> }
            )
        }
    }
} 