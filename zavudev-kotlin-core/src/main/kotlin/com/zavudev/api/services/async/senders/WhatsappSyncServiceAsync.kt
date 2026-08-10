// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.senders.whatsappsync.WhatsappSyncRetrieveParams
import com.zavudev.api.models.senders.whatsappsync.WhatsappSyncRetrieveResponse
import com.zavudev.api.models.senders.whatsappsync.WhatsappSyncStartContactsSyncParams
import com.zavudev.api.models.senders.whatsappsync.WhatsappSyncStartContactsSyncResponse
import com.zavudev.api.models.senders.whatsappsync.WhatsappSyncStartHistorySyncParams
import com.zavudev.api.models.senders.whatsappsync.WhatsappSyncStartHistorySyncResponse

interface WhatsappSyncServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): WhatsappSyncServiceAsync

    /**
     * Get the current sync status for a sender's WhatsApp coexistence account. Only available for
     * senders connected in coexistence mode (WhatsApp Business App + Cloud API).
     */
    suspend fun retrieve(
        senderId: String,
        params: WhatsappSyncRetrieveParams = WhatsappSyncRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WhatsappSyncRetrieveResponse =
        retrieve(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: WhatsappSyncRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WhatsappSyncRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(
        senderId: String,
        requestOptions: RequestOptions,
    ): WhatsappSyncRetrieveResponse =
        retrieve(senderId, WhatsappSyncRetrieveParams.none(), requestOptions)

    /**
     * Initiate contact names sync from the WhatsApp Business App. This imports contact names stored
     * in the app to Zavu. Only available for coexistence accounts with active status.
     */
    suspend fun startContactsSync(
        senderId: String,
        params: WhatsappSyncStartContactsSyncParams = WhatsappSyncStartContactsSyncParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WhatsappSyncStartContactsSyncResponse =
        startContactsSync(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see startContactsSync */
    suspend fun startContactsSync(
        params: WhatsappSyncStartContactsSyncParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WhatsappSyncStartContactsSyncResponse

    /** @see startContactsSync */
    suspend fun startContactsSync(
        senderId: String,
        requestOptions: RequestOptions,
    ): WhatsappSyncStartContactsSyncResponse =
        startContactsSync(senderId, WhatsappSyncStartContactsSyncParams.none(), requestOptions)

    /**
     * Initiate message history sync from the WhatsApp Business App. This sends a request to the
     * account owner to approve sharing their conversation history. Only available for coexistence
     * accounts with active status.
     */
    suspend fun startHistorySync(
        senderId: String,
        params: WhatsappSyncStartHistorySyncParams = WhatsappSyncStartHistorySyncParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WhatsappSyncStartHistorySyncResponse =
        startHistorySync(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see startHistorySync */
    suspend fun startHistorySync(
        params: WhatsappSyncStartHistorySyncParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WhatsappSyncStartHistorySyncResponse

    /** @see startHistorySync */
    suspend fun startHistorySync(
        senderId: String,
        requestOptions: RequestOptions,
    ): WhatsappSyncStartHistorySyncResponse =
        startHistorySync(senderId, WhatsappSyncStartHistorySyncParams.none(), requestOptions)

    /**
     * A view of [WhatsappSyncServiceAsync] that provides access to raw HTTP responses for each
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
        ): WhatsappSyncServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/senders/{senderId}/whatsapp-sync`, but is
         * otherwise the same as [WhatsappSyncServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            senderId: String,
            params: WhatsappSyncRetrieveParams = WhatsappSyncRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WhatsappSyncRetrieveResponse> =
            retrieve(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: WhatsappSyncRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WhatsappSyncRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WhatsappSyncRetrieveResponse> =
            retrieve(senderId, WhatsappSyncRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/senders/{senderId}/whatsapp-sync/contacts`, but
         * is otherwise the same as [WhatsappSyncServiceAsync.startContactsSync].
         */
        @MustBeClosed
        suspend fun startContactsSync(
            senderId: String,
            params: WhatsappSyncStartContactsSyncParams =
                WhatsappSyncStartContactsSyncParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WhatsappSyncStartContactsSyncResponse> =
            startContactsSync(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see startContactsSync */
        @MustBeClosed
        suspend fun startContactsSync(
            params: WhatsappSyncStartContactsSyncParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WhatsappSyncStartContactsSyncResponse>

        /** @see startContactsSync */
        @MustBeClosed
        suspend fun startContactsSync(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WhatsappSyncStartContactsSyncResponse> =
            startContactsSync(senderId, WhatsappSyncStartContactsSyncParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/senders/{senderId}/whatsapp-sync/history`, but
         * is otherwise the same as [WhatsappSyncServiceAsync.startHistorySync].
         */
        @MustBeClosed
        suspend fun startHistorySync(
            senderId: String,
            params: WhatsappSyncStartHistorySyncParams = WhatsappSyncStartHistorySyncParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WhatsappSyncStartHistorySyncResponse> =
            startHistorySync(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see startHistorySync */
        @MustBeClosed
        suspend fun startHistorySync(
            params: WhatsappSyncStartHistorySyncParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WhatsappSyncStartHistorySyncResponse>

        /** @see startHistorySync */
        @MustBeClosed
        suspend fun startHistorySync(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WhatsappSyncStartHistorySyncResponse> =
            startHistorySync(senderId, WhatsappSyncStartHistorySyncParams.none(), requestOptions)
    }
}
