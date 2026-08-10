// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.subaccounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.zavudev.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SubAccountGetBalanceResponseTest {

    @Test
    fun create() {
        val subAccountGetBalanceResponse =
            SubAccountGetBalanceResponse.builder()
                .balance(0L)
                .currency("usd")
                .creditLimit(0L)
                .isSubAccount(true)
                .totalSpent(0L)
                .build()

        assertThat(subAccountGetBalanceResponse.balance()).isEqualTo(0L)
        assertThat(subAccountGetBalanceResponse.currency()).isEqualTo("usd")
        assertThat(subAccountGetBalanceResponse.creditLimit()).isEqualTo(0L)
        assertThat(subAccountGetBalanceResponse.isSubAccount()).isEqualTo(true)
        assertThat(subAccountGetBalanceResponse.totalSpent()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val subAccountGetBalanceResponse =
            SubAccountGetBalanceResponse.builder()
                .balance(0L)
                .currency("usd")
                .creditLimit(0L)
                .isSubAccount(true)
                .totalSpent(0L)
                .build()

        val roundtrippedSubAccountGetBalanceResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(subAccountGetBalanceResponse),
                jacksonTypeRef<SubAccountGetBalanceResponse>(),
            )

        assertThat(roundtrippedSubAccountGetBalanceResponse).isEqualTo(subAccountGetBalanceResponse)
    }
}
