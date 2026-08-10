// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.addresses.AddressCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AddressServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun create() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val addressServiceAsync = client.addresses()

        val address =
            addressServiceAsync.create(
                AddressCreateParams.builder()
                    .countryCode("DE")
                    .locality("Berlin")
                    .postalCode("10115")
                    .streetAddress("123 Main St")
                    .administrativeArea("administrativeArea")
                    .businessName("businessName")
                    .extendedAddress("extendedAddress")
                    .firstName("John")
                    .lastName("Doe")
                    .build()
            )

        address.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val addressServiceAsync = client.addresses()

        val address = addressServiceAsync.retrieve("addressId")

        address.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val addressServiceAsync = client.addresses()

        val page = addressServiceAsync.list()

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun delete() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val addressServiceAsync = client.addresses()

        addressServiceAsync.delete("addressId")
    }
}
