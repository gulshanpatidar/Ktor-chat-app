package com.example.ktor_chat_app.data.remote

import com.example.ktor_chat_app.data.remote.dto.MessageDto
import com.example.ktor_chat_app.domain.model.Message
import io.ktor.client.*
import io.ktor.client.request.*
import java.lang.Exception

class MessageServiceImpl(
    private val client: HttpClient
): MessageService {

    override suspend fun getAllMessages(): List<Message> {
        return try {
            client.get<List<MessageDto>>(MessageService.EndPoints.GetAllMessages.url)
                .map { it.toMessage() }
        }catch (e: Exception){
            emptyList()
        }
    }
}