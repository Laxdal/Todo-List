package com.example.composetodo.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PushPin
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetodo.ui.theme.ComposeTodoTheme
import com.example.composetodo.ui.theme.ThemePreview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskDialog(
    onDismissRequest: () -> Unit,
    onTaskAdded: (title: String, isHighlighted: Boolean, isPinned: Boolean) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var isHighlighted by remember { mutableStateOf(false) }
    var isPinned by remember { mutableStateOf(false) }
    var showError by remember { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text("添加新任务") },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = title,
                    onValueChange = {
                        title = it
                        showError = false
                    },
                    label = { Text("任务标题") },
                    singleLine = true,
                    isError = showError,
                    supportingText = if (showError) {
                        { Text("请输入任务标题") }
                    } else null,
                    modifier = Modifier.fillMaxWidth()
                )

                // 高亮和置顶选项
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Checkbox(
                            checked = isHighlighted,
                            onCheckedChange = { isHighlighted = it }
                        )
                        Icon(Icons.Outlined.Star, contentDescription = null)
                        Text("高亮")
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Checkbox(
                            checked = isPinned,
                            onCheckedChange = { isPinned = it }
                        )
                        Icon(Icons.Outlined.PushPin, contentDescription = null)
                        Text("置顶")
                    }
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (title.isBlank()) {
                        showError = true
                    } else {
                        onTaskAdded(title, isHighlighted, isPinned)
                        onDismissRequest()
                    }
                }
            ) {
                Text("添加")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text("取消")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun AddTaskDialogPreview() {
    ComposeTodoTheme {
        Surface {
            AddTaskDialog(
                onDismissRequest = {},
                onTaskAdded = { _, _, _ -> }
            )
        }
    }
} 