// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.broadcasts

import com.zavudev.api.core.AutoPager
import com.zavudev.api.core.Page
import com.zavudev.api.core.checkRequired
import com.zavudev.api.services.blocking.BroadcastService
import java.util.Objects

/** @see BroadcastService.list */
class BroadcastListPage
private constructor(
    private val service: BroadcastService,
    private val params: BroadcastListParams,
    private val response: BroadcastListPageResponse,
) : Page<Broadcast> {

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

    override fun nextPage(): BroadcastListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Broadcast> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): BroadcastListParams = params

    /** The response that this page was parsed from. */
    fun response(): BroadcastListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BroadcastListPage].
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

    /** A builder for [BroadcastListPage]. */
    class Builder internal constructor() {

        private var service: BroadcastService? = null
        private var params: BroadcastListParams? = null
        private var response: BroadcastListPageResponse? = null

        internal fun from(broadcastListPage: BroadcastListPage) = apply {
            service = broadcastListPage.service
            params = broadcastListPage.params
            response = broadcastListPage.response
        }

        fun service(service: BroadcastService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: BroadcastListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: BroadcastListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [BroadcastListPage].
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
        fun build(): BroadcastListPage =
            BroadcastListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BroadcastListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "BroadcastListPage{service=$service, params=$params, response=$response}"
}
