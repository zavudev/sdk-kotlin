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
import com.zavudev.api.models.urls.UrlEscalateParams
import com.zavudev.api.models.urls.UrlEscalateResponse
import com.zavudev.api.models.urls.UrlListVerifiedPageAsync
import com.zavudev.api.models.urls.UrlListVerifiedPageResponse
import com.zavudev.api.models.urls.UrlListVerifiedParams
import com.zavudev.api.models.urls.UrlRetrieveDetailsParams
import com.zavudev.api.models.urls.UrlRetrieveDetailsResponse
import com.zavudev.api.models.urls.UrlSubmitForVerificationParams
import com.zavudev.api.models.urls.UrlSubmitForVerificationResponse

class UrlServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    UrlServiceAsync {

    private val withRawResponse: UrlServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): UrlServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): UrlServiceAsync =
        UrlServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun escalate(
        params: UrlEscalateParams,
        requestOptions: RequestOptions,
    ): UrlEscalateResponse =
        // post /v1/urls/{urlId}/escalate
        withRawResponse().escalate(params, requestOptions).parse()

    override suspend fun listVerified(
        params: UrlListVerifiedParams,
        requestOptions: RequestOptions,
    ): UrlListVerifiedPageAsync =
        // get /v1/urls
        withRawResponse().listVerified(params, requestOptions).parse()

    override suspend fun retrieveDetails(
        params: UrlRetrieveDetailsParams,
        requestOptions: RequestOptions,
    ): UrlRetrieveDetailsResponse =
        // get /v1/urls/{urlId}
        withRawResponse().retrieveDetails(params, requestOptions).parse()

    override suspend fun submitForVerification(
        params: UrlSubmitForVerificationParams,
        requestOptions: RequestOptions,
    ): UrlSubmitForVerificationResponse =
        // post /v1/urls
        withRawResponse().submitForVerification(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        UrlServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): UrlServiceAsync.WithRawResponse =
            UrlServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val escalateHandler: Handler<UrlEscalateResponse> =
            jsonHandler<UrlEscalateResponse>(clientOptions.jsonMapper)

        override suspend fun escalate(
            params: UrlEscalateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UrlEscalateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("urlId", params.urlId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "urls", params._pathParam(0), "escalate")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { escalateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listVerifiedHandler: Handler<UrlListVerifiedPageResponse> =
            jsonHandler<UrlListVerifiedPageResponse>(clientOptions.jsonMapper)

        override suspend fun listVerified(
            params: UrlListVerifiedParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UrlListVerifiedPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "urls")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listVerifiedHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        UrlListVerifiedPageAsync.builder()
                            .service(UrlServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val retrieveDetailsHandler: Handler<UrlRetrieveDetailsResponse> =
            jsonHandler<UrlRetrieveDetailsResponse>(clientOptions.jsonMapper)

        override suspend fun retrieveDetails(
            params: UrlRetrieveDetailsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UrlRetrieveDetailsResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("urlId", params.urlId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "urls", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveDetailsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val submitForVerificationHandler: Handler<UrlSubmitForVerificationResponse> =
            jsonHandler<UrlSubmitForVerificationResponse>(clientOptions.jsonMapper)

        override suspend fun submitForVerification(
            params: UrlSubmitForVerificationParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UrlSubmitForVerificationResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "urls")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { submitForVerificationHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
