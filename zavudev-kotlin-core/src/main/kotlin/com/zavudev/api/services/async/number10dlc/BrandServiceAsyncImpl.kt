// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.number10dlc

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
import com.zavudev.api.models.number10dlc.brands.BrandCreateParams
import com.zavudev.api.models.number10dlc.brands.BrandCreateResponse
import com.zavudev.api.models.number10dlc.brands.BrandDeleteParams
import com.zavudev.api.models.number10dlc.brands.BrandListPageAsync
import com.zavudev.api.models.number10dlc.brands.BrandListPageResponse
import com.zavudev.api.models.number10dlc.brands.BrandListParams
import com.zavudev.api.models.number10dlc.brands.BrandListUseCasesParams
import com.zavudev.api.models.number10dlc.brands.BrandListUseCasesResponse
import com.zavudev.api.models.number10dlc.brands.BrandRetrieveParams
import com.zavudev.api.models.number10dlc.brands.BrandRetrieveResponse
import com.zavudev.api.models.number10dlc.brands.BrandSubmitParams
import com.zavudev.api.models.number10dlc.brands.BrandSubmitResponse
import com.zavudev.api.models.number10dlc.brands.BrandSyncStatusParams
import com.zavudev.api.models.number10dlc.brands.BrandSyncStatusResponse
import com.zavudev.api.models.number10dlc.brands.BrandUpdateParams
import com.zavudev.api.models.number10dlc.brands.BrandUpdateResponse

class BrandServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BrandServiceAsync {

    private val withRawResponse: BrandServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BrandServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): BrandServiceAsync =
        BrandServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun create(
        params: BrandCreateParams,
        requestOptions: RequestOptions,
    ): BrandCreateResponse =
        // post /v1/10dlc/brands
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: BrandRetrieveParams,
        requestOptions: RequestOptions,
    ): BrandRetrieveResponse =
        // get /v1/10dlc/brands/{brandId}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun update(
        params: BrandUpdateParams,
        requestOptions: RequestOptions,
    ): BrandUpdateResponse =
        // patch /v1/10dlc/brands/{brandId}
        withRawResponse().update(params, requestOptions).parse()

    override suspend fun list(
        params: BrandListParams,
        requestOptions: RequestOptions,
    ): BrandListPageAsync =
        // get /v1/10dlc/brands
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(params: BrandDeleteParams, requestOptions: RequestOptions) {
        // delete /v1/10dlc/brands/{brandId}
        withRawResponse().delete(params, requestOptions)
    }

    override suspend fun listUseCases(
        params: BrandListUseCasesParams,
        requestOptions: RequestOptions,
    ): BrandListUseCasesResponse =
        // get /v1/10dlc/brands/use-cases
        withRawResponse().listUseCases(params, requestOptions).parse()

    override suspend fun submit(
        params: BrandSubmitParams,
        requestOptions: RequestOptions,
    ): BrandSubmitResponse =
        // post /v1/10dlc/brands/{brandId}/submit
        withRawResponse().submit(params, requestOptions).parse()

    override suspend fun syncStatus(
        params: BrandSyncStatusParams,
        requestOptions: RequestOptions,
    ): BrandSyncStatusResponse =
        // post /v1/10dlc/brands/{brandId}/sync
        withRawResponse().syncStatus(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BrandServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): BrandServiceAsync.WithRawResponse =
            BrandServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val createHandler: Handler<BrandCreateResponse> =
            jsonHandler<BrandCreateResponse>(clientOptions.jsonMapper)

        override suspend fun create(
            params: BrandCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BrandCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "10dlc", "brands")
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

        private val retrieveHandler: Handler<BrandRetrieveResponse> =
            jsonHandler<BrandRetrieveResponse>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: BrandRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BrandRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("brandId", params.brandId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "10dlc", "brands", params._pathParam(0))
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

        private val updateHandler: Handler<BrandUpdateResponse> =
            jsonHandler<BrandUpdateResponse>(clientOptions.jsonMapper)

        override suspend fun update(
            params: BrandUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BrandUpdateResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("brandId", params.brandId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "10dlc", "brands", params._pathParam(0))
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

        private val listHandler: Handler<BrandListPageResponse> =
            jsonHandler<BrandListPageResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: BrandListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BrandListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "10dlc", "brands")
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
                        BrandListPageAsync.builder()
                            .service(BrandServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override suspend fun delete(
            params: BrandDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("brandId", params.brandId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "10dlc", "brands", params._pathParam(0))
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val listUseCasesHandler: Handler<BrandListUseCasesResponse> =
            jsonHandler<BrandListUseCasesResponse>(clientOptions.jsonMapper)

        override suspend fun listUseCases(
            params: BrandListUseCasesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BrandListUseCasesResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "10dlc", "brands", "use-cases")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listUseCasesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val submitHandler: Handler<BrandSubmitResponse> =
            jsonHandler<BrandSubmitResponse>(clientOptions.jsonMapper)

        override suspend fun submit(
            params: BrandSubmitParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BrandSubmitResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("brandId", params.brandId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "10dlc", "brands", params._pathParam(0), "submit")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { submitHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val syncStatusHandler: Handler<BrandSyncStatusResponse> =
            jsonHandler<BrandSyncStatusResponse>(clientOptions.jsonMapper)

        override suspend fun syncStatus(
            params: BrandSyncStatusParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BrandSyncStatusResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("brandId", params.brandId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "10dlc", "brands", params._pathParam(0), "sync")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { syncStatusHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
