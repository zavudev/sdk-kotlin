// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.templates

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TemplateCreateParamsTest {

    @Test
    fun create() {
        TemplateCreateParams.builder()
            .body("Hi {{1}}, your order {{2}} has been confirmed and will ship within 24 hours.")
            .language("en")
            .name("order_confirmation")
            .addSecurityRecommendation(true)
            .addButton(
                TemplateCreateParams.Button.builder()
                    .type(TemplateCreateParams.Button.Type.QUICK_REPLY)
                    .example("ORD-12345")
                    .otpType(TemplateCreateParams.Button.OtpType.COPY_CODE)
                    .packageName("packageName")
                    .phoneNumber("phoneNumber")
                    .signatureHash("signatureHash")
                    .text("text")
                    .url("https://example.com")
                    .build()
            )
            .codeExpirationMinutes(1L)
            .footer("footer")
            .headerContent("headerContent")
            .headerType(TemplateCreateParams.HeaderType.TEXT)
            .instagramBody("instagramBody")
            .smsBody("smsBody")
            .telegramBody("telegramBody")
            .addVariable("customer_name")
            .addVariable("order_id")
            .whatsappCategory(WhatsappCategory.UTILITY)
            .build()
    }

    @Test
    fun body() {
        val params =
            TemplateCreateParams.builder()
                .body(
                    "Hi {{1}}, your order {{2}} has been confirmed and will ship within 24 hours."
                )
                .language("en")
                .name("order_confirmation")
                .addSecurityRecommendation(true)
                .addButton(
                    TemplateCreateParams.Button.builder()
                        .type(TemplateCreateParams.Button.Type.QUICK_REPLY)
                        .example("ORD-12345")
                        .otpType(TemplateCreateParams.Button.OtpType.COPY_CODE)
                        .packageName("packageName")
                        .phoneNumber("phoneNumber")
                        .signatureHash("signatureHash")
                        .text("text")
                        .url("https://example.com")
                        .build()
                )
                .codeExpirationMinutes(1L)
                .footer("footer")
                .headerContent("headerContent")
                .headerType(TemplateCreateParams.HeaderType.TEXT)
                .instagramBody("instagramBody")
                .smsBody("smsBody")
                .telegramBody("telegramBody")
                .addVariable("customer_name")
                .addVariable("order_id")
                .whatsappCategory(WhatsappCategory.UTILITY)
                .build()

        val body = params._body()

        assertThat(body.body())
            .isEqualTo(
                "Hi {{1}}, your order {{2}} has been confirmed and will ship within 24 hours."
            )
        assertThat(body.language()).isEqualTo("en")
        assertThat(body.name()).isEqualTo("order_confirmation")
        assertThat(body.addSecurityRecommendation()).isEqualTo(true)
        assertThat(body.buttons())
            .containsExactly(
                TemplateCreateParams.Button.builder()
                    .type(TemplateCreateParams.Button.Type.QUICK_REPLY)
                    .example("ORD-12345")
                    .otpType(TemplateCreateParams.Button.OtpType.COPY_CODE)
                    .packageName("packageName")
                    .phoneNumber("phoneNumber")
                    .signatureHash("signatureHash")
                    .text("text")
                    .url("https://example.com")
                    .build()
            )
        assertThat(body.codeExpirationMinutes()).isEqualTo(1L)
        assertThat(body.footer()).isEqualTo("footer")
        assertThat(body.headerContent()).isEqualTo("headerContent")
        assertThat(body.headerType()).isEqualTo(TemplateCreateParams.HeaderType.TEXT)
        assertThat(body.instagramBody()).isEqualTo("instagramBody")
        assertThat(body.smsBody()).isEqualTo("smsBody")
        assertThat(body.telegramBody()).isEqualTo("telegramBody")
        assertThat(body.variables()).containsExactly("customer_name", "order_id")
        assertThat(body.whatsappCategory()).isEqualTo(WhatsappCategory.UTILITY)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            TemplateCreateParams.builder()
                .body(
                    "Hi {{1}}, your order {{2}} has been confirmed and will ship within 24 hours."
                )
                .language("en")
                .name("order_confirmation")
                .build()

        val body = params._body()

        assertThat(body.body())
            .isEqualTo(
                "Hi {{1}}, your order {{2}} has been confirmed and will ship within 24 hours."
            )
        assertThat(body.language()).isEqualTo("en")
        assertThat(body.name()).isEqualTo("order_confirmation")
    }
}
