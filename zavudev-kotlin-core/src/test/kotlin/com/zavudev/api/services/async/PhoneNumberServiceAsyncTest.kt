// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.phonenumbers.PhoneNumberPurchaseParams
import com.zavudev.api.models.phonenumbers.PhoneNumberRequirementsParams
import com.zavudev.api.models.phonenumbers.PhoneNumberSearchAvailableParams
import com.zavudev.api.models.phonenumbers.PhoneNumberType
import com.zavudev.api.models.phonenumbers.PhoneNumberUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class PhoneNumberServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val phoneNumberServiceAsync = client.phoneNumbers()

        val phoneNumber = phoneNumberServiceAsync.retrieve("phoneNumberId")

        phoneNumber.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun update() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val phoneNumberServiceAsync = client.phoneNumbers()

        val phoneNumber =
            phoneNumberServiceAsync.update(
                PhoneNumberUpdateParams.builder()
                    .phoneNumberId("phoneNumberId")
                    .name("Support Line")
                    .senderId("senderId")
                    .build()
            )

        phoneNumber.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val phoneNumberServiceAsync = client.phoneNumbers()

        val page = phoneNumberServiceAsync.list()

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun purchase() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val phoneNumberServiceAsync = client.phoneNumbers()

        val response =
            phoneNumberServiceAsync.purchase(
                PhoneNumberPurchaseParams.builder()
                    .phoneNumber("+15551234567")
                    .name("Primary Line")
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun release() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val phoneNumberServiceAsync = client.phoneNumbers()

        phoneNumberServiceAsync.release("phoneNumberId")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun requirements() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val phoneNumberServiceAsync = client.phoneNumbers()

        val response =
            phoneNumberServiceAsync.requirements(
                PhoneNumberRequirementsParams.builder()
                    .countryCode("xx")
                    .type(PhoneNumberType.LOCAL)
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun searchAvailable() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val phoneNumberServiceAsync = client.phoneNumbers()

        val response =
            phoneNumberServiceAsync.searchAvailable(
                PhoneNumberSearchAvailableParams.builder()
                    .countryCode("xx")
                    .capabilities("voice,sms")
                    .contains("contains")
                    .limit(50L)
                    .type(PhoneNumberType.LOCAL)
                    .build()
            )

        response.validate()
    }
}
