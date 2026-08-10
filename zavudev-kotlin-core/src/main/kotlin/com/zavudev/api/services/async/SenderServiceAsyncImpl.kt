// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.checkRequired
import com.zavudev.api.core.handlers.emptyHandler
import com.zavudev.api.core.handlers.errorBodyHandler
import com.zavudev.api.core.handlers.errorHandler
import com.zavudev.api.core.handlers.jsonHandler
import com.zavudev.api.core.http.HttpMethod
import com.zavudev.api.core.http.HttpRequest
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponse.Handler
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.core.http.json
import com.zavudev.api.core.http.parseable
import com.zavudev.api.core.prepareAsync
import com.zavudev.api.models.senders.Sender
import com.zavudev.api.models.senders.SenderCreateParams
import com.zavudev.api.models.senders.SenderDeleteParams
import com.zavudev.api.models.senders.SenderGetProfileParams
import com.zavudev.api.models.senders.SenderListPageAsync
import com.zavudev.api.models.senders.SenderListPageResponse
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
import com.zavudev.api.services.async.senders.AgentServiceAsyncImpl
import com.zavudev.api.services.async.senders.WhatsappSyncServiceAsync
import com.zavudev.api.services.async.senders.WhatsappSyncServiceAsyncImpl

class SenderServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SenderServiceAsync {

    private val withRawResponse: SenderServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val agent: AgentServiceAsync by lazy { AgentServiceAsyncImpl(clientOptions) }

    private val whatsappSync: WhatsappSyncServiceAsync by lazy {
        WhatsappSyncServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): SenderServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): SenderServiceAsync =
        SenderServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun agent(): AgentServiceAsync = agent

    override fun whatsappSync(): WhatsappSyncServiceAsync = whatsappSync

    override suspend fun create(
        params: SenderCreateParams,
        requestOptions: RequestOptions,
    ): Sender =
        // post /v1/senders
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: SenderRetrieveParams,
        requestOptions: RequestOptions,
    ): Sender =
        // get /v1/senders/{senderId}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(
        params: SenderUpdateParams,
        requestOptions: RequestOptions,
    ): Sender =
        // patch /v1/senders/{senderId}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: SenderListParams,
        requestOptions: RequestOptions,
    ): SenderListPageAsync =
        // get /v1/senders
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(params: SenderDeleteParams, requestOptions: RequestOptions) {
        // delete /v1/senders/{senderId}
        withRawResponse().delete(params, requestOptions)
    }

    override suspend fun getProfile(
        params: SenderGetProfileParams,
        requestOptions: RequestOptions,
    ): WhatsappBusinessProfileResponse =
        // get /v1/senders/{senderId}/profile
        withRawResponse().getProfile(params, requestOptions).parse()

    override suspend fun regenerateWebhookSecret(
        params: SenderRegenerateWebhookSecretParams,
        requestOptions: RequestOptions,
    ): WebhookSecretResponse =
        // post /v1/senders/{senderId}/webhook/secret
        withRawResponse().regenerateWebhookSecret(params, requestOptions).parse()

    override suspend fun updateProfile(
        params: SenderUpdateProfileParams,
        requestOptions: RequestOptions,
    ): SenderUpdateProfileResponse =
        // patch /v1/senders/{senderId}/profile
        withRawResponse().updateProfile(params, requestOptions).parse()

    override suspend fun uploadProfilePicture(
        params: SenderUploadProfilePictureParams,
        requestOptions: RequestOptions,
    ): SenderUploadProfilePictureResponse =
        // post /v1/senders/{senderId}/profile/picture
        withRawResponse().uploadProfilePicture(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SenderServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val agent: AgentServiceAsync.WithRawResponse by lazy {
            AgentServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val whatsappSync: WhatsappSyncServiceAsync.WithRawResponse by lazy {
            WhatsappSyncServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): SenderServiceAsync.WithRawResponse =
            SenderServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        override fun agent(): AgentServiceAsync.WithRawResponse = agent

        override fun whatsappSync(): WhatsappSyncServiceAsync.WithRawResponse = whatsappSync

        private val createHandler: Handler<Sender> = jsonHandler<Sender>(clientOptions.jsonMapper)

        override suspend fun create(
            params: SenderCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Sender> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<Sender> = jsonHandler<Sender>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: SenderRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Sender> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("senderId", params.senderId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateHandler: Handler<Sender> = jsonHandler<Sender>(clientOptions.jsonMapper)

        override suspend fun update(
            params: SenderUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Sender> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("senderId", params.senderId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<SenderListPageResponse> =
            jsonHandler<SenderListPageResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: SenderListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SenderListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        SenderListPageAsync.builder()
                            .service(SenderServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override suspend fun delete(
            params: SenderDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("senderId", params.senderId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders", params._pathParam(0))
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val getProfileHandler: Handler<WhatsappBusinessProfileResponse> =
            jsonHandler<WhatsappBusinessProfileResponse>(clientOptions.jsonMapper)

        override suspend fun getProfile(
            params: SenderGetProfileParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WhatsappBusinessProfileResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("senderId", params.senderId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders", params._pathParam(0), "profile")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getProfileHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val regenerateWebhookSecretHandler: Handler<WebhookSecretResponse> =
            jsonHandler<WebhookSecretResponse>(clientOptions.jsonMapper)

        override suspend fun regenerateWebhookSecret(
            params: SenderRegenerateWebhookSecretParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WebhookSecretResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("senderId", params.senderId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders", params._pathParam(0), "webhook", "secret")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { regenerateWebhookSecretHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateProfileHandler: Handler<SenderUpdateProfileResponse> =
            jsonHandler<SenderUpdateProfileResponse>(clientOptions.jsonMapper)

        override suspend fun updateProfile(
            params: SenderUpdateProfileParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SenderUpdateProfileResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("senderId", params.senderId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders", params._pathParam(0), "profile")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateProfileHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val uploadProfilePictureHandler: Handler<SenderUploadProfilePictureResponse> =
            jsonHandler<SenderUploadProfilePictureResponse>(clientOptions.jsonMapper)

        override suspend fun uploadProfilePicture(
            params: SenderUploadProfilePictureParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SenderUploadProfilePictureResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("senderId", params.senderId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders", params._pathParam(0), "profile", "picture")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { uploadProfilePictureHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
