// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.functions

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.functions.gitlink.GitLinkLinkParams
import com.zavudev.api.models.functions.gitlink.GitLinkUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class GitLinkServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val gitLinkServiceAsync = client.functions().gitLink()

        val gitLink = gitLinkServiceAsync.retrieve("functionId")

        gitLink.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun update() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val gitLinkServiceAsync = client.functions().gitLink()

        val gitLink =
            gitLinkServiceAsync.update(
                GitLinkUpdateParams.builder()
                    .functionId("functionId")
                    .autoDeploy(false)
                    .branch("branch")
                    .rootDir("rootDir")
                    .build()
            )

        gitLink.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun deployNow() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val gitLinkServiceAsync = client.functions().gitLink()

        val response = gitLinkServiceAsync.deployNow("functionId")

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun link() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val gitLinkServiceAsync = client.functions().gitLink()

        val response =
            gitLinkServiceAsync.link(
                GitLinkLinkParams.builder()
                    .functionId("functionId")
                    .owner("acme")
                    .repo("order-bot")
                    .autoDeploy(true)
                    .branch("main")
                    .rootDir("apps/bot")
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun unlink() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val gitLinkServiceAsync = client.functions().gitLink()

        gitLinkServiceAsync.unlink("functionId")
    }
}
