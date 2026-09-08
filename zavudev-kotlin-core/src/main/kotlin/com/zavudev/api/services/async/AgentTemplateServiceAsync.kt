// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.agenttemplates.AgentTemplateListParams
import com.zavudev.api.models.agenttemplates.AgentTemplateListResponse
import com.zavudev.api.models.agenttemplates.AgentTemplateRetrieveParams
import com.zavudev.api.models.agenttemplates.AgentTemplateRetrieveResponse

interface AgentTemplateServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): AgentTemplateServiceAsync

    /**
     * Fetch a single factory agent fully rendered: the function files to scaffold (an `index.ts`
     * that declares the agent with `defineAgent` and its skills with `defineTool`) plus the secrets
     * it needs. This is what `npx zavudev agents pull <id>` writes to disk before `npx zavudev
     * deploy`.
     */
    suspend fun retrieve(
        templateId: String,
        params: AgentTemplateRetrieveParams = AgentTemplateRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentTemplateRetrieveResponse =
        retrieve(params.toBuilder().templateId(templateId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: AgentTemplateRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentTemplateRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(
        templateId: String,
        requestOptions: RequestOptions,
    ): AgentTemplateRetrieveResponse =
        retrieve(templateId, AgentTemplateRetrieveParams.none(), requestOptions)

    /**
     * List the factory agents available to scaffold with `npx zavudev agents pull`. Each entry is a
     * ready-made voice or text agent (system prompt, skills, and — for voice agents — a co-located
     * voice config).
     */
    suspend fun list(
        params: AgentTemplateListParams = AgentTemplateListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AgentTemplateListResponse

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): AgentTemplateListResponse =
        list(AgentTemplateListParams.none(), requestOptions)

    /**
     * A view of [AgentTemplateServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): AgentTemplateServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/agent-templates/{templateId}`, but is otherwise
         * the same as [AgentTemplateServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            templateId: String,
            params: AgentTemplateRetrieveParams = AgentTemplateRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentTemplateRetrieveResponse> =
            retrieve(params.toBuilder().templateId(templateId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: AgentTemplateRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentTemplateRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            templateId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentTemplateRetrieveResponse> =
            retrieve(templateId, AgentTemplateRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/agent-templates`, but is otherwise the same as
         * [AgentTemplateServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: AgentTemplateListParams = AgentTemplateListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AgentTemplateListResponse>

        /** @see list */
        @MustBeClosed
        suspend fun list(
            requestOptions: RequestOptions
        ): HttpResponseFor<AgentTemplateListResponse> =
            list(AgentTemplateListParams.none(), requestOptions)
    }
}
