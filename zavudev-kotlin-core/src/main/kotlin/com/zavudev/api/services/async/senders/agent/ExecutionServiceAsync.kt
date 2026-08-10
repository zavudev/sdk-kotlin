// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders.agent

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.senders.agent.executions.ExecutionListPageAsync
import com.zavudev.api.models.senders.agent.executions.ExecutionListParams
import com.zavudev.api.models.senders.agent.executions.ExecutionRetrieveParams
import com.zavudev.api.models.senders.agent.executions.ExecutionRetrieveResponse

interface ExecutionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ExecutionServiceAsync

    /**
     * Fetch full details for one execution — including `errorMessage`, `errorCode`, and
     * `responseText`. Use this to debug failures surfaced by the list endpoint.
     */
    suspend fun retrieve(
        executionId: String,
        params: ExecutionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExecutionRetrieveResponse =
        retrieve(params.toBuilder().executionId(executionId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: ExecutionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExecutionRetrieveResponse

    /**
     * List recent agent executions with pagination.
     *
     * An execution is one inbound message answered by the agent, so this covers the messaging
     * channels only. Voice calls are never listed here regardless of how many the agent handled.
     * Use `GET /v1/calls` (and `GET /v1/calls/{callId}` for the transcript) for voice.
     */
    suspend fun list(
        senderId: String,
        params: ExecutionListParams = ExecutionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExecutionListPageAsync = list(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see list */
    suspend fun list(
        params: ExecutionListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExecutionListPageAsync

    /** @see list */
    suspend fun list(senderId: String, requestOptions: RequestOptions): ExecutionListPageAsync =
        list(senderId, ExecutionListParams.none(), requestOptions)

    /**
     * A view of [ExecutionServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ExecutionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /v1/senders/{senderId}/agent/executions/{executionId}`, but is otherwise the same as
         * [ExecutionServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            executionId: String,
            params: ExecutionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExecutionRetrieveResponse> =
            retrieve(params.toBuilder().executionId(executionId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: ExecutionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExecutionRetrieveResponse>

        /**
         * Returns a raw HTTP response for `get /v1/senders/{senderId}/agent/executions`, but is
         * otherwise the same as [ExecutionServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            senderId: String,
            params: ExecutionListParams = ExecutionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExecutionListPageAsync> =
            list(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        suspend fun list(
            params: ExecutionListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExecutionListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExecutionListPageAsync> =
            list(senderId, ExecutionListParams.none(), requestOptions)
    }
}
