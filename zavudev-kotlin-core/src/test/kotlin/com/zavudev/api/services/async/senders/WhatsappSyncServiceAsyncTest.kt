// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WhatsappSyncServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val whatsappSyncServiceAsync = client.senders().whatsappSync()

        val whatsappSync = whatsappSyncServiceAsync.retrieve("senderId")

        whatsappSync.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun startContactsSync() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val whatsappSyncServiceAsync = client.senders().whatsappSync()

        val response = whatsappSyncServiceAsync.startContactsSync("senderId")

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun startHistorySync() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val whatsappSyncServiceAsync = client.senders().whatsappSync()

        val response = whatsappSyncServiceAsync.startHistorySync("senderId")

        response.validate()
    }
}
