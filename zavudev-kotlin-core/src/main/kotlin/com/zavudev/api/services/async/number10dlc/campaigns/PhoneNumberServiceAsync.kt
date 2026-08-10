// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.number10dlc.campaigns

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.number10dlc.campaigns.phonenumbers.PhoneNumberAssignParams
import com.zavudev.api.models.number10dlc.campaigns.phonenumbers.PhoneNumberAssignResponse
import com.zavudev.api.models.number10dlc.campaigns.phonenumbers.PhoneNumberListParams
import com.zavudev.api.models.number10dlc.campaigns.phonenumbers.PhoneNumberListResponse
import com.zavudev.api.models.number10dlc.campaigns.phonenumbers.PhoneNumberUnassignParams

interface PhoneNumberServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): PhoneNumberServiceAsync

    /** List phone numbers assigned to a 10DLC campaign. */
    suspend fun list(
        campaignId: String,
        params: PhoneNumberListParams = PhoneNumberListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PhoneNumberListResponse =
        list(params.toBuilder().campaignId(campaignId).build(), requestOptions)

    /** @see list */
    suspend fun list(
        params: PhoneNumberListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PhoneNumberListResponse

    /** @see list */
    suspend fun list(campaignId: String, requestOptions: RequestOptions): PhoneNumberListResponse =
        list(campaignId, PhoneNumberListParams.none(), requestOptions)

    /**
     * Assign a US phone number to an approved 10DLC campaign. The campaign must be in approved
     * status.
     */
    suspend fun assign(
        campaignId: String,
        params: PhoneNumberAssignParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PhoneNumberAssignResponse =
        assign(params.toBuilder().campaignId(campaignId).build(), requestOptions)

    /** @see assign */
    suspend fun assign(
        params: PhoneNumberAssignParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PhoneNumberAssignResponse

    /** Remove a phone number assignment from a 10DLC campaign. */
    suspend fun unassign(
        assignmentId: String,
        params: PhoneNumberUnassignParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = unassign(params.toBuilder().assignmentId(assignmentId).build(), requestOptions)

    /** @see unassign */
    suspend fun unassign(
        params: PhoneNumberUnassignParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /**
     * A view of [PhoneNumberServiceAsync] that provides access to raw HTTP responses for each
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
        ): PhoneNumberServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/10dlc/campaigns/{campaignId}/phone-numbers`, but
         * is otherwise the same as [PhoneNumberServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            campaignId: String,
            params: PhoneNumberListParams = PhoneNumberListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PhoneNumberListResponse> =
            list(params.toBuilder().campaignId(campaignId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        suspend fun list(
            params: PhoneNumberListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PhoneNumberListResponse>

        /** @see list */
        @MustBeClosed
        suspend fun list(
            campaignId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PhoneNumberListResponse> =
            list(campaignId, PhoneNumberListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/10dlc/campaigns/{campaignId}/phone-numbers`,
         * but is otherwise the same as [PhoneNumberServiceAsync.assign].
         */
        @MustBeClosed
        suspend fun assign(
            campaignId: String,
            params: PhoneNumberAssignParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PhoneNumberAssignResponse> =
            assign(params.toBuilder().campaignId(campaignId).build(), requestOptions)

        /** @see assign */
        @MustBeClosed
        suspend fun assign(
            params: PhoneNumberAssignParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PhoneNumberAssignResponse>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/10dlc/campaigns/{campaignId}/phone-numbers/{assignmentId}`, but is otherwise the same
         * as [PhoneNumberServiceAsync.unassign].
         */
        @MustBeClosed
        suspend fun unassign(
            assignmentId: String,
            params: PhoneNumberUnassignParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse =
            unassign(params.toBuilder().assignmentId(assignmentId).build(), requestOptions)

        /** @see unassign */
        @MustBeClosed
        suspend fun unassign(
            params: PhoneNumberUnassignParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
