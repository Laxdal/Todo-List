package com.example.composetodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.composetodo.data.TaskRepository
import com.example.composetodo.ui.TodoScreen
import com.example.composetodo.ui.theme.ComposeTodoTheme

class MainActivity : ComponentActivity() {
    private lateinit var taskRepository: TaskRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        taskRepository = TaskRepository(this)
        
        setContent {
            ComposeTodoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TodoScreen(
                        initialTasks = taskRepository.loadTasks(),
                        onTasksChanged = { tasks ->
                            taskRepository.saveTasks(tasks)
                        }
                    )
                }
            }
        }
    }
} 