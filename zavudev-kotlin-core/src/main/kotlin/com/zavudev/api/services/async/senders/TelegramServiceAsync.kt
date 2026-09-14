// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.senders.telegram.TelegramConnectParams
import com.zavudev.api.models.senders.telegram.TelegramConnectResponse
import com.zavudev.api.models.senders.telegram.TelegramDisconnectParams

interface TelegramServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TelegramServiceAsync

    /**
     * Connect a Telegram bot to a sender. Provide the bot token from @BotFather; Zavu validates it,
     * registers the webhook, and routes the sender's Telegram messages through it.
     */
    suspend fun connect(
        senderId: String,
        params: TelegramConnectParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TelegramConnectResponse =
        connect(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see connect */
    suspend fun connect(
        params: TelegramConnectParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TelegramConnectResponse

    /** Disconnect Telegram from a sender and remove the webhook. */
    suspend fun disconnect(
        senderId: String,
        params: TelegramDisconnectParams = TelegramDisconnectParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = disconnect(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see disconnect */
    suspend fun disconnect(
        params: TelegramDisconnectParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see disconnect */
    suspend fun disconnect(senderId: String, requestOptions: RequestOptions) =
        disconnect(senderId, TelegramDisconnectParams.none(), requestOptions)

    /**
     * A view of [TelegramServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): TelegramServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/senders/{senderId}/telegram`, but is otherwise
         * the same as [TelegramServiceAsync.connect].
         */
        @MustBeClosed
        suspend fun connect(
            senderId: String,
            params: TelegramConnectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TelegramConnectResponse> =
            connect(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see connect */
        @MustBeClosed
        suspend fun connect(
            params: TelegramConnectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TelegramConnectResponse>

        /**
         * Returns a raw HTTP response for `delete /v1/senders/{senderId}/telegram`, but is
         * otherwise the same as [TelegramServiceAsync.disconnect].
         */
        @MustBeClosed
        suspend fun disconnect(
            senderId: String,
            params: TelegramDisconnectParams = TelegramDisconnectParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = disconnect(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see disconnect */
        @MustBeClosed
        suspend fun disconnect(
            params: TelegramDisconnectParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see disconnect */
        @MustBeClosed
        suspend fun disconnect(senderId: String, requestOptions: RequestOptions): HttpResponse =
            disconnect(senderId, TelegramDisconnectParams.none(), requestOptions)
    }
}
