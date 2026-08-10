// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.broadcasts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.zavudev.api.core.JsonValue
import com.zavudev.api.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BroadcastTest {

    @Test
    fun create() {
        val broadcast =
            Broadcast.builder()
                .id("brd_abc123")
                .channel(BroadcastChannel.SMART)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .messageType(BroadcastMessageType.TEXT)
                .name("name")
                .status(BroadcastStatus.DRAFT)
                .totalContacts(0L)
                .actualCost(0.0)
                .completedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .content(
                    BroadcastContent.builder()
                        .filename("filename")
                        .mediaId("mediaId")
                        .mediaUrl("mediaUrl")
                        .mimeType("mimeType")
                        .templateButtonVariables(
                            BroadcastContent.TemplateButtonVariables.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .templateHeaderVariables(
                            BroadcastContent.TemplateHeaderVariables.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .templateId("templateId")
                        .templateVariables(
                            BroadcastContent.TemplateVariables.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .build()
                )
                .deliveredCount(0L)
                .emailSubject("emailSubject")
                .estimatedCost(0.0)
                .failedCount(0L)
                .metadata(
                    Broadcast.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .pendingCount(0L)
                .reservedAmount(0.0)
                .reviewAttempts(0L)
                .reviewResult(
                    Broadcast.ReviewResult.builder()
                        .addCategory("string")
                        .addFlaggedContent("string")
                        .reasoning("reasoning")
                        .reviewedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .score(0.0)
                        .build()
                )
                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .senderId("senderId")
                .sendingCount(0L)
                .startedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .text("text")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        assertThat(broadcast.id()).isEqualTo("brd_abc123")
        assertThat(broadcast.channel()).isEqualTo(BroadcastChannel.SMART)
        assertThat(broadcast.createdAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(broadcast.messageType()).isEqualTo(BroadcastMessageType.TEXT)
        assertThat(broadcast.name()).isEqualTo("name")
        assertThat(broadcast.status()).isEqualTo(BroadcastStatus.DRAFT)
        assertThat(broadcast.totalContacts()).isEqualTo(0L)
        assertThat(broadcast.actualCost()).isEqualTo(0.0)
        assertThat(broadcast.completedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(broadcast.content())
            .isEqualTo(
                BroadcastContent.builder()
                    .filename("filename")
                    .mediaId("mediaId")
                    .mediaUrl("mediaUrl")
                    .mimeType("mimeType")
                    .templateButtonVariables(
                        BroadcastContent.TemplateButtonVariables.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .templateHeaderVariables(
                        BroadcastContent.TemplateHeaderVariables.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .templateId("templateId")
                    .templateVariables(
                        BroadcastContent.TemplateVariables.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )
        assertThat(broadcast.deliveredCount()).isEqualTo(0L)
        assertThat(broadcast.emailSubject()).isEqualTo("emailSubject")
        assertThat(broadcast.estimatedCost()).isEqualTo(0.0)
        assertThat(broadcast.failedCount()).isEqualTo(0L)
        assertThat(broadcast.metadata())
            .isEqualTo(
                Broadcast.Metadata.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(broadcast.pendingCount()).isEqualTo(0L)
        assertThat(broadcast.reservedAmount()).isEqualTo(0.0)
        assertThat(broadcast.reviewAttempts()).isEqualTo(0L)
        assertThat(broadcast.reviewResult())
            .isEqualTo(
                Broadcast.ReviewResult.builder()
                    .addCategory("string")
                    .addFlaggedContent("string")
                    .reasoning("reasoning")
                    .reviewedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .score(0.0)
                    .build()
            )
        assertThat(broadcast.scheduledAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(broadcast.senderId()).isEqualTo("senderId")
        assertThat(broadcast.sendingCount()).isEqualTo(0L)
        assertThat(broadcast.startedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(broadcast.text()).isEqualTo("text")
        assertThat(broadcast.updatedAt())
            .isEqualTo(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val broadcast =
            Broadcast.builder()
                .id("brd_abc123")
                .channel(BroadcastChannel.SMART)
                .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .messageType(BroadcastMessageType.TEXT)
                .name("name")
                .status(BroadcastStatus.DRAFT)
                .totalContacts(0L)
                .actualCost(0.0)
                .completedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .content(
                    BroadcastContent.builder()
                        .filename("filename")
                        .mediaId("mediaId")
                        .mediaUrl("mediaUrl")
                        .mimeType("mimeType")
                        .templateButtonVariables(
                            BroadcastContent.TemplateButtonVariables.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .templateHeaderVariables(
                            BroadcastContent.TemplateHeaderVariables.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .templateId("templateId")
                        .templateVariables(
                            BroadcastContent.TemplateVariables.builder()
                                .putAdditionalProperty("foo", JsonValue.from("string"))
                                .build()
                        )
                        .build()
                )
                .deliveredCount(0L)
                .emailSubject("emailSubject")
                .estimatedCost(0.0)
                .failedCount(0L)
                .metadata(
                    Broadcast.Metadata.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .pendingCount(0L)
                .reservedAmount(0.0)
                .reviewAttempts(0L)
                .reviewResult(
                    Broadcast.ReviewResult.builder()
                        .addCategory("string")
                        .addFlaggedContent("string")
                        .reasoning("reasoning")
                        .reviewedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .score(0.0)
                        .build()
                )
                .scheduledAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .senderId("senderId")
                .sendingCount(0L)
                .startedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .text("text")
                .updatedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val roundtrippedBroadcast =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(broadcast),
                jacksonTypeRef<Broadcast>(),
            )

        assertThat(roundtrippedBroadcast).isEqualTo(broadcast)
    }
}
