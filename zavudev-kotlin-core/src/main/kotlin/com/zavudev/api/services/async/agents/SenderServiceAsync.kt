// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.agents

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.agents.senders.SenderConnectParams
import com.zavudev.api.models.agents.senders.SenderConnectResponse
import com.zavudev.api.models.agents.senders.SenderDisconnectParams

interface SenderServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): SenderServiceAsync

    /**
     * Make the agent answer on this sender. An agent can serve several senders; a sender answers
     * with at most one agent, so connecting one that is already in use returns `400` naming the
     * agent that holds it.
     */
    suspend fun connect(
        agentId: String,
        params: SenderConnectParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SenderConnectResponse = connect(params.toBuilder().agentId(agentId).build(), requestOptions)

    /** @see connect */
    suspend fun connect(
        params: SenderConnectParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SenderConnectResponse

    /**
     * Stop the agent answering on this sender. The agent's primary sender is part of the agent
     * itself and cannot be disconnected here.
     */
    suspend fun disconnect(
        senderId: String,
        params: SenderDisconnectParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = disconnect(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see disconnect */
    suspend fun disconnect(
        params: SenderDisconnectParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /**
     * A view of [SenderServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): SenderServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/agents/{agentId}/senders`, but is otherwise the
         * same as [SenderServiceAsync.connect].
         */
        @MustBeClosed
        suspend fun connect(
            agentId: String,
            params: SenderConnectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SenderConnectResponse> =
            connect(params.toBuilder().agentId(agentId).build(), requestOptions)

        /** @see connect */
        @MustBeClosed
        suspend fun connect(
            params: SenderConnectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SenderConnectResponse>

        /**
         * Returns a raw HTTP response for `delete /v1/agents/{agentId}/senders/{senderId}`, but is
         * otherwise the same as [SenderServiceAsync.disconnect].
         */
        @MustBeClosed
        suspend fun disconnect(
            senderId: String,
            params: SenderDisconnectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = disconnect(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see disconnect */
        @MustBeClosed
        suspend fun disconnect(
            params: SenderDisconnectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
