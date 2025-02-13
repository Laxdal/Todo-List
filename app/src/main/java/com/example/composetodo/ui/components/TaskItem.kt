package com.example.composetodo.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PushPin
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetodo.model.Task
import com.example.composetodo.ui.theme.ComposeTodoTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TaskItem(
    task: Task,
    onTaskCheckedChange: (Boolean) -> Unit,
    onDeleteTask: () -> Unit,
    onToggleHighlight: () -> Unit,
    onTogglePin: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showMenu by remember { mutableStateOf(false) }
    
    Card(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize()
            .combinedClickable(
                onClick = { /* 单击不做任何事 */ },
                onLongClick = { showMenu = true }
            ),
        colors = CardDefaults.cardColors(
            containerColor = when {
                task.isHighlighted -> MaterialTheme.colorScheme.primaryContainer
                else -> MaterialTheme.colorScheme.secondaryContainer
            }
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Checkbox(
                checked = task.isCompleted,
                onCheckedChange = onTaskCheckedChange,
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.primary,
                    uncheckedColor = MaterialTheme.colorScheme.onSecondaryContainer
                )
            )
            
            Text(
                text = task.title,
                style = MaterialTheme.typography.bodyLarge,
                color = if (task.isCompleted) {
                    MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.6f)
                } else {
                    MaterialTheme.colorScheme.onSecondaryContainer
                },
                textDecoration = if (task.isCompleted) {
                    TextDecoration.LineThrough
                } else {
                    null
                },
                modifier = Modifier.weight(1f)
            )
            
            // 显示状态图标
            if (task.isPinned) {
                Icon(
                    Icons.Default.PushPin,
                    contentDescription = "已置顶",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
            }
            
            if (task.isHighlighted) {
                Icon(
                    Icons.Default.Star,
                    contentDescription = "已高亮",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
    
    TaskMenu(
        expanded = showMenu,
        onDismissRequest = { showMenu = false },
        onDeleteClick = onDeleteTask,
        onToggleHighlight = onToggleHighlight,
        onTogglePin = onTogglePin,
        isHighlighted = task.isHighlighted,
        isPinned = task.isPinned
    )
}

@Preview(showBackground = true)
@Composable
private fun TaskItemPreview() {
    ComposeTodoTheme {
        TaskItem(
            task = Task(title = "预览任务", isCompleted = false),
            onTaskCheckedChange = {},
            onDeleteTask = {},
            onToggleHighlight = {},
            onTogglePin = {}
        )
    }
} 