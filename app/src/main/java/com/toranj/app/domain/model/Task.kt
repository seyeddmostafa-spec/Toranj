package com.toranj.app.domain.model

data class Task(val id: Long = 0, val title: String, val category: String = "عمومی", val completed: Boolean = false, val createdAt: Long = System.currentTimeMillis())
