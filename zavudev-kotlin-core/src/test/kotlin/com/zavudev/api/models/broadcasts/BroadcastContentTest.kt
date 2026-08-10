// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.broadcasts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.zavudev.api.core.JsonValue
import com.zavudev.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BroadcastContentTest {

    @Test
    fun create() {
        val broadcastContent =
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

        assertThat(broadcastContent.filename()).isEqualTo("filename")
        assertThat(broadcastContent.mediaId()).isEqualTo("mediaId")
        assertThat(broadcastContent.mediaUrl()).isEqualTo("mediaUrl")
        assertThat(broadcastContent.mimeType()).isEqualTo("mimeType")
        assertThat(broadcastContent.templateButtonVariables())
            .isEqualTo(
                BroadcastContent.TemplateButtonVariables.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(broadcastContent.templateHeaderVariables())
            .isEqualTo(
                BroadcastContent.TemplateHeaderVariables.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
        assertThat(broadcastContent.templateId()).isEqualTo("templateId")
        assertThat(broadcastContent.templateVariables())
            .isEqualTo(
                BroadcastContent.TemplateVariables.builder()
                    .putAdditionalProperty("foo", JsonValue.from("string"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val broadcastContent =
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

        val roundtrippedBroadcastContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(broadcastContent),
                jacksonTypeRef<BroadcastContent>(),
            )

        assertThat(roundtrippedBroadcastContent).isEqualTo(broadcastContent)
    }
}
