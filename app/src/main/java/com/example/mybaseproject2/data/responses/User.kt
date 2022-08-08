package com.example.mybaseproject2.data.responses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    val access_token: String?,
    val refresh_token: String?,
    val created_at: String,
    val email: String?,
    @PrimaryKey
    val phone: String,
    val email_verified_at: String?,
    val id: String?,
    val name: String,
    val updated_at: String?
)