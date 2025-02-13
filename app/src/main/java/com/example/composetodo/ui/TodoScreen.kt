package com.example.composetodo.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composetodo.model.Task
import com.example.composetodo.ui.components.AddTaskDialog
import com.example.composetodo.ui.components.TaskList
import com.example.composetodo.ui.components.TaskStats
import com.example.composetodo.ui.theme.ComposeTodoTheme
import com.example.composetodo.ui.theme.ThemePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen(
    initialTasks: List<Task> = emptyList(),
    onTasksChanged: (List<Task>) -> Unit = {}
) {
    var tasks by remember { mutableStateOf(initialTasks) }
    var showAddDialog by remember { mutableStateOf(false) }
    
    // 当tasks发生变化时通知外部
    LaunchedEffect(tasks) {
        onTasksChanged(tasks)
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("待办事项") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(Icons.Default.Add, contentDescription = "添加任务")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 显示任务统计
            TaskStats(tasks = tasks)
            
            // 显示任务列表
            TaskList(
                tasks = tasks,
                onTaskCheckedChange = { task, isCompleted ->
                    tasks = tasks.map { 
                        if (it.id == task.id) it.copy(isCompleted = isCompleted) else it 
                    }
                },
                onDeleteTask = { task ->
                    tasks = tasks.filterNot { it.id == task.id }
                },
                onToggleHighlight = { task ->
                    tasks = tasks.map {
                        if (it.id == task.id) it.copy(isHighlighted = !it.isHighlighted) else it
                    }
                },
                onTogglePin = { task ->
                    tasks = tasks.map {
                        if (it.id == task.id) it.copy(isPinned = !it.isPinned) else it
                    }
                }
            )
        }
    }

    // 显示添加任务对话框
    if (showAddDialog) {
        AddTaskDialog(
            onDismissRequest = { showAddDialog = false },
            onTaskAdded = { title, isHighlighted, isPinned ->
                tasks = tasks + Task(
                    title = title,
                    isHighlighted = isHighlighted,
                    isPinned = isPinned
                )
            }
        )
    }
}

@Composable
@ThemePreview
private fun TodoScreenPreview() {
    ComposeTodoTheme {
        Surface {
            TodoScreen()
        }
    }
} 