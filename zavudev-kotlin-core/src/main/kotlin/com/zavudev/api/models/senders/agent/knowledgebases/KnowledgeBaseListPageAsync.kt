// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.senders.agent.knowledgebases

import com.zavudev.api.core.AutoPagerAsync
import com.zavudev.api.core.PageAsync
import com.zavudev.api.core.checkRequired
import com.zavudev.api.services.async.senders.agent.KnowledgeBaseServiceAsync
import java.util.Objects

/** @see KnowledgeBaseServiceAsync.list */
class KnowledgeBaseListPageAsync
private constructor(
    private val service: KnowledgeBaseServiceAsync,
    private val params: KnowledgeBaseListParams,
    private val response: KnowledgeBaseListPageResponse,
) : PageAsync<AgentKnowledgeBase> {

    /**
     * Delegates to [KnowledgeBaseListPageResponse], but gracefully handles missing data.
     *
     * @see KnowledgeBaseListPageResponse.items
     */
    override fun items(): List<AgentKnowledgeBase> =
        response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [KnowledgeBaseListPageResponse], but gracefully handles missing data.
     *
     * @see KnowledgeBaseListPageResponse.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("nextCursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): KnowledgeBaseListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): KnowledgeBaseListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<AgentKnowledgeBase> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): KnowledgeBaseListParams = params

    /** The response that this page was parsed from. */
    fun response(): KnowledgeBaseListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [KnowledgeBaseListPageAsync].
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

    /** A builder for [KnowledgeBaseListPageAsync]. */
    class Builder internal constructor() {

        private var service: KnowledgeBaseServiceAsync? = null
        private var params: KnowledgeBaseListParams? = null
        private var response: KnowledgeBaseListPageResponse? = null

        internal fun from(knowledgeBaseListPageAsync: KnowledgeBaseListPageAsync) = apply {
            service = knowledgeBaseListPageAsync.service
            params = knowledgeBaseListPageAsync.params
            response = knowledgeBaseListPageAsync.response
        }

        fun service(service: KnowledgeBaseServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: KnowledgeBaseListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: KnowledgeBaseListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [KnowledgeBaseListPageAsync].
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
        fun build(): KnowledgeBaseListPageAsync =
            KnowledgeBaseListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is KnowledgeBaseListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "KnowledgeBaseListPageAsync{service=$service, params=$params, response=$response}"
}
