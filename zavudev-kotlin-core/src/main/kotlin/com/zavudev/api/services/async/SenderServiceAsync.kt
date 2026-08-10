// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.senders.Sender
import com.zavudev.api.models.senders.SenderCreateParams
import com.zavudev.api.models.senders.SenderDeleteParams
import com.zavudev.api.models.senders.SenderGetProfileParams
import com.zavudev.api.models.senders.SenderListPageAsync
import com.zavudev.api.models.senders.SenderListParams
import com.zavudev.api.models.senders.SenderRegenerateWebhookSecretParams
import com.zavudev.api.models.senders.SenderRetrieveParams
import com.zavudev.api.models.senders.SenderUpdateParams
import com.zavudev.api.models.senders.SenderUpdateProfileParams
import com.zavudev.api.models.senders.SenderUpdateProfileResponse
import com.zavudev.api.models.senders.SenderUploadProfilePictureParams
import com.zavudev.api.models.senders.SenderUploadProfilePictureResponse
import com.zavudev.api.models.senders.WebhookSecretResponse
import com.zavudev.api.models.senders.WhatsappBusinessProfileResponse
import com.zavudev.api.services.async.senders.AgentServiceAsync
import com.zavudev.api.services.async.senders.WhatsappSyncServiceAsync

interface SenderServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): SenderServiceAsync

    fun agent(): AgentServiceAsync

    fun whatsappSync(): WhatsappSyncServiceAsync

    /** Create sender */
    suspend fun create(
        params: SenderCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Sender

    /** Get sender */
    suspend fun retrieve(
        senderId: String,
        params: SenderRetrieveParams = SenderRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Sender = retrieve(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: SenderRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Sender

    /** @see retrieve */
    suspend fun retrieve(senderId: String, requestOptions: RequestOptions): Sender =
        retrieve(senderId, SenderRetrieveParams.none(), requestOptions)

    /** Update sender */
    suspend fun update(
        senderId: String,
        params: SenderUpdateParams = SenderUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Sender = update(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: SenderUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Sender

    /** @see update */
    suspend fun update(senderId: String, requestOptions: RequestOptions): Sender =
        update(senderId, SenderUpdateParams.none(), requestOptions)

    /** List senders */
    suspend fun list(
        params: SenderListParams = SenderListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SenderListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): SenderListPageAsync =
        list(SenderListParams.none(), requestOptions)

    /** Delete sender */
    suspend fun delete(
        senderId: String,
        params: SenderDeleteParams = SenderDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: SenderDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(senderId: String, requestOptions: RequestOptions) =
        delete(senderId, SenderDeleteParams.none(), requestOptions)

    /**
     * Get the WhatsApp Business profile for a sender. The sender must have a WhatsApp Business
     * Account connected.
     */
    suspend fun getProfile(
        senderId: String,
        params: SenderGetProfileParams = SenderGetProfileParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WhatsappBusinessProfileResponse =
        getProfile(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see getProfile */
    suspend fun getProfile(
        params: SenderGetProfileParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WhatsappBusinessProfileResponse

    /** @see getProfile */
    suspend fun getProfile(
        senderId: String,
        requestOptions: RequestOptions,
    ): WhatsappBusinessProfileResponse =
        getProfile(senderId, SenderGetProfileParams.none(), requestOptions)

    /**
     * Regenerate the webhook secret for a sender. The old secret will be invalidated immediately.
     */
    suspend fun regenerateWebhookSecret(
        senderId: String,
        params: SenderRegenerateWebhookSecretParams = SenderRegenerateWebhookSecretParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookSecretResponse =
        regenerateWebhookSecret(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see regenerateWebhookSecret */
    suspend fun regenerateWebhookSecret(
        params: SenderRegenerateWebhookSecretParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): WebhookSecretResponse

    /** @see regenerateWebhookSecret */
    suspend fun regenerateWebhookSecret(
        senderId: String,
        requestOptions: RequestOptions,
    ): WebhookSecretResponse =
        regenerateWebhookSecret(
            senderId,
            SenderRegenerateWebhookSecretParams.none(),
            requestOptions,
        )

    /**
     * Update the WhatsApp Business profile for a sender. The sender must have a WhatsApp Business
     * Account connected.
     */
    suspend fun updateProfile(
        senderId: String,
        params: SenderUpdateProfileParams = SenderUpdateProfileParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SenderUpdateProfileResponse =
        updateProfile(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see updateProfile */
    suspend fun updateProfile(
        params: SenderUpdateProfileParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SenderUpdateProfileResponse

    /** @see updateProfile */
    suspend fun updateProfile(
        senderId: String,
        requestOptions: RequestOptions,
    ): SenderUpdateProfileResponse =
        updateProfile(senderId, SenderUpdateProfileParams.none(), requestOptions)

    /**
     * Upload a new profile picture for the WhatsApp Business profile. The image will be uploaded to
     * Meta and set as the profile picture.
     */
    suspend fun uploadProfilePicture(
        senderId: String,
        params: SenderUploadProfilePictureParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SenderUploadProfilePictureResponse =
        uploadProfilePicture(params.toBuilder().senderId(senderId).build(), requestOptions)

    /** @see uploadProfilePicture */
    suspend fun uploadProfilePicture(
        params: SenderUploadProfilePictureParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SenderUploadProfilePictureResponse

    /**
     * A view of [SenderServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): SenderServiceAsync.WithRawResponse

        fun agent(): AgentServiceAsync.WithRawResponse

        fun whatsappSync(): WhatsappSyncServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/senders`, but is otherwise the same as
         * [SenderServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: SenderCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Sender>

        /**
         * Returns a raw HTTP response for `get /v1/senders/{senderId}`, but is otherwise the same
         * as [SenderServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            senderId: String,
            params: SenderRetrieveParams = SenderRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Sender> =
            retrieve(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: SenderRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Sender>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Sender> = retrieve(senderId, SenderRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/senders/{senderId}`, but is otherwise the same
         * as [SenderServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            senderId: String,
            params: SenderUpdateParams = SenderUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Sender> =
            update(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: SenderUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Sender>

        /** @see update */
        @MustBeClosed
        suspend fun update(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Sender> = update(senderId, SenderUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/senders`, but is otherwise the same as
         * [SenderServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: SenderListParams = SenderListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SenderListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<SenderListPageAsync> =
            list(SenderListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/senders/{senderId}`, but is otherwise the
         * same as [SenderServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            senderId: String,
            params: SenderDeleteParams = SenderDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: SenderDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(senderId: String, requestOptions: RequestOptions): HttpResponse =
            delete(senderId, SenderDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/senders/{senderId}/profile`, but is otherwise
         * the same as [SenderServiceAsync.getProfile].
         */
        @MustBeClosed
        suspend fun getProfile(
            senderId: String,
            params: SenderGetProfileParams = SenderGetProfileParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WhatsappBusinessProfileResponse> =
            getProfile(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see getProfile */
        @MustBeClosed
        suspend fun getProfile(
            params: SenderGetProfileParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WhatsappBusinessProfileResponse>

        /** @see getProfile */
        @MustBeClosed
        suspend fun getProfile(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WhatsappBusinessProfileResponse> =
            getProfile(senderId, SenderGetProfileParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/senders/{senderId}/webhook/secret`, but is
         * otherwise the same as [SenderServiceAsync.regenerateWebhookSecret].
         */
        @MustBeClosed
        suspend fun regenerateWebhookSecret(
            senderId: String,
            params: SenderRegenerateWebhookSecretParams =
                SenderRegenerateWebhookSecretParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookSecretResponse> =
            regenerateWebhookSecret(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see regenerateWebhookSecret */
        @MustBeClosed
        suspend fun regenerateWebhookSecret(
            params: SenderRegenerateWebhookSecretParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<WebhookSecretResponse>

        /** @see regenerateWebhookSecret */
        @MustBeClosed
        suspend fun regenerateWebhookSecret(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookSecretResponse> =
            regenerateWebhookSecret(
                senderId,
                SenderRegenerateWebhookSecretParams.none(),
                requestOptions,
            )

        /**
         * Returns a raw HTTP response for `patch /v1/senders/{senderId}/profile`, but is otherwise
         * the same as [SenderServiceAsync.updateProfile].
         */
        @MustBeClosed
        suspend fun updateProfile(
            senderId: String,
            params: SenderUpdateProfileParams = SenderUpdateProfileParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SenderUpdateProfileResponse> =
            updateProfile(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see updateProfile */
        @MustBeClosed
        suspend fun updateProfile(
            params: SenderUpdateProfileParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SenderUpdateProfileResponse>

        /** @see updateProfile */
        @MustBeClosed
        suspend fun updateProfile(
            senderId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SenderUpdateProfileResponse> =
            updateProfile(senderId, SenderUpdateProfileParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/senders/{senderId}/profile/picture`, but is
         * otherwise the same as [SenderServiceAsync.uploadProfilePicture].
         */
        @MustBeClosed
        suspend fun uploadProfilePicture(
            senderId: String,
            params: SenderUploadProfilePictureParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SenderUploadProfilePictureResponse> =
            uploadProfilePicture(params.toBuilder().senderId(senderId).build(), requestOptions)

        /** @see uploadProfilePicture */
        @MustBeClosed
        suspend fun uploadProfilePicture(
            params: SenderUploadProfilePictureParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SenderUploadProfilePictureResponse>
    }
}
