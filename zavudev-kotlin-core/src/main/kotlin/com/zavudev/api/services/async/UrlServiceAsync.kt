// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.urls.UrlEscalateParams
import com.zavudev.api.models.urls.UrlEscalateResponse
import com.zavudev.api.models.urls.UrlListVerifiedPageAsync
import com.zavudev.api.models.urls.UrlListVerifiedParams
import com.zavudev.api.models.urls.UrlRetrieveDetailsParams
import com.zavudev.api.models.urls.UrlRetrieveDetailsResponse
import com.zavudev.api.models.urls.UrlSubmitForVerificationParams
import com.zavudev.api.models.urls.UrlSubmitForVerificationResponse

interface UrlServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): UrlServiceAsync

    /**
     * Request manual review of a rejected URL. Only URLs in 'rejected' status can be escalated; the
     * status then moves to 'escalated'.
     */
    suspend fun escalate(
        urlId: String,
        params: UrlEscalateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UrlEscalateResponse = escalate(params.toBuilder().urlId(urlId).build(), requestOptions)

    /** @see escalate */
    suspend fun escalate(
        params: UrlEscalateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UrlEscalateResponse

    /** List URLs that have been verified for this project. */
    suspend fun listVerified(
        params: UrlListVerifiedParams = UrlListVerifiedParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UrlListVerifiedPageAsync

    /** @see listVerified */
    suspend fun listVerified(requestOptions: RequestOptions): UrlListVerifiedPageAsync =
        listVerified(UrlListVerifiedParams.none(), requestOptions)

    /** Get details of a specific verified URL. */
    suspend fun retrieveDetails(
        urlId: String,
        params: UrlRetrieveDetailsParams = UrlRetrieveDetailsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UrlRetrieveDetailsResponse =
        retrieveDetails(params.toBuilder().urlId(urlId).build(), requestOptions)

    /** @see retrieveDetails */
    suspend fun retrieveDetails(
        params: UrlRetrieveDetailsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UrlRetrieveDetailsResponse

    /** @see retrieveDetails */
    suspend fun retrieveDetails(
        urlId: String,
        requestOptions: RequestOptions,
    ): UrlRetrieveDetailsResponse =
        retrieveDetails(urlId, UrlRetrieveDetailsParams.none(), requestOptions)

    /**
     * Submit a URL for verification. URLs are automatically checked against Google Web Risk API.
     * Safe URLs are auto-approved, malicious URLs are blocked. URL shorteners (bit.ly, t.co, etc.)
     * are always blocked.
     *
     * **Important:** All SMS and Email messages containing URLs require those URLs to be verified
     * before the message can be sent. This endpoint allows pre-verification of URLs.
     */
    suspend fun submitForVerification(
        params: UrlSubmitForVerificationParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UrlSubmitForVerificationResponse

    /** A view of [UrlServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): UrlServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/urls/{urlId}/escalate`, but is otherwise the
         * same as [UrlServiceAsync.escalate].
         */
        @MustBeClosed
        suspend fun escalate(
            urlId: String,
            params: UrlEscalateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UrlEscalateResponse> =
            escalate(params.toBuilder().urlId(urlId).build(), requestOptions)

        /** @see escalate */
        @MustBeClosed
        suspend fun escalate(
            params: UrlEscalateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UrlEscalateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/urls`, but is otherwise the same as
         * [UrlServiceAsync.listVerified].
         */
        @MustBeClosed
        suspend fun listVerified(
            params: UrlListVerifiedParams = UrlListVerifiedParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UrlListVerifiedPageAsync>

        /** @see listVerified */
        @MustBeClosed
        suspend fun listVerified(
            requestOptions: RequestOptions
        ): HttpResponseFor<UrlListVerifiedPageAsync> =
            listVerified(UrlListVerifiedParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/urls/{urlId}`, but is otherwise the same as
         * [UrlServiceAsync.retrieveDetails].
         */
        @MustBeClosed
        suspend fun retrieveDetails(
            urlId: String,
            params: UrlRetrieveDetailsParams = UrlRetrieveDetailsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UrlRetrieveDetailsResponse> =
            retrieveDetails(params.toBuilder().urlId(urlId).build(), requestOptions)

        /** @see retrieveDetails */
        @MustBeClosed
        suspend fun retrieveDetails(
            params: UrlRetrieveDetailsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UrlRetrieveDetailsResponse>

        /** @see retrieveDetails */
        @MustBeClosed
        suspend fun retrieveDetails(
            urlId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UrlRetrieveDetailsResponse> =
            retrieveDetails(urlId, UrlRetrieveDetailsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/urls`, but is otherwise the same as
         * [UrlServiceAsync.submitForVerification].
         */
        @MustBeClosed
        suspend fun submitForVerification(
            params: UrlSubmitForVerificationParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UrlSubmitForVerificationResponse>
    }
}
