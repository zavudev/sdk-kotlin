// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.contacts.Contact
import com.zavudev.api.models.contacts.ContactCreateParams
import com.zavudev.api.models.contacts.ContactDeleteParams
import com.zavudev.api.models.contacts.ContactListPageAsync
import com.zavudev.api.models.contacts.ContactListParams
import com.zavudev.api.models.contacts.ContactMergeParams
import com.zavudev.api.models.contacts.ContactRetrieveByPhoneParams
import com.zavudev.api.models.contacts.ContactRetrieveParams
import com.zavudev.api.models.contacts.ContactUpdateParams
import com.zavudev.api.services.async.contacts.ChannelServiceAsync

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

    fun channels(): ChannelServiceAsync

    /** Create a new contact with one or more communication channels. */
    suspend fun create(
        params: ContactCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Contact

    /** Get contact */
    suspend fun retrieve(
        contactId: String,
        params: ContactRetrieveParams = ContactRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Contact = retrieve(params.toBuilder().contactId(contactId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: ContactRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Contact

    /** @see retrieve */
    suspend fun retrieve(contactId: String, requestOptions: RequestOptions): Contact =
        retrieve(contactId, ContactRetrieveParams.none(), requestOptions)

    /** Update contact */
    suspend fun update(
        contactId: String,
        params: ContactUpdateParams = ContactUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Contact = update(params.toBuilder().contactId(contactId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: ContactUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Contact

    /** @see update */
    suspend fun update(contactId: String, requestOptions: RequestOptions): Contact =
        update(contactId, ContactUpdateParams.none(), requestOptions)

    /** List contacts with their communication channels. */
    suspend fun list(
        params: ContactListParams = ContactListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContactListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): ContactListPageAsync =
        list(ContactListParams.none(), requestOptions)

    /**
     * Permanently delete a contact and its communication channels. Implements right-to-erasure
     * obligations under GDPR Art. 17, Ley 19.628 (Chile) Art. 12, CCPA § 1798.105, and LGPD Art.
     * 18.VI. The contact, its channels, and any associated agent flow sessions and conversation
     * threads are removed. Past message records and broadcast delivery logs are retained for
     * billing/audit but no longer reference the deleted contact.
     */
    suspend fun delete(
        contactId: String,
        params: ContactDeleteParams = ContactDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().contactId(contactId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: ContactDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(contactId: String, requestOptions: RequestOptions) =
        delete(contactId, ContactDeleteParams.none(), requestOptions)

    /**
     * Merge a source contact into this contact. All channels from the source contact will be moved
     * to the target contact, and the source contact will be marked as merged.
     */
    suspend fun merge(
        contactId: String,
        params: ContactMergeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Contact = merge(params.toBuilder().contactId(contactId).build(), requestOptions)

    /** @see merge */
    suspend fun merge(
        params: ContactMergeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Contact

    /** Get contact by phone number */
    suspend fun retrieveByPhone(
        phoneNumber: String,
        params: ContactRetrieveByPhoneParams = ContactRetrieveByPhoneParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Contact =
        retrieveByPhone(params.toBuilder().phoneNumber(phoneNumber).build(), requestOptions)

    /** @see retrieveByPhone */
    suspend fun retrieveByPhone(
        params: ContactRetrieveByPhoneParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Contact

    /** @see retrieveByPhone */
    suspend fun retrieveByPhone(phoneNumber: String, requestOptions: RequestOptions): Contact =
        retrieveByPhone(phoneNumber, ContactRetrieveByPhoneParams.none(), requestOptions)

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

        fun channels(): ChannelServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/contacts`, but is otherwise the same as
         * [ContactServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: ContactCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Contact>

        /**
         * Returns a raw HTTP response for `get /v1/contacts/{contactId}`, but is otherwise the same
         * as [ContactServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            contactId: String,
            params: ContactRetrieveParams = ContactRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Contact> =
            retrieve(params.toBuilder().contactId(contactId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: ContactRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Contact>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            contactId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Contact> =
            retrieve(contactId, ContactRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/contacts/{contactId}`, but is otherwise the
         * same as [ContactServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            contactId: String,
            params: ContactUpdateParams = ContactUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Contact> =
            update(params.toBuilder().contactId(contactId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: ContactUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Contact>

        /** @see update */
        @MustBeClosed
        suspend fun update(
            contactId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Contact> = update(contactId, ContactUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/contacts`, but is otherwise the same as
         * [ContactServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: ContactListParams = ContactListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContactListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<ContactListPageAsync> =
            list(ContactListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/contacts/{contactId}`, but is otherwise the
         * same as [ContactServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            contactId: String,
            params: ContactDeleteParams = ContactDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().contactId(contactId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: ContactDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(contactId: String, requestOptions: RequestOptions): HttpResponse =
            delete(contactId, ContactDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/contacts/{contactId}/merge`, but is otherwise
         * the same as [ContactServiceAsync.merge].
         */
        @MustBeClosed
        suspend fun merge(
            contactId: String,
            params: ContactMergeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Contact> =
            merge(params.toBuilder().contactId(contactId).build(), requestOptions)

        /** @see merge */
        @MustBeClosed
        suspend fun merge(
            params: ContactMergeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Contact>

        /**
         * Returns a raw HTTP response for `get /v1/contacts/phone/{phoneNumber}`, but is otherwise
         * the same as [ContactServiceAsync.retrieveByPhone].
         */
        @MustBeClosed
        suspend fun retrieveByPhone(
            phoneNumber: String,
            params: ContactRetrieveByPhoneParams = ContactRetrieveByPhoneParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Contact> =
            retrieveByPhone(params.toBuilder().phoneNumber(phoneNumber).build(), requestOptions)

        /** @see retrieveByPhone */
        @MustBeClosed
        suspend fun retrieveByPhone(
            params: ContactRetrieveByPhoneParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Contact>

        /** @see retrieveByPhone */
        @MustBeClosed
        suspend fun retrieveByPhone(
            phoneNumber: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Contact> =
            retrieveByPhone(phoneNumber, ContactRetrieveByPhoneParams.none(), requestOptions)
    }
}
