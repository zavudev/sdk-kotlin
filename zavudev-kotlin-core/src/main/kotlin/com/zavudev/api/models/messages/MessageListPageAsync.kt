// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.messages

import com.zavudev.api.core.AutoPagerAsync
import com.zavudev.api.core.PageAsync
import com.zavudev.api.core.checkRequired
import com.zavudev.api.services.async.MessageServiceAsync
import java.util.Objects

/** @see MessageServiceAsync.list */
class MessageListPageAsync
private constructor(
    private val service: MessageServiceAsync,
    private val params: MessageListParams,
    private val response: MessageListPageResponse,
) : PageAsync<Message> {

    /**
     * Delegates to [MessageListPageResponse], but gracefully handles missing data.
     *
     * @see MessageListPageResponse.items
     */
    override fun items(): List<Message> = response._items().getNullable("items") ?: emptyList()

    /**
     * Delegates to [MessageListPageResponse], but gracefully handles missing data.
     *
     * @see MessageListPageResponse.nextCursor
     */
    fun nextCursor(): String? = response._nextCursor().getNullable("nextCursor")

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor() != null

    fun nextPageParams(): MessageListParams {
        val nextCursor =
            nextCursor() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().cursor(nextCursor).build()
    }

    override suspend fun nextPage(): MessageListPageAsync = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Message> = AutoPagerAsync.from(this)

    /** The parameters that were used to request this page. */
    fun params(): MessageListParams = params

    /** The response that this page was parsed from. */
    fun response(): MessageListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageListPageAsync].
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

    /** A builder for [MessageListPageAsync]. */
    class Builder internal constructor() {

        private var service: MessageServiceAsync? = null
        private var params: MessageListParams? = null
        private var response: MessageListPageResponse? = null

        internal fun from(messageListPageAsync: MessageListPageAsync) = apply {
            service = messageListPageAsync.service
            params = messageListPageAsync.params
            response = messageListPageAsync.response
        }

        fun service(service: MessageServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: MessageListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MessageListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [MessageListPageAsync].
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
        fun build(): MessageListPageAsync =
            MessageListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MessageListPageAsync &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "MessageListPageAsync{service=$service, params=$params, response=$response}"
}
