// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders.agent.tools

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.senders.agent.tools.webhook.WebhookRotateSecretParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class WebhookServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun rotateSecret() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val webhookServiceAsync = client.senders().agent().tools().webhook()

        val webhookSecretResponse =
            webhookServiceAsync.rotateSecret(
                WebhookRotateSecretParams.builder().senderId("senderId").toolId("toolId").build()
            )

        webhookSecretResponse.validate()
    }
}
