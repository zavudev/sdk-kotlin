// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async.broadcasts

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
import com.zavudev.api.models.broadcasts.contacts.ContactAddParams
import com.zavudev.api.models.broadcasts.contacts.ContactAddResponse
import com.zavudev.api.models.broadcasts.contacts.ContactListPageAsync
import com.zavudev.api.models.broadcasts.contacts.ContactListPageResponse
import com.zavudev.api.models.broadcasts.contacts.ContactListParams
import com.zavudev.api.models.broadcasts.contacts.ContactRemoveParams

class ContactServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ContactServiceAsync {

    private val withRawResponse: ContactServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ContactServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ContactServiceAsync =
        ContactServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun list(
        params: ContactListParams,
        requestOptions: RequestOptions,
    ): ContactListPageAsync =
        // get /v1/broadcasts/{broadcastId}/contacts
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun add(
        params: ContactAddParams,
        requestOptions: RequestOptions,
    ): ContactAddResponse =
        // post /v1/broadcasts/{broadcastId}/contacts
        withRawResponse().add(params, requestOptions).parse()

    override suspend fun remove(params: ContactRemoveParams, requestOptions: RequestOptions) {
        // delete /v1/broadcasts/{broadcastId}/contacts/{contactId}
        withRawResponse().remove(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ContactServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ContactServiceAsync.WithRawResponse =
            ContactServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val listHandler: Handler<ContactListPageResponse> =
            jsonHandler<ContactListPageResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: ContactListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContactListPageAsync> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("broadcastId", params.broadcastId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "broadcasts", params._pathParam(0), "contacts")
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
                        ContactListPageAsync.builder()
                            .service(ContactServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val addHandler: Handler<ContactAddResponse> =
            jsonHandler<ContactAddResponse>(clientOptions.jsonMapper)

        override suspend fun add(
            params: ContactAddParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ContactAddResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("broadcastId", params.broadcastId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "broadcasts", params._pathParam(0), "contacts")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { addHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val removeHandler: Handler<Void?> = emptyHandler()

        override suspend fun remove(
            params: ContactRemoveParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("contactId", params.contactId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "v1",
                        "broadcasts",
                        params._pathParam(0),
                        "contacts",
                        params._pathParam(1),
                    )
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { removeHandler.handle(it) }
            }
        }
    }
}
