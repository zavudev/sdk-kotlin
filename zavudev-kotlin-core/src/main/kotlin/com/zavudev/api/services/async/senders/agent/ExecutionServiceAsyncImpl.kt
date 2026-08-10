// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.senders.agent

import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.checkRequired
import com.zavudev.api.core.handlers.errorBodyHandler
import com.zavudev.api.core.handlers.errorHandler
import com.zavudev.api.core.handlers.jsonHandler
import com.zavudev.api.core.http.HttpMethod
import com.zavudev.api.core.http.HttpRequest
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponse.Handler
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.core.http.parseable
import com.zavudev.api.core.prepareAsync
import com.zavudev.api.models.senders.agent.executions.ExecutionListPageAsync
import com.zavudev.api.models.senders.agent.executions.ExecutionListPageResponse
import com.zavudev.api.models.senders.agent.executions.ExecutionListParams
import com.zavudev.api.models.senders.agent.executions.ExecutionRetrieveParams
import com.zavudev.api.models.senders.agent.executions.ExecutionRetrieveResponse

class ExecutionServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ExecutionServiceAsync {

    private val withRawResponse: ExecutionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ExecutionServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ExecutionServiceAsync =
        ExecutionServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun retrieve(
        params: ExecutionRetrieveParams,
        requestOptions: RequestOptions,
    ): ExecutionRetrieveResponse =
        // get /v1/senders/{senderId}/agent/executions/{executionId}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun list(
        params: ExecutionListParams,
        requestOptions: RequestOptions,
    ): ExecutionListPageAsync =
        // get /v1/senders/{senderId}/agent/executions
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ExecutionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ExecutionServiceAsync.WithRawResponse =
            ExecutionServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val retrieveHandler: Handler<ExecutionRetrieveResponse> =
            jsonHandler<ExecutionRetrieveResponse>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: ExecutionRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExecutionRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("executionId", params.executionId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "senders",
                        params._pathParam(0),
                        "agent",
                        "executions",
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

        private val listHandler: Handler<ExecutionListPageResponse> =
            jsonHandler<ExecutionListPageResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: ExecutionListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ExecutionListPageAsync> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("senderId", params.senderId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "senders", params._pathParam(0), "agent", "executions")
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
                        ExecutionListPageAsync.builder()
                            .service(ExecutionServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
