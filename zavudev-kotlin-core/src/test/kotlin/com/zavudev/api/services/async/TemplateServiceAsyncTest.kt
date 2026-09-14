// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.templates.TemplateCreateParams
import com.zavudev.api.models.templates.TemplateSubmitParams
import com.zavudev.api.models.templates.TemplateSyncParams
import com.zavudev.api.models.templates.WhatsappCategory
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TemplateServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun create() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val templateServiceAsync = client.templates()

        val template =
            templateServiceAsync.create(
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
            )

        template.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val templateServiceAsync = client.templates()

        val template = templateServiceAsync.retrieve("templateId")

        template.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val templateServiceAsync = client.templates()

        val page = templateServiceAsync.list()

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun delete() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val templateServiceAsync = client.templates()

        templateServiceAsync.delete("templateId")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun submit() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val templateServiceAsync = client.templates()

        val template =
            templateServiceAsync.submit(
                TemplateSubmitParams.builder()
                    .templateId("templateId")
                    .senderId("sender_abc123")
                    .category(WhatsappCategory.UTILITY)
                    .build()
            )

        template.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun sync() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val templateServiceAsync = client.templates()

        val response =
            templateServiceAsync.sync(TemplateSyncParams.builder().senderId("sender_12345").build())

        response.validate()
    }
}
