// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders.agent

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.senders.agent.tools.ToolCreateParams
import com.zavudev.api.models.senders.agent.tools.ToolCreateResponse
import com.zavudev.api.models.senders.agent.tools.ToolDeleteParams
import com.zavudev.api.models.senders.agent.tools.ToolListPageAsync
import com.zavudev.api.models.senders.agent.tools.ToolListParams
import com.zavudev.api.models.senders.agent.tools.ToolRetrieveParams
import com.zavudev.api.models.senders.agent.tools.ToolRetrieveResponse
import com.zavudev.api.models.senders.agent.tools.ToolTestParams
import com.zavudev.api.models.senders.agent.tools.ToolTestResponse
import com.zavudev.api.models.senders.agent.tools.ToolUpdateParams
import com.zavudev.api.models.senders.agent.tools.ToolUpdateResponse

interface ToolServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ToolServiceAsync

    /** Create a new tool for an agent. Tools allow the agent to call external webhooks. */
    suspend fun create(
        senderId: String,
        params: ToolCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ToolCreateResponse = create(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see create */
    suspend fun create(
        params: ToolCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ToolCreateResponse

    /** Get a specific tool. */
    suspend fun retrieve(
        toolId: String,
        params: ToolRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ToolRetrieveResponse = retrieve(params.toBuilder().toolId(toolId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: ToolRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ToolRetrieveResponse

    /** Update a tool. */
    suspend fun update(
        toolId: String,
        params: ToolUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ToolUpdateResponse = update(params.toBuilder().toolId(toolId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: ToolUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ToolUpdateResponse

    /** List tools for an agent. */
    suspend fun list(
        senderId: String,
        params: ToolListParams = ToolListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ToolListPageAsync = list(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see list */
    suspend fun list(
        params: ToolListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ToolListPageAsync

    /** @see list */
    suspend fun list(senderId: String, requestOptions: RequestOptions): ToolListPageAsync =
        list(senderId, ToolListParams.none(), requestOptions)

    /** Delete a tool. */
    suspend fun delete(
        toolId: String,
        params: ToolDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().toolId(toolId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: ToolDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /**
     * Run a tool with the parameters you supply and return what it answered.
     *
     * The call is synchronous: the response carries the tool's status, body, and duration, so a
     * green result is evidence the tool ran rather than evidence it was accepted. Each run is also
     * recorded and readable afterwards via `GET
     * /v1/senders/{senderId}/agent/tools/{toolId}/test-runs`.
     *
     * A tool that answers with an error is reported as a run with `success: false` — the endpoint
     * itself still returns 200. This fires the tool's real webhook, so a test has whatever side
     * effects the tool has.
     */
    suspend fun test(
        toolId: String,
        params: ToolTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ToolTestResponse = test(params.toBuilder().toolId(toolId).build(), requestOptions)

    /** @see test */
    suspend fun test(
        params: ToolTestParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ToolTestResponse

    /** A view of [ToolServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ToolServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/senders/{senderId}/agent/tools`, but is
         * otherwise the same as [ToolServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            senderId: String,
            params: ToolCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ToolCreateResponse> =
            create(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        suspend fun create(
            params: ToolCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ToolCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/senders/{senderId}/agent/tools/{toolId}`, but is
         * otherwise the same as [ToolServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            toolId: String,
            params: ToolRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ToolRetrieveResponse> =
            retrieve(params.toBuilder().toolId(toolId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: ToolRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ToolRetrieveResponse>

        /**
         * Returns a raw HTTP response for `patch /v1/senders/{senderId}/agent/tools/{toolId}`, but
         * is otherwise the same as [ToolServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            toolId: String,
            params: ToolUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ToolUpdateResponse> =
            update(params.toBuilder().toolId(toolId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: ToolUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ToolUpdateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/senders/{senderId}/agent/tools`, but is
         * otherwise the same as [ToolServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            senderId: String,
            params: ToolListParams = ToolListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ToolListPageAsync> =
            list(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        suspend fun list(
            params: ToolListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ToolListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ToolListPageAsync> =
            list(senderId, ToolListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/senders/{senderId}/agent/tools/{toolId}`, but
         * is otherwise the same as [ToolServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            toolId: String,
            params: ToolDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().toolId(toolId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: ToolDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `post /v1/senders/{senderId}/agent/tools/{toolId}/test`,
         * but is otherwise the same as [ToolServiceAsync.test].
         */
        @MustBeClosed
        suspend fun test(
            toolId: String,
            params: ToolTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ToolTestResponse> =
            test(params.toBuilder().toolId(toolId).build(), requestOptions)

        /** @see test */
        @MustBeClosed
        suspend fun test(
            params: ToolTestParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ToolTestResponse>
    }
}
