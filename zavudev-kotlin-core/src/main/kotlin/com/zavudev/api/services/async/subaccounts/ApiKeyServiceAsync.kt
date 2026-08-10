// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.subaccounts

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.subaccounts.apikeys.ApiKeyCreateParams
import com.zavudev.api.models.subaccounts.apikeys.ApiKeyCreateResponse
import com.zavudev.api.models.subaccounts.apikeys.ApiKeyListParams
import com.zavudev.api.models.subaccounts.apikeys.ApiKeyListResponse
import com.zavudev.api.models.subaccounts.apikeys.ApiKeyRevokeParams

interface ApiKeyServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ApiKeyServiceAsync

    /**
     * Create sub-account API key. Requires a parent project API key; sub-account API keys receive
     * HTTP 403.
     */
    suspend fun create(
        id: String,
        params: ApiKeyCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyCreateResponse = create(params.toBuilder().id(id).build(), requestOptions)

    /** @see create */
    suspend fun create(
        params: ApiKeyCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyCreateResponse

    /**
     * List sub-account API keys. Requires a parent project API key; sub-account API keys receive
     * HTTP 403.
     */
    suspend fun list(
        id: String,
        params: ApiKeyListParams = ApiKeyListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyListResponse = list(params.toBuilder().id(id).build(), requestOptions)

    /** @see list */
    suspend fun list(
        params: ApiKeyListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ApiKeyListResponse

    /** @see list */
    suspend fun list(id: String, requestOptions: RequestOptions): ApiKeyListResponse =
        list(id, ApiKeyListParams.none(), requestOptions)

    /**
     * Revoke sub-account API key. Requires a parent project API key; sub-account API keys receive
     * HTTP 403.
     */
    suspend fun revoke(
        keyId: String,
        params: ApiKeyRevokeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = revoke(params.toBuilder().keyId(keyId).build(), requestOptions)

    /** @see revoke */
    suspend fun revoke(
        params: ApiKeyRevokeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /**
     * A view of [ApiKeyServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ApiKeyServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/sub-accounts/{id}/api-keys`, but is otherwise
         * the same as [ApiKeyServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            id: String,
            params: ApiKeyCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyCreateResponse> =
            create(params.toBuilder().id(id).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        suspend fun create(
            params: ApiKeyCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/sub-accounts/{id}/api-keys`, but is otherwise
         * the same as [ApiKeyServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            id: String,
            params: ApiKeyListParams = ApiKeyListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyListResponse> =
            list(params.toBuilder().id(id).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        suspend fun list(
            params: ApiKeyListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ApiKeyListResponse>

        /** @see list */
        @MustBeClosed
        suspend fun list(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ApiKeyListResponse> = list(id, ApiKeyListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/sub-accounts/{id}/api-keys/{keyId}`, but is
         * otherwise the same as [ApiKeyServiceAsync.revoke].
         */
        @MustBeClosed
        suspend fun revoke(
            keyId: String,
            params: ApiKeyRevokeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = revoke(params.toBuilder().keyId(keyId).build(), requestOptions)

        /** @see revoke */
        @MustBeClosed
        suspend fun revoke(
            params: ApiKeyRevokeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
