package com.example.roomdemoapp.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Created by Tirth Patel.
 */
@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val phone: String,
    val createdDate: Date,
    val isActive: Int
)