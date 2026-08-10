// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders.agent.knowledgebases

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentCreateParams
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentDeleteParams
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class DocumentServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun create() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val documentServiceAsync = client.senders().agent().knowledgeBases().documents()

        val document =
            documentServiceAsync.create(
                DocumentCreateParams.builder()
                    .senderId("senderId")
                    .kbId("kbId")
                    .content("Our return policy allows returns within 30 days of purchase...")
                    .title("Return Policy")
                    .build()
            )

        document.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val documentServiceAsync = client.senders().agent().knowledgeBases().documents()

        val page =
            documentServiceAsync.list(
                DocumentListParams.builder().senderId("senderId").kbId("kbId").build()
            )

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun delete() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val documentServiceAsync = client.senders().agent().knowledgeBases().documents()

        documentServiceAsync.delete(
            DocumentDeleteParams.builder().senderId("senderId").kbId("kbId").docId("docId").build()
        )
    }
}
