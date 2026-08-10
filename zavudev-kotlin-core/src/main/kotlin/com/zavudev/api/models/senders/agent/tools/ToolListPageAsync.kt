// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.senders.agent.tools

import com.zavudev.api.core.AutoPagerAsync
import com.zavudev.api.core.PageAsync
import com.zavudev.api.core.checkRequired
import com.zavudev.api.services.async.senders.agent.ToolServiceAsync
import java.util.Objects

/** @see ToolServiceAsync.list */
class ToolListPageAsync
private constructor(
    private val service: ToolServiceAsync,
    private val params: ToolListParams,
    private val response: ToolListPageResponse,
) : PageAsync<AgentTool> {

    /**
     * Delegates to [ToolListPageResponse], but gracefully handles missing data.
     *
     * @see ToolListPageResponse.items
     */
    override fun items(): List<AgentTool> = response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [ToolListPageResponse], but gracefully handles missing data.
     *
     * @see ToolListPageResponse.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("nextCursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): ToolListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): ToolListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<AgentTool> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ToolListParams = params

    /** The response that this page was parsed from. */
    fun response(): ToolListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ToolListPageAsync].
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

    /** A builder for [ToolListPageAsync]. */
    class Builder internal constructor() {

        private var service: ToolServiceAsync? = null
        private var params: ToolListParams? = null
        private var response: ToolListPageResponse? = null

        internal fun from(toolListPageAsync: ToolListPageAsync) = apply {
            service = toolListPageAsync.service
            params = toolListPageAsync.params
            response = toolListPageAsync.response
        }

        fun service(service: ToolServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ToolListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ToolListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ToolListPageAsync].
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
        fun build(): ToolListPageAsync =
            ToolListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ToolListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ToolListPageAsync{service=$service, params=$params, response=$response}"
}
