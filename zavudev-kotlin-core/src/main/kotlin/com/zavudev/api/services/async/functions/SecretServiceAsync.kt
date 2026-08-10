// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.functions

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.functions.secrets.SecretListParams
import com.zavudev.api.models.functions.secrets.SecretListResponse
import com.zavudev.api.models.functions.secrets.SecretSetParams
import com.zavudev.api.models.functions.secrets.SecretSetResponse
import com.zavudev.api.models.functions.secrets.SecretUnsetParams

interface SecretServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): SecretServiceAsync

    /**
     * Lists every secret key set on the function. Plaintext is NEVER returned — only the last 4
     * characters of each value, for visual confirmation.
     */
    suspend fun list(
        functionId: String,
        params: SecretListParams = SecretListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SecretListResponse = list(params.toBuilder().functionId(functionId).build(), requestOptions)

    /** @see list */
    suspend fun list(
        params: SecretListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SecretListResponse

    /** @see list */
    suspend fun list(functionId: String, requestOptions: RequestOptions): SecretListResponse =
        list(functionId, SecretListParams.none(), requestOptions)

    /**
     * Create or update a secret on a function. Marks the function out-of-sync; the next `POST
     * /deploy` re-publishes the Lambda with the new env. Keys must match `[A-Z_][A-Z0-9_]*`
     * (uppercase env-var style) and cannot start with reserved prefixes (AWS_, LAMBDA_, etc).
     */
    suspend fun set(
        key: String,
        params: SecretSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SecretSetResponse = set(params.toBuilder().key(key).build(), requestOptions)

    /** @see set */
    suspend fun set(
        params: SecretSetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SecretSetResponse

    /**
     * Remove a secret from a function. Doesn't take effect on the running Lambda until the next
     * deploy.
     */
    suspend fun unset(
        key: String,
        params: SecretUnsetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = unset(params.toBuilder().key(key).build(), requestOptions)

    /** @see unset */
    suspend fun unset(
        params: SecretUnsetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /**
     * A view of [SecretServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): SecretServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/functions/{functionId}/secrets`, but is
         * otherwise the same as [SecretServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            functionId: String,
            params: SecretListParams = SecretListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SecretListResponse> =
            list(params.toBuilder().functionId(functionId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        suspend fun list(
            params: SecretListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SecretListResponse>

        /** @see list */
        @MustBeClosed
        suspend fun list(
            functionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SecretListResponse> =
            list(functionId, SecretListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `put /v1/functions/{functionId}/secrets/{key}`, but is
         * otherwise the same as [SecretServiceAsync.set].
         */
        @MustBeClosed
        suspend fun set(
            key: String,
            params: SecretSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SecretSetResponse> =
            set(params.toBuilder().key(key).build(), requestOptions)

        /** @see set */
        @MustBeClosed
        suspend fun set(
            params: SecretSetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SecretSetResponse>

        /**
         * Returns a raw HTTP response for `delete /v1/functions/{functionId}/secrets/{key}`, but is
         * otherwise the same as [SecretServiceAsync.unset].
         */
        @MustBeClosed
        suspend fun unset(
            key: String,
            params: SecretUnsetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = unset(params.toBuilder().key(key).build(), requestOptions)

        /** @see unset */
        @MustBeClosed
        suspend fun unset(
            params: SecretUnsetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
