// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.number10dlc.campaigns

import com.zavudev.api.core.AutoPagerAsync
import com.zavudev.api.core.PageAsync
import com.zavudev.api.core.checkRequired
import com.zavudev.api.services.async.number10dlc.CampaignServiceAsync
import java.util.Objects

/** @see CampaignServiceAsync.list */
class CampaignListPageAsync
private constructor(
    private val service: CampaignServiceAsync,
    private val params: CampaignListParams,
    private val response: CampaignListPageResponse,
) : PageAsync<TenDlcCampaign> {

    /**
     * Delegates to [CampaignListPageResponse], but gracefully handles missing data.
     *
     * @see CampaignListPageResponse.items
     */
    override fun items(): List<TenDlcCampaign> =
        response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [CampaignListPageResponse], but gracefully handles missing data.
     *
     * @see CampaignListPageResponse.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("nextCursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): CampaignListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): CampaignListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<TenDlcCampaign> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): CampaignListParams = params

    /** The response that this page was parsed from. */
    fun response(): CampaignListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CampaignListPageAsync].
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

    /** A builder for [CampaignListPageAsync]. */
    class Builder internal constructor() {

        private var service: CampaignServiceAsync? = null
        private var params: CampaignListParams? = null
        private var response: CampaignListPageResponse? = null

        internal fun from(campaignListPageAsync: CampaignListPageAsync) = apply {
            service = campaignListPageAsync.service
            params = campaignListPageAsync.params
            response = campaignListPageAsync.response
        }

        fun service(service: CampaignServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: CampaignListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CampaignListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CampaignListPageAsync].
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
        fun build(): CampaignListPageAsync =
            CampaignListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CampaignListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "CampaignListPageAsync{service=$service, params=$params, response=$response}"
}
