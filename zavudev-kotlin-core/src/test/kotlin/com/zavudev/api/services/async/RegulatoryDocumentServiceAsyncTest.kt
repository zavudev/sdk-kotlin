// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.zavudev.api.client.okhttp.ZavudevOkHttpClientAsync
import com.zavudev.api.models.regulatorydocuments.RegulatoryDocumentCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class RegulatoryDocumentServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun create() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val regulatoryDocumentServiceAsync = client.regulatoryDocuments()

        val regulatoryDocument =
            regulatoryDocumentServiceAsync.create(
                RegulatoryDocumentCreateParams.builder()
                    .documentType(RegulatoryDocumentCreateParams.DocumentType.PASSPORT)
                    .fileSize(102400L)
                    .mimeType("image/jpeg")
                    .name("Passport Scan")
                    .storageId("kg2abc123...")
                    .build()
            )

        regulatoryDocument.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val regulatoryDocumentServiceAsync = client.regulatoryDocuments()

        val regulatoryDocument = regulatoryDocumentServiceAsync.retrieve("documentId")

        regulatoryDocument.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val regulatoryDocumentServiceAsync = client.regulatoryDocuments()

        val page = regulatoryDocumentServiceAsync.list()

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun delete() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val regulatoryDocumentServiceAsync = client.regulatoryDocuments()

        regulatoryDocumentServiceAsync.delete("documentId")
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun uploadUrl() {
        val client = ZavudevOkHttpClientAsync.builder().apiKey("My API Key").build()
        val regulatoryDocumentServiceAsync = client.regulatoryDocuments()

        val response = regulatoryDocumentServiceAsync.uploadUrl()

        response.validate()
    }
}
