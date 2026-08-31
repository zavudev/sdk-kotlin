// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

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
import com.zavudev.api.models.agenttemplates.AgentTemplateListParams
import com.zavudev.api.models.agenttemplates.AgentTemplateListResponse
import com.zavudev.api.models.agenttemplates.AgentTemplateRetrieveParams
import com.zavudev.api.models.agenttemplates.AgentTemplateRetrieveResponse

class AgentTemplateServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AgentTemplateServiceAsync {

    private val withRawResponse: AgentTemplateServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): AgentTemplateServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): AgentTemplateServiceAsync =
        AgentTemplateServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun retrieve(
        params: AgentTemplateRetrieveParams,
        requestOptions: RequestOptions,
    ): AgentTemplateRetrieveResponse =
        // get /v1/agent-templates/{templateId}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun list(
        params: AgentTemplateListParams,
        requestOptions: RequestOptions,
    ): AgentTemplateListResponse =
        // get /v1/agent-templates
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AgentTemplateServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): AgentTemplateServiceAsync.WithRawResponse =
            AgentTemplateServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val retrieveHandler: Handler<AgentTemplateRetrieveResponse> =
            jsonHandler<AgentTemplateRetrieveResponse>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: AgentTemplateRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentTemplateRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("templateId", params.templateId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "agent-templates", params._pathParam(0))
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

        private val listHandler: Handler<AgentTemplateListResponse> =
            jsonHandler<AgentTemplateListResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: AgentTemplateListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentTemplateListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "agent-templates")
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
            }
        }
    }
}
