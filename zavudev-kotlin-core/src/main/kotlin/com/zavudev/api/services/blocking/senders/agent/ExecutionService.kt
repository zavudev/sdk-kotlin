// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.blocking.senders.agent

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.senders.agent.executions.ExecutionListPage
import com.zavudev.api.models.senders.agent.executions.ExecutionListParams
import com.zavudev.api.models.senders.agent.executions.ExecutionRetrieveParams
import com.zavudev.api.models.senders.agent.executions.ExecutionRetrieveResponse

interface ExecutionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ExecutionService

    /**
     * Fetch full details for one execution — including `errorMessage`, `errorCode`, and
     * `responseText`. Use this to debug failures surfaced by the list endpoint.
     */
    fun retrieve(
        executionId: String,
        params: ExecutionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExecutionRetrieveResponse =
        retrieve(params.toBuilder().executionId(executionId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
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
    fun list(
        senderId: String,
        params: ExecutionListParams = ExecutionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExecutionListPage = list(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see list */
    fun list(
        params: ExecutionListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ExecutionListPage

    /** @see list */
    fun list(senderId: String, requestOptions: RequestOptions): ExecutionListPage =
        list(senderId, ExecutionListParams.none(), requestOptions)

    /** A view of [ExecutionService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ExecutionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /v1/senders/{senderId}/agent/executions/{executionId}`, but is otherwise the same as
         * [ExecutionService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            executionId: String,
            params: ExecutionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExecutionRetrieveResponse> =
            retrieve(params.toBuilder().executionId(executionId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ExecutionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExecutionRetrieveResponse>

        /**
         * Returns a raw HTTP response for `get /v1/senders/{senderId}/agent/executions`, but is
         * otherwise the same as [ExecutionService.list].
         */
        @MustBeClosed
        fun list(
            senderId: String,
            params: ExecutionListParams = ExecutionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExecutionListPage> =
            list(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            params: ExecutionListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ExecutionListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExecutionListPage> =
            list(senderId, ExecutionListParams.none(), requestOptions)
    }
}
