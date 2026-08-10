// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.addresses.AddressCreateParams
import com.zavudev.api.models.addresses.AddressCreateResponse
import com.zavudev.api.models.addresses.AddressDeleteParams
import com.zavudev.api.models.addresses.AddressListPageAsync
import com.zavudev.api.models.addresses.AddressListParams
import com.zavudev.api.models.addresses.AddressRetrieveParams
import com.zavudev.api.models.addresses.AddressRetrieveResponse

interface AddressServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): AddressServiceAsync

    /**
     * Create a regulatory address for phone number purchases. Some countries require a verified
     * address before phone numbers can be activated.
     */
    suspend fun create(
        params: AddressCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AddressCreateResponse

    /** Get a specific regulatory address. */
    suspend fun retrieve(
        addressId: String,
        params: AddressRetrieveParams = AddressRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AddressRetrieveResponse =
        retrieve(params.toBuilder().addressId(addressId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: AddressRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AddressRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(
        addressId: String,
        requestOptions: RequestOptions,
    ): AddressRetrieveResponse = retrieve(addressId, AddressRetrieveParams.none(), requestOptions)

    /** List regulatory addresses for this project. */
    suspend fun list(
        params: AddressListParams = AddressListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AddressListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): AddressListPageAsync =
        list(AddressListParams.none(), requestOptions)

    /** Delete a regulatory address. Cannot delete addresses that are in use. */
    suspend fun delete(
        addressId: String,
        params: AddressDeleteParams = AddressDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().addressId(addressId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: AddressDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(addressId: String, requestOptions: RequestOptions) =
        delete(addressId, AddressDeleteParams.none(), requestOptions)

    /**
     * A view of [AddressServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): AddressServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/addresses`, but is otherwise the same as
         * [AddressServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: AddressCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AddressCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/addresses/{addressId}`, but is otherwise the
         * same as [AddressServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            addressId: String,
            params: AddressRetrieveParams = AddressRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AddressRetrieveResponse> =
            retrieve(params.toBuilder().addressId(addressId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: AddressRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AddressRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            addressId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AddressRetrieveResponse> =
            retrieve(addressId, AddressRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/addresses`, but is otherwise the same as
         * [AddressServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: AddressListParams = AddressListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AddressListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<AddressListPageAsync> =
            list(AddressListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/addresses/{addressId}`, but is otherwise the
         * same as [AddressServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            addressId: String,
            params: AddressDeleteParams = AddressDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().addressId(addressId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: AddressDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(addressId: String, requestOptions: RequestOptions): HttpResponse =
            delete(addressId, AddressDeleteParams.none(), requestOptions)
    }
}
