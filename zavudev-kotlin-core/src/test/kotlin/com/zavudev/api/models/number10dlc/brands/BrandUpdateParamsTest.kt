// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.number10dlc.brands

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BrandUpdateParamsTest {

    @Test
    fun create() {
        BrandUpdateParams.builder()
            .brandId("brandId")
            .city("city")
            .companyName("companyName")
            .country("xx")
            .displayName("displayName")
            .ein("ein")
            .email("dev@stainless.com")
            .entityType(BrandUpdateParams.EntityType.PRIVATE_PROFIT)
            .firstName("firstName")
            .lastName("lastName")
            .phone("phone")
            .postalCode("postalCode")
            .state("state")
            .stockExchange("stockExchange")
            .stockSymbol("stockSymbol")
            .street("street")
            .vertical("vertical")
            .website("https://example.com")
            .build()
    }

    @Test
    fun pathParams() {
        val params = BrandUpdateParams.builder().brandId("brandId").build()

        assertThat(params._pathParam(0)).isEqualTo("brandId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            BrandUpdateParams.builder()
                .brandId("brandId")
                .city("city")
                .companyName("companyName")
                .country("xx")
                .displayName("displayName")
                .ein("ein")
                .email("dev@stainless.com")
                .entityType(BrandUpdateParams.EntityType.PRIVATE_PROFIT)
                .firstName("firstName")
                .lastName("lastName")
                .phone("phone")
                .postalCode("postalCode")
                .state("state")
                .stockExchange("stockExchange")
                .stockSymbol("stockSymbol")
                .street("street")
                .vertical("vertical")
                .website("https://example.com")
                .build()

        val body = params._body()

        assertThat(body.city()).isEqualTo("city")
        assertThat(body.companyName()).isEqualTo("companyName")
        assertThat(body.country()).isEqualTo("xx")
        assertThat(body.displayName()).isEqualTo("displayName")
        assertThat(body.ein()).isEqualTo("ein")
        assertThat(body.email()).isEqualTo("dev@stainless.com")
        assertThat(body.entityType()).isEqualTo(BrandUpdateParams.EntityType.PRIVATE_PROFIT)
        assertThat(body.firstName()).isEqualTo("firstName")
        assertThat(body.lastName()).isEqualTo("lastName")
        assertThat(body.phone()).isEqualTo("phone")
        assertThat(body.postalCode()).isEqualTo("postalCode")
        assertThat(body.state()).isEqualTo("state")
        assertThat(body.stockExchange()).isEqualTo("stockExchange")
        assertThat(body.stockSymbol()).isEqualTo("stockSymbol")
        assertThat(body.street()).isEqualTo("street")
        assertThat(body.vertical()).isEqualTo("vertical")
        assertThat(body.website()).isEqualTo("https://example.com")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = BrandUpdateParams.builder().brandId("brandId").build()

        val body = params._body()
    }
}
