// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders.agent

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.senders.agent.executions.ExecutionRetrieveParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ExecutionServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val executionServiceAsync = client.senders().agent().executions()

        val execution =
            executionServiceAsync.retrieve(
                ExecutionRetrieveParams.builder()
                    .senderId("senderId")
                    .executionId("executionId")
                    .build()
            )

        execution.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val executionServiceAsync = client.senders().agent().executions()

        val page = executionServiceAsync.list("senderId")

        page.response().validate()
    }
}
