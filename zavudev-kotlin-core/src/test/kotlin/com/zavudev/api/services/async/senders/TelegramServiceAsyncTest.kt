// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.senders.telegram.TelegramConnectParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TelegramServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun connect() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val telegramServiceAsync = client.senders().telegram()

        val response =
            telegramServiceAsync.connect(
                TelegramConnectParams.builder().senderId("senderId").botToken("botToken").build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun disconnect() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val telegramServiceAsync = client.senders().telegram()

        telegramServiceAsync.disconnect("senderId")
    }
}
