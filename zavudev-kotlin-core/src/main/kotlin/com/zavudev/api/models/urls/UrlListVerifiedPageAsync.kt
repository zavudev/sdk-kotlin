// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.urls

import com.zavudev.api.core.AutoPagerAsync
import com.zavudev.api.core.PageAsync
import com.zavudev.api.core.checkRequired
import com.zavudev.api.services.async.UrlServiceAsync
import java.util.Objects

/** @see UrlServiceAsync.listVerified */
class UrlListVerifiedPageAsync
private constructor(
    private val service: UrlServiceAsync,
    private val params: UrlListVerifiedParams,
    private val response: UrlListVerifiedPageResponse,
) : PageAsync<VerifiedUrl> {

    /**
     * Delegates to [UrlListVerifiedPageResponse], but gracefully handles missing data.
     *
     * @see UrlListVerifiedPageResponse.items
     */
    override fun items(): List<VerifiedUrl> = response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [UrlListVerifiedPageResponse], but gracefully handles missing data.
     *
     * @see UrlListVerifiedPageResponse.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("nextCursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): UrlListVerifiedParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): UrlListVerifiedPageAsync =
        service.listVerified(nextPageParams())

    fun autoPager(): AutoPagerAsync<VerifiedUrl> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): UrlListVerifiedParams = params

    /** The response that this page was parsed from. */
    fun response(): UrlListVerifiedPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UrlListVerifiedPageAsync].
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

    /** A builder for [UrlListVerifiedPageAsync]. */
    class Builder internal constructor() {

        private var service: UrlServiceAsync? = null
        private var params: UrlListVerifiedParams? = null
        private var response: UrlListVerifiedPageResponse? = null

        internal fun from(urlListVerifiedPageAsync: UrlListVerifiedPageAsync) = apply {
            service = urlListVerifiedPageAsync.service
            params = urlListVerifiedPageAsync.params
            response = urlListVerifiedPageAsync.response
        }

        fun service(service: UrlServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: UrlListVerifiedParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: UrlListVerifiedPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [UrlListVerifiedPageAsync].
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
        fun build(): UrlListVerifiedPageAsync =
            UrlListVerifiedPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UrlListVerifiedPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "UrlListVerifiedPageAsync{service=$service, params=$params, response=$response}"
}
