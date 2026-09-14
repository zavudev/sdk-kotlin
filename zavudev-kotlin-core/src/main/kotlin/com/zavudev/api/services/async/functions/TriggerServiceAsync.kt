// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.functions

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.functions.triggers.TriggerCreateParams
import com.zavudev.api.models.functions.triggers.TriggerCreateResponse
import com.zavudev.api.models.functions.triggers.TriggerDeleteParams
import com.zavudev.api.models.functions.triggers.TriggerListParams
import com.zavudev.api.models.functions.triggers.TriggerListResponse
import com.zavudev.api.models.functions.triggers.TriggerUpdateParams
import com.zavudev.api.models.functions.triggers.TriggerUpdateResponse

interface TriggerServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TriggerServiceAsync

    /**
     * Subscribe a function to one or more event types, optionally scoped to specific senders.
     * Provide eventTypes and senderIds (use null in senderIds for all senders); a trigger is
     * created for each event type and sender combination.
     *
     * The special event type `cron` runs the function on a schedule instead of a messaging event:
     * include a `cron` field with a 5-field UTC cron expression (minimum granularity one minute). A
     * cron trigger ignores the sender axis, and a function may hold several cron triggers with
     * different expressions. The function receives an event with `type: "cron"` and `data.cron`.
     */
    suspend fun create(
        functionId: String,
        params: TriggerCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TriggerCreateResponse =
        create(params.toBuilder().functionId(functionId).build(), requestOptions)

    /** @see create */
    suspend fun create(
        params: TriggerCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TriggerCreateResponse

    /** Enable or disable a trigger */
    suspend fun update(
        triggerId: String,
        params: TriggerUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TriggerUpdateResponse =
        update(params.toBuilder().triggerId(triggerId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: TriggerUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TriggerUpdateResponse

    /** List function triggers */
    suspend fun list(
        functionId: String,
        params: TriggerListParams = TriggerListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TriggerListResponse = list(params.toBuilder().functionId(functionId).build(), requestOptions)

    /** @see list */
    suspend fun list(
        params: TriggerListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TriggerListResponse

    /** @see list */
    suspend fun list(functionId: String, requestOptions: RequestOptions): TriggerListResponse =
        list(functionId, TriggerListParams.none(), requestOptions)

    /** Delete a trigger */
    suspend fun delete(
        triggerId: String,
        params: TriggerDeleteParams = TriggerDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().triggerId(triggerId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: TriggerDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(triggerId: String, requestOptions: RequestOptions) =
        delete(triggerId, TriggerDeleteParams.none(), requestOptions)

    /**
     * A view of [TriggerServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): TriggerServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/functions/{functionId}/triggers`, but is
         * otherwise the same as [TriggerServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            functionId: String,
            params: TriggerCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TriggerCreateResponse> =
            create(params.toBuilder().functionId(functionId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        suspend fun create(
            params: TriggerCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TriggerCreateResponse>

        /**
         * Returns a raw HTTP response for `patch /v1/functions/triggers/{triggerId}`, but is
         * otherwise the same as [TriggerServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            triggerId: String,
            params: TriggerUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TriggerUpdateResponse> =
            update(params.toBuilder().triggerId(triggerId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: TriggerUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TriggerUpdateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/functions/{functionId}/triggers`, but is
         * otherwise the same as [TriggerServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            functionId: String,
            params: TriggerListParams = TriggerListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TriggerListResponse> =
            list(params.toBuilder().functionId(functionId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        suspend fun list(
            params: TriggerListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TriggerListResponse>

        /** @see list */
        @MustBeClosed
        suspend fun list(
            functionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TriggerListResponse> =
            list(functionId, TriggerListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/functions/triggers/{triggerId}`, but is
         * otherwise the same as [TriggerServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            triggerId: String,
            params: TriggerDeleteParams = TriggerDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().triggerId(triggerId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: TriggerDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(triggerId: String, requestOptions: RequestOptions): HttpResponse =
            delete(triggerId, TriggerDeleteParams.none(), requestOptions)
    }
}
