// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders.agent

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
import com.zavudev.api.models.senders.agent.tools.ToolCreateParams
import com.zavudev.api.models.senders.agent.tools.ToolCreateResponse
import com.zavudev.api.models.senders.agent.tools.ToolDeleteParams
import com.zavudev.api.models.senders.agent.tools.ToolListPageAsync
import com.zavudev.api.models.senders.agent.tools.ToolListPageResponse
import com.zavudev.api.models.senders.agent.tools.ToolListParams
import com.zavudev.api.models.senders.agent.tools.ToolRetrieveParams
import com.zavudev.api.models.senders.agent.tools.ToolRetrieveResponse
import com.zavudev.api.models.senders.agent.tools.ToolTestParams
import com.zavudev.api.models.senders.agent.tools.ToolTestResponse
import com.zavudev.api.models.senders.agent.tools.ToolUpdateParams
import com.zavudev.api.models.senders.agent.tools.ToolUpdateResponse

class ToolServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ToolServiceAsync {

    private val withRawResponse: ToolServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ToolServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ToolServiceAsync =
        ToolServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun create(
        params: ToolCreateParams,
        requestOptions: RequestOptions,
    ): ToolCreateResponse =
        // post /v1/senders/{senderId}/agent/tools
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: ToolRetrieveParams,
        requestOptions: RequestOptions,
    ): ToolRetrieveResponse =
        // get /v1/senders/{senderId}/agent/tools/{toolId}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(
        params: ToolUpdateParams,
        requestOptions: RequestOptions,
    ): ToolUpdateResponse =
        // patch /v1/senders/{senderId}/agent/tools/{toolId}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: ToolListParams,
        requestOptions: RequestOptions,
    ): ToolListPageAsync =
        // get /v1/senders/{senderId}/agent/tools
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(params: ToolDeleteParams, requestOptions: RequestOptions) {
        // delete /v1/senders/{senderId}/agent/tools/{toolId}
        withRawResponse().delete(params, requestOptions)
    }

    override suspend fun test(
        params: ToolTestParams,
        requestOptions: RequestOptions,
    ): ToolTestResponse =
        // post /v1/senders/{senderId}/agent/tools/{toolId}/test
        withRawResponse().test(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ToolServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ToolServiceAsync.WithRawResponse =
            ToolServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val createHandler: Handler<ToolCreateResponse> =
            jsonHandler<ToolCreateResponse>(clientOptions.jsonMapper)

        override suspend fun create(
            params: ToolCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ToolCreateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("senderId", params.senderId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders", params._pathParam(0), "agent", "tools")
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

        private val retrieveHandler: Handler<ToolRetrieveResponse> =
            jsonHandler<ToolRetrieveResponse>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: ToolRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ToolRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("toolId", params.toolId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "senders",
                        params._pathParam(0),
                        "agent",
                        "tools",
                        params._pathParam(1),
                    )
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

        private val updateHandler: Handler<ToolUpdateResponse> =
            jsonHandler<ToolUpdateResponse>(clientOptions.jsonMapper)

        override suspend fun update(
            params: ToolUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ToolUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("toolId", params.toolId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "senders",
                        params._pathParam(0),
                        "agent",
                        "tools",
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

        private val listHandler: Handler<ToolListPageResponse> =
            jsonHandler<ToolListPageResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: ToolListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ToolListPageAsync> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("senderId", params.senderId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders", params._pathParam(0), "agent", "tools")
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
                        ToolListPageAsync.builder()
                            .service(ToolServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override suspend fun delete(
            params: ToolDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("toolId", params.toolId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "senders",
                        params._pathParam(0),
                        "agent",
                        "tools",
                        params._pathParam(1),
                    )
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val testHandler: Handler<ToolTestResponse> =
            jsonHandler<ToolTestResponse>(clientOptions.jsonMapper)

        override suspend fun test(
            params: ToolTestParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ToolTestResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("toolId", params.toolId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "senders",
                        params._pathParam(0),
                        "agent",
                        "tools",
                        params._pathParam(1),
                        "test",
                    )
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
