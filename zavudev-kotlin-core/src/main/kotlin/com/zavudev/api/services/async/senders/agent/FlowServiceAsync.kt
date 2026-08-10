// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders.agent

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.senders.agent.flows.FlowCreateParams
import com.zavudev.api.models.senders.agent.flows.FlowCreateResponse
import com.zavudev.api.models.senders.agent.flows.FlowDeleteParams
import com.zavudev.api.models.senders.agent.flows.FlowDuplicateParams
import com.zavudev.api.models.senders.agent.flows.FlowDuplicateResponse
import com.zavudev.api.models.senders.agent.flows.FlowListPageAsync
import com.zavudev.api.models.senders.agent.flows.FlowListParams
import com.zavudev.api.models.senders.agent.flows.FlowRetrieveParams
import com.zavudev.api.models.senders.agent.flows.FlowRetrieveResponse
import com.zavudev.api.models.senders.agent.flows.FlowUpdateParams
import com.zavudev.api.models.senders.agent.flows.FlowUpdateResponse

interface FlowServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): FlowServiceAsync

    /** Create a new flow for an agent. */
    suspend fun create(
        senderId: String,
        params: FlowCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FlowCreateResponse = create(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see create */
    suspend fun create(
        params: FlowCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FlowCreateResponse

    /** Get a specific flow. */
    suspend fun retrieve(
        flowId: String,
        params: FlowRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FlowRetrieveResponse = retrieve(params.toBuilder().flowId(flowId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: FlowRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FlowRetrieveResponse

    /** Update a flow. */
    suspend fun update(
        flowId: String,
        params: FlowUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FlowUpdateResponse = update(params.toBuilder().flowId(flowId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: FlowUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FlowUpdateResponse

    /** List flows for an agent. */
    suspend fun list(
        senderId: String,
        params: FlowListParams = FlowListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FlowListPageAsync = list(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see list */
    suspend fun list(
        params: FlowListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FlowListPageAsync

    /** @see list */
    suspend fun list(senderId: String, requestOptions: RequestOptions): FlowListPageAsync =
        list(senderId, FlowListParams.none(), requestOptions)

    /** Delete a flow. Cannot delete flows with active sessions. */
    suspend fun delete(
        flowId: String,
        params: FlowDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().flowId(flowId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: FlowDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** Create a copy of an existing flow with a new name. */
    suspend fun duplicate(
        flowId: String,
        params: FlowDuplicateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FlowDuplicateResponse = duplicate(params.toBuilder().flowId(flowId).build(), requestOptions)

    /** @see duplicate */
    suspend fun duplicate(
        params: FlowDuplicateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FlowDuplicateResponse

    /** A view of [FlowServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): FlowServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/senders/{senderId}/agent/flows`, but is
         * otherwise the same as [FlowServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            senderId: String,
            params: FlowCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FlowCreateResponse> =
            create(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        suspend fun create(
            params: FlowCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FlowCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/senders/{senderId}/agent/flows/{flowId}`, but is
         * otherwise the same as [FlowServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            flowId: String,
            params: FlowRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FlowRetrieveResponse> =
            retrieve(params.toBuilder().flowId(flowId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: FlowRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FlowRetrieveResponse>

        /**
         * Returns a raw HTTP response for `patch /v1/senders/{senderId}/agent/flows/{flowId}`, but
         * is otherwise the same as [FlowServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            flowId: String,
            params: FlowUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FlowUpdateResponse> =
            update(params.toBuilder().flowId(flowId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: FlowUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FlowUpdateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/senders/{senderId}/agent/flows`, but is
         * otherwise the same as [FlowServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            senderId: String,
            params: FlowListParams = FlowListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FlowListPageAsync> =
            list(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        suspend fun list(
            params: FlowListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FlowListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FlowListPageAsync> =
            list(senderId, FlowListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/senders/{senderId}/agent/flows/{flowId}`, but
         * is otherwise the same as [FlowServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            flowId: String,
            params: FlowDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().flowId(flowId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: FlowDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `post
         * /v1/senders/{senderId}/agent/flows/{flowId}/duplicate`, but is otherwise the same as
         * [FlowServiceAsync.duplicate].
         */
        @MustBeClosed
        suspend fun duplicate(
            flowId: String,
            params: FlowDuplicateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FlowDuplicateResponse> =
            duplicate(params.toBuilder().flowId(flowId).build(), requestOptions)

        /** @see duplicate */
        @MustBeClosed
        suspend fun duplicate(
            params: FlowDuplicateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FlowDuplicateResponse>
    }
}
