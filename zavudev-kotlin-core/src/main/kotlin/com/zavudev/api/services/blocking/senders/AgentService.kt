// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.blocking.senders

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
import com.zavudev.api.services.blocking.senders.agent.ExecutionService
import com.zavudev.api.services.blocking.senders.agent.FlowService
import com.zavudev.api.services.blocking.senders.agent.KnowledgeBaseService
import com.zavudev.api.services.blocking.senders.agent.ToolService

interface AgentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): AgentService

    fun executions(): ExecutionService

    fun flows(): FlowService

    fun tools(): ToolService

    fun knowledgeBases(): KnowledgeBaseService

    /** Create an AI agent for a sender. Each sender can have at most one agent. */
    fun create(
        senderId: String,
        params: AgentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentResponse = create(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see create */
    fun create(
        params: AgentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentResponse

    /** Get the AI agent configuration for a sender. */
    fun retrieve(
        senderId: String,
        params: AgentRetrieveParams = AgentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentResponse = retrieve(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        params: AgentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentResponse

    /** @see retrieve */
    fun retrieve(senderId: String, requestOptions: RequestOptions): AgentResponse =
        retrieve(senderId, AgentRetrieveParams.none(), requestOptions)

    /** Update an AI agent's configuration. */
    fun update(
        senderId: String,
        params: AgentUpdateParams = AgentUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentResponse = update(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see update */
    fun update(
        params: AgentUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentResponse

    /** @see update */
    fun update(senderId: String, requestOptions: RequestOptions): AgentResponse =
        update(senderId, AgentUpdateParams.none(), requestOptions)

    /** Delete an AI agent. */
    fun delete(
        senderId: String,
        params: AgentDeleteParams = AgentDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see delete */
    fun delete(params: AgentDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    fun delete(senderId: String, requestOptions: RequestOptions) =
        delete(senderId, AgentDeleteParams.none(), requestOptions)

    /**
     * Get statistics for an AI agent including invocations, tokens, and costs.
     *
     * Covers the messaging channels only. Voice calls are not counted here: a call is a multi-turn
     * conversation rather than one inbound message and one reply, so it is recorded as a call, not
     * an execution. An agent that only answers phone calls reports zeros on every field. Use `GET
     * /v1/calls` for voice activity, duration, and cost.
     */
    fun stats(
        senderId: String,
        params: AgentStatsParams = AgentStatsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentStats = stats(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see stats */
    fun stats(
        params: AgentStatsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentStats

    /** @see stats */
    fun stats(senderId: String, requestOptions: RequestOptions): AgentStats =
        stats(senderId, AgentStatsParams.none(), requestOptions)

    /** A view of [AgentService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): AgentService.WithRawResponse

        fun executions(): ExecutionService.WithRawResponse

        fun flows(): FlowService.WithRawResponse

        fun tools(): ToolService.WithRawResponse

        fun knowledgeBases(): KnowledgeBaseService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/senders/{senderId}/agent`, but is otherwise the
         * same as [AgentService.create].
         */
        @MustBeClosed
        fun create(
            senderId: String,
            params: AgentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentResponse> =
            create(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(
            params: AgentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentResponse>

        /**
         * Returns a raw HTTP response for `get /v1/senders/{senderId}/agent`, but is otherwise the
         * same as [AgentService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            senderId: String,
            params: AgentRetrieveParams = AgentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentResponse> =
            retrieve(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AgentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentResponse> =
            retrieve(senderId, AgentRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/senders/{senderId}/agent`, but is otherwise
         * the same as [AgentService.update].
         */
        @MustBeClosed
        fun update(
            senderId: String,
            params: AgentUpdateParams = AgentUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentResponse> =
            update(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(
            params: AgentUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentResponse>

        /** @see update */
        @MustBeClosed
        fun update(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentResponse> =
            update(senderId, AgentUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/senders/{senderId}/agent`, but is otherwise
         * the same as [AgentService.delete].
         */
        @MustBeClosed
        fun delete(
            senderId: String,
            params: AgentDeleteParams = AgentDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: AgentDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(senderId: String, requestOptions: RequestOptions): HttpResponse =
            delete(senderId, AgentDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/senders/{senderId}/agent/stats`, but is
         * otherwise the same as [AgentService.stats].
         */
        @MustBeClosed
        fun stats(
            senderId: String,
            params: AgentStatsParams = AgentStatsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentStats> =
            stats(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see stats */
        @MustBeClosed
        fun stats(
            params: AgentStatsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentStats>

        /** @see stats */
        @MustBeClosed
        fun stats(senderId: String, requestOptions: RequestOptions): HttpResponseFor<AgentStats> =
            stats(senderId, AgentStatsParams.none(), requestOptions)
    }
}
