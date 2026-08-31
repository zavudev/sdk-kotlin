// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.introspect

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IntrospectValidateEmailParamsTest {

    @Test
    fun create() {
        IntrospectValidateEmailParams.builder()
            .email("maria@example.com")
            .addEmail("maria@example.com")
            .addEmail("info@deaddomain.example")
            .build()
    }

    @Test
    fun body() {
        val params =
            IntrospectValidateEmailParams.builder()
                .email("maria@example.com")
                .addEmail("maria@example.com")
                .addEmail("info@deaddomain.example")
                .build()

        val body = params._body()

        assertThat(body.email()).isEqualTo("maria@example.com")
        assertThat(body.emails()).containsExactly("maria@example.com", "info@deaddomain.example")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = IntrospectValidateEmailParams.builder().build()

        val body = params._body()
    }
}
