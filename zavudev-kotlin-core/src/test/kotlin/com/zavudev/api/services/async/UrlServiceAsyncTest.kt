// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.urls.UrlEscalateParams
import com.zavudev.api.models.urls.UrlSubmitForVerificationParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class UrlServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun escalate() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val urlServiceAsync = client.urls()

        val response =
            urlServiceAsync.escalate(
                UrlEscalateParams.builder()
                    .urlId("urlId")
                    .reason("This is our official landing page and was rejected in error.")
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun listVerified() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val urlServiceAsync = client.urls()

        val page = urlServiceAsync.listVerified()

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieveDetails() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val urlServiceAsync = client.urls()

        val response = urlServiceAsync.retrieveDetails("urlId")

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun submitForVerification() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val urlServiceAsync = client.urls()

        val response =
            urlServiceAsync.submitForVerification(
                UrlSubmitForVerificationParams.builder().url("https://example.com/page").build()
            )

        response.validate()
    }
}
