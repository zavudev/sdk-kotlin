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
import com.zavudev.api.models.phonenumbers.PhoneNumberListPageAsync
import com.zavudev.api.models.phonenumbers.PhoneNumberListPageResponse
import com.zavudev.api.models.phonenumbers.PhoneNumberListParams
import com.zavudev.api.models.phonenumbers.PhoneNumberPurchaseParams
import com.zavudev.api.models.phonenumbers.PhoneNumberPurchaseResponse
import com.zavudev.api.models.phonenumbers.PhoneNumberReleaseParams
import com.zavudev.api.models.phonenumbers.PhoneNumberRequirementsParams
import com.zavudev.api.models.phonenumbers.PhoneNumberRequirementsResponse
import com.zavudev.api.models.phonenumbers.PhoneNumberRetrieveParams
import com.zavudev.api.models.phonenumbers.PhoneNumberRetrieveResponse
import com.zavudev.api.models.phonenumbers.PhoneNumberSearchAvailableParams
import com.zavudev.api.models.phonenumbers.PhoneNumberSearchAvailableResponse
import com.zavudev.api.models.phonenumbers.PhoneNumberUpdateParams
import com.zavudev.api.models.phonenumbers.PhoneNumberUpdateResponse

class PhoneNumberServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    PhoneNumberServiceAsync {

    private val withRawResponse: PhoneNumberServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PhoneNumberServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): PhoneNumberServiceAsync =
        PhoneNumberServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun retrieve(
        params: PhoneNumberRetrieveParams,
        requestOptions: RequestOptions,
    ): PhoneNumberRetrieveResponse =
        // get /v1/phone-numbers/{phoneNumberId}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(
        params: PhoneNumberUpdateParams,
        requestOptions: RequestOptions,
    ): PhoneNumberUpdateResponse =
        // patch /v1/phone-numbers/{phoneNumberId}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: PhoneNumberListParams,
        requestOptions: RequestOptions,
    ): PhoneNumberListPageAsync =
        // get /v1/phone-numbers
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun purchase(
        params: PhoneNumberPurchaseParams,
        requestOptions: RequestOptions,
    ): PhoneNumberPurchaseResponse =
        // post /v1/phone-numbers
        withRawResponse().purchase(params, requestOptions).parse()

    override suspend fun release(params: PhoneNumberReleaseParams, requestOptions: RequestOptions) {
        // delete /v1/phone-numbers/{phoneNumberId}
        withRawResponse().release(params, requestOptions)
    }

    override suspend fun requirements(
        params: PhoneNumberRequirementsParams,
        requestOptions: RequestOptions,
    ): PhoneNumberRequirementsResponse =
        // get /v1/phone-numbers/requirements
        withRawResponse().requirements(params, requestOptions).parse()

    override suspend fun searchAvailable(
        params: PhoneNumberSearchAvailableParams,
        requestOptions: RequestOptions,
    ): PhoneNumberSearchAvailableResponse =
        // get /v1/phone-numbers/available
        withRawResponse().searchAvailable(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PhoneNumberServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): PhoneNumberServiceAsync.WithRawResponse =
            PhoneNumberServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val retrieveHandler: Handler<PhoneNumberRetrieveResponse> =
            jsonHandler<PhoneNumberRetrieveResponse>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: PhoneNumberRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PhoneNumberRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("phoneNumberId", params.phoneNumberId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "phone-numbers", params._pathParam(0))
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

        private val updateHandler: Handler<PhoneNumberUpdateResponse> =
            jsonHandler<PhoneNumberUpdateResponse>(clientOptions.jsonMapper)

        override suspend fun update(
            params: PhoneNumberUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PhoneNumberUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("phoneNumberId", params.phoneNumberId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "phone-numbers", params._pathParam(0))
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

        private val listHandler: Handler<PhoneNumberListPageResponse> =
            jsonHandler<PhoneNumberListPageResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: PhoneNumberListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PhoneNumberListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "phone-numbers")
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
                        PhoneNumberListPageAsync.builder()
                            .service(PhoneNumberServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val purchaseHandler: Handler<PhoneNumberPurchaseResponse> =
            jsonHandler<PhoneNumberPurchaseResponse>(clientOptions.jsonMapper)

        override suspend fun purchase(
            params: PhoneNumberPurchaseParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PhoneNumberPurchaseResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "phone-numbers")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { purchaseHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val releaseHandler: Handler<Void?> = emptyHandler()

        override suspend fun release(
            params: PhoneNumberReleaseParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("phoneNumberId", params.phoneNumberId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "phone-numbers", params._pathParam(0))
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { releaseHandler.handle(it) }
            }
        }

        private val requirementsHandler: Handler<PhoneNumberRequirementsResponse> =
            jsonHandler<PhoneNumberRequirementsResponse>(clientOptions.jsonMapper)

        override suspend fun requirements(
            params: PhoneNumberRequirementsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PhoneNumberRequirementsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "phone-numbers", "requirements")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { requirementsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val searchAvailableHandler: Handler<PhoneNumberSearchAvailableResponse> =
            jsonHandler<PhoneNumberSearchAvailableResponse>(clientOptions.jsonMapper)

        override suspend fun searchAvailable(
            params: PhoneNumberSearchAvailableParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PhoneNumberSearchAvailableResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "phone-numbers", "available")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { searchAvailableHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
