// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.calls

import com.zavudev.api.core.AutoPager
import com.zavudev.api.core.Page
import com.zavudev.api.core.checkRequired
import com.zavudev.api.services.blocking.CallService
import java.util.Objects

/** @see CallService.list */
class CallListPage
private constructor(
    private val service: CallService,
    private val params: CallListParams,
    private val response: CallListPageResponse,
) : Page<CallListResponse> {

    /**
     * Delegates to [CallListPageResponse], but gracefully handles missing data.
     *
     * @see CallListPageResponse.items
     */
    override fun items(): List<CallListResponse> =
        response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [CallListPageResponse], but gracefully handles missing data.
     *
     * @see CallListPageResponse.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("nextCursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): CallListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override fun nextPage(): CallListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<CallListResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): CallListParams = params

    /** The response that this page was parsed from. */
    fun response(): CallListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CallListPage].
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

    /** A builder for [CallListPage]. */
    class Builder internal constructor() {

        private var service: CallService? = null
        private var params: CallListParams? = null
        private var response: CallListPageResponse? = null

        internal fun from(callListPage: CallListPage) = apply {
            service = callListPage.service
            params = callListPage.params
            response = callListPage.response
        }

        fun service(service: CallService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: CallListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CallListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CallListPage].
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
        fun build(): CallListPage =
            CallListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CallListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "CallListPage{service=$service, params=$params, response=$response}"
}
