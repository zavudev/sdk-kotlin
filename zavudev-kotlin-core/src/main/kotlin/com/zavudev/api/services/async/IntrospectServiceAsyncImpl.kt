// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
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
import com.zavudev.api.models.introspect.IntrospectValidateEmailParams
import com.zavudev.api.models.introspect.IntrospectValidateEmailResponse
import com.zavudev.api.models.introspect.IntrospectValidatePhoneParams
import com.zavudev.api.models.introspect.IntrospectValidatePhoneResponse

class IntrospectServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    IntrospectServiceAsync {

    private val withRawResponse: IntrospectServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): IntrospectServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): IntrospectServiceAsync =
        IntrospectServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun validateEmail(
        params: IntrospectValidateEmailParams,
        requestOptions: RequestOptions,
    ): IntrospectValidateEmailResponse =
        // post /v1/introspect/email
        withRawResponse().validateEmail(params, requestOptions).parse()

    override suspend fun validatePhone(
        params: IntrospectValidatePhoneParams,
        requestOptions: RequestOptions,
    ): IntrospectValidatePhoneResponse =
        // post /v1/introspect/phone
        withRawResponse().validatePhone(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        IntrospectServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): IntrospectServiceAsync.WithRawResponse =
            IntrospectServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val validateEmailHandler: Handler<IntrospectValidateEmailResponse> =
            jsonHandler<IntrospectValidateEmailResponse>(clientOptions.jsonMapper)

        override suspend fun validateEmail(
            params: IntrospectValidateEmailParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<IntrospectValidateEmailResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "introspect", "email")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { validateEmailHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val validatePhoneHandler: Handler<IntrospectValidatePhoneResponse> =
            jsonHandler<IntrospectValidatePhoneResponse>(clientOptions.jsonMapper)

        override suspend fun validatePhone(
            params: IntrospectValidatePhoneParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<IntrospectValidatePhoneResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "introspect", "phone")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { validatePhoneHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
