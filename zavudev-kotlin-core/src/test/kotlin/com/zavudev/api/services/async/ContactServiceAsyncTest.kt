// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.core.JsonValue
import com.zavudev.api.models.contacts.ContactCreateParams
import com.zavudev.api.models.contacts.ContactMergeParams
import com.zavudev.api.models.contacts.ContactUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ContactServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun create() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val contactServiceAsync = client.contacts()

        val contact =
            contactServiceAsync.create(
                ContactCreateParams.builder()
                    .addChannel(
                        ContactCreateParams.Channel.builder()
                            .channel(ContactCreateParams.Channel.InnerChannel.SMS)
                            .identifier("+14155551234")
                            .countryCode("US")
                            .isPrimary(true)
                            .label("work")
                            .build()
                    )
                    .displayName("John Doe")
                    .metadata(
                        ContactCreateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        contact.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val contactServiceAsync = client.contacts()

        val contact = contactServiceAsync.retrieve("contactId")

        contact.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun update() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val contactServiceAsync = client.contacts()

        val contact =
            contactServiceAsync.update(
                ContactUpdateParams.builder()
                    .contactId("contactId")
                    .defaultChannel(ContactUpdateParams.DefaultChannel.SMS)
                    .metadata(
                        ContactUpdateParams.Metadata.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .build()
            )

        contact.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val contactServiceAsync = client.contacts()

        val page = contactServiceAsync.list()

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun delete() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val contactServiceAsync = client.contacts()

        contactServiceAsync.delete("contactId")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun dismissMergeSuggestion() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val contactServiceAsync = client.contacts()

        contactServiceAsync.dismissMergeSuggestion("contactId")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun merge() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val contactServiceAsync = client.contacts()

        val contact =
            contactServiceAsync.merge(
                ContactMergeParams.builder()
                    .contactId("contactId")
                    .sourceContactId("jx7xyz789")
                    .build()
            )

        contact.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieveByPhone() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val contactServiceAsync = client.contacts()

        val contact = contactServiceAsync.retrieveByPhone("phoneNumber")

        contact.validate()
    }
}
