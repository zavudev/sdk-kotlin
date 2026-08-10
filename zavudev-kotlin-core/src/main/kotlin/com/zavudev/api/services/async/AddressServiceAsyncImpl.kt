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
import com.zavudev.api.models.addresses.AddressCreateParams
import com.zavudev.api.models.addresses.AddressCreateResponse
import com.zavudev.api.models.addresses.AddressDeleteParams
import com.zavudev.api.models.addresses.AddressListPageAsync
import com.zavudev.api.models.addresses.AddressListPageResponse
import com.zavudev.api.models.addresses.AddressListParams
import com.zavudev.api.models.addresses.AddressRetrieveParams
import com.zavudev.api.models.addresses.AddressRetrieveResponse

class AddressServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AddressServiceAsync {

    private val withRawResponse: AddressServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): AddressServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): AddressServiceAsync =
        AddressServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun create(
        params: AddressCreateParams,
        requestOptions: RequestOptions,
    ): AddressCreateResponse =
        // post /v1/addresses
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: AddressRetrieveParams,
        requestOptions: RequestOptions,
    ): AddressRetrieveResponse =
        // get /v1/addresses/{addressId}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun list(
        params: AddressListParams,
        requestOptions: RequestOptions,
    ): AddressListPageAsync =
        // get /v1/addresses
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(params: AddressDeleteParams, requestOptions: RequestOptions) {
        // delete /v1/addresses/{addressId}
        withRawResponse().delete(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AddressServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): AddressServiceAsync.WithRawResponse =
            AddressServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val createHandler: Handler<AddressCreateResponse> =
            jsonHandler<AddressCreateResponse>(clientOptions.jsonMapper)

        override suspend fun create(
            params: AddressCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AddressCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "addresses")
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

        private val retrieveHandler: Handler<AddressRetrieveResponse> =
            jsonHandler<AddressRetrieveResponse>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: AddressRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AddressRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("addressId", params.addressId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "addresses", params._pathParam(0))
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

        private val listHandler: Handler<AddressListPageResponse> =
            jsonHandler<AddressListPageResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: AddressListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AddressListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "addresses")
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
                        AddressListPageAsync.builder()
                            .service(AddressServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override suspend fun delete(
            params: AddressDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("addressId", params.addressId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "addresses", params._pathParam(0))
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }
    }
}
