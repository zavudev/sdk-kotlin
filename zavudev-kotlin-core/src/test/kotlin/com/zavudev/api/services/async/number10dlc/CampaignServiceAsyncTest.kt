// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.number10dlc

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.number10dlc.campaigns.CampaignCreateParams
import com.zavudev.api.models.number10dlc.campaigns.CampaignUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CampaignServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun create() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val campaignServiceAsync = client.number10dlc().campaigns()

        val campaign =
            campaignServiceAsync.create(
                CampaignCreateParams.builder()
                    .affiliateMarketing(false)
                    .ageGated(false)
                    .brandId("brand_abc123")
                    .description(
                        "Send order status updates and shipping notifications to customers who opted in."
                    )
                    .directLending(false)
                    .embeddedLink(true)
                    .embeddedPhone(false)
                    .name("Order Notifications")
                    .numberPooling(false)
                    .addSampleMessage(
                        "Hi {{name}}, your order #{{order_id}} has shipped! Track it at {{url}}"
                    )
                    .addSampleMessage(
                        "Your order #{{order_id}} has been delivered. Thank you for your purchase!"
                    )
                    .subscriberHelp(true)
                    .subscriberOptIn(true)
                    .subscriberOptOut(true)
                    .useCase("ACCOUNT_NOTIFICATION")
                    .helpMessage("helpMessage")
                    .messageFlow("messageFlow")
                    .addOptInKeyword("string")
                    .addOptOutKeyword("string")
                    .addSubUseCase("string")
                    .build()
            )

        campaign.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val campaignServiceAsync = client.number10dlc().campaigns()

        val campaign = campaignServiceAsync.retrieve("campaignId")

        campaign.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun update() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val campaignServiceAsync = client.number10dlc().campaigns()

        val campaign =
            campaignServiceAsync.update(
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
            )

        campaign.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val campaignServiceAsync = client.number10dlc().campaigns()

        val page = campaignServiceAsync.list()

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun delete() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val campaignServiceAsync = client.number10dlc().campaigns()

        campaignServiceAsync.delete("campaignId")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun submit() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val campaignServiceAsync = client.number10dlc().campaigns()

        val response = campaignServiceAsync.submit("campaignId")

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun syncStatus() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val campaignServiceAsync = client.number10dlc().campaigns()

        val response = campaignServiceAsync.syncStatus("campaignId")

        response.validate()
    }
}
