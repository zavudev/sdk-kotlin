// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.number10dlc

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.number10dlc.campaigns.CampaignCreateParams
import com.zavudev.api.models.number10dlc.campaigns.CampaignCreateResponse
import com.zavudev.api.models.number10dlc.campaigns.CampaignDeleteParams
import com.zavudev.api.models.number10dlc.campaigns.CampaignListPageAsync
import com.zavudev.api.models.number10dlc.campaigns.CampaignListParams
import com.zavudev.api.models.number10dlc.campaigns.CampaignRetrieveParams
import com.zavudev.api.models.number10dlc.campaigns.CampaignRetrieveResponse
import com.zavudev.api.models.number10dlc.campaigns.CampaignSubmitParams
import com.zavudev.api.models.number10dlc.campaigns.CampaignSubmitResponse
import com.zavudev.api.models.number10dlc.campaigns.CampaignSyncStatusParams
import com.zavudev.api.models.number10dlc.campaigns.CampaignSyncStatusResponse
import com.zavudev.api.models.number10dlc.campaigns.CampaignUpdateParams
import com.zavudev.api.models.number10dlc.campaigns.CampaignUpdateResponse
import com.zavudev.api.services.async.number10dlc.campaigns.PhoneNumberServiceAsync

interface CampaignServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): CampaignServiceAsync

    fun phoneNumbers(): PhoneNumberServiceAsync

    /**
     * Create a 10DLC campaign under an existing brand. The campaign starts in draft status. Submit
     * it for carrier review using the submit endpoint.
     */
    suspend fun create(
        params: CampaignCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CampaignCreateResponse

    /** Get 10DLC campaign */
    suspend fun retrieve(
        campaignId: String,
        params: CampaignRetrieveParams = CampaignRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CampaignRetrieveResponse =
        retrieve(params.toBuilder().campaignId(campaignId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: CampaignRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CampaignRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(
        campaignId: String,
        requestOptions: RequestOptions,
    ): CampaignRetrieveResponse =
        retrieve(campaignId, CampaignRetrieveParams.none(), requestOptions)

    /** Update a 10DLC campaign in draft status. Cannot update after submission. */
    suspend fun update(
        campaignId: String,
        params: CampaignUpdateParams = CampaignUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CampaignUpdateResponse =
        update(params.toBuilder().campaignId(campaignId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: CampaignUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CampaignUpdateResponse

    /** @see update */
    suspend fun update(campaignId: String, requestOptions: RequestOptions): CampaignUpdateResponse =
        update(campaignId, CampaignUpdateParams.none(), requestOptions)

    /** List 10DLC campaign registrations for this project. */
    suspend fun list(
        params: CampaignListParams = CampaignListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CampaignListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): CampaignListPageAsync =
        list(CampaignListParams.none(), requestOptions)

    /** Delete 10DLC campaign */
    suspend fun delete(
        campaignId: String,
        params: CampaignDeleteParams = CampaignDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().campaignId(campaignId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: CampaignDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(campaignId: String, requestOptions: RequestOptions) =
        delete(campaignId, CampaignDeleteParams.none(), requestOptions)

    /**
     * Submit a draft campaign for carrier review. The campaign must be in draft status and its
     * brand must be verified. TCR's one-time registration fee is charged from your balance at
     * submission ($15 for standard use cases, $2 for LOW_VOLUME), passed through at cost and
     * refunded if the carrier rejects it. Once approved, the campaign's monthly TCR fee ($10
     * standard, $2 LOW_VOLUME) is charged from your balance while the campaign is active — see
     * registrationCostCents and monthlyFeeCents on the campaign object.
     */
    suspend fun submit(
        campaignId: String,
        params: CampaignSubmitParams = CampaignSubmitParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CampaignSubmitResponse =
        submit(params.toBuilder().campaignId(campaignId).build(), requestOptions)

    /** @see submit */
    suspend fun submit(
        params: CampaignSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CampaignSubmitResponse

    /** @see submit */
    suspend fun submit(campaignId: String, requestOptions: RequestOptions): CampaignSubmitResponse =
        submit(campaignId, CampaignSubmitParams.none(), requestOptions)

    /**
     * Sync the campaign status with the registration provider. Use this to check for approval
     * updates after submission.
     */
    suspend fun syncStatus(
        campaignId: String,
        params: CampaignSyncStatusParams = CampaignSyncStatusParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CampaignSyncStatusResponse =
        syncStatus(params.toBuilder().campaignId(campaignId).build(), requestOptions)

    /** @see syncStatus */
    suspend fun syncStatus(
        params: CampaignSyncStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CampaignSyncStatusResponse

    /** @see syncStatus */
    suspend fun syncStatus(
        campaignId: String,
        requestOptions: RequestOptions,
    ): CampaignSyncStatusResponse =
        syncStatus(campaignId, CampaignSyncStatusParams.none(), requestOptions)

    /**
     * A view of [CampaignServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): CampaignServiceAsync.WithRawResponse

        fun phoneNumbers(): PhoneNumberServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/10dlc/campaigns`, but is otherwise the same as
         * [CampaignServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: CampaignCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CampaignCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/10dlc/campaigns/{campaignId}`, but is otherwise
         * the same as [CampaignServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            campaignId: String,
            params: CampaignRetrieveParams = CampaignRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CampaignRetrieveResponse> =
            retrieve(params.toBuilder().campaignId(campaignId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: CampaignRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CampaignRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            campaignId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CampaignRetrieveResponse> =
            retrieve(campaignId, CampaignRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/10dlc/campaigns/{campaignId}`, but is
         * otherwise the same as [CampaignServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            campaignId: String,
            params: CampaignUpdateParams = CampaignUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CampaignUpdateResponse> =
            update(params.toBuilder().campaignId(campaignId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: CampaignUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CampaignUpdateResponse>

        /** @see update */
        @MustBeClosed
        suspend fun update(
            campaignId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CampaignUpdateResponse> =
            update(campaignId, CampaignUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/10dlc/campaigns`, but is otherwise the same as
         * [CampaignServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: CampaignListParams = CampaignListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CampaignListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<CampaignListPageAsync> =
            list(CampaignListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/10dlc/campaigns/{campaignId}`, but is
         * otherwise the same as [CampaignServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            campaignId: String,
            params: CampaignDeleteParams = CampaignDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().campaignId(campaignId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: CampaignDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(campaignId: String, requestOptions: RequestOptions): HttpResponse =
            delete(campaignId, CampaignDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/10dlc/campaigns/{campaignId}/submit`, but is
         * otherwise the same as [CampaignServiceAsync.submit].
         */
        @MustBeClosed
        suspend fun submit(
            campaignId: String,
            params: CampaignSubmitParams = CampaignSubmitParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CampaignSubmitResponse> =
            submit(params.toBuilder().campaignId(campaignId).build(), requestOptions)

        /** @see submit */
        @MustBeClosed
        suspend fun submit(
            params: CampaignSubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CampaignSubmitResponse>

        /** @see submit */
        @MustBeClosed
        suspend fun submit(
            campaignId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CampaignSubmitResponse> =
            submit(campaignId, CampaignSubmitParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/10dlc/campaigns/{campaignId}/sync`, but is
         * otherwise the same as [CampaignServiceAsync.syncStatus].
         */
        @MustBeClosed
        suspend fun syncStatus(
            campaignId: String,
            params: CampaignSyncStatusParams = CampaignSyncStatusParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CampaignSyncStatusResponse> =
            syncStatus(params.toBuilder().campaignId(campaignId).build(), requestOptions)

        /** @see syncStatus */
        @MustBeClosed
        suspend fun syncStatus(
            params: CampaignSyncStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CampaignSyncStatusResponse>

        /** @see syncStatus */
        @MustBeClosed
        suspend fun syncStatus(
            campaignId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CampaignSyncStatusResponse> =
            syncStatus(campaignId, CampaignSyncStatusParams.none(), requestOptions)
    }
}
