// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.functions

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
import com.zavudev.api.models.functions.gitlink.GitLinkDeployNowParams
import com.zavudev.api.models.functions.gitlink.GitLinkDeployNowResponse
import com.zavudev.api.models.functions.gitlink.GitLinkLinkParams
import com.zavudev.api.models.functions.gitlink.GitLinkLinkResponse
import com.zavudev.api.models.functions.gitlink.GitLinkRetrieveParams
import com.zavudev.api.models.functions.gitlink.GitLinkRetrieveResponse
import com.zavudev.api.models.functions.gitlink.GitLinkUnlinkParams
import com.zavudev.api.models.functions.gitlink.GitLinkUpdateParams
import com.zavudev.api.models.functions.gitlink.GitLinkUpdateResponse

class GitLinkServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    GitLinkServiceAsync {

    private val withRawResponse: GitLinkServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): GitLinkServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): GitLinkServiceAsync =
        GitLinkServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun retrieve(
        params: GitLinkRetrieveParams,
        requestOptions: RequestOptions,
    ): GitLinkRetrieveResponse =
        // get /v1/functions/{functionId}/git-link
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(
        params: GitLinkUpdateParams,
        requestOptions: RequestOptions,
    ): GitLinkUpdateResponse =
        // patch /v1/functions/{functionId}/git-link
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun deployNow(
        params: GitLinkDeployNowParams,
        requestOptions: RequestOptions,
    ): GitLinkDeployNowResponse =
        // post /v1/functions/{functionId}/git-link/deploy
        withRawResponse().deployNow(params, requestOptions).parse()

    override suspend fun link(
        params: GitLinkLinkParams,
        requestOptions: RequestOptions,
    ): GitLinkLinkResponse =
        // post /v1/functions/{functionId}/git-link
        withRawResponse().link(params, requestOptions).parse()

    override suspend fun unlink(params: GitLinkUnlinkParams, requestOptions: RequestOptions) {
        // delete /v1/functions/{functionId}/git-link
        withRawResponse().unlink(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GitLinkServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): GitLinkServiceAsync.WithRawResponse =
            GitLinkServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val retrieveHandler: Handler<GitLinkRetrieveResponse> =
            jsonHandler<GitLinkRetrieveResponse>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: GitLinkRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GitLinkRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("functionId", params.functionId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "functions", params._pathParam(0), "git-link")
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

        private val updateHandler: Handler<GitLinkUpdateResponse> =
            jsonHandler<GitLinkUpdateResponse>(clientOptions.jsonMapper)

        override suspend fun update(
            params: GitLinkUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GitLinkUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("functionId", params.functionId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "functions", params._pathParam(0), "git-link")
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

        private val deployNowHandler: Handler<GitLinkDeployNowResponse> =
            jsonHandler<GitLinkDeployNowResponse>(clientOptions.jsonMapper)

        override suspend fun deployNow(
            params: GitLinkDeployNowParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GitLinkDeployNowResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("functionId", params.functionId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "functions", params._pathParam(0), "git-link", "deploy")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deployNowHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val linkHandler: Handler<GitLinkLinkResponse> =
            jsonHandler<GitLinkLinkResponse>(clientOptions.jsonMapper)

        override suspend fun link(
            params: GitLinkLinkParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GitLinkLinkResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("functionId", params.functionId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "functions", params._pathParam(0), "git-link")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { linkHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val unlinkHandler: Handler<Void?> = emptyHandler()

        override suspend fun unlink(
            params: GitLinkUnlinkParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("functionId", params.functionId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "functions", params._pathParam(0), "git-link")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { unlinkHandler.handle(it) }
            }
        }
    }
}
