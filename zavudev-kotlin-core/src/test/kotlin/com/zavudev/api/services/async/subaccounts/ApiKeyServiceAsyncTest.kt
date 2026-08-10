// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.subaccounts

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.subaccounts.apikeys.ApiKeyCreateParams
import com.zavudev.api.models.subaccounts.apikeys.ApiKeyRevokeParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ApiKeyServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun create() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val apiKeyServiceAsync = client.subAccounts().apiKeys()

        val apiKey =
            apiKeyServiceAsync.create(
                ApiKeyCreateParams.builder()
                    .id("id")
                    .name("Production Key")
                    .environment(ApiKeyCreateParams.Environment.LIVE)
                    .addPermission("string")
                    .build()
            )

        apiKey.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val apiKeyServiceAsync = client.subAccounts().apiKeys()

        val apiKeys = apiKeyServiceAsync.list("id")

        apiKeys.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun revoke() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val apiKeyServiceAsync = client.subAccounts().apiKeys()

        apiKeyServiceAsync.revoke(ApiKeyRevokeParams.builder().id("id").keyId("keyId").build())
    }
}
