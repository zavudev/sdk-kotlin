// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.functions.FunctionCreateParams
import com.zavudev.api.models.functions.FunctionCreateResponse
import com.zavudev.api.models.functions.FunctionDeleteParams
import com.zavudev.api.models.functions.FunctionDeleteResponse
import com.zavudev.api.models.functions.FunctionDeployParams
import com.zavudev.api.models.functions.FunctionDeployResponse
import com.zavudev.api.models.functions.FunctionGetDeploymentParams
import com.zavudev.api.models.functions.FunctionGetDeploymentResponse
import com.zavudev.api.models.functions.FunctionRetrieveParams
import com.zavudev.api.models.functions.FunctionRetrieveResponse
import com.zavudev.api.models.functions.FunctionTailLogsParams
import com.zavudev.api.models.functions.FunctionTailLogsResponse
import com.zavudev.api.models.functions.FunctionUpdateParams
import com.zavudev.api.models.functions.FunctionUpdateResponse
import com.zavudev.api.services.async.functions.SecretServiceAsync

interface FunctionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): FunctionServiceAsync

    fun secrets(): SecretServiceAsync

    /**
     * Create a new Zavu Function. The function starts in `draft` status. A dedicated API key is
     * auto-provisioned and injected as the `ZAVU_API_KEY` secret so the function can call back into
     * the Zavu API without manual setup.
     *
     * Provide `sourceCode` to seed the draft. Call `POST /v1/functions/{functionId}/deploy`
     * afterwards to publish.
     */
    suspend fun create(
        params: FunctionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionCreateResponse

    /** Get function */
    suspend fun retrieve(
        functionId: String,
        params: FunctionRetrieveParams = FunctionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionRetrieveResponse =
        retrieve(params.toBuilder().functionId(functionId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: FunctionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(
        functionId: String,
        requestOptions: RequestOptions,
    ): FunctionRetrieveResponse =
        retrieve(functionId, FunctionRetrieveParams.none(), requestOptions)

    /**
     * Update an existing function. `sourceCode` / `dependencies` edit the draft without triggering
     * a build — they go live on the next `POST /v1/functions/{functionId}/deploy`. `httpEnabled` is
     * applied to the deployed function immediately, so turning the public endpoint on or off does
     * not require a redeploy.
     */
    suspend fun update(
        functionId: String,
        params: FunctionUpdateParams = FunctionUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionUpdateResponse =
        update(params.toBuilder().functionId(functionId).build(), requestOptions)

    /** @see update */
    suspend fun update(
        params: FunctionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionUpdateResponse

    /** @see update */
    suspend fun update(functionId: String, requestOptions: RequestOptions): FunctionUpdateResponse =
        update(functionId, FunctionUpdateParams.none(), requestOptions)

    /**
     * Permanently delete a function and cascade: triggers, secrets, deployment history, managed
     * agents+tools, and revoke the auto-provisioned API key. The AWS Lambda + log group are torn
     * down asynchronously.
     */
    suspend fun delete(
        functionId: String,
        params: FunctionDeleteParams = FunctionDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionDeleteResponse =
        delete(params.toBuilder().functionId(functionId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: FunctionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionDeleteResponse

    /** @see delete */
    suspend fun delete(functionId: String, requestOptions: RequestOptions): FunctionDeleteResponse =
        delete(functionId, FunctionDeleteParams.none(), requestOptions)

    /**
     * Publish the function. If `sourceCode` or `dependencies` are provided in the body, they
     * replace the current draft before deployment. Returns immediately with a deployment ID — poll
     * `GET /v1/functions/deployments/{deploymentId}` until status is `active` or `failed`.
     */
    suspend fun deploy(
        functionId: String,
        params: FunctionDeployParams = FunctionDeployParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionDeployResponse =
        deploy(params.toBuilder().functionId(functionId).build(), requestOptions)

    /** @see deploy */
    suspend fun deploy(
        params: FunctionDeployParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionDeployResponse

    /** @see deploy */
    suspend fun deploy(functionId: String, requestOptions: RequestOptions): FunctionDeployResponse =
        deploy(functionId, FunctionDeployParams.none(), requestOptions)

    /** Fetch a deployment to poll its status during a deploy. */
    suspend fun getDeployment(
        deploymentId: String,
        params: FunctionGetDeploymentParams = FunctionGetDeploymentParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionGetDeploymentResponse =
        getDeployment(params.toBuilder().deploymentId(deploymentId).build(), requestOptions)

    /** @see getDeployment */
    suspend fun getDeployment(
        params: FunctionGetDeploymentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionGetDeploymentResponse

    /** @see getDeployment */
    suspend fun getDeployment(
        deploymentId: String,
        requestOptions: RequestOptions,
    ): FunctionGetDeploymentResponse =
        getDeployment(deploymentId, FunctionGetDeploymentParams.none(), requestOptions)

    /**
     * Fetch invocation logs for a function. Logs are paginated via `nextToken`. Pass `startTime` /
     * `endTime` (Unix epoch milliseconds) to bound the window, or `filterPattern` to filter
     * messages.
     */
    suspend fun tailLogs(
        functionId: String,
        params: FunctionTailLogsParams = FunctionTailLogsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionTailLogsResponse =
        tailLogs(params.toBuilder().functionId(functionId).build(), requestOptions)

    /** @see tailLogs */
    suspend fun tailLogs(
        params: FunctionTailLogsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FunctionTailLogsResponse

    /** @see tailLogs */
    suspend fun tailLogs(
        functionId: String,
        requestOptions: RequestOptions,
    ): FunctionTailLogsResponse =
        tailLogs(functionId, FunctionTailLogsParams.none(), requestOptions)

    /**
     * A view of [FunctionServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): FunctionServiceAsync.WithRawResponse

        fun secrets(): SecretServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/functions`, but is otherwise the same as
         * [FunctionServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: FunctionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/functions/{functionId}`, but is otherwise the
         * same as [FunctionServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            functionId: String,
            params: FunctionRetrieveParams = FunctionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionRetrieveResponse> =
            retrieve(params.toBuilder().functionId(functionId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: FunctionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            functionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionRetrieveResponse> =
            retrieve(functionId, FunctionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /v1/functions/{functionId}`, but is otherwise the
         * same as [FunctionServiceAsync.update].
         */
        @MustBeClosed
        suspend fun update(
            functionId: String,
            params: FunctionUpdateParams = FunctionUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionUpdateResponse> =
            update(params.toBuilder().functionId(functionId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        suspend fun update(
            params: FunctionUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionUpdateResponse>

        /** @see update */
        @MustBeClosed
        suspend fun update(
            functionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionUpdateResponse> =
            update(functionId, FunctionUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/functions/{functionId}`, but is otherwise the
         * same as [FunctionServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            functionId: String,
            params: FunctionDeleteParams = FunctionDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionDeleteResponse> =
            delete(params.toBuilder().functionId(functionId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: FunctionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionDeleteResponse>

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            functionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionDeleteResponse> =
            delete(functionId, FunctionDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/functions/{functionId}/deploy`, but is
         * otherwise the same as [FunctionServiceAsync.deploy].
         */
        @MustBeClosed
        suspend fun deploy(
            functionId: String,
            params: FunctionDeployParams = FunctionDeployParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionDeployResponse> =
            deploy(params.toBuilder().functionId(functionId).build(), requestOptions)

        /** @see deploy */
        @MustBeClosed
        suspend fun deploy(
            params: FunctionDeployParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionDeployResponse>

        /** @see deploy */
        @MustBeClosed
        suspend fun deploy(
            functionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionDeployResponse> =
            deploy(functionId, FunctionDeployParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/functions/deployments/{deploymentId}`, but is
         * otherwise the same as [FunctionServiceAsync.getDeployment].
         */
        @MustBeClosed
        suspend fun getDeployment(
            deploymentId: String,
            params: FunctionGetDeploymentParams = FunctionGetDeploymentParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionGetDeploymentResponse> =
            getDeployment(params.toBuilder().deploymentId(deploymentId).build(), requestOptions)

        /** @see getDeployment */
        @MustBeClosed
        suspend fun getDeployment(
            params: FunctionGetDeploymentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionGetDeploymentResponse>

        /** @see getDeployment */
        @MustBeClosed
        suspend fun getDeployment(
            deploymentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionGetDeploymentResponse> =
            getDeployment(deploymentId, FunctionGetDeploymentParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/functions/{functionId}/logs`, but is otherwise
         * the same as [FunctionServiceAsync.tailLogs].
         */
        @MustBeClosed
        suspend fun tailLogs(
            functionId: String,
            params: FunctionTailLogsParams = FunctionTailLogsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionTailLogsResponse> =
            tailLogs(params.toBuilder().functionId(functionId).build(), requestOptions)

        /** @see tailLogs */
        @MustBeClosed
        suspend fun tailLogs(
            params: FunctionTailLogsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FunctionTailLogsResponse>

        /** @see tailLogs */
        @MustBeClosed
        suspend fun tailLogs(
            functionId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FunctionTailLogsResponse> =
            tailLogs(functionId, FunctionTailLogsParams.none(), requestOptions)
    }
}
