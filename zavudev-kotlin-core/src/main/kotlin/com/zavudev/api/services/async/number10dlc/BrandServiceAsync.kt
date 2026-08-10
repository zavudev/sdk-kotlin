// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.number10dlc

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.number10dlc.brands.BrandCreateParams
import com.zavudev.api.models.number10dlc.brands.BrandCreateResponse
import com.zavudev.api.models.number10dlc.brands.BrandDeleteParams
import com.zavudev.api.models.number10dlc.brands.BrandListPageAsync
import com.zavudev.api.models.number10dlc.brands.BrandListParams
import com.zavudev.api.models.number10dlc.brands.BrandListUseCasesParams
import com.zavudev.api.models.number10dlc.brands.BrandListUseCasesResponse
import com.zavudev.api.models.number10dlc.brands.BrandRetrieveParams
import com.zavudev.api.models.number10dlc.brands.BrandRetrieveResponse
import com.zavudev.api.models.number10dlc.brands.BrandSubmitParams
import com.zavudev.api.models.number10dlc.brands.BrandSubmitResponse
import com.zavudev.api.models.number10dlc.brands.BrandSyncStatusParams
import com.zavudev.api.models.number10dlc.brands.BrandSyncStatusResponse
import com.zavudev.api.models.number10dlc.brands.BrandUpdateParams
import com.zavudev.api.models.number10dlc.brands.BrandUpdateResponse

interface BrandServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): BrandServiceAsync

    /**
     * Create a 10DLC brand registration. The brand starts in draft status. Submit it for review
     * using the submit endpoint.
     */
    suspend fun create(
        params: BrandCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BrandCreateResponse

    /** Get 10DLC brand */
    suspend fun retrieve(
        brandId: String,
        params: BrandRetrieveParams = BrandRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BrandRetrieveResponse = retrieve(params.toBuilder().brandId(brandId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: BrandRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BrandRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(brandId: String, requestOptions: RequestOptions): BrandRetrieveResponse =
        retrieve(brandId, BrandRetrieveParams.none(), requestOptions)

    /** Update a 10DLC brand in draft status. Cannot update after submission. */
    suspend fun update(
        brandId: String,
        params: BrandUpdateParams = BrandUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BrandUpdateResponse = update(params.toBuilder().brandId(brandId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: BrandUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BrandUpdateResponse

    /** @see update */
    suspend fun update(brandId: String, requestOptions: RequestOptions): BrandUpdateResponse =
        update(brandId, BrandUpdateParams.none(), requestOptions)

    /** List 10DLC brand registrations for this project. */
    suspend fun list(
        params: BrandListParams = BrandListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BrandListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): BrandListPageAsync =
        list(BrandListParams.none(), requestOptions)

    /** Delete 10DLC brand */
    suspend fun delete(
        brandId: String,
        params: BrandDeleteParams = BrandDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().brandId(brandId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: BrandDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(brandId: String, requestOptions: RequestOptions) =
        delete(brandId, BrandDeleteParams.none(), requestOptions)

    /** List available use cases for 10DLC campaign registration. */
    suspend fun listUseCases(
        params: BrandListUseCasesParams = BrandListUseCasesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BrandListUseCasesResponse

    /** @see listUseCases */
    suspend fun listUseCases(requestOptions: RequestOptions): BrandListUseCasesResponse =
        listUseCases(BrandListUseCasesParams.none(), requestOptions)

    /**
     * Submit a draft brand to The Campaign Registry (TCR) for vetting. The brand must be in draft
     * status. TCR's one-time $4 brand registration fee is charged from your balance at submission
     * (passed through at cost) and refunded if the carrier rejects the registration. A team that
     * already paid this fee through the compliance flow is not charged again. Campaign registration
     * is billed separately when a campaign is submitted.
     */
    suspend fun submit(
        brandId: String,
        params: BrandSubmitParams = BrandSubmitParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BrandSubmitResponse = submit(params.toBuilder().brandId(brandId).build(), requestOptions)

    /** @see submit */
    suspend fun submit(
        params: BrandSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BrandSubmitResponse

    /** @see submit */
    suspend fun submit(brandId: String, requestOptions: RequestOptions): BrandSubmitResponse =
        submit(brandId, BrandSubmitParams.none(), requestOptions)

    /**
     * Sync the brand status with the registration provider. Use this to check for approval updates
     * after submission.
     */
    suspend fun syncStatus(
        brandId: String,
        params: BrandSyncStatusParams = BrandSyncStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BrandSyncStatusResponse =
        syncStatus(params.toBuilder().brandId(brandId).build(), requestOptions)

    /** @see syncStatus */
    suspend fun syncStatus(
        params: BrandSyncStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BrandSyncStatusResponse

    /** @see syncStatus */
    suspend fun syncStatus(
        brandId: String,
        requestOptions: RequestOptions,
    ): BrandSyncStatusResponse = syncStatus(brandId, BrandSyncStatusParams.none(), requestOptions)

    /** A view of [BrandServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): BrandServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/10dlc/brands`, but is otherwise the same as
         * [BrandServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: BrandCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BrandCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/10dlc/brands/{brandId}`, but is otherwise the
         * same as [BrandServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            brandId: String,
            params: BrandRetrieveParams = BrandRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BrandRetrieveResponse> =
            retrieve(params.toBuilder().brandId(brandId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: BrandRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BrandRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            brandId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BrandRetrieveResponse> =
            retrieve(brandId, BrandRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/10dlc/brands/{brandId}`, but is otherwise the
         * same as [BrandServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            brandId: String,
            params: BrandUpdateParams = BrandUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BrandUpdateResponse> =
            update(params.toBuilder().brandId(brandId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: BrandUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BrandUpdateResponse>

        /** @see update */
        @MustBeClosed
        suspend fun update(
            brandId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BrandUpdateResponse> =
            update(brandId, BrandUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/10dlc/brands`, but is otherwise the same as
         * [BrandServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: BrandListParams = BrandListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BrandListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<BrandListPageAsync> =
            list(BrandListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/10dlc/brands/{brandId}`, but is otherwise the
         * same as [BrandServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            brandId: String,
            params: BrandDeleteParams = BrandDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().brandId(brandId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: BrandDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(brandId: String, requestOptions: RequestOptions): HttpResponse =
            delete(brandId, BrandDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/10dlc/brands/use-cases`, but is otherwise the
         * same as [BrandServiceAsync.listUseCases].
         */
        @MustBeClosed
        suspend fun listUseCases(
            params: BrandListUseCasesParams = BrandListUseCasesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BrandListUseCasesResponse>

        /** @see listUseCases */
        @MustBeClosed
        suspend fun listUseCases(
            requestOptions: RequestOptions
        ): HttpResponseFor<BrandListUseCasesResponse> =
            listUseCases(BrandListUseCasesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/10dlc/brands/{brandId}/submit`, but is
         * otherwise the same as [BrandServiceAsync.submit].
         */
        @MustBeClosed
        suspend fun submit(
            brandId: String,
            params: BrandSubmitParams = BrandSubmitParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BrandSubmitResponse> =
            submit(params.toBuilder().brandId(brandId).build(), requestOptions)

        /** @see submit */
        @MustBeClosed
        suspend fun submit(
            params: BrandSubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BrandSubmitResponse>

        /** @see submit */
        @MustBeClosed
        suspend fun submit(
            brandId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BrandSubmitResponse> =
            submit(brandId, BrandSubmitParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/10dlc/brands/{brandId}/sync`, but is otherwise
         * the same as [BrandServiceAsync.syncStatus].
         */
        @MustBeClosed
        suspend fun syncStatus(
            brandId: String,
            params: BrandSyncStatusParams = BrandSyncStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BrandSyncStatusResponse> =
            syncStatus(params.toBuilder().brandId(brandId).build(), requestOptions)

        /** @see syncStatus */
        @MustBeClosed
        suspend fun syncStatus(
            params: BrandSyncStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BrandSyncStatusResponse>

        /** @see syncStatus */
        @MustBeClosed
        suspend fun syncStatus(
            brandId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BrandSyncStatusResponse> =
            syncStatus(brandId, BrandSyncStatusParams.none(), requestOptions)
    }
}
