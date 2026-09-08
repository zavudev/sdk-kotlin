// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.agents

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
import com.zavudev.api.models.agents.senders.SenderConnectParams
import com.zavudev.api.models.agents.senders.SenderConnectResponse
import com.zavudev.api.models.agents.senders.SenderDisconnectParams

class SenderServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SenderServiceAsync {

    private val withRawResponse: SenderServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SenderServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): SenderServiceAsync =
        SenderServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun connect(
        params: SenderConnectParams,
        requestOptions: RequestOptions,
    ): SenderConnectResponse =
        // post /v1/agents/{agentId}/senders
        withRawResponse().connect(params, requestOptions).parse()

    override suspend fun disconnect(
        params: SenderDisconnectParams,
        requestOptions: RequestOptions,
    ) {
        // delete /v1/agents/{agentId}/senders/{senderId}
        withRawResponse().disconnect(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SenderServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): SenderServiceAsync.WithRawResponse =
            SenderServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val connectHandler: Handler<SenderConnectResponse> =
            jsonHandler<SenderConnectResponse>(clientOptions.jsonMapper)

        override suspend fun connect(
            params: SenderConnectParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SenderConnectResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("agentId", params.agentId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "agents", params._pathParam(0), "senders")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { connectHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val disconnectHandler: Handler<Void?> = emptyHandler()

        override suspend fun disconnect(
            params: SenderDisconnectParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("senderId", params.senderId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "agents",
                        params._pathParam(0),
                        "senders",
                        params._pathParam(1),
                    )
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { disconnectHandler.handle(it) }
            }
        }
    }
}
