package com.example.mybaseproject2.data.responses

data class LoginResponse(
    val avatar: Any,
    val doctor_id: Any,
    val email: String?,
    val email_verified: Int,
    val gender: Int?,
    val key: String,
    val message: Message?,
    val name: String,
    val occupation: Int?,
    val phone: String,
    val success: String,
    val userid: Int
)

data class Message(
    val body: List<String>
)