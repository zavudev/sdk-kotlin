// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.senders.agent.executions

import com.zavudev.api.core.AutoPagerAsync
import com.zavudev.api.core.PageAsync
import com.zavudev.api.core.checkRequired
import com.zavudev.api.models.senders.agent.AgentExecution
import com.zavudev.api.services.async.senders.agent.ExecutionServiceAsync
import java.util.Objects

/** @see ExecutionServiceAsync.list */
class ExecutionListPageAsync
private constructor(
    private val service: ExecutionServiceAsync,
    private val params: ExecutionListParams,
    private val response: ExecutionListPageResponse,
) : PageAsync<AgentExecution> {

    /**
     * Delegates to [ExecutionListPageResponse], but gracefully handles missing data.
     *
     * @see ExecutionListPageResponse.items
     */
    override fun items(): List<AgentExecution> =
        response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [ExecutionListPageResponse], but gracefully handles missing data.
     *
     * @see ExecutionListPageResponse.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("nextCursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): ExecutionListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): ExecutionListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<AgentExecution> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ExecutionListParams = params

    /** The response that this page was parsed from. */
    fun response(): ExecutionListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ExecutionListPageAsync].
         *
         * The following fields are required:
         * ```kotlin
         * .service()
         * .params()
         * .response()
         * ```
         */
        fun builder() = Builder()
    }

    /** A builder for [ExecutionListPageAsync]. */
    class Builder internal constructor() {

        private var service: ExecutionServiceAsync? = null
        private var params: ExecutionListParams? = null
        private var response: ExecutionListPageResponse? = null

        internal fun from(executionListPageAsync: ExecutionListPageAsync) = apply {
            service = executionListPageAsync.service
            params = executionListPageAsync.params
            response = executionListPageAsync.response
        }

        fun service(service: ExecutionServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ExecutionListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ExecutionListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ExecutionListPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```kotlin
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ExecutionListPageAsync =
            ExecutionListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExecutionListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ExecutionListPageAsync{service=$service, params=$params, response=$response}"
}
