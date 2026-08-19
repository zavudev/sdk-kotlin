// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.blocking.senders.agent.knowledgebases

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentCreateParams
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentCreateResponse
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentDeleteParams
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentListPage
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentListParams
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentRetrieveDocumentParams
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentRetrieveDocumentResponse
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentUpdateDocumentParams
import com.zavudev.api.models.senders.agent.knowledgebases.documents.DocumentUpdateDocumentResponse

interface DocumentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): DocumentService

    /** Add a document to a knowledge base. The document will be automatically processed for RAG. */
    fun create(
        kbId: String,
        params: DocumentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DocumentCreateResponse = create(params.toBuilder().kbId(kbId).build(), requestOptions)

    /** @see create */
    fun create(
        params: DocumentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DocumentCreateResponse

    /** List documents in a knowledge base. */
    fun list(
        kbId: String,
        params: DocumentListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DocumentListPage = list(params.toBuilder().kbId(kbId).build(), requestOptions)

    /** @see list */
    fun list(
        params: DocumentListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DocumentListPage

    /** Delete a document from a knowledge base. */
    fun delete(
        docId: String,
        params: DocumentDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().docId(docId).build(), requestOptions)

    /** @see delete */
    fun delete(params: DocumentDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** Get a single document from a knowledge base. */
    fun retrieveDocument(
        docId: String,
        params: DocumentRetrieveDocumentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DocumentRetrieveDocumentResponse =
        retrieveDocument(params.toBuilder().docId(docId).build(), requestOptions)

    /** @see retrieveDocument */
    fun retrieveDocument(
        params: DocumentRetrieveDocumentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DocumentRetrieveDocumentResponse

    /** Update a document's title or content. Updating content reprocesses the document for RAG. */
    fun updateDocument(
        docId: String,
        params: DocumentUpdateDocumentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DocumentUpdateDocumentResponse =
        updateDocument(params.toBuilder().docId(docId).build(), requestOptions)

    /** @see updateDocument */
    fun updateDocument(
        params: DocumentUpdateDocumentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DocumentUpdateDocumentResponse

    /** A view of [DocumentService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): DocumentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post
         * /v1/senders/{senderId}/agent/knowledge-bases/{kbId}/documents`, but is otherwise the same
         * as [DocumentService.create].
         */
        @MustBeClosed
        fun create(
            kbId: String,
            params: DocumentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DocumentCreateResponse> =
            create(params.toBuilder().kbId(kbId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(
            params: DocumentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DocumentCreateResponse>

        /**
         * Returns a raw HTTP response for `get
         * /v1/senders/{senderId}/agent/knowledge-bases/{kbId}/documents`, but is otherwise the same
         * as [DocumentService.list].
         */
        @MustBeClosed
        fun list(
            kbId: String,
            params: DocumentListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DocumentListPage> =
            list(params.toBuilder().kbId(kbId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            params: DocumentListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DocumentListPage>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/senders/{senderId}/agent/knowledge-bases/{kbId}/documents/{docId}`, but is otherwise
         * the same as [DocumentService.delete].
         */
        @MustBeClosed
        fun delete(
            docId: String,
            params: DocumentDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().docId(docId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: DocumentDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `get
         * /v1/senders/{senderId}/agent/knowledge-bases/{kbId}/documents/{docId}`, but is otherwise
         * the same as [DocumentService.retrieveDocument].
         */
        @MustBeClosed
        fun retrieveDocument(
            docId: String,
            params: DocumentRetrieveDocumentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DocumentRetrieveDocumentResponse> =
            retrieveDocument(params.toBuilder().docId(docId).build(), requestOptions)

        /** @see retrieveDocument */
        @MustBeClosed
        fun retrieveDocument(
            params: DocumentRetrieveDocumentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DocumentRetrieveDocumentResponse>

        /**
         * Returns a raw HTTP response for `patch
         * /v1/senders/{senderId}/agent/knowledge-bases/{kbId}/documents/{docId}`, but is otherwise
         * the same as [DocumentService.updateDocument].
         */
        @MustBeClosed
        fun updateDocument(
            docId: String,
            params: DocumentUpdateDocumentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DocumentUpdateDocumentResponse> =
            updateDocument(params.toBuilder().docId(docId).build(), requestOptions)

        /** @see updateDocument */
        @MustBeClosed
        fun updateDocument(
            params: DocumentUpdateDocumentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DocumentUpdateDocumentResponse>
    }
}
