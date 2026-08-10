// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.regulatorydocuments.RegulatoryDocumentCreateParams
import com.zavudev.api.models.regulatorydocuments.RegulatoryDocumentCreateResponse
import com.zavudev.api.models.regulatorydocuments.RegulatoryDocumentDeleteParams
import com.zavudev.api.models.regulatorydocuments.RegulatoryDocumentListPageAsync
import com.zavudev.api.models.regulatorydocuments.RegulatoryDocumentListParams
import com.zavudev.api.models.regulatorydocuments.RegulatoryDocumentRetrieveParams
import com.zavudev.api.models.regulatorydocuments.RegulatoryDocumentRetrieveResponse
import com.zavudev.api.models.regulatorydocuments.RegulatoryDocumentUploadUrlParams
import com.zavudev.api.models.regulatorydocuments.RegulatoryDocumentUploadUrlResponse

interface RegulatoryDocumentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): RegulatoryDocumentServiceAsync

    /**
     * Create a regulatory document record after uploading the file. Use the upload-url endpoint
     * first to get an upload URL.
     */
    suspend fun create(
        params: RegulatoryDocumentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RegulatoryDocumentCreateResponse

    /** Get a specific regulatory document. */
    suspend fun retrieve(
        documentId: String,
        params: RegulatoryDocumentRetrieveParams = RegulatoryDocumentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RegulatoryDocumentRetrieveResponse =
        retrieve(params.toBuilder().documentId(documentId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: RegulatoryDocumentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RegulatoryDocumentRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(
        documentId: String,
        requestOptions: RequestOptions,
    ): RegulatoryDocumentRetrieveResponse =
        retrieve(documentId, RegulatoryDocumentRetrieveParams.none(), requestOptions)

    /** List regulatory documents for this project. */
    suspend fun list(
        params: RegulatoryDocumentListParams = RegulatoryDocumentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RegulatoryDocumentListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): RegulatoryDocumentListPageAsync =
        list(RegulatoryDocumentListParams.none(), requestOptions)

    /** Delete a regulatory document. Cannot delete verified documents. */
    suspend fun delete(
        documentId: String,
        params: RegulatoryDocumentDeleteParams = RegulatoryDocumentDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().documentId(documentId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: RegulatoryDocumentDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(documentId: String, requestOptions: RequestOptions) =
        delete(documentId, RegulatoryDocumentDeleteParams.none(), requestOptions)

    /**
     * Get a presigned URL to upload a document file. After uploading, use the storageId to create
     * the document record.
     */
    suspend fun uploadUrl(
        params: RegulatoryDocumentUploadUrlParams = RegulatoryDocumentUploadUrlParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RegulatoryDocumentUploadUrlResponse

    /** @see uploadUrl */
    suspend fun uploadUrl(requestOptions: RequestOptions): RegulatoryDocumentUploadUrlResponse =
        uploadUrl(RegulatoryDocumentUploadUrlParams.none(), requestOptions)

    /**
     * A view of [RegulatoryDocumentServiceAsync] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): RegulatoryDocumentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/documents`, but is otherwise the same as
         * [RegulatoryDocumentServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: RegulatoryDocumentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RegulatoryDocumentCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/documents/{documentId}`, but is otherwise the
         * same as [RegulatoryDocumentServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            documentId: String,
            params: RegulatoryDocumentRetrieveParams = RegulatoryDocumentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RegulatoryDocumentRetrieveResponse> =
            retrieve(params.toBuilder().documentId(documentId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: RegulatoryDocumentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RegulatoryDocumentRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            documentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RegulatoryDocumentRetrieveResponse> =
            retrieve(documentId, RegulatoryDocumentRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/documents`, but is otherwise the same as
         * [RegulatoryDocumentServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: RegulatoryDocumentListParams = RegulatoryDocumentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RegulatoryDocumentListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(
            requestOptions: RequestOptions
        ): HttpResponseFor<RegulatoryDocumentListPageAsync> =
            list(RegulatoryDocumentListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/documents/{documentId}`, but is otherwise the
         * same as [RegulatoryDocumentServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            documentId: String,
            params: RegulatoryDocumentDeleteParams = RegulatoryDocumentDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().documentId(documentId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: RegulatoryDocumentDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(documentId: String, requestOptions: RequestOptions): HttpResponse =
            delete(documentId, RegulatoryDocumentDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/documents/upload-url`, but is otherwise the
         * same as [RegulatoryDocumentServiceAsync.uploadUrl].
         */
        @MustBeClosed
        suspend fun uploadUrl(
            params: RegulatoryDocumentUploadUrlParams = RegulatoryDocumentUploadUrlParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RegulatoryDocumentUploadUrlResponse>

        /** @see uploadUrl */
        @MustBeClosed
        suspend fun uploadUrl(
            requestOptions: RequestOptions
        ): HttpResponseFor<RegulatoryDocumentUploadUrlResponse> =
            uploadUrl(RegulatoryDocumentUploadUrlParams.none(), requestOptions)
    }
}
