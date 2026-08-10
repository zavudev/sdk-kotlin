// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.addresses

import com.zavudev.api.core.AutoPagerAsync
import com.zavudev.api.core.PageAsync
import com.zavudev.api.core.checkRequired
import com.zavudev.api.services.async.AddressServiceAsync
import java.util.Objects

/** @see AddressServiceAsync.list */
class AddressListPageAsync
private constructor(
    private val service: AddressServiceAsync,
    private val params: AddressListParams,
    private val response: AddressListPageResponse,
) : PageAsync<Address> {

    /**
     * Delegates to [AddressListPageResponse], but gracefully handles missing data.
     *
     * @see AddressListPageResponse.items
     */
    override fun items(): List<Address> = response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [AddressListPageResponse], but gracefully handles missing data.
     *
     * @see AddressListPageResponse.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("nextCursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): AddressListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): AddressListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Address> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): AddressListParams = params

    /** The response that this page was parsed from. */
    fun response(): AddressListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AddressListPageAsync].
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

    /** A builder for [AddressListPageAsync]. */
    class Builder internal constructor() {

        private var service: AddressServiceAsync? = null
        private var params: AddressListParams? = null
        private var response: AddressListPageResponse? = null

        internal fun from(addressListPageAsync: AddressListPageAsync) = apply {
            service = addressListPageAsync.service
            params = addressListPageAsync.params
            response = addressListPageAsync.response
        }

        fun service(service: AddressServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: AddressListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: AddressListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [AddressListPageAsync].
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
        fun build(): AddressListPageAsync =
            AddressListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AddressListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "AddressListPageAsync{service=$service, params=$params, response=$response}"
}
