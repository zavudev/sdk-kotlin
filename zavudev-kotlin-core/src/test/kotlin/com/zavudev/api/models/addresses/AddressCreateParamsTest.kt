// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.addresses

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AddressCreateParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.countryCode()).isEqualTo("DE")
        assertThat(body.locality()).isEqualTo("Berlin")
        assertThat(body.postalCode()).isEqualTo("10115")
        assertThat(body.streetAddress()).isEqualTo("123 Main St")
        assertThat(body.administrativeArea()).isEqualTo("administrativeArea")
        assertThat(body.businessName()).isEqualTo("businessName")
        assertThat(body.extendedAddress()).isEqualTo("extendedAddress")
        assertThat(body.firstName()).isEqualTo("John")
        assertThat(body.lastName()).isEqualTo("Doe")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            AddressCreateParams.builder()
                .countryCode("DE")
                .locality("Berlin")
                .postalCode("10115")
                .streetAddress("123 Main St")
                .build()

        val body = params._body()

        assertThat(body.countryCode()).isEqualTo("DE")
        assertThat(body.locality()).isEqualTo("Berlin")
        assertThat(body.postalCode()).isEqualTo("10115")
        assertThat(body.streetAddress()).isEqualTo("123 Main St")
    }
}
