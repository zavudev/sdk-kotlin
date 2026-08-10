// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.phonenumbers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PhoneNumberUpdateParamsTest {

    @Test
    fun create() {
        PhoneNumberUpdateParams.builder()
            .phoneNumberId("phoneNumberId")
            .name("Support Line")
            .senderId("senderId")
            .build()
    }

    @Test
    fun pathParams() {
        val params = PhoneNumberUpdateParams.builder().phoneNumberId("phoneNumberId").build()

        assertThat(params._pathParam(0)).isEqualTo("phoneNumberId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            PhoneNumberUpdateParams.builder()
                .phoneNumberId("phoneNumberId")
                .name("Support Line")
                .senderId("senderId")
                .build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("Support Line")
        assertThat(body.senderId()).isEqualTo("senderId")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = PhoneNumberUpdateParams.builder().phoneNumberId("phoneNumberId").build()

        val body = params._body()
    }
}
