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
import com.zavudev.api.models.messages.MessageListAttachmentsParams
import com.zavudev.api.models.messages.MessageListAttachmentsResponse
import com.zavudev.api.models.messages.MessageListPageAsync
import com.zavudev.api.models.messages.MessageListPageResponse
import com.zavudev.api.models.messages.MessageListParams
import com.zavudev.api.models.messages.MessageReactParams
import com.zavudev.api.models.messages.MessageResponse
import com.zavudev.api.models.messages.MessageRetrieveParams
import com.zavudev.api.models.messages.MessageSendParams
import com.zavudev.api.models.messages.MessageShowTypingParams
import com.zavudev.api.models.messages.MessageShowTypingResponse

class MessageServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    MessageServiceAsync {

    private val withRawResponse: MessageServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MessageServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): MessageServiceAsync =
        MessageServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun retrieve(
        params: MessageRetrieveParams,
        requestOptions: RequestOptions,
    ): MessageResponse =
        // get /v1/messages/{messageId}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun list(
        params: MessageListParams,
        requestOptions: RequestOptions,
    ): MessageListPageAsync =
        // get /v1/messages
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun listAttachments(
        params: MessageListAttachmentsParams,
        requestOptions: RequestOptions,
    ): MessageListAttachmentsResponse =
        // get /v1/messages/{messageId}/attachments
        withRawResponse().listAttachments(params, requestOptions).parse()

    override suspend fun react(
        params: MessageReactParams,
        requestOptions: RequestOptions,
    ): MessageResponse =
        // post /v1/messages/{messageId}/reactions
        withRawResponse().react(params, requestOptions).parse()

    override suspend fun send(
        params: MessageSendParams,
        requestOptions: RequestOptions,
    ): MessageResponse =
        // post /v1/messages
        withRawResponse().send(params, requestOptions).parse()

    override suspend fun showTyping(
        params: MessageShowTypingParams,
        requestOptions: RequestOptions,
    ): MessageShowTypingResponse =
        // post /v1/messages/{messageId}/typing
        withRawResponse().showTyping(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MessageServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): MessageServiceAsync.WithRawResponse =
            MessageServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val retrieveHandler: Handler<MessageResponse> =
            jsonHandler<MessageResponse>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: MessageRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("messageId", params.messageId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "messages", params._pathParam(0))
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

        private val listHandler: Handler<MessageListPageResponse> =
            jsonHandler<MessageListPageResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: MessageListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListPageAsync> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "messages")
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
                        MessageListPageAsync.builder()
                            .service(MessageServiceAsyncImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val listAttachmentsHandler: Handler<MessageListAttachmentsResponse> =
            jsonHandler<MessageListAttachmentsResponse>(clientOptions.jsonMapper)

        override suspend fun listAttachments(
            params: MessageListAttachmentsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListAttachmentsResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("messageId", params.messageId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "messages", params._pathParam(0), "attachments")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listAttachmentsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val reactHandler: Handler<MessageResponse> =
            jsonHandler<MessageResponse>(clientOptions.jsonMapper)

        override suspend fun react(
            params: MessageReactParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("messageId", params.messageId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "messages", params._pathParam(0), "reactions")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { reactHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val sendHandler: Handler<MessageResponse> =
            jsonHandler<MessageResponse>(clientOptions.jsonMapper)

        override suspend fun send(
            params: MessageSendParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "messages")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { sendHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val showTypingHandler: Handler<MessageShowTypingResponse> =
            jsonHandler<MessageShowTypingResponse>(clientOptions.jsonMapper)

        override suspend fun showTyping(
            params: MessageShowTypingParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageShowTypingResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("messageId", params.messageId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "messages", params._pathParam(0), "typing")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { showTypingHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
