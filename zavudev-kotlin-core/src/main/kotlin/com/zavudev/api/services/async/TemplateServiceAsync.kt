// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.templates.Template
import com.zavudev.api.models.templates.TemplateCreateParams
import com.zavudev.api.models.templates.TemplateDeleteParams
import com.zavudev.api.models.templates.TemplateListPageAsync
import com.zavudev.api.models.templates.TemplateListParams
import com.zavudev.api.models.templates.TemplateRetrieveParams
import com.zavudev.api.models.templates.TemplateSubmitParams

interface TemplateServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): TemplateServiceAsync

    /** Create a WhatsApp message template. Note: Templates must be approved by Meta before use. */
    suspend fun create(
        params: TemplateCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Template

    /** Get template */
    suspend fun retrieve(
        templateId: String,
        params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Template = retrieve(params.toBuilder().templateId(templateId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: TemplateRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Template

    /** @see retrieve */
    suspend fun retrieve(templateId: String, requestOptions: RequestOptions): Template =
        retrieve(templateId, TemplateRetrieveParams.none(), requestOptions)

    /** List WhatsApp message templates for this project. */
    suspend fun list(
        params: TemplateListParams = TemplateListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TemplateListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): TemplateListPageAsync =
        list(TemplateListParams.none(), requestOptions)

    /** Delete template */
    suspend fun delete(
        templateId: String,
        params: TemplateDeleteParams = TemplateDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().templateId(templateId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: TemplateDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(templateId: String, requestOptions: RequestOptions) =
        delete(templateId, TemplateDeleteParams.none(), requestOptions)

    /**
     * Submit a WhatsApp template to Meta for approval. The template must be in draft status and
     * associated with a sender that has a WhatsApp Business Account configured.
     */
    suspend fun submit(
        templateId: String,
        params: TemplateSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Template = submit(params.toBuilder().templateId(templateId).build(), requestOptions)

    /** @see submit */
    suspend fun submit(
        params: TemplateSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Template

    /**
     * A view of [TemplateServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): TemplateServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/templates`, but is otherwise the same as
         * [TemplateServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: TemplateCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Template>

        /**
         * Returns a raw HTTP response for `get /v1/templates/{templateId}`, but is otherwise the
         * same as [TemplateServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            templateId: String,
            params: TemplateRetrieveParams = TemplateRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Template> =
            retrieve(params.toBuilder().templateId(templateId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: TemplateRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Template>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            templateId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Template> =
            retrieve(templateId, TemplateRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/templates`, but is otherwise the same as
         * [TemplateServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: TemplateListParams = TemplateListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TemplateListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<TemplateListPageAsync> =
            list(TemplateListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/templates/{templateId}`, but is otherwise the
         * same as [TemplateServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            templateId: String,
            params: TemplateDeleteParams = TemplateDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().templateId(templateId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: TemplateDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(templateId: String, requestOptions: RequestOptions): HttpResponse =
            delete(templateId, TemplateDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/templates/{templateId}/submit`, but is
         * otherwise the same as [TemplateServiceAsync.submit].
         */
        @MustBeClosed
        suspend fun submit(
            templateId: String,
            params: TemplateSubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Template> =
            submit(params.toBuilder().templateId(templateId).build(), requestOptions)

        /** @see submit */
        @MustBeClosed
        suspend fun submit(
            params: TemplateSubmitParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Template>
    }
}
