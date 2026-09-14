// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.emaildomains.EmailDomainCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class EmailDomainServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun create() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val emailDomainServiceAsync = client.emailDomains()

        val emailDomain =
            emailDomainServiceAsync.create(
                EmailDomainCreateParams.builder().domain("example.com").build()
            )

        emailDomain.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val emailDomainServiceAsync = client.emailDomains()

        val emailDomain = emailDomainServiceAsync.retrieve("domainId")

        emailDomain.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val emailDomainServiceAsync = client.emailDomains()

        val emailDomains = emailDomainServiceAsync.list()

        emailDomains.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun delete() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val emailDomainServiceAsync = client.emailDomains()

        emailDomainServiceAsync.delete("domainId")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun verify() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val emailDomainServiceAsync = client.emailDomains()

        val response = emailDomainServiceAsync.verify("domainId")

        response.validate()
    }
}
