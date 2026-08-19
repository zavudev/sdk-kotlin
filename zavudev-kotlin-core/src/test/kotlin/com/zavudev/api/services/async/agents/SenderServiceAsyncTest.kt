// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.agents

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.agents.senders.SenderConnectParams
import com.zavudev.api.models.agents.senders.SenderDisconnectParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class SenderServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun connect() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val senderServiceAsync = client.agents().senders()

        val response =
            senderServiceAsync.connect(
                SenderConnectParams.builder().agentId("agentId").senderId("senderId").build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun disconnect() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val senderServiceAsync = client.agents().senders()

        senderServiceAsync.disconnect(
            SenderDisconnectParams.builder().agentId("agentId").senderId("senderId").build()
        )
    }
}
