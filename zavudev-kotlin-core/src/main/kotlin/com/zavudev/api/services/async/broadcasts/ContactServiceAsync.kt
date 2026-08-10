// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.broadcasts

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.broadcasts.contacts.ContactAddParams
import com.zavudev.api.models.broadcasts.contacts.ContactAddResponse
import com.zavudev.api.models.broadcasts.contacts.ContactListPageAsync
import com.zavudev.api.models.broadcasts.contacts.ContactListParams
import com.zavudev.api.models.broadcasts.contacts.ContactRemoveParams

interface ContactServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ContactServiceAsync

    /** List contacts in a broadcast with optional status filter. */
    suspend fun list(
        broadcastId: String,
        params: ContactListParams = ContactListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactListPageAsync =
        list(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

    /** @see list */
    suspend fun list(
        params: ContactListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactListPageAsync

    /** @see list */
    suspend fun list(broadcastId: String, requestOptions: RequestOptions): ContactListPageAsync =
        list(broadcastId, ContactListParams.none(), requestOptions)

    /** Add contacts to a broadcast in batch. Maximum 1000 contacts per request. */
    suspend fun add(
        broadcastId: String,
        params: ContactAddParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactAddResponse = add(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

    /** @see add */
    suspend fun add(
        params: ContactAddParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactAddResponse

    /** Remove a contact from a broadcast in draft status. */
    suspend fun remove(
        contactId: String,
        params: ContactRemoveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = remove(params.toBuilder().contactId(contactId).build(), requestOptions)

    /** @see remove */
    suspend fun remove(
        params: ContactRemoveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /**
     * A view of [ContactServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ContactServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/broadcasts/{broadcastId}/contacts`, but is
         * otherwise the same as [ContactServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            broadcastId: String,
            params: ContactListParams = ContactListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactListPageAsync> =
            list(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        suspend fun list(
            params: ContactListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(
            broadcastId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContactListPageAsync> =
            list(broadcastId, ContactListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/broadcasts/{broadcastId}/contacts`, but is
         * otherwise the same as [ContactServiceAsync.add].
         */
        @MustBeClosed
        suspend fun add(
            broadcastId: String,
            params: ContactAddParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactAddResponse> =
            add(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

        /** @see add */
        @MustBeClosed
        suspend fun add(
            params: ContactAddParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactAddResponse>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/broadcasts/{broadcastId}/contacts/{contactId}`, but is otherwise the same as
         * [ContactServiceAsync.remove].
         */
        @MustBeClosed
        suspend fun remove(
            contactId: String,
            params: ContactRemoveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = remove(params.toBuilder().contactId(contactId).build(), requestOptions)

        /** @see remove */
        @MustBeClosed
        suspend fun remove(
            params: ContactRemoveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
