package com.example.ktor_chat_app.data.remote

import com.example.ktor_chat_app.domain.model.Message

interface MessageService {

    suspend fun getAllMessages(): List<Message>

    companion object{
        const val BASE_URL = "http://10.0.2.2:8080"
    }

    sealed class EndPoints(val url: String){
        object GetAllMessages: EndPoints("$BASE_URL/messages")
    }
}