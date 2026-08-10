// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.number10dlc.brands

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandCreateParamsTest {

    @Test
    fun create() {
        BrandCreateParams.builder()
            .city("San Francisco")
            .country("US")
            .displayName("Acme Corp")
            .email("compliance@acme.com")
            .entityType(BrandCreateParams.EntityType.PRIVATE_PROFIT)
            .phone("+14155551234")
            .postalCode("94102")
            .state("CA")
            .street("123 Main St")
            .vertical("Technology")
            .companyName("Acme Corporation")
            .ein("12-3456789")
            .firstName("firstName")
            .lastName("lastName")
            .stockExchange("stockExchange")
            .stockSymbol("stockSymbol")
            .website("https://acme.com")
            .build()
    }

    @Test
    fun body() {
        val params =
            BrandCreateParams.builder()
                .city("San Francisco")
                .country("US")
                .displayName("Acme Corp")
                .email("compliance@acme.com")
                .entityType(BrandCreateParams.EntityType.PRIVATE_PROFIT)
                .phone("+14155551234")
                .postalCode("94102")
                .state("CA")
                .street("123 Main St")
                .vertical("Technology")
                .companyName("Acme Corporation")
                .ein("12-3456789")
                .firstName("firstName")
                .lastName("lastName")
                .stockExchange("stockExchange")
                .stockSymbol("stockSymbol")
                .website("https://acme.com")
                .build()

        val body = params._body()

        assertThat(body.city()).isEqualTo("San Francisco")
        assertThat(body.country()).isEqualTo("US")
        assertThat(body.displayName()).isEqualTo("Acme Corp")
        assertThat(body.email()).isEqualTo("compliance@acme.com")
        assertThat(body.entityType()).isEqualTo(BrandCreateParams.EntityType.PRIVATE_PROFIT)
        assertThat(body.phone()).isEqualTo("+14155551234")
        assertThat(body.postalCode()).isEqualTo("94102")
        assertThat(body.state()).isEqualTo("CA")
        assertThat(body.street()).isEqualTo("123 Main St")
        assertThat(body.vertical()).isEqualTo("Technology")
        assertThat(body.companyName()).isEqualTo("Acme Corporation")
        assertThat(body.ein()).isEqualTo("12-3456789")
        assertThat(body.firstName()).isEqualTo("firstName")
        assertThat(body.lastName()).isEqualTo("lastName")
        assertThat(body.stockExchange()).isEqualTo("stockExchange")
        assertThat(body.stockSymbol()).isEqualTo("stockSymbol")
        assertThat(body.website()).isEqualTo("https://acme.com")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            BrandCreateParams.builder()
                .city("San Francisco")
                .country("US")
                .displayName("Acme Corp")
                .email("compliance@acme.com")
                .entityType(BrandCreateParams.EntityType.PRIVATE_PROFIT)
                .phone("+14155551234")
                .postalCode("94102")
                .state("CA")
                .street("123 Main St")
                .vertical("Technology")
                .build()

        val body = params._body()

        assertThat(body.city()).isEqualTo("San Francisco")
        assertThat(body.country()).isEqualTo("US")
        assertThat(body.displayName()).isEqualTo("Acme Corp")
        assertThat(body.email()).isEqualTo("compliance@acme.com")
        assertThat(body.entityType()).isEqualTo(BrandCreateParams.EntityType.PRIVATE_PROFIT)
        assertThat(body.phone()).isEqualTo("+14155551234")
        assertThat(body.postalCode()).isEqualTo("94102")
        assertThat(body.state()).isEqualTo("CA")
        assertThat(body.street()).isEqualTo("123 Main St")
        assertThat(body.vertical()).isEqualTo("Technology")
    }
}
