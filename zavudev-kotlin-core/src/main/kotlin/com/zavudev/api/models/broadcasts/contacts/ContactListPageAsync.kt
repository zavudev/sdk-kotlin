// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.broadcasts.contacts

import com.zavudev.api.core.AutoPagerAsync
import com.zavudev.api.core.PageAsync
import com.zavudev.api.core.checkRequired
import com.zavudev.api.models.broadcasts.BroadcastContact
import com.zavudev.api.services.async.broadcasts.ContactServiceAsync
import java.util.Objects

/** @see ContactServiceAsync.list */
class ContactListPageAsync
private constructor(
    private val service: ContactServiceAsync,
    private val params: ContactListParams,
    private val response: ContactListPageResponse,
) : PageAsync<BroadcastContact> {

    /**
     * Delegates to [ContactListPageResponse], but gracefully handles missing data.
     *
     * @see ContactListPageResponse.items
     */
    override fun items(): List<BroadcastContact> =
        response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [ContactListPageResponse], but gracefully handles missing data.
     *
     * @see ContactListPageResponse.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("nextCursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): ContactListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): ContactListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<BroadcastContact> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ContactListParams = params

    /** The response that this page was parsed from. */
    fun response(): ContactListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ContactListPageAsync].
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

    /** A builder for [ContactListPageAsync]. */
    class Builder internal constructor() {

        private var service: ContactServiceAsync? = null
        private var params: ContactListParams? = null
        private var response: ContactListPageResponse? = null

        internal fun from(contactListPageAsync: ContactListPageAsync) = apply {
            service = contactListPageAsync.service
            params = contactListPageAsync.params
            response = contactListPageAsync.response
        }

        fun service(service: ContactServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ContactListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ContactListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ContactListPageAsync].
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
        fun build(): ContactListPageAsync =
            ContactListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContactListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ContactListPageAsync{service=$service, params=$params, response=$response}"
}
