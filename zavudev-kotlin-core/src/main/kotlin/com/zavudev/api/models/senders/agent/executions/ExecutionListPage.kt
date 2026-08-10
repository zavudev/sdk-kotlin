// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.senders.agent.executions

import com.zavudev.api.core.AutoPager
import com.zavudev.api.core.Page
import com.zavudev.api.core.checkRequired
import com.zavudev.api.models.senders.agent.AgentExecution
import com.zavudev.api.services.blocking.senders.agent.ExecutionService
import java.util.Objects

/** @see ExecutionService.list */
class ExecutionListPage
private constructor(
    private val service: ExecutionService,
    private val params: ExecutionListParams,
    private val response: ExecutionListPageResponse,
) : Page<AgentExecution> {

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

    override fun nextPage(): ExecutionListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<AgentExecution> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ExecutionListParams = params

    /** The response that this page was parsed from. */
    fun response(): ExecutionListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ExecutionListPage].
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

    /** A builder for [ExecutionListPage]. */
    class Builder internal constructor() {

        private var service: ExecutionService? = null
        private var params: ExecutionListParams? = null
        private var response: ExecutionListPageResponse? = null

        internal fun from(executionListPage: ExecutionListPage) = apply {
            service = executionListPage.service
            params = executionListPage.params
            response = executionListPage.response
        }

        fun service(service: ExecutionService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ExecutionListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ExecutionListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ExecutionListPage].
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
        fun build(): ExecutionListPage =
            ExecutionListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExecutionListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ExecutionListPage{service=$service, params=$params, response=$response}"
}
