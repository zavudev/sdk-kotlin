// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.agents.AgentCreateParams
import com.zavudev.api.models.agents.AgentCreateResponse
import com.zavudev.api.models.agents.AgentDeleteParams
import com.zavudev.api.models.agents.AgentListPageAsync
import com.zavudev.api.models.agents.AgentListParams
import com.zavudev.api.models.agents.AgentListVoicesParams
import com.zavudev.api.models.agents.AgentListVoicesResponse
import com.zavudev.api.models.agents.AgentRetrieveParams
import com.zavudev.api.models.agents.AgentRetrieveResponse
import com.zavudev.api.models.agents.AgentTestParams
import com.zavudev.api.models.agents.AgentTestResponse
import com.zavudev.api.models.agents.AgentUpdateParams
import com.zavudev.api.models.agents.AgentUpdateResponse
import com.zavudev.api.services.async.agents.SenderServiceAsync

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

    fun senders(): SenderServiceAsync

    /**
     * Create an agent without a sender. It is created disabled; connect a sender and enable it when
     * you are ready for it to answer.
     *
     * **Sub-resources.** An agent's tools, flows and knowledge bases are reachable at
     * `/v1/agents/{agentId}/tools`, `/v1/agents/{agentId}/flows` and
     * `/v1/agents/{agentId}/knowledge-bases`, mirroring the sender-scoped routes documented under
     * `/v1/senders/{senderId}/agent/...` exactly. Use the agent-scoped form while the agent has no
     * sender: the sender-scoped one cannot address it.
     */
    suspend fun create(
        params: AgentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentCreateResponse

    /** Get an agent */
    suspend fun retrieve(
        agentId: String,
        params: AgentRetrieveParams = AgentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentRetrieveResponse = retrieve(params.toBuilder().agentId(agentId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: AgentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(agentId: String, requestOptions: RequestOptions): AgentRetrieveResponse =
        retrieve(agentId, AgentRetrieveParams.none(), requestOptions)

    /** Update an agent */
    suspend fun update(
        agentId: String,
        params: AgentUpdateParams = AgentUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentUpdateResponse = update(params.toBuilder().agentId(agentId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: AgentUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentUpdateResponse

    /** @see update */
    suspend fun update(agentId: String, requestOptions: RequestOptions): AgentUpdateResponse =
        update(agentId, AgentUpdateParams.none(), requestOptions)

    /**
     * Every agent in the project, newest first — including agents that are not connected to any
     * sender yet, which the sender-scoped routes cannot reach. Each item carries `senderIds`, the
     * senders the agent answers on.
     */
    suspend fun list(
        params: AgentListParams = AgentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): AgentListPageAsync =
        list(AgentListParams.none(), requestOptions)

    /** Delete an agent */
    suspend fun delete(
        agentId: String,
        params: AgentDeleteParams = AgentDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().agentId(agentId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: AgentDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(agentId: String, requestOptions: RequestOptions) =
        delete(agentId, AgentDeleteParams.none(), requestOptions)

    /**
     * The voices an agent can speak with, for `voice.ttsVoiceId`. Filter by `language` to get the
     * ones that speak it; a voice can still be used with `language: auto`, where the agent follows
     * the caller and keeps the chosen voice.
     */
    suspend fun listVoices(
        params: AgentListVoicesParams = AgentListVoicesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentListVoicesResponse

    /** @see listVoices */
    suspend fun listVoices(requestOptions: RequestOptions): AgentListVoicesResponse =
        listVoices(AgentListVoicesParams.none(), requestOptions)

    /**
     * Run the agent's prompt, model and knowledge base against a message and return the reply
     * instead of delivering it. Writes nothing and charges nothing, so it is safe to call
     * repeatedly while iterating on a prompt.
     *
     * Note that a dry run never **executes** tools — running them would cause real side effects.
     * Live conversations on every channel do call them. When the agent has enabled tools, that gap
     * is reported in `warnings` rather than silently producing an answer that looks like a tool
     * call happened.
     */
    suspend fun test(
        agentId: String,
        params: AgentTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentTestResponse = test(params.toBuilder().agentId(agentId).build(), requestOptions)

    /** @see test */
    suspend fun test(
        params: AgentTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentTestResponse

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

        fun senders(): SenderServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/agents`, but is otherwise the same as
         * [AgentServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: AgentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/agents/{agentId}`, but is otherwise the same as
         * [AgentServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            agentId: String,
            params: AgentRetrieveParams = AgentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentRetrieveResponse> =
            retrieve(params.toBuilder().agentId(agentId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: AgentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            agentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentRetrieveResponse> =
            retrieve(agentId, AgentRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/agents/{agentId}`, but is otherwise the same
         * as [AgentServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            agentId: String,
            params: AgentUpdateParams = AgentUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentUpdateResponse> =
            update(params.toBuilder().agentId(agentId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: AgentUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentUpdateResponse>

        /** @see update */
        @MustBeClosed
        suspend fun update(
            agentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentUpdateResponse> =
            update(agentId, AgentUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/agents`, but is otherwise the same as
         * [AgentServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: AgentListParams = AgentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<AgentListPageAsync> =
            list(AgentListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/agents/{agentId}`, but is otherwise the same
         * as [AgentServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            agentId: String,
            params: AgentDeleteParams = AgentDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().agentId(agentId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: AgentDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(agentId: String, requestOptions: RequestOptions): HttpResponse =
            delete(agentId, AgentDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/agents/voices`, but is otherwise the same as
         * [AgentServiceAsync.listVoices].
         */
        @MustBeClosed
        suspend fun listVoices(
            params: AgentListVoicesParams = AgentListVoicesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentListVoicesResponse>

        /** @see listVoices */
        @MustBeClosed
        suspend fun listVoices(
            requestOptions: RequestOptions
        ): HttpResponseFor<AgentListVoicesResponse> =
            listVoices(AgentListVoicesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/agents/{agentId}/test`, but is otherwise the
         * same as [AgentServiceAsync.test].
         */
        @MustBeClosed
        suspend fun test(
            agentId: String,
            params: AgentTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentTestResponse> =
            test(params.toBuilder().agentId(agentId).build(), requestOptions)

        /** @see test */
        @MustBeClosed
        suspend fun test(
            params: AgentTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentTestResponse>
    }
}
