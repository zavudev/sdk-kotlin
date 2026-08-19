// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.conversations.ConversationListMessagesPageAsync
import com.zavudev.api.models.conversations.ConversationListMessagesParams
import com.zavudev.api.models.conversations.ConversationListPageAsync
import com.zavudev.api.models.conversations.ConversationListParams
import com.zavudev.api.models.conversations.ConversationMarkAsReadParams
import com.zavudev.api.models.conversations.ConversationMarkAsReadResponse
import com.zavudev.api.models.conversations.ConversationRetrieveParams
import com.zavudev.api.models.conversations.ConversationRetrieveResponse

interface ConversationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ConversationServiceAsync

    /** Get conversation */
    suspend fun retrieve(
        conversationId: String,
        params: ConversationRetrieveParams = ConversationRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationRetrieveResponse =
        retrieve(params.toBuilder().conversationId(conversationId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: ConversationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(
        conversationId: String,
        requestOptions: RequestOptions,
    ): ConversationRetrieveResponse =
        retrieve(conversationId, ConversationRetrieveParams.none(), requestOptions)

    /**
     * List inbox threads, most recently active first. A conversation groups every message with one
     * contact across channels, which is what you need to build an inbox: `GET /v1/messages` returns
     * a flat log with no thread to hang it on.
     *
     * Use `senderId` to scope the list to a single number, and `channel` to keep only threads that
     * have carried that channel.
     */
    suspend fun list(
        params: ConversationListParams = ConversationListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): ConversationListPageAsync =
        list(ConversationListParams.none(), requestOptions)

    /**
     * Messages in this thread, newest first, across every channel it has carried. Reply with `POST
     * /v1/messages`, passing the conversation's `senderId` as the `Zavu-Sender` header so the
     * answer leaves from the number the contact already knows.
     */
    suspend fun listMessages(
        conversationId: String,
        params: ConversationListMessagesParams = ConversationListMessagesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationListMessagesPageAsync =
        listMessages(params.toBuilder().conversationId(conversationId).build(), requestOptions)

    /** @see listMessages */
    suspend fun listMessages(
        params: ConversationListMessagesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationListMessagesPageAsync

    /** @see listMessages */
    suspend fun listMessages(
        conversationId: String,
        requestOptions: RequestOptions,
    ): ConversationListMessagesPageAsync =
        listMessages(conversationId, ConversationListMessagesParams.none(), requestOptions)

    /**
     * Reset the thread's `unreadCount` to zero. Marks the thread read in your own inbox only: it
     * does not send a read receipt to the contact.
     */
    suspend fun markAsRead(
        conversationId: String,
        params: ConversationMarkAsReadParams = ConversationMarkAsReadParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationMarkAsReadResponse =
        markAsRead(params.toBuilder().conversationId(conversationId).build(), requestOptions)

    /** @see markAsRead */
    suspend fun markAsRead(
        params: ConversationMarkAsReadParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ConversationMarkAsReadResponse

    /** @see markAsRead */
    suspend fun markAsRead(
        conversationId: String,
        requestOptions: RequestOptions,
    ): ConversationMarkAsReadResponse =
        markAsRead(conversationId, ConversationMarkAsReadParams.none(), requestOptions)

    /**
     * A view of [ConversationServiceAsync] that provides access to raw HTTP responses for each
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
        ): ConversationServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/conversations/{conversationId}`, but is
         * otherwise the same as [ConversationServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            conversationId: String,
            params: ConversationRetrieveParams = ConversationRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationRetrieveResponse> =
            retrieve(params.toBuilder().conversationId(conversationId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: ConversationRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            conversationId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ConversationRetrieveResponse> =
            retrieve(conversationId, ConversationRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/conversations`, but is otherwise the same as
         * [ConversationServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: ConversationListParams = ConversationListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(
            requestOptions: RequestOptions
        ): HttpResponseFor<ConversationListPageAsync> =
            list(ConversationListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/conversations/{conversationId}/messages`, but is
         * otherwise the same as [ConversationServiceAsync.listMessages].
         */
        @MustBeClosed
        suspend fun listMessages(
            conversationId: String,
            params: ConversationListMessagesParams = ConversationListMessagesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationListMessagesPageAsync> =
            listMessages(params.toBuilder().conversationId(conversationId).build(), requestOptions)

        /** @see listMessages */
        @MustBeClosed
        suspend fun listMessages(
            params: ConversationListMessagesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationListMessagesPageAsync>

        /** @see listMessages */
        @MustBeClosed
        suspend fun listMessages(
            conversationId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ConversationListMessagesPageAsync> =
            listMessages(conversationId, ConversationListMessagesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/conversations/{conversationId}/read`, but is
         * otherwise the same as [ConversationServiceAsync.markAsRead].
         */
        @MustBeClosed
        suspend fun markAsRead(
            conversationId: String,
            params: ConversationMarkAsReadParams = ConversationMarkAsReadParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationMarkAsReadResponse> =
            markAsRead(params.toBuilder().conversationId(conversationId).build(), requestOptions)

        /** @see markAsRead */
        @MustBeClosed
        suspend fun markAsRead(
            params: ConversationMarkAsReadParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ConversationMarkAsReadResponse>

        /** @see markAsRead */
        @MustBeClosed
        suspend fun markAsRead(
            conversationId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ConversationMarkAsReadResponse> =
            markAsRead(conversationId, ConversationMarkAsReadParams.none(), requestOptions)
    }
}
