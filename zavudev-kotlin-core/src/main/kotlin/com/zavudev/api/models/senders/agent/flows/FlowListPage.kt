// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.senders.agent.flows

import com.zavudev.api.core.AutoPager
import com.zavudev.api.core.Page
import com.zavudev.api.core.checkRequired
import com.zavudev.api.services.blocking.senders.agent.FlowService
import java.util.Objects

/** @see FlowService.list */
class FlowListPage
private constructor(
    private val service: FlowService,
    private val params: FlowListParams,
    private val response: FlowListPageResponse,
) : Page<AgentFlow> {

    /**
     * Delegates to [FlowListPageResponse], but gracefully handles missing data.
     *
     * @see FlowListPageResponse.items
     */
    override fun items(): List<AgentFlow> = response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [FlowListPageResponse], but gracefully handles missing data.
     *
     * @see FlowListPageResponse.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("nextCursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): FlowListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): FlowListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<AgentFlow> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): FlowListParams = params

    /** The response that this page was parsed from. */
    fun response(): FlowListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FlowListPage].
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

    /** A builder for [FlowListPage]. */
    class Builder internal constructor() {

        private var service: FlowService? = null
        private var params: FlowListParams? = null
        private var response: FlowListPageResponse? = null

        internal fun from(flowListPage: FlowListPage) = apply {
            service = flowListPage.service
            params = flowListPage.params
            response = flowListPage.response
        }

        fun service(service: FlowService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: FlowListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: FlowListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [FlowListPage].
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
        fun build(): FlowListPage =
            FlowListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FlowListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "FlowListPage{service=$service, params=$params, response=$response}"
}
