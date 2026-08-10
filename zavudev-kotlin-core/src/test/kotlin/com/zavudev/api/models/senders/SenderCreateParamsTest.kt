// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.senders

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SenderCreateParamsTest {

    @Test
    fun create() {
        SenderCreateParams.builder()
            .name("name")
            .emailAddress("noreply@yourdomain.com")
            .emailDomainId("emailDomainId")
            .emailFromName("emailFromName")
            .emailReceivingEnabled(true)
            .enableSmsOneway(true)
            .enableVoice(true)
            .phoneNumber("phoneNumber")
            .setAsDefault(true)
            .addWebhookEvent(WebhookEvent.MESSAGE_QUEUED)
            .webhookSignatureVersion(SenderCreateParams.WebhookSignatureVersion.V2)
            .webhookUrl("https://example.com")
            .build()
    }

    @Test
    fun body() {
        val params =
            SenderCreateParams.builder()
                .name("name")
                .emailAddress("noreply@yourdomain.com")
                .emailDomainId("emailDomainId")
                .emailFromName("emailFromName")
                .emailReceivingEnabled(true)
                .enableSmsOneway(true)
                .enableVoice(true)
                .phoneNumber("phoneNumber")
                .setAsDefault(true)
                .addWebhookEvent(WebhookEvent.MESSAGE_QUEUED)
                .webhookSignatureVersion(SenderCreateParams.WebhookSignatureVersion.V2)
                .webhookUrl("https://example.com")
                .build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
        assertThat(body.emailAddress()).isEqualTo("noreply@yourdomain.com")
        assertThat(body.emailDomainId()).isEqualTo("emailDomainId")
        assertThat(body.emailFromName()).isEqualTo("emailFromName")
        assertThat(body.emailReceivingEnabled()).isEqualTo(true)
        assertThat(body.enableSmsOneway()).isEqualTo(true)
        assertThat(body.enableVoice()).isEqualTo(true)
        assertThat(body.phoneNumber()).isEqualTo("phoneNumber")
        assertThat(body.setAsDefault()).isEqualTo(true)
        assertThat(body.webhookEvents()).containsExactly(WebhookEvent.MESSAGE_QUEUED)
        assertThat(body.webhookSignatureVersion())
            .isEqualTo(SenderCreateParams.WebhookSignatureVersion.V2)
        assertThat(body.webhookUrl()).isEqualTo("https://example.com")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = SenderCreateParams.builder().name("name").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
    }
}
