// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders.agent

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.senders.agent.knowledgebases.KnowledgeBaseCreateParams
import com.zavudev.api.models.senders.agent.knowledgebases.KnowledgeBaseDeleteParams
import com.zavudev.api.models.senders.agent.knowledgebases.KnowledgeBaseRetrieveParams
import com.zavudev.api.models.senders.agent.knowledgebases.KnowledgeBaseUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class KnowledgeBaseServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun create() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val knowledgeBaseServiceAsync = client.senders().agent().knowledgeBases()

        val knowledgeBase =
            knowledgeBaseServiceAsync.create(
                KnowledgeBaseCreateParams.builder()
                    .senderId("senderId")
                    .name("Product FAQ")
                    .description("Frequently asked questions about our products")
                    .build()
            )

        knowledgeBase.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val knowledgeBaseServiceAsync = client.senders().agent().knowledgeBases()

        val knowledgeBase =
            knowledgeBaseServiceAsync.retrieve(
                KnowledgeBaseRetrieveParams.builder().senderId("senderId").kbId("kbId").build()
            )

        knowledgeBase.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun update() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val knowledgeBaseServiceAsync = client.senders().agent().knowledgeBases()

        val knowledgeBase =
            knowledgeBaseServiceAsync.update(
                KnowledgeBaseUpdateParams.builder()
                    .senderId("senderId")
                    .kbId("kbId")
                    .description("description")
                    .name("name")
                    .build()
            )

        knowledgeBase.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val knowledgeBaseServiceAsync = client.senders().agent().knowledgeBases()

        val page = knowledgeBaseServiceAsync.list("senderId")

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun delete() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val knowledgeBaseServiceAsync = client.senders().agent().knowledgeBases()

        knowledgeBaseServiceAsync.delete(
            KnowledgeBaseDeleteParams.builder().senderId("senderId").kbId("kbId").build()
        )
    }
}
