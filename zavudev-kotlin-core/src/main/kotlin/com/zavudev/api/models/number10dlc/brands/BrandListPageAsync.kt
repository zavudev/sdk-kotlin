// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.number10dlc.brands

import com.zavudev.api.core.AutoPagerAsync
import com.zavudev.api.core.PageAsync
import com.zavudev.api.core.checkRequired
import com.zavudev.api.services.async.number10dlc.BrandServiceAsync
import java.util.Objects

/** @see BrandServiceAsync.list */
class BrandListPageAsync
private constructor(
    private val service: BrandServiceAsync,
    private val params: BrandListParams,
    private val response: BrandListPageResponse,
) : PageAsync<TenDlcBrand> {

    /**
     * Delegates to [BrandListPageResponse], but gracefully handles missing data.
     *
     * @see BrandListPageResponse.items
     */
    override fun items(): List<TenDlcBrand> = response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [BrandListPageResponse], but gracefully handles missing data.
     *
     * @see BrandListPageResponse.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("nextCursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): BrandListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): BrandListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<TenDlcBrand> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): BrandListParams = params

    /** The response that this page was parsed from. */
    fun response(): BrandListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BrandListPageAsync].
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

    /** A builder for [BrandListPageAsync]. */
    class Builder internal constructor() {

        private var service: BrandServiceAsync? = null
        private var params: BrandListParams? = null
        private var response: BrandListPageResponse? = null

        internal fun from(brandListPageAsync: BrandListPageAsync) = apply {
            service = brandListPageAsync.service
            params = brandListPageAsync.params
            response = brandListPageAsync.response
        }

        fun service(service: BrandServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: BrandListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: BrandListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [BrandListPageAsync].
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
        fun build(): BrandListPageAsync =
            BrandListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BrandListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "BrandListPageAsync{service=$service, params=$params, response=$response}"
}
