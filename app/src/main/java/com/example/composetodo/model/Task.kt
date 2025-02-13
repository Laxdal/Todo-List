package com.example.composetodo.model

import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val id: Long = System.currentTimeMillis(), // 使用时间戳作为唯一ID
    val title: String,
    var isCompleted: Boolean = false,
    var isHighlighted: Boolean = false,
    var isPinned: Boolean = false,
    val createdAt: Long = System.currentTimeMillis() // 用于排序
) 