// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.contacts

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.contacts.channels.ChannelAddParams
import com.zavudev.api.models.contacts.channels.ChannelAddResponse
import com.zavudev.api.models.contacts.channels.ChannelRemoveParams
import com.zavudev.api.models.contacts.channels.ChannelSetPrimaryParams
import com.zavudev.api.models.contacts.channels.ChannelSetPrimaryResponse
import com.zavudev.api.models.contacts.channels.ChannelUpdateParams
import com.zavudev.api.models.contacts.channels.ChannelUpdateResponse

interface ChannelServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ChannelServiceAsync

    /** Update a contact's channel properties. */
    suspend fun update(
        channelId: String,
        params: ChannelUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChannelUpdateResponse =
        update(params.toBuilder().channelId(channelId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: ChannelUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChannelUpdateResponse

    /** Add a new communication channel to an existing contact. */
    suspend fun add(
        contactId: String,
        params: ChannelAddParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChannelAddResponse = add(params.toBuilder().contactId(contactId).build(), requestOptions)

    /** @see add */
    suspend fun add(
        params: ChannelAddParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChannelAddResponse

    /** Remove a communication channel from a contact. Cannot remove the last channel. */
    suspend fun remove(
        channelId: String,
        params: ChannelRemoveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = remove(params.toBuilder().channelId(channelId).build(), requestOptions)

    /** @see remove */
    suspend fun remove(
        params: ChannelRemoveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** Set a channel as the primary channel for its type. */
    suspend fun setPrimary(
        channelId: String,
        params: ChannelSetPrimaryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChannelSetPrimaryResponse =
        setPrimary(params.toBuilder().channelId(channelId).build(), requestOptions)

    /** @see setPrimary */
    suspend fun setPrimary(
        params: ChannelSetPrimaryParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChannelSetPrimaryResponse

    /**
     * A view of [ChannelServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ChannelServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `patch /v1/contacts/{contactId}/channels/{channelId}`,
         * but is otherwise the same as [ChannelServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            channelId: String,
            params: ChannelUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChannelUpdateResponse> =
            update(params.toBuilder().channelId(channelId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: ChannelUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChannelUpdateResponse>

        /**
         * Returns a raw HTTP response for `post /v1/contacts/{contactId}/channels`, but is
         * otherwise the same as [ChannelServiceAsync.add].
         */
        @MustBeClosed
        suspend fun add(
            contactId: String,
            params: ChannelAddParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChannelAddResponse> =
            add(params.toBuilder().contactId(contactId).build(), requestOptions)

        /** @see add */
        @MustBeClosed
        suspend fun add(
            params: ChannelAddParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChannelAddResponse>

        /**
         * Returns a raw HTTP response for `delete /v1/contacts/{contactId}/channels/{channelId}`,
         * but is otherwise the same as [ChannelServiceAsync.remove].
         */
        @MustBeClosed
        suspend fun remove(
            channelId: String,
            params: ChannelRemoveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = remove(params.toBuilder().channelId(channelId).build(), requestOptions)

        /** @see remove */
        @MustBeClosed
        suspend fun remove(
            params: ChannelRemoveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /**
         * Returns a raw HTTP response for `post
         * /v1/contacts/{contactId}/channels/{channelId}/primary`, but is otherwise the same as
         * [ChannelServiceAsync.setPrimary].
         */
        @MustBeClosed
        suspend fun setPrimary(
            channelId: String,
            params: ChannelSetPrimaryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChannelSetPrimaryResponse> =
            setPrimary(params.toBuilder().channelId(channelId).build(), requestOptions)

        /** @see setPrimary */
        @MustBeClosed
        suspend fun setPrimary(
            params: ChannelSetPrimaryParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ChannelSetPrimaryResponse>
    }
}
