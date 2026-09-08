// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders.agent.knowledgebases

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentCreateParams
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentCreateResponse
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentDeleteParams
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentListPageAsync
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentListParams
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentRetrieveDocumentParams
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentRetrieveDocumentResponse
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentUpdateDocumentParams
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentUpdateDocumentResponse

interface DocumentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): DocumentServiceAsync

    /** Add a document to a knowledge base. The document will be automatically processed for RAG. */
    suspend fun create(
        kbId: String,
        params: DocumentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DocumentCreateResponse = create(params.toBuilder().kbId(kbId).build(), requestOptions)

    /** @see create */
    suspend fun create(
        params: DocumentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DocumentCreateResponse

    /** List documents in a knowledge base. */
    suspend fun list(
        kbId: String,
        params: DocumentListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DocumentListPageAsync = list(params.toBuilder().kbId(kbId).build(), requestOptions)

    /** @see list */
    suspend fun list(
        params: DocumentListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DocumentListPageAsync

    /** Delete a document from a knowledge base. */
    suspend fun delete(
        docId: String,
        params: DocumentDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().docId(docId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: DocumentDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** Get a single document from a knowledge base. */
    suspend fun retrieveDocument(
        docId: String,
        params: DocumentRetrieveDocumentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DocumentRetrieveDocumentResponse =
        retrieveDocument(params.toBuilder().docId(docId).build(), requestOptions)

    /** @see retrieveDocument */
    suspend fun retrieveDocument(
        params: DocumentRetrieveDocumentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DocumentRetrieveDocumentResponse

    /** Update a document's title or content. Updating content reprocesses the document for RAG. */
    suspend fun updateDocument(
        docId: String,
        params: DocumentUpdateDocumentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DocumentUpdateDocumentResponse =
        updateDocument(params.toBuilder().docId(docId).build(), requestOptions)

    /** @see updateDocument */
    suspend fun updateDocument(
        params: DocumentUpdateDocumentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DocumentUpdateDocumentResponse

    /**
     * A view of [DocumentServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): DocumentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post
         * /v1/senders/{senderId}/agent/knowledge-bases/{kbId}/documents`, but is otherwise the same
         * as [DocumentServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            kbId: String,
            params: DocumentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DocumentCreateResponse> =
            create(params.toBuilder().kbId(kbId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        suspend fun create(
            params: DocumentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DocumentCreateResponse>

        /**
         * Returns a raw HTTP response for `get
         * /v1/senders/{senderId}/agent/knowledge-bases/{kbId}/documents`, but is otherwise the same
         * as [DocumentServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            kbId: String,
            params: DocumentListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DocumentListPageAsync> =
            list(params.toBuilder().kbId(kbId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        suspend fun list(
            params: DocumentListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DocumentListPageAsync>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/senders/{senderId}/agent/knowledge-bases/{kbId}/documents/{docId}`, but is otherwise
         * the same as [DocumentServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            docId: String,
            params: DocumentDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().docId(docId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: DocumentDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `get
         * /v1/senders/{senderId}/agent/knowledge-bases/{kbId}/documents/{docId}`, but is otherwise
         * the same as [DocumentServiceAsync.retrieveDocument].
         */
        @MustBeClosed
        suspend fun retrieveDocument(
            docId: String,
            params: DocumentRetrieveDocumentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DocumentRetrieveDocumentResponse> =
            retrieveDocument(params.toBuilder().docId(docId).build(), requestOptions)

        /** @see retrieveDocument */
        @MustBeClosed
        suspend fun retrieveDocument(
            params: DocumentRetrieveDocumentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DocumentRetrieveDocumentResponse>

        /**
         * Returns a raw HTTP response for `patch
         * /v1/senders/{senderId}/agent/knowledge-bases/{kbId}/documents/{docId}`, but is otherwise
         * the same as [DocumentServiceAsync.updateDocument].
         */
        @MustBeClosed
        suspend fun updateDocument(
            docId: String,
            params: DocumentUpdateDocumentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DocumentUpdateDocumentResponse> =
            updateDocument(params.toBuilder().docId(docId).build(), requestOptions)

        /** @see updateDocument */
        @MustBeClosed
        suspend fun updateDocument(
            params: DocumentUpdateDocumentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DocumentUpdateDocumentResponse>
    }
}
