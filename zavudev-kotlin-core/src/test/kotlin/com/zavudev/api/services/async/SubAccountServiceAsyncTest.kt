// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.core.JsonValue
import com.zavudev.api.models.subaccounts.SubAccountCreateParams
import com.zavudev.api.models.subaccounts.SubAccountUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class SubAccountServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun create() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val subAccountServiceAsync = client.subAccounts()

        val subAccount =
            subAccountServiceAsync.create(
                SubAccountCreateParams.builder()
                    .name("Client ABC")
                    .creditLimit(0L)
                    .externalId("externalId")
                    .metadata(
                        SubAccountCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .build()
            )

        subAccount.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val subAccountServiceAsync = client.subAccounts()

        val subAccount = subAccountServiceAsync.retrieve("id")

        subAccount.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun update() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val subAccountServiceAsync = client.subAccounts()

        val subAccount =
            subAccountServiceAsync.update(
                SubAccountUpdateParams.builder()
                    .id("id")
                    .creditLimit(0L)
                    .externalId("externalId")
                    .metadata(
                        SubAccountUpdateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .name("name")
                    .status(SubAccountUpdateParams.Status.ACTIVE)
                    .build()
            )

        subAccount.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val subAccountServiceAsync = client.subAccounts()

        val page = subAccountServiceAsync.list()

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun deactivate() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val subAccountServiceAsync = client.subAccounts()

        val response = subAccountServiceAsync.deactivate("id")

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun getBalance() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val subAccountServiceAsync = client.subAccounts()

        val response = subAccountServiceAsync.getBalance("id")

        response.validate()
    }
}
