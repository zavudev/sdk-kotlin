// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.invitations.InvitationCancelParams
import com.zavudev.api.models.invitations.InvitationCancelResponse
import com.zavudev.api.models.invitations.InvitationCreateParams
import com.zavudev.api.models.invitations.InvitationCreateResponse
import com.zavudev.api.models.invitations.InvitationListPageAsync
import com.zavudev.api.models.invitations.InvitationListParams
import com.zavudev.api.models.invitations.InvitationRetrieveParams
import com.zavudev.api.models.invitations.InvitationRetrieveResponse

interface InvitationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): InvitationServiceAsync

    /**
     * Create a partner invitation link for a client to connect a Meta channel. The client opens the
     * returned `url` and authorizes with Meta; the resulting sender is created in your project when
     * they finish, and the invitation transitions to `completed`.
     *
     * `connectionType` picks the channel:
     * - `whatsapp_waba` (default): Meta's embedded signup links an official WhatsApp Business
     *   Account.
     * - `messenger`: the client picks a Facebook Page they administer; its Messenger inbox
     *   (including Marketplace chats) is routed to Zavu.
     *
     * One invitation connects one channel — create one per channel to onboard a client on several.
     * `phoneNumberId` and `allowedPhoneCountries` apply to `whatsapp_waba` only.
     */
    suspend fun create(
        params: InvitationCreateParams = InvitationCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvitationCreateResponse

    /** @see create */
    suspend fun create(requestOptions: RequestOptions): InvitationCreateResponse =
        create(InvitationCreateParams.none(), requestOptions)

    /** Get invitation */
    suspend fun retrieve(
        invitationId: String,
        params: InvitationRetrieveParams = InvitationRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvitationRetrieveResponse =
        retrieve(params.toBuilder().invitationId(invitationId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: InvitationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvitationRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(
        invitationId: String,
        requestOptions: RequestOptions,
    ): InvitationRetrieveResponse =
        retrieve(invitationId, InvitationRetrieveParams.none(), requestOptions)

    /** List partner invitations for this project. */
    suspend fun list(
        params: InvitationListParams = InvitationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvitationListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): InvitationListPageAsync =
        list(InvitationListParams.none(), requestOptions)

    /**
     * Cancel an active invitation. The client will no longer be able to use the invitation link.
     */
    suspend fun cancel(
        invitationId: String,
        params: InvitationCancelParams = InvitationCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvitationCancelResponse =
        cancel(params.toBuilder().invitationId(invitationId).build(), requestOptions)

    /** @see cancel */
    suspend fun cancel(
        params: InvitationCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvitationCancelResponse

    /** @see cancel */
    suspend fun cancel(
        invitationId: String,
        requestOptions: RequestOptions,
    ): InvitationCancelResponse =
        cancel(invitationId, InvitationCancelParams.none(), requestOptions)

    /**
     * A view of [InvitationServiceAsync] that provides access to raw HTTP responses for each
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
        ): InvitationServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/invitations`, but is otherwise the same as
         * [InvitationServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: InvitationCreateParams = InvitationCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvitationCreateResponse>

        /** @see create */
        @MustBeClosed
        suspend fun create(
            requestOptions: RequestOptions
        ): HttpResponseFor<InvitationCreateResponse> =
            create(InvitationCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/invitations/{invitationId}`, but is otherwise
         * the same as [InvitationServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            invitationId: String,
            params: InvitationRetrieveParams = InvitationRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvitationRetrieveResponse> =
            retrieve(params.toBuilder().invitationId(invitationId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: InvitationRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvitationRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            invitationId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvitationRetrieveResponse> =
            retrieve(invitationId, InvitationRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/invitations`, but is otherwise the same as
         * [InvitationServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: InvitationListParams = InvitationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvitationListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<InvitationListPageAsync> =
            list(InvitationListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/invitations/{invitationId}/cancel`, but is
         * otherwise the same as [InvitationServiceAsync.cancel].
         */
        @MustBeClosed
        suspend fun cancel(
            invitationId: String,
            params: InvitationCancelParams = InvitationCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvitationCancelResponse> =
            cancel(params.toBuilder().invitationId(invitationId).build(), requestOptions)

        /** @see cancel */
        @MustBeClosed
        suspend fun cancel(
            params: InvitationCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvitationCancelResponse>

        /** @see cancel */
        @MustBeClosed
        suspend fun cancel(
            invitationId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvitationCancelResponse> =
            cancel(invitationId, InvitationCancelParams.none(), requestOptions)
    }
}
