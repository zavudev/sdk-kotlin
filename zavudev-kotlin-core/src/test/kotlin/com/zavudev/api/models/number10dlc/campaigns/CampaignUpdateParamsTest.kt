// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.number10dlc.campaigns

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CampaignUpdateParamsTest {

    @Test
    fun create() {
        CampaignUpdateParams.builder()
            .campaignId("campaignId")
            .description("description")
            .helpMessage("helpMessage")
            .messageFlow("messageFlow")
            .name("name")
            .addOptInKeyword("string")
            .addOptOutKeyword("string")
            .addSampleMessage("string")
            .build()
    }

    @Test
    fun pathParams() {
        val params = CampaignUpdateParams.builder().campaignId("campaignId").build()

        assertThat(params._pathParam(0)).isEqualTo("campaignId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            CampaignUpdateParams.builder()
                .campaignId("campaignId")
                .description("description")
                .helpMessage("helpMessage")
                .messageFlow("messageFlow")
                .name("name")
                .addOptInKeyword("string")
                .addOptOutKeyword("string")
                .addSampleMessage("string")
                .build()

        val body = params._body()

        assertThat(body.description()).isEqualTo("description")
        assertThat(body.helpMessage()).isEqualTo("helpMessage")
        assertThat(body.messageFlow()).isEqualTo("messageFlow")
        assertThat(body.name()).isEqualTo("name")
        assertThat(body.optInKeywords()).containsExactly("string")
        assertThat(body.optOutKeywords()).containsExactly("string")
        assertThat(body.sampleMessages()).containsExactly("string")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = CampaignUpdateParams.builder().campaignId("campaignId").build()

        val body = params._body()
    }
}
