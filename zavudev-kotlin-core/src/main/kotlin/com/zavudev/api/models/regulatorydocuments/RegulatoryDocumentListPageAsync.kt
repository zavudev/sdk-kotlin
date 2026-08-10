// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.regulatorydocuments

import com.zavudev.api.core.AutoPagerAsync
import com.zavudev.api.core.PageAsync
import com.zavudev.api.core.checkRequired
import com.zavudev.api.services.async.RegulatoryDocumentServiceAsync
import java.util.Objects

/** @see RegulatoryDocumentServiceAsync.list */
class RegulatoryDocumentListPageAsync
private constructor(
    private val service: RegulatoryDocumentServiceAsync,
    private val params: RegulatoryDocumentListParams,
    private val response: RegulatoryDocumentListPageResponse,
) : PageAsync<RegulatoryDocument> {

    /**
     * Delegates to [RegulatoryDocumentListPageResponse], but gracefully handles missing data.
     *
     * @see RegulatoryDocumentListPageResponse.items
     */
    override fun items(): List<RegulatoryDocument> =
        response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [RegulatoryDocumentListPageResponse], but gracefully handles missing data.
     *
     * @see RegulatoryDocumentListPageResponse.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("nextCursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): RegulatoryDocumentListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): RegulatoryDocumentListPageAsync =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<RegulatoryDocument> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): RegulatoryDocumentListParams = params

    /** The response that this page was parsed from. */
    fun response(): RegulatoryDocumentListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [RegulatoryDocumentListPageAsync].
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

    /** A builder for [RegulatoryDocumentListPageAsync]. */
    class Builder internal constructor() {

        private var service: RegulatoryDocumentServiceAsync? = null
        private var params: RegulatoryDocumentListParams? = null
        private var response: RegulatoryDocumentListPageResponse? = null

        internal fun from(regulatoryDocumentListPageAsync: RegulatoryDocumentListPageAsync) =
            apply {
                service = regulatoryDocumentListPageAsync.service
                params = regulatoryDocumentListPageAsync.params
                response = regulatoryDocumentListPageAsync.response
            }

        fun service(service: RegulatoryDocumentServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: RegulatoryDocumentListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: RegulatoryDocumentListPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [RegulatoryDocumentListPageAsync].
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
        fun build(): RegulatoryDocumentListPageAsync =
            RegulatoryDocumentListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RegulatoryDocumentListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "RegulatoryDocumentListPageAsync{service=$service, params=$params, response=$response}"
}
