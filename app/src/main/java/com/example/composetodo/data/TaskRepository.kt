package com.example.composetodo.data

import android.content.Context
import android.content.SharedPreferences
import com.example.composetodo.model.Task
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class TaskRepository(context: Context) {
    private val sharedPreferences: SharedPreferences = 
        context.getSharedPreferences("tasks", Context.MODE_PRIVATE)
    
    private val json = Json { 
        ignoreUnknownKeys = true 
        prettyPrint = true
    }
    
    fun saveTasks(tasks: List<Task>) {
        val tasksJson = json.encodeToString(tasks)
        sharedPreferences.edit().putString("tasks_key", tasksJson).apply()
    }
    
    fun loadTasks(): List<Task> {
        val tasksJson = sharedPreferences.getString("tasks_key", "[]")
        return try {
            json.decodeFromString(tasksJson ?: "[]")
        } catch (e: Exception) {
            emptyList()
        }
    }
} 