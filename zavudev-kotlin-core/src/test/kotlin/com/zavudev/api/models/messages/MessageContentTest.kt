// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.messages

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.zavudev.api.core.JsonValue
import com.zavudev.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MessageContentTest {

    @Test
    fun create() {
        val messageContent =
            MessageContent.builder()
                .addButton(MessageContent.Button.builder().id("id").title("title").build())
                .addContact(
                    MessageContent.Contact.builder().name("name").addPhone("string").build()
                )
                .ctaDisplayText("See Dates")
                .ctaHeaderMediaUrl("https://example.com")
                .ctaHeaderText("ctaHeaderText")
                .ctaHeaderType(MessageContent.CtaHeaderType.TEXT)
                .ctaUrl("https://example.com/schedule")
                .emoji("emoji")
                .filename("invoice.pdf")
                .footerText("Dates subject to change.")
                .latitude(0.0)
                .listButton("listButton")
                .locationAddress("locationAddress")
                .locationName("locationName")
                .longitude(0.0)
                .mediaId("mediaId")
                .mediaUrl("https://example.com/image.jpg")
                .mimeType("image/jpeg")
                .reactToMessageId("reactToMessageId")
                .replyToFrom("replyToFrom")
                .replyToMessageId("replyToMessageId")
                .replyToMessageType("replyToMessageType")
                .replyToProviderMessageId("replyToProviderMessageId")
                .replyToText("replyToText")
                .addSection(
                    MessageContent.Section.builder()
                        .addRow(
                            MessageContent.Section.Row.builder()
                                .id("id")
                                .title("title")
                                .description("description")
                                .build()
                        )
                        .title("title")
                        .build()
                )
                .templateButtonVariables(
                    MessageContent.TemplateButtonVariables.builder()
                        .putAdditionalProperty("0", JsonValue.from("abc-report-token"))
                        .build()
                )
                .templateHeaderVariables(
                    MessageContent.TemplateHeaderVariables.builder()
                        .putAdditionalProperty("1", JsonValue.from("Jorge y Laura"))
                        .build()
                )
                .templateId("templateId")
                .templateVariables(
                    MessageContent.TemplateVariables.builder()
                        .putAdditionalProperty("1", JsonValue.from("John"))
                        .putAdditionalProperty("2", JsonValue.from("ORD-12345"))
                        .build()
                )
                .build()

        assertThat(messageContent.buttons())
            .containsExactly(MessageContent.Button.builder().id("id").title("title").build())
        assertThat(messageContent.contacts())
            .containsExactly(
                MessageContent.Contact.builder().name("name").addPhone("string").build()
            )
        assertThat(messageContent.ctaDisplayText()).isEqualTo("See Dates")
        assertThat(messageContent.ctaHeaderMediaUrl()).isEqualTo("https://example.com")
        assertThat(messageContent.ctaHeaderText()).isEqualTo("ctaHeaderText")
        assertThat(messageContent.ctaHeaderType()).isEqualTo(MessageContent.CtaHeaderType.TEXT)
        assertThat(messageContent.ctaUrl()).isEqualTo("https://example.com/schedule")
        assertThat(messageContent.emoji()).isEqualTo("emoji")
        assertThat(messageContent.filename()).isEqualTo("invoice.pdf")
        assertThat(messageContent.footerText()).isEqualTo("Dates subject to change.")
        assertThat(messageContent.latitude()).isEqualTo(0.0)
        assertThat(messageContent.listButton()).isEqualTo("listButton")
        assertThat(messageContent.locationAddress()).isEqualTo("locationAddress")
        assertThat(messageContent.locationName()).isEqualTo("locationName")
        assertThat(messageContent.longitude()).isEqualTo(0.0)
        assertThat(messageContent.mediaId()).isEqualTo("mediaId")
        assertThat(messageContent.mediaUrl()).isEqualTo("https://example.com/image.jpg")
        assertThat(messageContent.mimeType()).isEqualTo("image/jpeg")
        assertThat(messageContent.reactToMessageId()).isEqualTo("reactToMessageId")
        assertThat(messageContent.replyToFrom()).isEqualTo("replyToFrom")
        assertThat(messageContent.replyToMessageId()).isEqualTo("replyToMessageId")
        assertThat(messageContent.replyToMessageType()).isEqualTo("replyToMessageType")
        assertThat(messageContent.replyToProviderMessageId()).isEqualTo("replyToProviderMessageId")
        assertThat(messageContent.replyToText()).isEqualTo("replyToText")
        assertThat(messageContent.sections())
            .containsExactly(
                MessageContent.Section.builder()
                    .addRow(
                        MessageContent.Section.Row.builder()
                            .id("id")
                            .title("title")
                            .description("description")
                            .build()
                    )
                    .title("title")
                    .build()
            )
        assertThat(messageContent.templateButtonVariables())
            .isEqualTo(
                MessageContent.TemplateButtonVariables.builder()
                    .putAdditionalProperty("0", JsonValue.from("abc-report-token"))
                    .build()
            )
        assertThat(messageContent.templateHeaderVariables())
            .isEqualTo(
                MessageContent.TemplateHeaderVariables.builder()
                    .putAdditionalProperty("1", JsonValue.from("Jorge y Laura"))
                    .build()
            )
        assertThat(messageContent.templateId()).isEqualTo("templateId")
        assertThat(messageContent.templateVariables())
            .isEqualTo(
                MessageContent.TemplateVariables.builder()
                    .putAdditionalProperty("1", JsonValue.from("John"))
                    .putAdditionalProperty("2", JsonValue.from("ORD-12345"))
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val messageContent =
            MessageContent.builder()
                .addButton(MessageContent.Button.builder().id("id").title("title").build())
                .addContact(
                    MessageContent.Contact.builder().name("name").addPhone("string").build()
                )
                .ctaDisplayText("See Dates")
                .ctaHeaderMediaUrl("https://example.com")
                .ctaHeaderText("ctaHeaderText")
                .ctaHeaderType(MessageContent.CtaHeaderType.TEXT)
                .ctaUrl("https://example.com/schedule")
                .emoji("emoji")
                .filename("invoice.pdf")
                .footerText("Dates subject to change.")
                .latitude(0.0)
                .listButton("listButton")
                .locationAddress("locationAddress")
                .locationName("locationName")
                .longitude(0.0)
                .mediaId("mediaId")
                .mediaUrl("https://example.com/image.jpg")
                .mimeType("image/jpeg")
                .reactToMessageId("reactToMessageId")
                .replyToFrom("replyToFrom")
                .replyToMessageId("replyToMessageId")
                .replyToMessageType("replyToMessageType")
                .replyToProviderMessageId("replyToProviderMessageId")
                .replyToText("replyToText")
                .addSection(
                    MessageContent.Section.builder()
                        .addRow(
                            MessageContent.Section.Row.builder()
                                .id("id")
                                .title("title")
                                .description("description")
                                .build()
                        )
                        .title("title")
                        .build()
                )
                .templateButtonVariables(
                    MessageContent.TemplateButtonVariables.builder()
                        .putAdditionalProperty("0", JsonValue.from("abc-report-token"))
                        .build()
                )
                .templateHeaderVariables(
                    MessageContent.TemplateHeaderVariables.builder()
                        .putAdditionalProperty("1", JsonValue.from("Jorge y Laura"))
                        .build()
                )
                .templateId("templateId")
                .templateVariables(
                    MessageContent.TemplateVariables.builder()
                        .putAdditionalProperty("1", JsonValue.from("John"))
                        .putAdditionalProperty("2", JsonValue.from("ORD-12345"))
                        .build()
                )
                .build()

        val roundtrippedMessageContent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(messageContent),
                jacksonTypeRef<MessageContent>(),
            )

        assertThat(roundtrippedMessageContent).isEqualTo(messageContent)
    }
}
