// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.broadcasts

import com.zavudev.api.core.AutoPagerAsync
import com.zavudev.api.core.PageAsync
import com.zavudev.api.core.checkRequired
import com.zavudev.api.services.async.BroadcastServiceAsync
import java.util.Objects

/** @see BroadcastServiceAsync.list */
class BroadcastListPageAsync
private constructor(
    private val service: BroadcastServiceAsync,
    private val params: BroadcastListParams,
    private val response: BroadcastListPageResponse,
) : PageAsync<Broadcast> {

    /**
     * Delegates to [BroadcastListPageResponse], but gracefully handles missing data.
     *
     * @see BroadcastListPageResponse.items
     */
    override fun items(): List<Broadcast> = response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [BroadcastListPageResponse], but gracefully handles missing data.
     *
     * @see BroadcastListPageResponse.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("nextCursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): BroadcastListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): BroadcastListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Broadcast> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): BroadcastListParams = params

    /** The response that this page was parsed from. */
    fun response(): BroadcastListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BroadcastListPageAsync].
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

    /** A builder for [BroadcastListPageAsync]. */
    class Builder internal constructor() {

        private var service: BroadcastServiceAsync? = null
        private var params: BroadcastListParams? = null
        private var response: BroadcastListPageResponse? = null

        internal fun from(broadcastListPageAsync: BroadcastListPageAsync) = apply {
            service = broadcastListPageAsync.service
            params = broadcastListPageAsync.params
            response = broadcastListPageAsync.response
        }

        fun service(service: BroadcastServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: BroadcastListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: BroadcastListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [BroadcastListPageAsync].
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
        fun build(): BroadcastListPageAsync =
            BroadcastListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BroadcastListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "BroadcastListPageAsync{service=$service, params=$params, response=$response}"
}
