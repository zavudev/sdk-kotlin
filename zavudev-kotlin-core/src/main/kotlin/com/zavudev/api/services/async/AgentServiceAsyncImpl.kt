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
import com.zavudev.api.models.agents.AgentCreateParams
import com.zavudev.api.models.agents.AgentCreateResponse
import com.zavudev.api.models.agents.AgentDeleteParams
import com.zavudev.api.models.agents.AgentListPageAsync
import com.zavudev.api.models.agents.AgentListPageResponse
import com.zavudev.api.models.agents.AgentListParams
import com.zavudev.api.models.agents.AgentListVoicesParams
import com.zavudev.api.models.agents.AgentListVoicesResponse
import com.zavudev.api.models.agents.AgentRetrieveParams
import com.zavudev.api.models.agents.AgentRetrieveResponse
import com.zavudev.api.models.agents.AgentTestParams
import com.zavudev.api.models.agents.AgentTestResponse
import com.zavudev.api.models.agents.AgentUpdateParams
import com.zavudev.api.models.agents.AgentUpdateResponse
import com.zavudev.api.services.async.agents.SenderServiceAsync
import com.zavudev.api.services.async.agents.SenderServiceAsyncImpl

class AgentServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AgentServiceAsync {

    private val withRawResponse: AgentServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val senders: SenderServiceAsync by lazy { SenderServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): AgentServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): AgentServiceAsync =
        AgentServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun senders(): SenderServiceAsync = senders

    override suspend fun create(
        params: AgentCreateParams,
        requestOptions: RequestOptions,
    ): AgentCreateResponse =
        // post /v1/agents
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: AgentRetrieveParams,
        requestOptions: RequestOptions,
    ): AgentRetrieveResponse =
        // get /v1/agents/{agentId}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(
        params: AgentUpdateParams,
        requestOptions: RequestOptions,
    ): AgentUpdateResponse =
        // patch /v1/agents/{agentId}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: AgentListParams,
        requestOptions: RequestOptions,
    ): AgentListPageAsync =
        // get /v1/agents
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(params: AgentDeleteParams, requestOptions: RequestOptions) {
        // delete /v1/agents/{agentId}
        withRawResponse().delete(params, requestOptions)
    }

    override suspend fun listVoices(
        params: AgentListVoicesParams,
        requestOptions: RequestOptions,
    ): AgentListVoicesResponse =
        // get /v1/agents/voices
        withRawResponse().listVoices(params, requestOptions).parse()

    override suspend fun test(
        params: AgentTestParams,
        requestOptions: RequestOptions,
    ): AgentTestResponse =
        // post /v1/agents/{agentId}/test
        withRawResponse().test(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AgentServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val senders: SenderServiceAsync.WithRawResponse by lazy {
            SenderServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): AgentServiceAsync.WithRawResponse =
            AgentServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        override fun senders(): SenderServiceAsync.WithRawResponse = senders

        private val createHandler: Handler<AgentCreateResponse> =
            jsonHandler<AgentCreateResponse>(clientOptions.jsonMapper)

        override suspend fun create(
            params: AgentCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "agents")
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

        private val retrieveHandler: Handler<AgentRetrieveResponse> =
            jsonHandler<AgentRetrieveResponse>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: AgentRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("agentId", params.agentId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "agents", params._pathParam(0))
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

        private val updateHandler: Handler<AgentUpdateResponse> =
            jsonHandler<AgentUpdateResponse>(clientOptions.jsonMapper)

        override suspend fun update(
            params: AgentUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("agentId", params.agentId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "agents", params._pathParam(0))
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

        private val listHandler: Handler<AgentListPageResponse> =
            jsonHandler<AgentListPageResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: AgentListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "agents")
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
                        AgentListPageAsync.builder()
                            .service(AgentServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override suspend fun delete(
            params: AgentDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("agentId", params.agentId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "agents", params._pathParam(0))
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val listVoicesHandler: Handler<AgentListVoicesResponse> =
            jsonHandler<AgentListVoicesResponse>(clientOptions.jsonMapper)

        override suspend fun listVoices(
            params: AgentListVoicesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentListVoicesResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "agents", "voices")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listVoicesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val testHandler: Handler<AgentTestResponse> =
            jsonHandler<AgentTestResponse>(clientOptions.jsonMapper)

        override suspend fun test(
            params: AgentTestParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentTestResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("agentId", params.agentId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "agents", params._pathParam(0), "test")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { testHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
