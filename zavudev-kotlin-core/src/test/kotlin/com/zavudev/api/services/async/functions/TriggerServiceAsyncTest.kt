// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.functions

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.functions.triggers.TriggerCreateParams
import com.zavudev.api.models.functions.triggers.TriggerUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TriggerServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun create() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val triggerServiceAsync = client.functions().triggers()

        val trigger =
            triggerServiceAsync.create(
                TriggerCreateParams.builder()
                    .functionId("functionId")
                    .addEventType("message.inbound")
                    .addSenderId(null)
                    .cron("0 9 * * 1-5")
                    .build()
            )

        trigger.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun update() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val triggerServiceAsync = client.functions().triggers()

        val trigger =
            triggerServiceAsync.update(
                TriggerUpdateParams.builder().triggerId("triggerId").active(true).build()
            )

        trigger.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val triggerServiceAsync = client.functions().triggers()

        val triggers = triggerServiceAsync.list("functionId")

        triggers.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun delete() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val triggerServiceAsync = client.functions().triggers()

        triggerServiceAsync.delete("triggerId")
    }
}
