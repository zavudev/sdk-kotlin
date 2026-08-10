// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.blocking.broadcasts

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.broadcasts.contacts.ContactAddParams
import com.zavudev.api.models.broadcasts.contacts.ContactAddResponse
import com.zavudev.api.models.broadcasts.contacts.ContactListPage
import com.zavudev.api.models.broadcasts.contacts.ContactListParams
import com.zavudev.api.models.broadcasts.contacts.ContactRemoveParams

interface ContactService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ContactService

    /** List contacts in a broadcast with optional status filter. */
    fun list(
        broadcastId: String,
        params: ContactListParams = ContactListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactListPage = list(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

    /** @see list */
    fun list(
        params: ContactListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactListPage

    /** @see list */
    fun list(broadcastId: String, requestOptions: RequestOptions): ContactListPage =
        list(broadcastId, ContactListParams.none(), requestOptions)

    /** Add contacts to a broadcast in batch. Maximum 1000 contacts per request. */
    fun add(
        broadcastId: String,
        params: ContactAddParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactAddResponse = add(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

    /** @see add */
    fun add(
        params: ContactAddParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactAddResponse

    /** Remove a contact from a broadcast in draft status. */
    fun remove(
        contactId: String,
        params: ContactRemoveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = remove(params.toBuilder().contactId(contactId).build(), requestOptions)

    /** @see remove */
    fun remove(params: ContactRemoveParams, requestOptions: RequestOptions = RequestOptions.none())

    /** A view of [ContactService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ContactService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/broadcasts/{broadcastId}/contacts`, but is
         * otherwise the same as [ContactService.list].
         */
        @MustBeClosed
        fun list(
            broadcastId: String,
            params: ContactListParams = ContactListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactListPage> =
            list(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            params: ContactListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            broadcastId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContactListPage> =
            list(broadcastId, ContactListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/broadcasts/{broadcastId}/contacts`, but is
         * otherwise the same as [ContactService.add].
         */
        @MustBeClosed
        fun add(
            broadcastId: String,
            params: ContactAddParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactAddResponse> =
            add(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

        /** @see add */
        @MustBeClosed
        fun add(
            params: ContactAddParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactAddResponse>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/broadcasts/{broadcastId}/contacts/{contactId}`, but is otherwise the same as
         * [ContactService.remove].
         */
        @MustBeClosed
        fun remove(
            contactId: String,
            params: ContactRemoveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = remove(params.toBuilder().contactId(contactId).build(), requestOptions)

        /** @see remove */
        @MustBeClosed
        fun remove(
            params: ContactRemoveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
