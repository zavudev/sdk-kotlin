// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders.agent

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.senders.agent.knowledgebases.KnowledgeBaseCreateParams
import com.zavudev.api.models.senders.agent.knowledgebases.KnowledgeBaseCreateResponse
import com.zavudev.api.models.senders.agent.knowledgebases.KnowledgeBaseDeleteParams
import com.zavudev.api.models.senders.agent.knowledgebases.KnowledgeBaseListPageAsync
import com.zavudev.api.models.senders.agent.knowledgebases.KnowledgeBaseListParams
import com.zavudev.api.models.senders.agent.knowledgebases.KnowledgeBaseRetrieveParams
import com.zavudev.api.models.senders.agent.knowledgebases.KnowledgeBaseRetrieveResponse
import com.zavudev.api.models.senders.agent.knowledgebases.KnowledgeBaseUpdateParams
import com.zavudev.api.models.senders.agent.knowledgebases.KnowledgeBaseUpdateResponse
import com.zavudev.api.services.async.senders.agent.knowledgebases.DocumentServiceAsync

interface KnowledgeBaseServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): KnowledgeBaseServiceAsync

    fun documents(): DocumentServiceAsync

    /** Create a new knowledge base for an agent. */
    suspend fun create(
        senderId: String,
        params: KnowledgeBaseCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KnowledgeBaseCreateResponse =
        create(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see create */
    suspend fun create(
        params: KnowledgeBaseCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KnowledgeBaseCreateResponse

    /** Get a specific knowledge base. */
    suspend fun retrieve(
        kbId: String,
        params: KnowledgeBaseRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KnowledgeBaseRetrieveResponse =
        retrieve(params.toBuilder().kbId(kbId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: KnowledgeBaseRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KnowledgeBaseRetrieveResponse

    /** Update a knowledge base. */
    suspend fun update(
        kbId: String,
        params: KnowledgeBaseUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KnowledgeBaseUpdateResponse = update(params.toBuilder().kbId(kbId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: KnowledgeBaseUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KnowledgeBaseUpdateResponse

    /** List knowledge bases for an agent. */
    suspend fun list(
        senderId: String,
        params: KnowledgeBaseListParams = KnowledgeBaseListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KnowledgeBaseListPageAsync =
        list(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see list */
    suspend fun list(
        params: KnowledgeBaseListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KnowledgeBaseListPageAsync

    /** @see list */
    suspend fun list(senderId: String, requestOptions: RequestOptions): KnowledgeBaseListPageAsync =
        list(senderId, KnowledgeBaseListParams.none(), requestOptions)

    /** Delete a knowledge base and all its documents. */
    suspend fun delete(
        kbId: String,
        params: KnowledgeBaseDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().kbId(kbId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: KnowledgeBaseDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /**
     * A view of [KnowledgeBaseServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): KnowledgeBaseServiceAsync.WithRawResponse

        fun documents(): DocumentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/senders/{senderId}/agent/knowledge-bases`, but
         * is otherwise the same as [KnowledgeBaseServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            senderId: String,
            params: KnowledgeBaseCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KnowledgeBaseCreateResponse> =
            create(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        suspend fun create(
            params: KnowledgeBaseCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KnowledgeBaseCreateResponse>

        /**
         * Returns a raw HTTP response for `get
         * /v1/senders/{senderId}/agent/knowledge-bases/{kbId}`, but is otherwise the same as
         * [KnowledgeBaseServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            kbId: String,
            params: KnowledgeBaseRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KnowledgeBaseRetrieveResponse> =
            retrieve(params.toBuilder().kbId(kbId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: KnowledgeBaseRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KnowledgeBaseRetrieveResponse>

        /**
         * Returns a raw HTTP response for `patch
         * /v1/senders/{senderId}/agent/knowledge-bases/{kbId}`, but is otherwise the same as
         * [KnowledgeBaseServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            kbId: String,
            params: KnowledgeBaseUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KnowledgeBaseUpdateResponse> =
            update(params.toBuilder().kbId(kbId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: KnowledgeBaseUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KnowledgeBaseUpdateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/senders/{senderId}/agent/knowledge-bases`, but
         * is otherwise the same as [KnowledgeBaseServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            senderId: String,
            params: KnowledgeBaseListParams = KnowledgeBaseListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KnowledgeBaseListPageAsync> =
            list(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        suspend fun list(
            params: KnowledgeBaseListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KnowledgeBaseListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KnowledgeBaseListPageAsync> =
            list(senderId, KnowledgeBaseListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /v1/senders/{senderId}/agent/knowledge-bases/{kbId}`, but is otherwise the same as
         * [KnowledgeBaseServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            kbId: String,
            params: KnowledgeBaseDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().kbId(kbId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: KnowledgeBaseDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
