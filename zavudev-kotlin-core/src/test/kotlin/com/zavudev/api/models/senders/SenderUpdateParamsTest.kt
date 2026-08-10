// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.senders

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SenderUpdateParamsTest {

    @Test
    fun create() {
        SenderUpdateParams.builder()
            .senderId("senderId")
            .emailAddress("noreply@yourdomain.com")
            .emailCatchAllEnabled(true)
            .emailDomainId("emailDomainId")
            .emailFromName("emailFromName")
            .emailReceivingEnabled(true)
            .enableSmsOneway(true)
            .enableVoice(true)
            .name("name")
            .setAsDefault(true)
            .webhookActive(true)
            .addWebhookEvent(WebhookEvent.MESSAGE_QUEUED)
            .webhookSignatureVersion(SenderUpdateParams.WebhookSignatureVersion.V2)
            .webhookUrl("https://example.com")
            .build()
    }

    @Test
    fun pathParams() {
        val params = SenderUpdateParams.builder().senderId("senderId").build()

        assertThat(params._pathParam(0)).isEqualTo("senderId")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            SenderUpdateParams.builder()
                .senderId("senderId")
                .emailAddress("noreply@yourdomain.com")
                .emailCatchAllEnabled(true)
                .emailDomainId("emailDomainId")
                .emailFromName("emailFromName")
                .emailReceivingEnabled(true)
                .enableSmsOneway(true)
                .enableVoice(true)
                .name("name")
                .setAsDefault(true)
                .webhookActive(true)
                .addWebhookEvent(WebhookEvent.MESSAGE_QUEUED)
                .webhookSignatureVersion(SenderUpdateParams.WebhookSignatureVersion.V2)
                .webhookUrl("https://example.com")
                .build()

        val body = params._body()

        assertThat(body.emailAddress()).isEqualTo("noreply@yourdomain.com")
        assertThat(body.emailCatchAllEnabled()).isEqualTo(true)
        assertThat(body.emailDomainId()).isEqualTo("emailDomainId")
        assertThat(body.emailFromName()).isEqualTo("emailFromName")
        assertThat(body.emailReceivingEnabled()).isEqualTo(true)
        assertThat(body.enableSmsOneway()).isEqualTo(true)
        assertThat(body.enableVoice()).isEqualTo(true)
        assertThat(body.name()).isEqualTo("name")
        assertThat(body.setAsDefault()).isEqualTo(true)
        assertThat(body.webhookActive()).isEqualTo(true)
        assertThat(body.webhookEvents()).containsExactly(WebhookEvent.MESSAGE_QUEUED)
        assertThat(body.webhookSignatureVersion())
            .isEqualTo(SenderUpdateParams.WebhookSignatureVersion.V2)
        assertThat(body.webhookUrl()).isEqualTo("https://example.com")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = SenderUpdateParams.builder().senderId("senderId").build()

        val body = params._body()
    }
}
