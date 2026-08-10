// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.invitations

import com.zavudev.api.core.AutoPagerAsync
import com.zavudev.api.core.PageAsync
import com.zavudev.api.core.checkRequired
import com.zavudev.api.services.async.InvitationServiceAsync
import java.util.Objects

/** @see InvitationServiceAsync.list */
class InvitationListPageAsync
private constructor(
    private val service: InvitationServiceAsync,
    private val params: InvitationListParams,
    private val response: InvitationListPageResponse,
) : PageAsync<Invitation> {

    /**
     * Delegates to [InvitationListPageResponse], but gracefully handles missing data.
     *
     * @see InvitationListPageResponse.items
     */
    override fun items(): List<Invitation> = response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [InvitationListPageResponse], but gracefully handles missing data.
     *
     * @see InvitationListPageResponse.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("nextCursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): InvitationListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): InvitationListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Invitation> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): InvitationListParams = params

    /** The response that this page was parsed from. */
    fun response(): InvitationListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InvitationListPageAsync].
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

    /** A builder for [InvitationListPageAsync]. */
    class Builder internal constructor() {

        private var service: InvitationServiceAsync? = null
        private var params: InvitationListParams? = null
        private var response: InvitationListPageResponse? = null

        internal fun from(invitationListPageAsync: InvitationListPageAsync) = apply {
            service = invitationListPageAsync.service
            params = invitationListPageAsync.params
            response = invitationListPageAsync.response
        }

        fun service(service: InvitationServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: InvitationListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: InvitationListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [InvitationListPageAsync].
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
        fun build(): InvitationListPageAsync =
            InvitationListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InvitationListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "InvitationListPageAsync{service=$service, params=$params, response=$response}"
}
