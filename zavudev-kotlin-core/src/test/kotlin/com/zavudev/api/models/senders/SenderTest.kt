// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.senders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.zavudev.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SenderTest {

    @Test
    fun create() {
        val sender =
            Sender.builder()
                .id("sender_12345")
                .name("Primary sender")
                .phoneNumber("+13125551212")
                .addChannel("sms")
                .addChannel("voice")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .emailAddress("noreply@yourdomain.com")
                .emailCatchAllEnabled(true)
                .emailReceivingEnabled(true)
                .isDefault(true)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .webhook(
                    SenderWebhook.builder()
                        .active(true)
                        .addEvent(WebhookEvent.MESSAGE_QUEUED)
                        .signatureVersion(SenderWebhook.SignatureVersion.V2)
                        .url("https://api.example.com/webhooks/zavu")
                        .secret("whsec_abc123...")
                        .build()
                )
                .whatsapp(
                    Sender.Whatsapp.builder()
                        .displayPhoneNumber("+14155551234")
                        .paymentStatus(
                            Sender.Whatsapp.PaymentStatus.builder()
                                .canSendTemplates(true)
                                .methodStatus("VALID")
                                .setupStatus("COMPLETE")
                                .build()
                        )
                        .phoneNumberId("phoneNumberId")
                        .build()
                )
                .build()

        assertThat(sender.id()).isEqualTo("sender_12345")
        assertThat(sender.name()).isEqualTo("Primary sender")
        assertThat(sender.phoneNumber()).isEqualTo("+13125551212")
        assertThat(sender.channels()).containsExactly("sms", "voice")
        assertThat(sender.createdAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(sender.emailAddress()).isEqualTo("noreply@yourdomain.com")
        assertThat(sender.emailCatchAllEnabled()).isEqualTo(true)
        assertThat(sender.emailReceivingEnabled()).isEqualTo(true)
        assertThat(sender.isDefault()).isEqualTo(true)
        assertThat(sender.updatedAt()).isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(sender.webhook())
            .isEqualTo(
                SenderWebhook.builder()
                    .active(true)
                    .addEvent(WebhookEvent.MESSAGE_QUEUED)
                    .signatureVersion(SenderWebhook.SignatureVersion.V2)
                    .url("https://api.example.com/webhooks/zavu")
                    .secret("whsec_abc123...")
                    .build()
            )
        assertThat(sender.whatsapp())
            .isEqualTo(
                Sender.Whatsapp.builder()
                    .displayPhoneNumber("+14155551234")
                    .paymentStatus(
                        Sender.Whatsapp.PaymentStatus.builder()
                            .canSendTemplates(true)
                            .methodStatus("VALID")
                            .setupStatus("COMPLETE")
                            .build()
                    )
                    .phoneNumberId("phoneNumberId")
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sender =
            Sender.builder()
                .id("sender_12345")
                .name("Primary sender")
                .phoneNumber("+13125551212")
                .addChannel("sms")
                .addChannel("voice")
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .emailAddress("noreply@yourdomain.com")
                .emailCatchAllEnabled(true)
                .emailReceivingEnabled(true)
                .isDefault(true)
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .webhook(
                    SenderWebhook.builder()
                        .active(true)
                        .addEvent(WebhookEvent.MESSAGE_QUEUED)
                        .signatureVersion(SenderWebhook.SignatureVersion.V2)
                        .url("https://api.example.com/webhooks/zavu")
                        .secret("whsec_abc123...")
                        .build()
                )
                .whatsapp(
                    Sender.Whatsapp.builder()
                        .displayPhoneNumber("+14155551234")
                        .paymentStatus(
                            Sender.Whatsapp.PaymentStatus.builder()
                                .canSendTemplates(true)
                                .methodStatus("VALID")
                                .setupStatus("COMPLETE")
                                .build()
                        )
                        .phoneNumberId("phoneNumberId")
                        .build()
                )
                .build()

        val roundtrippedSender =
            jsonMapper.readValue(jsonMapper.writeValueAsString(sender), jacksonTypeRef<Sender>())

        assertThat(roundtrippedSender).isEqualTo(sender)
    }
}
