// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.templates

import com.zavudev.api.core.AutoPagerAsync
import com.zavudev.api.core.PageAsync
import com.zavudev.api.core.checkRequired
import com.zavudev.api.services.async.TemplateServiceAsync
import java.util.Objects

/** @see TemplateServiceAsync.list */
class TemplateListPageAsync
private constructor(
    private val service: TemplateServiceAsync,
    private val params: TemplateListParams,
    private val response: TemplateListPageResponse,
) : PageAsync<Template> {

    /**
     * Delegates to [TemplateListPageResponse], but gracefully handles missing data.
     *
     * @see TemplateListPageResponse.items
     */
    override fun items(): List<Template> = response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [TemplateListPageResponse], but gracefully handles missing data.
     *
     * @see TemplateListPageResponse.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("nextCursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): TemplateListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): TemplateListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Template> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): TemplateListParams = params

    /** The response that this page was parsed from. */
    fun response(): TemplateListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TemplateListPageAsync].
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

    /** A builder for [TemplateListPageAsync]. */
    class Builder internal constructor() {

        private var service: TemplateServiceAsync? = null
        private var params: TemplateListParams? = null
        private var response: TemplateListPageResponse? = null

        internal fun from(templateListPageAsync: TemplateListPageAsync) = apply {
            service = templateListPageAsync.service
            params = templateListPageAsync.params
            response = templateListPageAsync.response
        }

        fun service(service: TemplateServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: TemplateListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: TemplateListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [TemplateListPageAsync].
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
        fun build(): TemplateListPageAsync =
            TemplateListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TemplateListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "TemplateListPageAsync{service=$service, params=$params, response=$response}"
}
