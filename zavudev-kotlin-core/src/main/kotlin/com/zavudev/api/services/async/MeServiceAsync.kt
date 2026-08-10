// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.me.MeRetrieveParams
import com.zavudev.api.models.me.MeRetrieveResponse

interface MeServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): MeServiceAsync

    /**
     * Returns the project, team, and API key metadata bound to the current Bearer token. Used by
     * CLIs and SDKs to confirm which project they will operate on.
     */
    suspend fun retrieve(
        params: MeRetrieveParams = MeRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MeRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(requestOptions: RequestOptions): MeRetrieveResponse =
        retrieve(MeRetrieveParams.none(), requestOptions)

    /** A view of [MeServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): MeServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/me`, but is otherwise the same as
         * [MeServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: MeRetrieveParams = MeRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MeRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(requestOptions: RequestOptions): HttpResponseFor<MeRetrieveResponse> =
            retrieve(MeRetrieveParams.none(), requestOptions)
    }
}
