// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.number10dlc.campaigns

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
import com.zavudev.api.models.number10dlc.campaigns.phonenumbers.PhoneNumberAssignParams
import com.zavudev.api.models.number10dlc.campaigns.phonenumbers.PhoneNumberAssignResponse
import com.zavudev.api.models.number10dlc.campaigns.phonenumbers.PhoneNumberListParams
import com.zavudev.api.models.number10dlc.campaigns.phonenumbers.PhoneNumberListResponse
import com.zavudev.api.models.number10dlc.campaigns.phonenumbers.PhoneNumberUnassignParams

class PhoneNumberServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    PhoneNumberServiceAsync {

    private val withRawResponse: PhoneNumberServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PhoneNumberServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): PhoneNumberServiceAsync =
        PhoneNumberServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun list(
        params: PhoneNumberListParams,
        requestOptions: RequestOptions,
    ): PhoneNumberListResponse =
        // get /v1/10dlc/campaigns/{campaignId}/phone-numbers
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun assign(
        params: PhoneNumberAssignParams,
        requestOptions: RequestOptions,
    ): PhoneNumberAssignResponse =
        // post /v1/10dlc/campaigns/{campaignId}/phone-numbers
        withRawResponse().assign(params, requestOptions).parse()

    override suspend fun unassign(
        params: PhoneNumberUnassignParams,
        requestOptions: RequestOptions,
    ) {
        // delete /v1/10dlc/campaigns/{campaignId}/phone-numbers/{assignmentId}
        withRawResponse().unassign(params, requestOptions)
    }

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

        private val listHandler: Handler<PhoneNumberListResponse> =
            jsonHandler<PhoneNumberListResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: PhoneNumberListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PhoneNumberListResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("campaignId", params.campaignId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "10dlc",
                        "campaigns",
                        params._pathParam(0),
                        "phone-numbers",
                    )
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

        private val assignHandler: Handler<PhoneNumberAssignResponse> =
            jsonHandler<PhoneNumberAssignResponse>(clientOptions.jsonMapper)

        override suspend fun assign(
            params: PhoneNumberAssignParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PhoneNumberAssignResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("campaignId", params.campaignId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "10dlc",
                        "campaigns",
                        params._pathParam(0),
                        "phone-numbers",
                    )
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { assignHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val unassignHandler: Handler<Void?> = emptyHandler()

        override suspend fun unassign(
            params: PhoneNumberUnassignParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("assignmentId", params.assignmentId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "10dlc",
                        "campaigns",
                        params._pathParam(0),
                        "phone-numbers",
                        params._pathParam(1),
                    )
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { unassignHandler.handle(it) }
            }
        }
    }
}
