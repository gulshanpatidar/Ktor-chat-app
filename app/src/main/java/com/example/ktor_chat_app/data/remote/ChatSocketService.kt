package com.example.ktor_chat_app.data.remote

import com.example.ktor_chat_app.domain.model.Message
import com.example.ktor_chat_app.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initSession(
        username: String
    ): Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessages(): Flow<Message>

    suspend fun closeSession()

    companion object{
        const val BASE_URL = "ws://192.168.0.118:8080"
    }

    sealed class EndPoints(val url: String){
        object ChatSocket: EndPoints("$BASE_URL/chat-socket")
    }
}