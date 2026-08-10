// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.contacts

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
import com.zavudev.api.models.contacts.channels.ChannelAddParams
import com.zavudev.api.models.contacts.channels.ChannelAddResponse
import com.zavudev.api.models.contacts.channels.ChannelRemoveParams
import com.zavudev.api.models.contacts.channels.ChannelSetPrimaryParams
import com.zavudev.api.models.contacts.channels.ChannelSetPrimaryResponse
import com.zavudev.api.models.contacts.channels.ChannelUpdateParams
import com.zavudev.api.models.contacts.channels.ChannelUpdateResponse

class ChannelServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ChannelServiceAsync {

    private val withRawResponse: ChannelServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ChannelServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ChannelServiceAsync =
        ChannelServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun update(
        params: ChannelUpdateParams,
        requestOptions: RequestOptions,
    ): ChannelUpdateResponse =
        // patch /v1/contacts/{contactId}/channels/{channelId}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun add(
        params: ChannelAddParams,
        requestOptions: RequestOptions,
    ): ChannelAddResponse =
        // post /v1/contacts/{contactId}/channels
        withRawResponse().add(params, requestOptions).parse()

    override suspend fun remove(params: ChannelRemoveParams, requestOptions: RequestOptions) {
        // delete /v1/contacts/{contactId}/channels/{channelId}
        withRawResponse().remove(params, requestOptions)
    }

    override suspend fun setPrimary(
        params: ChannelSetPrimaryParams,
        requestOptions: RequestOptions,
    ): ChannelSetPrimaryResponse =
        // post /v1/contacts/{contactId}/channels/{channelId}/primary
        withRawResponse().setPrimary(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChannelServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ChannelServiceAsync.WithRawResponse =
            ChannelServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val updateHandler: Handler<ChannelUpdateResponse> =
            jsonHandler<ChannelUpdateResponse>(clientOptions.jsonMapper)

        override suspend fun update(
            params: ChannelUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChannelUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("channelId", params.channelId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "contacts",
                        params._pathParam(0),
                        "channels",
                        params._pathParam(1),
                    )
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

        private val addHandler: Handler<ChannelAddResponse> =
            jsonHandler<ChannelAddResponse>(clientOptions.jsonMapper)

        override suspend fun add(
            params: ChannelAddParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChannelAddResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("contactId", params.contactId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "contacts", params._pathParam(0), "channels")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { addHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val removeHandler: Handler<Void?> = emptyHandler()

        override suspend fun remove(
            params: ChannelRemoveParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("channelId", params.channelId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "contacts",
                        params._pathParam(0),
                        "channels",
                        params._pathParam(1),
                    )
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { removeHandler.handle(it) }
            }
        }

        private val setPrimaryHandler: Handler<ChannelSetPrimaryResponse> =
            jsonHandler<ChannelSetPrimaryResponse>(clientOptions.jsonMapper)

        override suspend fun setPrimary(
            params: ChannelSetPrimaryParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChannelSetPrimaryResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("channelId", params.channelId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "contacts",
                        params._pathParam(0),
                        "channels",
                        params._pathParam(1),
                        "primary",
                    )
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { setPrimaryHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
