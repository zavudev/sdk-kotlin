// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.calls.CallCreateParams
import com.zavudev.api.models.calls.CallCreateResponse
import com.zavudev.api.models.calls.CallHangupParams
import com.zavudev.api.models.calls.CallHangupResponse
import com.zavudev.api.models.calls.CallListPageAsync
import com.zavudev.api.models.calls.CallListParams
import com.zavudev.api.models.calls.CallRetrieveParams
import com.zavudev.api.models.calls.CallRetrieveResponse

interface CallServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): CallServiceAsync

    /**
     * Place an outbound voice call answered by the voice agent configured on the sender. Zavu dials
     * the recipient and runs the conversation through its managed voice pipeline (speech
     * recognition, the agent's LLM, and speech synthesis, with real-time interruption handling).
     *
     * **Requirements:**
     * - The Voice Agents feature must be enabled for your team (otherwise `403`).
     * - An account that has verified nothing may only call the phone numbers the project has
     *   verified (`403` with code `destination_not_verified`, and `details.verifiedNumbers` lists
     *   them), and at most 5 calls a day (`429` with code `daily_limit_exceeded`). A number is
     *   verified from the dashboard's Sandbox screen by sending the pre-filled WhatsApp message
     *   from that phone; the same verification covers SMS and calls. Verify your identity, add a
     *   payment method, settle a deposit or subscribe to call any destination. That raises the
     *   ceiling to 50 calls a day on Free; paid plans have no daily call ceiling. Full reference:
     *   https://docs.zavu.dev/concepts/sending-limits
     * - The sender's agent must have `voice.enabled` set to `true`.
     * - Not available with test-mode API keys.
     *
     * **Billing:** Voice calls are billed per minute of connected time plus telephony, deducted
     * from your prepaid balance. A short-duration estimate is reserved when the call is placed; you
     * are charged for the actual duration when the call ends.
     */
    suspend fun create(
        params: CallCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CallCreateResponse

    /**
     * Retrieve a single voice call, including its full transcript once the conversation has
     * produced turns.
     */
    suspend fun retrieve(
        callId: String,
        params: CallRetrieveParams = CallRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CallRetrieveResponse = retrieve(params.toBuilder().callId(callId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: CallRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CallRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(callId: String, requestOptions: RequestOptions): CallRetrieveResponse =
        retrieve(callId, CallRetrieveParams.none(), requestOptions)

    /**
     * List voice calls for this project, most recent first. Transcripts are omitted from the list;
     * fetch a single call to get its transcript.
     */
    suspend fun list(
        params: CallListParams = CallListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CallListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): CallListPageAsync =
        list(CallListParams.none(), requestOptions)

    /**
     * End an active voice call. The call must still be ringing or in progress. Not available with
     * test-mode API keys.
     */
    suspend fun hangup(
        callId: String,
        params: CallHangupParams = CallHangupParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CallHangupResponse = hangup(params.toBuilder().callId(callId).build(), requestOptions)

    /** @see hangup */
    suspend fun hangup(
        params: CallHangupParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CallHangupResponse

    /** @see hangup */
    suspend fun hangup(callId: String, requestOptions: RequestOptions): CallHangupResponse =
        hangup(callId, CallHangupParams.none(), requestOptions)

    /** A view of [CallServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): CallServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/calls`, but is otherwise the same as
         * [CallServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: CallCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CallCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/calls/{callId}`, but is otherwise the same as
         * [CallServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            callId: String,
            params: CallRetrieveParams = CallRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CallRetrieveResponse> =
            retrieve(params.toBuilder().callId(callId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: CallRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CallRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            callId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CallRetrieveResponse> =
            retrieve(callId, CallRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/calls`, but is otherwise the same as
         * [CallServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: CallListParams = CallListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CallListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<CallListPageAsync> =
            list(CallListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/calls/{callId}/hangup`, but is otherwise the
         * same as [CallServiceAsync.hangup].
         */
        @MustBeClosed
        suspend fun hangup(
            callId: String,
            params: CallHangupParams = CallHangupParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CallHangupResponse> =
            hangup(params.toBuilder().callId(callId).build(), requestOptions)

        /** @see hangup */
        @MustBeClosed
        suspend fun hangup(
            params: CallHangupParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CallHangupResponse>

        /** @see hangup */
        @MustBeClosed
        suspend fun hangup(
            callId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CallHangupResponse> =
            hangup(callId, CallHangupParams.none(), requestOptions)
    }
}
