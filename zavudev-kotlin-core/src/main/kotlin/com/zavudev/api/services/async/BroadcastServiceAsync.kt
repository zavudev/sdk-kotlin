// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.broadcasts.BroadcastCancelParams
import com.zavudev.api.models.broadcasts.BroadcastCancelResponse
import com.zavudev.api.models.broadcasts.BroadcastCreateParams
import com.zavudev.api.models.broadcasts.BroadcastCreateResponse
import com.zavudev.api.models.broadcasts.BroadcastDeleteParams
import com.zavudev.api.models.broadcasts.BroadcastEscalateReviewParams
import com.zavudev.api.models.broadcasts.BroadcastEscalateReviewResponse
import com.zavudev.api.models.broadcasts.BroadcastListPageAsync
import com.zavudev.api.models.broadcasts.BroadcastListParams
import com.zavudev.api.models.broadcasts.BroadcastProgress
import com.zavudev.api.models.broadcasts.BroadcastProgressParams
import com.zavudev.api.models.broadcasts.BroadcastRescheduleParams
import com.zavudev.api.models.broadcasts.BroadcastRescheduleResponse
import com.zavudev.api.models.broadcasts.BroadcastRetrieveParams
import com.zavudev.api.models.broadcasts.BroadcastRetrieveResponse
import com.zavudev.api.models.broadcasts.BroadcastRetryReviewParams
import com.zavudev.api.models.broadcasts.BroadcastRetryReviewResponse
import com.zavudev.api.models.broadcasts.BroadcastSendParams
import com.zavudev.api.models.broadcasts.BroadcastSendResponse
import com.zavudev.api.models.broadcasts.BroadcastUpdateParams
import com.zavudev.api.models.broadcasts.BroadcastUpdateResponse
import com.zavudev.api.services.async.broadcasts.ContactServiceAsync

interface BroadcastServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): BroadcastServiceAsync

    fun contacts(): ContactServiceAsync

    /** Create a new broadcast campaign. Add contacts after creation, then send. */
    suspend fun create(
        params: BroadcastCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastCreateResponse

    /** Get broadcast */
    suspend fun retrieve(
        broadcastId: String,
        params: BroadcastRetrieveParams = BroadcastRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastRetrieveResponse =
        retrieve(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: BroadcastRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(
        broadcastId: String,
        requestOptions: RequestOptions,
    ): BroadcastRetrieveResponse =
        retrieve(broadcastId, BroadcastRetrieveParams.none(), requestOptions)

    /** Update a broadcast in draft status. */
    suspend fun update(
        broadcastId: String,
        params: BroadcastUpdateParams = BroadcastUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastUpdateResponse =
        update(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: BroadcastUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastUpdateResponse

    /** @see update */
    suspend fun update(
        broadcastId: String,
        requestOptions: RequestOptions,
    ): BroadcastUpdateResponse = update(broadcastId, BroadcastUpdateParams.none(), requestOptions)

    /** List broadcasts for this project. */
    suspend fun list(
        params: BroadcastListParams = BroadcastListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): BroadcastListPageAsync =
        list(BroadcastListParams.none(), requestOptions)

    /** Delete a broadcast in draft status. */
    suspend fun delete(
        broadcastId: String,
        params: BroadcastDeleteParams = BroadcastDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: BroadcastDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(broadcastId: String, requestOptions: RequestOptions) =
        delete(broadcastId, BroadcastDeleteParams.none(), requestOptions)

    /**
     * Cancel a broadcast. Pending contacts will be skipped, but already queued messages may still
     * be delivered.
     */
    suspend fun cancel(
        broadcastId: String,
        params: BroadcastCancelParams = BroadcastCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastCancelResponse =
        cancel(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

    /** @see cancel */
    suspend fun cancel(
        params: BroadcastCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastCancelResponse

    /** @see cancel */
    suspend fun cancel(
        broadcastId: String,
        requestOptions: RequestOptions,
    ): BroadcastCancelResponse = cancel(broadcastId, BroadcastCancelParams.none(), requestOptions)

    /**
     * Request manual review by the Zavu team for a rejected broadcast. Use this after automated
     * review rejection if you believe the content is legitimate.
     */
    suspend fun escalateReview(
        broadcastId: String,
        params: BroadcastEscalateReviewParams = BroadcastEscalateReviewParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastEscalateReviewResponse =
        escalateReview(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

    /** @see escalateReview */
    suspend fun escalateReview(
        params: BroadcastEscalateReviewParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastEscalateReviewResponse

    /** @see escalateReview */
    suspend fun escalateReview(
        broadcastId: String,
        requestOptions: RequestOptions,
    ): BroadcastEscalateReviewResponse =
        escalateReview(broadcastId, BroadcastEscalateReviewParams.none(), requestOptions)

    /**
     * Get real-time progress of a broadcast including delivery counts and estimated completion
     * time.
     */
    suspend fun progress(
        broadcastId: String,
        params: BroadcastProgressParams = BroadcastProgressParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastProgress =
        progress(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

    /** @see progress */
    suspend fun progress(
        params: BroadcastProgressParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastProgress

    /** @see progress */
    suspend fun progress(broadcastId: String, requestOptions: RequestOptions): BroadcastProgress =
        progress(broadcastId, BroadcastProgressParams.none(), requestOptions)

    /** Update the scheduled time for a broadcast. The broadcast must be in scheduled status. */
    suspend fun reschedule(
        broadcastId: String,
        params: BroadcastRescheduleParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastRescheduleResponse =
        reschedule(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

    /** @see reschedule */
    suspend fun reschedule(
        params: BroadcastRescheduleParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastRescheduleResponse

    /**
     * Resubmit a rejected broadcast for AI review after editing content. Maximum 3 review attempts
     * allowed per broadcast.
     */
    suspend fun retryReview(
        broadcastId: String,
        params: BroadcastRetryReviewParams = BroadcastRetryReviewParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastRetryReviewResponse =
        retryReview(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

    /** @see retryReview */
    suspend fun retryReview(
        params: BroadcastRetryReviewParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastRetryReviewResponse

    /** @see retryReview */
    suspend fun retryReview(
        broadcastId: String,
        requestOptions: RequestOptions,
    ): BroadcastRetryReviewResponse =
        retryReview(broadcastId, BroadcastRetryReviewParams.none(), requestOptions)

    /**
     * Start sending the broadcast immediately or schedule for later.
     *
     * **The account must be past the unverified level to send, except on WhatsApp.** An account
     * that has verified nothing is refused with `403` and code `kyc_required` on every channel
     * other than `whatsapp`. Any one of these lifts it: identity verification (KYC), a saved
     * payment method, a settled deposit, or a paid plan. Business verification (KYB) is not
     * required to broadcast; it gates 10DLC registration only. A `whatsapp` broadcast is exempt: it
     * can only be built on a template, and Meta vets the business and the content when it approves
     * that template, so an unapproved template is refused instead. `smart` is not exempt, since it
     * can route a contact to SMS or email. Drafts can be created, edited and kept without any
     * check. Every send path (dashboard, API and CLI) enforces the same rule.
     *
     * **Daily ceilings apply per recipient.** Each message a broadcast sends counts against the
     * channel's daily ceiling (see `POST /v1/messages`). Once the ceiling is reached, the remaining
     * recipients are marked `failed` with `errorCode` `DAILY_LIMIT_EXCEEDED`; they are not retried
     * the next day.
     *
     * **Review depends on the channel, and cannot be bypassed.** A draft is submitted to automated
     * content review here; it does not go straight out. A WhatsApp broadcast built on a
     * Meta-approved template skips review (Meta already vetted the content) and begins sending. An
     * email broadcast sends as soon as the automated review passes. Every other channel moves to
     * `pending_admin_review` and waits for a person. If the review rejects it, use PATCH to edit
     * the content then call POST /retry-review.
     *
     * Calling this on a broadcast that is already `approved` or `scheduled` sends or reschedules it
     * directly, since it has already been reviewed. Reserves the estimated cost from your balance.
     */
    suspend fun send(
        broadcastId: String,
        params: BroadcastSendParams = BroadcastSendParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastSendResponse =
        send(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

    /** @see send */
    suspend fun send(
        params: BroadcastSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BroadcastSendResponse

    /** @see send */
    suspend fun send(broadcastId: String, requestOptions: RequestOptions): BroadcastSendResponse =
        send(broadcastId, BroadcastSendParams.none(), requestOptions)

    /**
     * A view of [BroadcastServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): BroadcastServiceAsync.WithRawResponse

        fun contacts(): ContactServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/broadcasts`, but is otherwise the same as
         * [BroadcastServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: BroadcastCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/broadcasts/{broadcastId}`, but is otherwise the
         * same as [BroadcastServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            broadcastId: String,
            params: BroadcastRetrieveParams = BroadcastRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastRetrieveResponse> =
            retrieve(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: BroadcastRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            broadcastId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BroadcastRetrieveResponse> =
            retrieve(broadcastId, BroadcastRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/broadcasts/{broadcastId}`, but is otherwise
         * the same as [BroadcastServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            broadcastId: String,
            params: BroadcastUpdateParams = BroadcastUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastUpdateResponse> =
            update(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: BroadcastUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastUpdateResponse>

        /** @see update */
        @MustBeClosed
        suspend fun update(
            broadcastId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BroadcastUpdateResponse> =
            update(broadcastId, BroadcastUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/broadcasts`, but is otherwise the same as
         * [BroadcastServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: BroadcastListParams = BroadcastListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<BroadcastListPageAsync> =
            list(BroadcastListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/broadcasts/{broadcastId}`, but is otherwise
         * the same as [BroadcastServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            broadcastId: String,
            params: BroadcastDeleteParams = BroadcastDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse =
            delete(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: BroadcastDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(broadcastId: String, requestOptions: RequestOptions): HttpResponse =
            delete(broadcastId, BroadcastDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/broadcasts/{broadcastId}/cancel`, but is
         * otherwise the same as [BroadcastServiceAsync.cancel].
         */
        @MustBeClosed
        suspend fun cancel(
            broadcastId: String,
            params: BroadcastCancelParams = BroadcastCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastCancelResponse> =
            cancel(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

        /** @see cancel */
        @MustBeClosed
        suspend fun cancel(
            params: BroadcastCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastCancelResponse>

        /** @see cancel */
        @MustBeClosed
        suspend fun cancel(
            broadcastId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BroadcastCancelResponse> =
            cancel(broadcastId, BroadcastCancelParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/broadcasts/{broadcastId}/escalate`, but is
         * otherwise the same as [BroadcastServiceAsync.escalateReview].
         */
        @MustBeClosed
        suspend fun escalateReview(
            broadcastId: String,
            params: BroadcastEscalateReviewParams = BroadcastEscalateReviewParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastEscalateReviewResponse> =
            escalateReview(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

        /** @see escalateReview */
        @MustBeClosed
        suspend fun escalateReview(
            params: BroadcastEscalateReviewParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastEscalateReviewResponse>

        /** @see escalateReview */
        @MustBeClosed
        suspend fun escalateReview(
            broadcastId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BroadcastEscalateReviewResponse> =
            escalateReview(broadcastId, BroadcastEscalateReviewParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/broadcasts/{broadcastId}/progress`, but is
         * otherwise the same as [BroadcastServiceAsync.progress].
         */
        @MustBeClosed
        suspend fun progress(
            broadcastId: String,
            params: BroadcastProgressParams = BroadcastProgressParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastProgress> =
            progress(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

        /** @see progress */
        @MustBeClosed
        suspend fun progress(
            params: BroadcastProgressParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastProgress>

        /** @see progress */
        @MustBeClosed
        suspend fun progress(
            broadcastId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BroadcastProgress> =
            progress(broadcastId, BroadcastProgressParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/broadcasts/{broadcastId}/schedule`, but is
         * otherwise the same as [BroadcastServiceAsync.reschedule].
         */
        @MustBeClosed
        suspend fun reschedule(
            broadcastId: String,
            params: BroadcastRescheduleParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastRescheduleResponse> =
            reschedule(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

        /** @see reschedule */
        @MustBeClosed
        suspend fun reschedule(
            params: BroadcastRescheduleParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastRescheduleResponse>

        /**
         * Returns a raw HTTP response for `post /v1/broadcasts/{broadcastId}/retry-review`, but is
         * otherwise the same as [BroadcastServiceAsync.retryReview].
         */
        @MustBeClosed
        suspend fun retryReview(
            broadcastId: String,
            params: BroadcastRetryReviewParams = BroadcastRetryReviewParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastRetryReviewResponse> =
            retryReview(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

        /** @see retryReview */
        @MustBeClosed
        suspend fun retryReview(
            params: BroadcastRetryReviewParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastRetryReviewResponse>

        /** @see retryReview */
        @MustBeClosed
        suspend fun retryReview(
            broadcastId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BroadcastRetryReviewResponse> =
            retryReview(broadcastId, BroadcastRetryReviewParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/broadcasts/{broadcastId}/send`, but is
         * otherwise the same as [BroadcastServiceAsync.send].
         */
        @MustBeClosed
        suspend fun send(
            broadcastId: String,
            params: BroadcastSendParams = BroadcastSendParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastSendResponse> =
            send(params.toBuilder().broadcastId(broadcastId).build(), requestOptions)

        /** @see send */
        @MustBeClosed
        suspend fun send(
            params: BroadcastSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BroadcastSendResponse>

        /** @see send */
        @MustBeClosed
        suspend fun send(
            broadcastId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BroadcastSendResponse> =
            send(broadcastId, BroadcastSendParams.none(), requestOptions)
    }
}
