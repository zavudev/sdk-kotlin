// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.senders.agent.AgentCreateParams
import com.zavudev.api.models.senders.agent.AgentDeleteParams
import com.zavudev.api.models.senders.agent.AgentResponse
import com.zavudev.api.models.senders.agent.AgentRetrieveParams
import com.zavudev.api.models.senders.agent.AgentStats
import com.zavudev.api.models.senders.agent.AgentStatsParams
import com.zavudev.api.models.senders.agent.AgentUpdateParams
import com.zavudev.api.services.async.senders.agent.ExecutionServiceAsync
import com.zavudev.api.services.async.senders.agent.FlowServiceAsync
import com.zavudev.api.services.async.senders.agent.KnowledgeBaseServiceAsync
import com.zavudev.api.services.async.senders.agent.ToolServiceAsync

interface AgentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): AgentServiceAsync

    fun executions(): ExecutionServiceAsync

    fun flows(): FlowServiceAsync

    fun tools(): ToolServiceAsync

    fun knowledgeBases(): KnowledgeBaseServiceAsync

    /** Create an AI agent for a sender. Each sender can have at most one agent. */
    suspend fun create(
        senderId: String,
        params: AgentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentResponse = create(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see create */
    suspend fun create(
        params: AgentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentResponse

    /** Get the AI agent configuration for a sender. */
    suspend fun retrieve(
        senderId: String,
        params: AgentRetrieveParams = AgentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentResponse = retrieve(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: AgentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentResponse

    /** @see retrieve */
    suspend fun retrieve(senderId: String, requestOptions: RequestOptions): AgentResponse =
        retrieve(senderId, AgentRetrieveParams.none(), requestOptions)

    /** Update an AI agent's configuration. */
    suspend fun update(
        senderId: String,
        params: AgentUpdateParams = AgentUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentResponse = update(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: AgentUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentResponse

    /** @see update */
    suspend fun update(senderId: String, requestOptions: RequestOptions): AgentResponse =
        update(senderId, AgentUpdateParams.none(), requestOptions)

    /** Delete an AI agent. */
    suspend fun delete(
        senderId: String,
        params: AgentDeleteParams = AgentDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: AgentDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(senderId: String, requestOptions: RequestOptions) =
        delete(senderId, AgentDeleteParams.none(), requestOptions)

    /**
     * Get statistics for an AI agent including invocations, tokens, and costs.
     *
     * Covers the messaging channels only. Voice calls are not counted here: a call is a multi-turn
     * conversation rather than one inbound message and one reply, so it is recorded as a call, not
     * an execution. An agent that only answers phone calls reports zeros on every field. Use `GET
     * /v1/calls` for voice activity, duration, and cost.
     */
    suspend fun stats(
        senderId: String,
        params: AgentStatsParams = AgentStatsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentStats = stats(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see stats */
    suspend fun stats(
        params: AgentStatsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentStats

    /** @see stats */
    suspend fun stats(senderId: String, requestOptions: RequestOptions): AgentStats =
        stats(senderId, AgentStatsParams.none(), requestOptions)

    /** A view of [AgentServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): AgentServiceAsync.WithRawResponse

        fun executions(): ExecutionServiceAsync.WithRawResponse

        fun flows(): FlowServiceAsync.WithRawResponse

        fun tools(): ToolServiceAsync.WithRawResponse

        fun knowledgeBases(): KnowledgeBaseServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/senders/{senderId}/agent`, but is otherwise the
         * same as [AgentServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            senderId: String,
            params: AgentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentResponse> =
            create(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        suspend fun create(
            params: AgentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentResponse>

        /**
         * Returns a raw HTTP response for `get /v1/senders/{senderId}/agent`, but is otherwise the
         * same as [AgentServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            senderId: String,
            params: AgentRetrieveParams = AgentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentResponse> =
            retrieve(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: AgentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentResponse> =
            retrieve(senderId, AgentRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/senders/{senderId}/agent`, but is otherwise
         * the same as [AgentServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            senderId: String,
            params: AgentUpdateParams = AgentUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentResponse> =
            update(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: AgentUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentResponse>

        /** @see update */
        @MustBeClosed
        suspend fun update(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentResponse> =
            update(senderId, AgentUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/senders/{senderId}/agent`, but is otherwise
         * the same as [AgentServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            senderId: String,
            params: AgentDeleteParams = AgentDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: AgentDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(senderId: String, requestOptions: RequestOptions): HttpResponse =
            delete(senderId, AgentDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/senders/{senderId}/agent/stats`, but is
         * otherwise the same as [AgentServiceAsync.stats].
         */
        @MustBeClosed
        suspend fun stats(
            senderId: String,
            params: AgentStatsParams = AgentStatsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentStats> =
            stats(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see stats */
        @MustBeClosed
        suspend fun stats(
            params: AgentStatsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentStats>

        /** @see stats */
        @MustBeClosed
        suspend fun stats(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentStats> = stats(senderId, AgentStatsParams.none(), requestOptions)
    }
}
