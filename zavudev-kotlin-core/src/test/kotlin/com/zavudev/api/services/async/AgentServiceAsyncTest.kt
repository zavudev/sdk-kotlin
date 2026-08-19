// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.core.JsonValue
import com.zavudev.api.models.agents.AgentCreateParams
import com.zavudev.api.models.agents.AgentListVoicesParams
import com.zavudev.api.models.agents.AgentTestParams
import com.zavudev.api.models.agents.AgentUpdateParams
import com.zavudev.api.models.senders.agent.AgentProvider
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AgentServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun create() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val agentServiceAsync = client.agents()

        val agent =
            agentServiceAsync.create(
                AgentCreateParams.builder()
                    .model("model")
                    .name("name")
                    .provider(AgentProvider.OPENAI)
                    .systemPrompt("systemPrompt")
                    .contextWindowMessages(1L)
                    .includeContactMetadata(true)
                    .maxTokens(1L)
                    .temperature(0.0)
                    .addTriggerOnChannel("string")
                    .addTriggerOnMessageType("string")
                    .voice(
                        AgentCreateParams.Voice.builder()
                            .enabled(true)
                            .greeting("Hi, thanks for calling Acme. How can I help you today?")
                            .greetings(
                                AgentCreateParams.Voice.Greetings.builder()
                                    .putAdditionalProperty(
                                        "es",
                                        JsonValue.from(
                                            "Hola, soy Atlas. Preguntame lo que quieras."
                                        ),
                                    )
                                    .build()
                            )
                            .interruptible(true)
                            .language("en")
                            .maxCallDurationMinutes(1L)
                            .maxIdleSeconds(5L)
                            .model("openai/gpt-4o")
                            .recordCalls(true)
                            .sttModel("sttModel")
                            .sttProvider("sttProvider")
                            .transferPhoneNumber("+14155551234")
                            .ttsProvider("ttsProvider")
                            .ttsVoiceId("aria")
                            .voicemailAction(AgentCreateParams.Voice.VoicemailAction.HANGUP)
                            .voicemailMessage("voicemailMessage")
                            .voiceSpeed(0.5)
                            .build()
                    )
                    .build()
            )

        agent.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val agentServiceAsync = client.agents()

        val agent = agentServiceAsync.retrieve("agentId")

        agent.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun update() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val agentServiceAsync = client.agents()

        val agent =
            agentServiceAsync.update(
                AgentUpdateParams.builder()
                    .agentId("agentId")
                    .apiKey("apiKey")
                    .contextWindowMessages(1L)
                    .enabled(true)
                    .includeContactMetadata(true)
                    .maxTokens(1L)
                    .model("model")
                    .name("name")
                    .provider(AgentProvider.OPENAI)
                    .systemPrompt("systemPrompt")
                    .temperature(0.0)
                    .addTriggerOnChannel("string")
                    .addTriggerOnMessageType("string")
                    .voice(
                        AgentUpdateParams.Voice.builder()
                            .enabled(true)
                            .greeting("Hi, thanks for calling Acme. How can I help you today?")
                            .greetings(
                                AgentUpdateParams.Voice.Greetings.builder()
                                    .putAdditionalProperty(
                                        "es",
                                        JsonValue.from(
                                            "Hola, soy Atlas. Preguntame lo que quieras."
                                        ),
                                    )
                                    .build()
                            )
                            .interruptible(true)
                            .language("en")
                            .maxCallDurationMinutes(1L)
                            .maxIdleSeconds(5L)
                            .model("openai/gpt-4o")
                            .recordCalls(true)
                            .sttModel("sttModel")
                            .sttProvider("sttProvider")
                            .transferPhoneNumber("+14155551234")
                            .ttsProvider("ttsProvider")
                            .ttsVoiceId("aria")
                            .voicemailAction(AgentUpdateParams.Voice.VoicemailAction.HANGUP)
                            .voicemailMessage("voicemailMessage")
                            .voiceSpeed(0.5)
                            .build()
                    )
                    .build()
            )

        agent.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val agentServiceAsync = client.agents()

        val page = agentServiceAsync.list()

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun delete() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val agentServiceAsync = client.agents()

        agentServiceAsync.delete("agentId")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun listVoices() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val agentServiceAsync = client.agents()

        val response =
            agentServiceAsync.listVoices(AgentListVoicesParams.builder().language("es").build())

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun test() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val agentServiceAsync = client.agents()

        val response =
            agentServiceAsync.test(
                AgentTestParams.builder()
                    .agentId("agentId")
                    .message("Where is order ORD-12345?")
                    .executeTools(true)
                    .addHistory(
                        AgentTestParams.History.builder()
                            .content("content")
                            .role(AgentTestParams.History.Role.USER)
                            .build()
                    )
                    .useKnowledgeBase(true)
                    .build()
            )

        response.validate()
    }
}
