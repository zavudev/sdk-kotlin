// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.subaccounts.SubAccountCreateParams
import com.zavudev.api.models.subaccounts.SubAccountCreateResponse
import com.zavudev.api.models.subaccounts.SubAccountDeactivateParams
import com.zavudev.api.models.subaccounts.SubAccountDeactivateResponse
import com.zavudev.api.models.subaccounts.SubAccountGetBalanceParams
import com.zavudev.api.models.subaccounts.SubAccountGetBalanceResponse
import com.zavudev.api.models.subaccounts.SubAccountListPageAsync
import com.zavudev.api.models.subaccounts.SubAccountListParams
import com.zavudev.api.models.subaccounts.SubAccountRetrieveParams
import com.zavudev.api.models.subaccounts.SubAccountRetrieveResponse
import com.zavudev.api.models.subaccounts.SubAccountUpdateParams
import com.zavudev.api.models.subaccounts.SubAccountUpdateResponse
import com.zavudev.api.services.async.subaccounts.ApiKeyServiceAsync

interface SubAccountServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): SubAccountServiceAsync

    fun apiKeys(): ApiKeyServiceAsync

    /**
     * Create a new sub-account (project) with its own API key. All charges are billed to the parent
     * team's balance. Use creditLimit to set a spending cap. The sub-account's API key is returned
     * only in the creation response. Requires a parent project API key; sub-account API keys
     * receive HTTP 403.
     */
    suspend fun create(
        params: SubAccountCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SubAccountCreateResponse

    /**
     * Get sub-account. Requires a parent project API key; sub-account API keys receive HTTP 403.
     */
    suspend fun retrieve(
        id: String,
        params: SubAccountRetrieveParams = SubAccountRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SubAccountRetrieveResponse = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: SubAccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SubAccountRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(id: String, requestOptions: RequestOptions): SubAccountRetrieveResponse =
        retrieve(id, SubAccountRetrieveParams.none(), requestOptions)

    /**
     * Update sub-account. Requires a parent project API key; sub-account API keys receive HTTP 403.
     */
    suspend fun update(
        id: String,
        params: SubAccountUpdateParams = SubAccountUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SubAccountUpdateResponse = update(params.toBuilder().id(id).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: SubAccountUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SubAccountUpdateResponse

    /** @see update */
    suspend fun update(id: String, requestOptions: RequestOptions): SubAccountUpdateResponse =
        update(id, SubAccountUpdateParams.none(), requestOptions)

    /**
     * List sub-accounts for this team. Requires a parent project API key; sub-account API keys
     * receive HTTP 403.
     */
    suspend fun list(
        params: SubAccountListParams = SubAccountListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SubAccountListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): SubAccountListPageAsync =
        list(SubAccountListParams.none(), requestOptions)

    /**
     * Deactivate a sub-account. Remaining balance is returned to the parent team and all API keys
     * are revoked. Requires a parent project API key; sub-account API keys receive HTTP 403.
     */
    suspend fun deactivate(
        id: String,
        params: SubAccountDeactivateParams = SubAccountDeactivateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SubAccountDeactivateResponse = deactivate(params.toBuilder().id(id).build(), requestOptions)

    /** @see deactivate */
    suspend fun deactivate(
        params: SubAccountDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SubAccountDeactivateResponse

    /** @see deactivate */
    suspend fun deactivate(
        id: String,
        requestOptions: RequestOptions,
    ): SubAccountDeactivateResponse =
        deactivate(id, SubAccountDeactivateParams.none(), requestOptions)

    /**
     * Get spending information for a sub-account. Returns the parent team's balance, the
     * sub-account's total spending, and its credit limit (spending cap). Requires a parent project
     * API key; sub-account API keys receive HTTP 403.
     */
    suspend fun getBalance(
        id: String,
        params: SubAccountGetBalanceParams = SubAccountGetBalanceParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SubAccountGetBalanceResponse = getBalance(params.toBuilder().id(id).build(), requestOptions)

    /** @see getBalance */
    suspend fun getBalance(
        params: SubAccountGetBalanceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SubAccountGetBalanceResponse

    /** @see getBalance */
    suspend fun getBalance(
        id: String,
        requestOptions: RequestOptions,
    ): SubAccountGetBalanceResponse =
        getBalance(id, SubAccountGetBalanceParams.none(), requestOptions)

    /**
     * A view of [SubAccountServiceAsync] that provides access to raw HTTP responses for each
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
        ): SubAccountServiceAsync.WithRawResponse

        fun apiKeys(): ApiKeyServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/sub-accounts`, but is otherwise the same as
         * [SubAccountServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: SubAccountCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SubAccountCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/sub-accounts/{id}`, but is otherwise the same as
         * [SubAccountServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            id: String,
            params: SubAccountRetrieveParams = SubAccountRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SubAccountRetrieveResponse> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: SubAccountRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SubAccountRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SubAccountRetrieveResponse> =
            retrieve(id, SubAccountRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/sub-accounts/{id}`, but is otherwise the same
         * as [SubAccountServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            id: String,
            params: SubAccountUpdateParams = SubAccountUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SubAccountUpdateResponse> =
            update(params.toBuilder().id(id).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: SubAccountUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SubAccountUpdateResponse>

        /** @see update */
        @MustBeClosed
        suspend fun update(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SubAccountUpdateResponse> =
            update(id, SubAccountUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/sub-accounts`, but is otherwise the same as
         * [SubAccountServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: SubAccountListParams = SubAccountListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SubAccountListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<SubAccountListPageAsync> =
            list(SubAccountListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/sub-accounts/{id}`, but is otherwise the same
         * as [SubAccountServiceAsync.deactivate].
         */
        @MustBeClosed
        suspend fun deactivate(
            id: String,
            params: SubAccountDeactivateParams = SubAccountDeactivateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SubAccountDeactivateResponse> =
            deactivate(params.toBuilder().id(id).build(), requestOptions)

        /** @see deactivate */
        @MustBeClosed
        suspend fun deactivate(
            params: SubAccountDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SubAccountDeactivateResponse>

        /** @see deactivate */
        @MustBeClosed
        suspend fun deactivate(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SubAccountDeactivateResponse> =
            deactivate(id, SubAccountDeactivateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/sub-accounts/{id}/balance`, but is otherwise the
         * same as [SubAccountServiceAsync.getBalance].
         */
        @MustBeClosed
        suspend fun getBalance(
            id: String,
            params: SubAccountGetBalanceParams = SubAccountGetBalanceParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SubAccountGetBalanceResponse> =
            getBalance(params.toBuilder().id(id).build(), requestOptions)

        /** @see getBalance */
        @MustBeClosed
        suspend fun getBalance(
            params: SubAccountGetBalanceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SubAccountGetBalanceResponse>

        /** @see getBalance */
        @MustBeClosed
        suspend fun getBalance(
            id: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SubAccountGetBalanceResponse> =
            getBalance(id, SubAccountGetBalanceParams.none(), requestOptions)
    }
}
