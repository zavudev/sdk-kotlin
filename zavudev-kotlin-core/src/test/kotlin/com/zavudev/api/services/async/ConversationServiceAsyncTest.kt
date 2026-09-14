// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ConversationServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val conversationServiceAsync = client.conversations()

        val conversation = conversationServiceAsync.retrieve("conversationId")

        conversation.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val conversationServiceAsync = client.conversations()

        val page = conversationServiceAsync.list()

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun listMessages() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val conversationServiceAsync = client.conversations()

        val page = conversationServiceAsync.listMessages("conversationId")

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun markAsRead() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val conversationServiceAsync = client.conversations()

        val response = conversationServiceAsync.markAsRead("conversationId")

        response.validate()
    }
}
