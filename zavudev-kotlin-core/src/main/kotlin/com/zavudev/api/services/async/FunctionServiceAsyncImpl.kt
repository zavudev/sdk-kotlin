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
import com.zavudev.api.core.http.json
import com.zavudev.api.core.http.parseable
import com.zavudev.api.core.prepareAsync
import com.zavudev.api.models.functions.FunctionCreateParams
import com.zavudev.api.models.functions.FunctionCreateResponse
import com.zavudev.api.models.functions.FunctionDeleteParams
import com.zavudev.api.models.functions.FunctionDeleteResponse
import com.zavudev.api.models.functions.FunctionDeployParams
import com.zavudev.api.models.functions.FunctionDeployResponse
import com.zavudev.api.models.functions.FunctionGetDeploymentParams
import com.zavudev.api.models.functions.FunctionGetDeploymentResponse
import com.zavudev.api.models.functions.FunctionListDeploymentsParams
import com.zavudev.api.models.functions.FunctionListDeploymentsResponse
import com.zavudev.api.models.functions.FunctionListEventTypesParams
import com.zavudev.api.models.functions.FunctionListEventTypesResponse
import com.zavudev.api.models.functions.FunctionRetrieveParams
import com.zavudev.api.models.functions.FunctionRetrieveResponse
import com.zavudev.api.models.functions.FunctionRollbackDeploymentParams
import com.zavudev.api.models.functions.FunctionRollbackDeploymentResponse
import com.zavudev.api.models.functions.FunctionTailLogsParams
import com.zavudev.api.models.functions.FunctionTailLogsResponse
import com.zavudev.api.models.functions.FunctionUpdateParams
import com.zavudev.api.models.functions.FunctionUpdateResponse
import com.zavudev.api.services.async.functions.GitLinkServiceAsync
import com.zavudev.api.services.async.functions.GitLinkServiceAsyncImpl
import com.zavudev.api.services.async.functions.SecretServiceAsync
import com.zavudev.api.services.async.functions.SecretServiceAsyncImpl
import com.zavudev.api.services.async.functions.TriggerServiceAsync
import com.zavudev.api.services.async.functions.TriggerServiceAsyncImpl

class FunctionServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    FunctionServiceAsync {

    private val withRawResponse: FunctionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val secrets: SecretServiceAsync by lazy { SecretServiceAsyncImpl(clientOptions) }

    private val triggers: TriggerServiceAsync by lazy { TriggerServiceAsyncImpl(clientOptions) }

    private val gitLink: GitLinkServiceAsync by lazy { GitLinkServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): FunctionServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): FunctionServiceAsync =
        FunctionServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun secrets(): SecretServiceAsync = secrets

    override fun triggers(): TriggerServiceAsync = triggers

    override fun gitLink(): GitLinkServiceAsync = gitLink

    override suspend fun create(
        params: FunctionCreateParams,
        requestOptions: RequestOptions,
    ): FunctionCreateResponse =
        // post /v1/functions
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: FunctionRetrieveParams,
        requestOptions: RequestOptions,
    ): FunctionRetrieveResponse =
        // get /v1/functions/{functionId}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(
        params: FunctionUpdateParams,
        requestOptions: RequestOptions,
    ): FunctionUpdateResponse =
        // patch /v1/functions/{functionId}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun delete(
        params: FunctionDeleteParams,
        requestOptions: RequestOptions,
    ): FunctionDeleteResponse =
        // delete /v1/functions/{functionId}
        withRawResponse().delete(params, requestOptions).parse()

    override suspend fun deploy(
        params: FunctionDeployParams,
        requestOptions: RequestOptions,
    ): FunctionDeployResponse =
        // post /v1/functions/{functionId}/deploy
        withRawResponse().deploy(params, requestOptions).parse()

    override suspend fun getDeployment(
        params: FunctionGetDeploymentParams,
        requestOptions: RequestOptions,
    ): FunctionGetDeploymentResponse =
        // get /v1/functions/deployments/{deploymentId}
        withRawResponse().getDeployment(params, requestOptions).parse()

    override suspend fun listDeployments(
        params: FunctionListDeploymentsParams,
        requestOptions: RequestOptions,
    ): FunctionListDeploymentsResponse =
        // get /v1/functions/{functionId}/deployments
        withRawResponse().listDeployments(params, requestOptions).parse()

    override suspend fun listEventTypes(
        params: FunctionListEventTypesParams,
        requestOptions: RequestOptions,
    ): FunctionListEventTypesResponse =
        // get /v1/functions/event-types
        withRawResponse().listEventTypes(params, requestOptions).parse()

    override suspend fun rollbackDeployment(
        params: FunctionRollbackDeploymentParams,
        requestOptions: RequestOptions,
    ): FunctionRollbackDeploymentResponse =
        // post /v1/functions/{functionId}/rollback
        withRawResponse().rollbackDeployment(params, requestOptions).parse()

    override suspend fun tailLogs(
        params: FunctionTailLogsParams,
        requestOptions: RequestOptions,
    ): FunctionTailLogsResponse =
        // get /v1/functions/{functionId}/logs
        withRawResponse().tailLogs(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FunctionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val secrets: SecretServiceAsync.WithRawResponse by lazy {
            SecretServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val triggers: TriggerServiceAsync.WithRawResponse by lazy {
            TriggerServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val gitLink: GitLinkServiceAsync.WithRawResponse by lazy {
            GitLinkServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): FunctionServiceAsync.WithRawResponse =
            FunctionServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        override fun secrets(): SecretServiceAsync.WithRawResponse = secrets

        override fun triggers(): TriggerServiceAsync.WithRawResponse = triggers

        override fun gitLink(): GitLinkServiceAsync.WithRawResponse = gitLink

        private val createHandler: Handler<FunctionCreateResponse> =
            jsonHandler<FunctionCreateResponse>(clientOptions.jsonMapper)

        override suspend fun create(
            params: FunctionCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "functions")
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

        private val retrieveHandler: Handler<FunctionRetrieveResponse> =
            jsonHandler<FunctionRetrieveResponse>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: FunctionRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("functionId", params.functionId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "functions", params._pathParam(0))
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

        private val updateHandler: Handler<FunctionUpdateResponse> =
            jsonHandler<FunctionUpdateResponse>(clientOptions.jsonMapper)

        override suspend fun update(
            params: FunctionUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("functionId", params.functionId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "functions", params._pathParam(0))
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

        private val deleteHandler: Handler<FunctionDeleteResponse> =
            jsonHandler<FunctionDeleteResponse>(clientOptions.jsonMapper)

        override suspend fun delete(
            params: FunctionDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("functionId", params.functionId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "functions", params._pathParam(0))
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val deployHandler: Handler<FunctionDeployResponse> =
            jsonHandler<FunctionDeployResponse>(clientOptions.jsonMapper)

        override suspend fun deploy(
            params: FunctionDeployParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionDeployResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("functionId", params.functionId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "functions", params._pathParam(0), "deploy")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deployHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getDeploymentHandler: Handler<FunctionGetDeploymentResponse> =
            jsonHandler<FunctionGetDeploymentResponse>(clientOptions.jsonMapper)

        override suspend fun getDeployment(
            params: FunctionGetDeploymentParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionGetDeploymentResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("deploymentId", params.deploymentId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "functions", "deployments", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { getDeploymentHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listDeploymentsHandler: Handler<FunctionListDeploymentsResponse> =
            jsonHandler<FunctionListDeploymentsResponse>(clientOptions.jsonMapper)

        override suspend fun listDeployments(
            params: FunctionListDeploymentsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionListDeploymentsResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("functionId", params.functionId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "functions", params._pathParam(0), "deployments")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listDeploymentsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listEventTypesHandler: Handler<FunctionListEventTypesResponse> =
            jsonHandler<FunctionListEventTypesResponse>(clientOptions.jsonMapper)

        override suspend fun listEventTypes(
            params: FunctionListEventTypesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionListEventTypesResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "functions", "event-types")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listEventTypesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val rollbackDeploymentHandler: Handler<FunctionRollbackDeploymentResponse> =
            jsonHandler<FunctionRollbackDeploymentResponse>(clientOptions.jsonMapper)

        override suspend fun rollbackDeployment(
            params: FunctionRollbackDeploymentParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionRollbackDeploymentResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("functionId", params.functionId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "functions", params._pathParam(0), "rollback")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { rollbackDeploymentHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val tailLogsHandler: Handler<FunctionTailLogsResponse> =
            jsonHandler<FunctionTailLogsResponse>(clientOptions.jsonMapper)

        override suspend fun tailLogs(
            params: FunctionTailLogsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionTailLogsResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("functionId", params.functionId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "functions", params._pathParam(0), "logs")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { tailLogsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
