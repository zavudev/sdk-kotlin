// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.invitations

import com.zavudev.api.core.AutoPager
import com.zavudev.api.core.Page
import com.zavudev.api.core.checkRequired
import com.zavudev.api.services.blocking.InvitationService
import java.util.Objects

/** @see InvitationService.list */
class InvitationListPage
private constructor(
    private val service: InvitationService,
    private val params: InvitationListParams,
    private val response: InvitationListPageResponse,
) : Page<Invitation> {

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

    override fun nextPage(): InvitationListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Invitation> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): InvitationListParams = params

    /** The response that this page was parsed from. */
    fun response(): InvitationListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InvitationListPage].
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

    /** A builder for [InvitationListPage]. */
    class Builder internal constructor() {

        private var service: InvitationService? = null
        private var params: InvitationListParams? = null
        private var response: InvitationListPageResponse? = null

        internal fun from(invitationListPage: InvitationListPage) = apply {
            service = invitationListPage.service
            params = invitationListPage.params
            response = invitationListPage.response
        }

        fun service(service: InvitationService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: InvitationListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: InvitationListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [InvitationListPage].
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
        fun build(): InvitationListPage =
            InvitationListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InvitationListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "InvitationListPage{service=$service, params=$params, response=$response}"
}
