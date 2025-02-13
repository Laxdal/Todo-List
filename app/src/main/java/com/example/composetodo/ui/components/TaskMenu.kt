package com.example.composetodo.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PushPin
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.PushPin
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun TaskMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    onDeleteClick: () -> Unit,
    onToggleHighlight: () -> Unit,
    onTogglePin: () -> Unit,
    isHighlighted: Boolean,
    isPinned: Boolean
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        offset = DpOffset(0.dp, 8.dp)
    ) {
        DropdownMenuItem(
            text = { Text("删除任务") },
            onClick = {
                onDeleteClick()
                onDismissRequest()
            },
            leadingIcon = {
                Icon(Icons.Default.Delete, contentDescription = "删除")
            }
        )
        
        DropdownMenuItem(
            text = { Text(if (isHighlighted) "取消高亮" else "高亮任务") },
            onClick = {
                onToggleHighlight()
                onDismissRequest()
            },
            leadingIcon = {
                Icon(
                    if (isHighlighted) Icons.Filled.Star else Icons.Outlined.Star,
                    contentDescription = if (isHighlighted) "取消高亮" else "高亮"
                )
            }
        )
        
        DropdownMenuItem(
            text = { Text(if (isPinned) "取消置顶" else "置顶任务") },
            onClick = {
                onTogglePin()
                onDismissRequest()
            },
            leadingIcon = {
                Icon(
                    if (isPinned) Icons.Filled.PushPin else Icons.Outlined.PushPin,
                    contentDescription = if (isPinned) "取消置顶" else "置顶"
                )
            }
        )
    }
} 