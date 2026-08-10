// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders

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
import com.zavudev.api.models.senders.agent.AgentCreateParams
import com.zavudev.api.models.senders.agent.AgentDeleteParams
import com.zavudev.api.models.senders.agent.AgentResponse
import com.zavudev.api.models.senders.agent.AgentRetrieveParams
import com.zavudev.api.models.senders.agent.AgentStats
import com.zavudev.api.models.senders.agent.AgentStatsParams
import com.zavudev.api.models.senders.agent.AgentUpdateParams
import com.zavudev.api.services.async.senders.agent.ExecutionServiceAsync
import com.zavudev.api.services.async.senders.agent.ExecutionServiceAsyncImpl
import com.zavudev.api.services.async.senders.agent.FlowServiceAsync
import com.zavudev.api.services.async.senders.agent.FlowServiceAsyncImpl
import com.zavudev.api.services.async.senders.agent.KnowledgeBaseServiceAsync
import com.zavudev.api.services.async.senders.agent.KnowledgeBaseServiceAsyncImpl
import com.zavudev.api.services.async.senders.agent.ToolServiceAsync
import com.zavudev.api.services.async.senders.agent.ToolServiceAsyncImpl

class AgentServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AgentServiceAsync {

    private val withRawResponse: AgentServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val executions: ExecutionServiceAsync by lazy {
        ExecutionServiceAsyncImpl(clientOptions)
    }

    private val flows: FlowServiceAsync by lazy { FlowServiceAsyncImpl(clientOptions) }

    private val tools: ToolServiceAsync by lazy { ToolServiceAsyncImpl(clientOptions) }

    private val knowledgeBases: KnowledgeBaseServiceAsync by lazy {
        KnowledgeBaseServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): AgentServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): AgentServiceAsync =
        AgentServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun executions(): ExecutionServiceAsync = executions

    override fun flows(): FlowServiceAsync = flows

    override fun tools(): ToolServiceAsync = tools

    override fun knowledgeBases(): KnowledgeBaseServiceAsync = knowledgeBases

    override suspend fun create(
        params: AgentCreateParams,
        requestOptions: RequestOptions,
    ): AgentResponse =
        // post /v1/senders/{senderId}/agent
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: AgentRetrieveParams,
        requestOptions: RequestOptions,
    ): AgentResponse =
        // get /v1/senders/{senderId}/agent
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(
        params: AgentUpdateParams,
        requestOptions: RequestOptions,
    ): AgentResponse =
        // patch /v1/senders/{senderId}/agent
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun delete(params: AgentDeleteParams, requestOptions: RequestOptions) {
        // delete /v1/senders/{senderId}/agent
        withRawResponse().delete(params, requestOptions)
    }

    override suspend fun stats(
        params: AgentStatsParams,
        requestOptions: RequestOptions,
    ): AgentStats =
        // get /v1/senders/{senderId}/agent/stats
        withRawResponse().stats(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AgentServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val executions: ExecutionServiceAsync.WithRawResponse by lazy {
            ExecutionServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val flows: FlowServiceAsync.WithRawResponse by lazy {
            FlowServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val tools: ToolServiceAsync.WithRawResponse by lazy {
            ToolServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val knowledgeBases: KnowledgeBaseServiceAsync.WithRawResponse by lazy {
            KnowledgeBaseServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): AgentServiceAsync.WithRawResponse =
            AgentServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        override fun executions(): ExecutionServiceAsync.WithRawResponse = executions

        override fun flows(): FlowServiceAsync.WithRawResponse = flows

        override fun tools(): ToolServiceAsync.WithRawResponse = tools

        override fun knowledgeBases(): KnowledgeBaseServiceAsync.WithRawResponse = knowledgeBases

        private val createHandler: Handler<AgentResponse> =
            jsonHandler<AgentResponse>(clientOptions.jsonMapper)

        override suspend fun create(
            params: AgentCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("senderId", params.senderId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders", params._pathParam(0), "agent")
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

        private val retrieveHandler: Handler<AgentResponse> =
            jsonHandler<AgentResponse>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: AgentRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("senderId", params.senderId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders", params._pathParam(0), "agent")
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

        private val updateHandler: Handler<AgentResponse> =
            jsonHandler<AgentResponse>(clientOptions.jsonMapper)

        override suspend fun update(
            params: AgentUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("senderId", params.senderId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders", params._pathParam(0), "agent")
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

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override suspend fun delete(
            params: AgentDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("senderId", params.senderId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders", params._pathParam(0), "agent")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val statsHandler: Handler<AgentStats> =
            jsonHandler<AgentStats>(clientOptions.jsonMapper)

        override suspend fun stats(
            params: AgentStatsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentStats> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("senderId", params.senderId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders", params._pathParam(0), "agent", "stats")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { statsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
