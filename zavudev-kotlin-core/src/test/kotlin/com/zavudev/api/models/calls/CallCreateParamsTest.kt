// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.calls

import com.zavudev.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CallCreateParamsTest {

    @Test
    fun create() {
        CallCreateParams.builder()
            .to("+56912345678")
            .greeting("greeting")
            .language("es-ES")
            .maxDurationMinutes(1L)
            .metadata(
                CallCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
            .senderId("sender_12345")
            .build()
    }

    @Test
    fun body() {
        val params =
            CallCreateParams.builder()
                .to("+56912345678")
                .greeting("greeting")
                .language("es-ES")
                .maxDurationMinutes(1L)
                .metadata(
                    CallCreateParams.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .senderId("sender_12345")
                .build()

        val body = params._body()

        assertThat(body.to()).isEqualTo("+56912345678")
        assertThat(body.greeting()).isEqualTo("greeting")
        assertThat(body.language()).isEqualTo("es-ES")
        assertThat(body.maxDurationMinutes()).isEqualTo(1L)
        assertThat(body.metadata())
            .isEqualTo(
                CallCreateParams.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(body.senderId()).isEqualTo("sender_12345")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = CallCreateParams.builder().to("+56912345678").build()

        val body = params._body()

        assertThat(body.to()).isEqualTo("+56912345678")
    }
}
