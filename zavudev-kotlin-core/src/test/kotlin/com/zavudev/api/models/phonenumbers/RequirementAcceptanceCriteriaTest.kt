// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.phonenumbers

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.zavudev.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RequirementAcceptanceCriteriaTest {

    @Test
    fun create() {
        val requirementAcceptanceCriteria =
            RequirementAcceptanceCriteria.builder()
                .addAllowedValue("string")
                .maxLength(0L)
                .minLength(0L)
                .regexPattern("regexPattern")
                .build()

        assertThat(requirementAcceptanceCriteria.allowedValues()).containsExactly("string")
        assertThat(requirementAcceptanceCriteria.maxLength()).isEqualTo(0L)
        assertThat(requirementAcceptanceCriteria.minLength()).isEqualTo(0L)
        assertThat(requirementAcceptanceCriteria.regexPattern()).isEqualTo("regexPattern")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val requirementAcceptanceCriteria =
            RequirementAcceptanceCriteria.builder()
                .addAllowedValue("string")
                .maxLength(0L)
                .minLength(0L)
                .regexPattern("regexPattern")
                .build()

        val roundtrippedRequirementAcceptanceCriteria =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(requirementAcceptanceCriteria),
                jacksonTypeRef<RequirementAcceptanceCriteria>(),
            )

        assertThat(roundtrippedRequirementAcceptanceCriteria)
            .isEqualTo(requirementAcceptanceCriteria)
    }
}
