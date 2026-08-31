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
import com.zavudev.api.models.emaildomains.EmailDomainCreateParams
import com.zavudev.api.models.emaildomains.EmailDomainCreateResponse
import com.zavudev.api.models.emaildomains.EmailDomainDeleteParams
import com.zavudev.api.models.emaildomains.EmailDomainListParams
import com.zavudev.api.models.emaildomains.EmailDomainListResponse
import com.zavudev.api.models.emaildomains.EmailDomainRetrieveParams
import com.zavudev.api.models.emaildomains.EmailDomainRetrieveResponse
import com.zavudev.api.models.emaildomains.EmailDomainVerifyParams
import com.zavudev.api.models.emaildomains.EmailDomainVerifyResponse

class EmailDomainServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    EmailDomainServiceAsync {

    private val withRawResponse: EmailDomainServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): EmailDomainServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): EmailDomainServiceAsync =
        EmailDomainServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun create(
        params: EmailDomainCreateParams,
        requestOptions: RequestOptions,
    ): EmailDomainCreateResponse =
        // post /v1/email-domains
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: EmailDomainRetrieveParams,
        requestOptions: RequestOptions,
    ): EmailDomainRetrieveResponse =
        // get /v1/email-domains/{domainId}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun list(
        params: EmailDomainListParams,
        requestOptions: RequestOptions,
    ): EmailDomainListResponse =
        // get /v1/email-domains
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(params: EmailDomainDeleteParams, requestOptions: RequestOptions) {
        // delete /v1/email-domains/{domainId}
        withRawResponse().delete(params, requestOptions)
    }

    override suspend fun verify(
        params: EmailDomainVerifyParams,
        requestOptions: RequestOptions,
    ): EmailDomainVerifyResponse =
        // post /v1/email-domains/{domainId}/verify
        withRawResponse().verify(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        EmailDomainServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): EmailDomainServiceAsync.WithRawResponse =
            EmailDomainServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val createHandler: Handler<EmailDomainCreateResponse> =
            jsonHandler<EmailDomainCreateResponse>(clientOptions.jsonMapper)

        override suspend fun create(
            params: EmailDomainCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EmailDomainCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "email-domains")
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

        private val retrieveHandler: Handler<EmailDomainRetrieveResponse> =
            jsonHandler<EmailDomainRetrieveResponse>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: EmailDomainRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EmailDomainRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("domainId", params.domainId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "email-domains", params._pathParam(0))
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

        private val listHandler: Handler<EmailDomainListResponse> =
            jsonHandler<EmailDomainListResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: EmailDomainListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EmailDomainListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "email-domains")
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

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override suspend fun delete(
            params: EmailDomainDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("domainId", params.domainId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "email-domains", params._pathParam(0))
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val verifyHandler: Handler<EmailDomainVerifyResponse> =
            jsonHandler<EmailDomainVerifyResponse>(clientOptions.jsonMapper)

        override suspend fun verify(
            params: EmailDomainVerifyParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EmailDomainVerifyResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("domainId", params.domainId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "email-domains", params._pathParam(0), "verify")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { verifyHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
