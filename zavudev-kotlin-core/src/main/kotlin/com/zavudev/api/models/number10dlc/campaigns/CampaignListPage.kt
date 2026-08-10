// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.number10dlc.campaigns

import com.zavudev.api.core.AutoPager
import com.zavudev.api.core.Page
import com.zavudev.api.core.checkRequired
import com.zavudev.api.services.blocking.number10dlc.CampaignService
import java.util.Objects

/** @see CampaignService.list */
class CampaignListPage
private constructor(
    private val service: CampaignService,
    private val params: CampaignListParams,
    private val response: CampaignListPageResponse,
) : Page<TenDlcCampaign> {

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

    override fun nextPage(): CampaignListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<TenDlcCampaign> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): CampaignListParams = params

    /** The response that this page was parsed from. */
    fun response(): CampaignListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CampaignListPage].
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

    /** A builder for [CampaignListPage]. */
    class Builder internal constructor() {

        private var service: CampaignService? = null
        private var params: CampaignListParams? = null
        private var response: CampaignListPageResponse? = null

        internal fun from(campaignListPage: CampaignListPage) = apply {
            service = campaignListPage.service
            params = campaignListPage.params
            response = campaignListPage.response
        }

        fun service(service: CampaignService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: CampaignListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CampaignListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CampaignListPage].
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
        fun build(): CampaignListPage =
            CampaignListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CampaignListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "CampaignListPage{service=$service, params=$params, response=$response}"
}
