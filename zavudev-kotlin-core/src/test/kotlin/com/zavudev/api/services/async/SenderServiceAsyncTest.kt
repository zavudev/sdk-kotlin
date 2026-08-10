// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.senders.SenderCreateParams
import com.zavudev.api.models.senders.SenderUpdateParams
import com.zavudev.api.models.senders.SenderUpdateProfileParams
import com.zavudev.api.models.senders.SenderUploadProfilePictureParams
import com.zavudev.api.models.senders.WebhookEvent
import com.zavudev.api.models.senders.WhatsappBusinessProfileVertical
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class SenderServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun create() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val senderServiceAsync = client.senders()

        val sender =
            senderServiceAsync.create(
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
            )

        sender.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val senderServiceAsync = client.senders()

        val sender = senderServiceAsync.retrieve("senderId")

        sender.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun update() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val senderServiceAsync = client.senders()

        val sender =
            senderServiceAsync.update(
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
            )

        sender.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val senderServiceAsync = client.senders()

        val page = senderServiceAsync.list()

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun delete() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val senderServiceAsync = client.senders()

        senderServiceAsync.delete("senderId")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun getProfile() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val senderServiceAsync = client.senders()

        val whatsappBusinessProfileResponse = senderServiceAsync.getProfile("senderId")

        whatsappBusinessProfileResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun regenerateWebhookSecret() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val senderServiceAsync = client.senders()

        val webhookSecretResponse = senderServiceAsync.regenerateWebhookSecret("senderId")

        webhookSecretResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun updateProfile() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val senderServiceAsync = client.senders()

        val response =
            senderServiceAsync.updateProfile(
                SenderUpdateProfileParams.builder()
                    .senderId("senderId")
                    .about("Succulent specialists!")
                    .address("address")
                    .description("We specialize in providing high-quality succulents.")
                    .email("contact@example.com")
                    .vertical(WhatsappBusinessProfileVertical.RETAIL)
                    .addWebsite("https://www.example.com")
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun uploadProfilePicture() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val senderServiceAsync = client.senders()

        val response =
            senderServiceAsync.uploadProfilePicture(
                SenderUploadProfilePictureParams.builder()
                    .senderId("senderId")
                    .imageUrl("https://example.com/profile.jpg")
                    .mimeType(SenderUploadProfilePictureParams.MimeType.IMAGE_JPEG)
                    .build()
            )

        response.validate()
    }
}
