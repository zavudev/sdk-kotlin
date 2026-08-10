// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.functions

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.functions.secrets.SecretSetParams
import com.zavudev.api.models.functions.secrets.SecretUnsetParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class SecretServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val secretServiceAsync = client.functions().secrets()

        val secrets = secretServiceAsync.list("functionId")

        secrets.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun set() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val secretServiceAsync = client.functions().secrets()

        val response =
            secretServiceAsync.set(
                SecretSetParams.builder().functionId("functionId").key("key").value("value").build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun unset() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val secretServiceAsync = client.functions().secrets()

        secretServiceAsync.unset(
            SecretUnsetParams.builder().functionId("functionId").key("key").build()
        )
    }
}
