// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.messages.MessageListAttachmentsParams
import com.zavudev.api.models.messages.MessageListAttachmentsResponse
import com.zavudev.api.models.messages.MessageListPageAsync
import com.zavudev.api.models.messages.MessageListParams
import com.zavudev.api.models.messages.MessageReactParams
import com.zavudev.api.models.messages.MessageResponse
import com.zavudev.api.models.messages.MessageRetrieveParams
import com.zavudev.api.models.messages.MessageSendParams
import com.zavudev.api.models.messages.MessageShowTypingParams
import com.zavudev.api.models.messages.MessageShowTypingResponse

interface MessageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): MessageServiceAsync

    /** Get message by ID */
    suspend fun retrieve(
        messageId: String,
        params: MessageRetrieveParams = MessageRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageResponse = retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: MessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageResponse

    /** @see retrieve */
    suspend fun retrieve(messageId: String, requestOptions: RequestOptions): MessageResponse =
        retrieve(messageId, MessageRetrieveParams.none(), requestOptions)

    /** List messages previously sent by this project. */
    suspend fun list(
        params: MessageListParams = MessageListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListPageAsync

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): MessageListPageAsync =
        list(MessageListParams.none(), requestOptions)

    /**
     * List the stored file attachments for an email message and get a short-lived signed
     * `downloadUrl` for each. Works for both inbound emails (received via `message.inbound`) and
     * outbound emails you sent with attachments. Messages without stored attachments (including
     * SMS, WhatsApp, and other channels) return an empty list. Each `downloadUrl` is generated
     * fresh per request and expires — fetch the file promptly and do not cache the URL.
     */
    suspend fun listAttachments(
        messageId: String,
        params: MessageListAttachmentsParams = MessageListAttachmentsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListAttachmentsResponse =
        listAttachments(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see listAttachments */
    suspend fun listAttachments(
        params: MessageListAttachmentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageListAttachmentsResponse

    /** @see listAttachments */
    suspend fun listAttachments(
        messageId: String,
        requestOptions: RequestOptions,
    ): MessageListAttachmentsResponse =
        listAttachments(messageId, MessageListAttachmentsParams.none(), requestOptions)

    /**
     * Send an emoji reaction to an existing WhatsApp message. Reactions are only supported for
     * WhatsApp messages.
     */
    suspend fun react(
        messageId: String,
        params: MessageReactParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageResponse = react(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see react */
    suspend fun react(
        params: MessageReactParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageResponse

    /**
     * Send a message to a recipient via SMS or WhatsApp.
     *
     * **Channel selection:**
     * - If `channel` is omitted and `messageType` is `text`, defaults to SMS
     * - If `messageType` is anything other than `text`, WhatsApp is used automatically
     *
     * **WhatsApp 24-hour window:**
     * - Free-form messages (non-template) require an open 24h window
     * - Window opens when the user messages you first
     * - Use template messages to initiate conversations outside the window
     *
     * **Plan allowances and email billing:**
     * - WhatsApp, Telegram, Instagram and Messenger share an allowance of 2,000 messages per month
     *   on Free. **It counts messages in both directions**: a message a contact sends you consumes
     *   one unit exactly as a message you send them does, so a project that has sent 300 and
     *   received 1,700 has used the whole allowance. Messages you send from the WhatsApp Business
     *   App on your own phone under coexistence are mirrored into your inbox but never counted, and
     *   neither are failed sends. Over the allowance, sends return 429 with code
     *   `a2p_limit_exceeded` and upgrade details, **and inbound messages on those channels are
     *   refused as well**: not stored, not shown in the inbox, and no `message.inbound` webhook,
     *   and not delivered later when the month resets. The counter resets on the 1st of each month.
     *   Paid plans have no message caps
     * - Email is billed from your prepaid balance in 1,000-message blocks: $0.40 per 1,000
     *   transactional emails, $0.80 per 1,000 marketing (broadcast) emails. A block is charged when
     *   your monthly count crosses each 1,000 boundary, and at zero balance email sends return 402
     *   with code `insufficient_balance`. Free teams start with $2 of credit and additionally cap
     *   at 3,000 emails/month and 100/day. Teams on earlier plans keep their original email quotas
     *   instead
     * - SMS and voice are billed per message from your balance on every plan
     *
     * **Daily limits:**
     * - An account sends on every channel from its first minute, to any destination. Verification
     *   is not a permission to send: identity verification and business verification (KYB) raise
     *   the ceilings below and nothing else asks for them here. KYB is still required to register a
     *   10DLC brand and campaign, which every US and Canadian (+1) SMS destination needs — a
     *   carrier rule, answered separately with `403 ten_dlc_required`
     * - Daily ceilings apply per channel group and rise with verification. An account that has
     *   verified nothing: 25/day across `sms` + `sms_oneway`, 5/day for `voice`, 100/day across
     *   WhatsApp, Telegram, Instagram and Messenger combined. Past that floor: 200/day for SMS, or
     *   10,000/day once identity or business verification is approved (or a higher limit agreed for
     *   your account); 50/day voice and 250/day conversational on Free. **Paid plans have no voice
     *   or conversational daily ceiling.** Over a ceiling, sends return `429` with code
     *   `daily_limit_exceeded` and `details.limit`; the count resets at 00:00 UTC
     * - The daily ceiling never reduces the monthly allowance: 100/day on the conversational group
     *   still reaches the 2,000 monthly A2P messages Free includes
     * - Email: a sender with a verified domain sends from day one, within the plan quota (100/day
     *   and 3,000/month on Free). Over the daily quota it returns `429` with code
     *   `daily_limit_exceeded`
     * - Full reference: https://docs.zavu.dev/concepts/sending-limits
     *
     * **Risk review:** Every outbound `sms`, `sms_oneway`, `email` and `voice` message is read
     * before it is sent — the content, and how this account has been sending. What is checked is
     * the message, not who you are.
     * - A message can be **held** for a short review. It stays `queued` while it waits: no new
     *   status exists for this, and `MessageStatus` is unchanged. When it is approved it sends
     *   normally.
     * - A message that is not approved moves to `failed` and fires `message.failed`. `errorCode`
     *   says which happened: `RISK_REJECTED` (a reviewer refused it), `RISK_REVIEW_EXPIRED` (the
     *   review window closed first — it is a couple of hours, because a code that arrives late is
     *   worse than one that does not arrive), or `RISK_BLOCKED` (refused outright, without a hold).
     *   An SMS that fails this way is not charged; the prepaid amount is returned.
     * - A call is never held. `POST /v1/calls` fails a call the review stops rather than placing it
     *   hours late.
     * - A message whose content cannot be read — the check is briefly unavailable — is held rather
     *   than sent. An account with an approved business verification is unaffected, and so is one
     *   that has verified something, already sends real traffic, and has a clean recent record.
     * - Repeated refusals suspend an account's sending. While it is suspended every send is refused
     *   with `403` and code `sending_suspended`, `details.dashboardUrl` points at support, and a
     *   message already queued fails with `errorCode` `SENDING_SUSPENDED`.
     * - A broadcast is read once, on the broadcast itself, rather than per recipient — see `POST
     *   /v1/broadcasts/{broadcastId}/send`.
     *
     * **Email recipient pre-flight:** Email messages are validated automatically before dispatch.
     * Sends that would be a guaranteed hard bounce are failed instead of sent, protecting your
     * bounce rate: the message transitions to `failed` (visible via `GET /v1/messages/{messageId}`
     * and the `message.failed` webhook) with `errorCode` set to `EMAIL_INVALID_RECIPIENT`
     * (malformed address), `EMAIL_DOMAIN_NOT_FOUND` (recipient domain has no MX or A records), or
     * `EMAIL_RECIPIENT_SUPPRESSED` (address is on your suppression list after a previous bounce or
     * complaint). Advisory signals (role addresses, disposable domains) do not block sends — check
     * them beforehand with `POST /v1/introspect/email`.
     */
    suspend fun send(
        params: MessageSendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageResponse

    /**
     * Mark an inbound WhatsApp message as read and display a typing indicator to the user while you
     * prepare a response. The indicator is automatically dismissed when you send a reply, or after
     * 25 seconds — whichever comes first. Only valid for inbound WhatsApp messages. Use this when a
     * reply will take more than a couple of seconds (LLM agent, tool call, lookup) to improve the
     * recipient's experience.
     */
    suspend fun showTyping(
        messageId: String,
        params: MessageShowTypingParams = MessageShowTypingParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageShowTypingResponse =
        showTyping(params.toBuilder().messageId(messageId).build(), requestOptions)

    /** @see showTyping */
    suspend fun showTyping(
        params: MessageShowTypingParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageShowTypingResponse

    /** @see showTyping */
    suspend fun showTyping(
        messageId: String,
        requestOptions: RequestOptions,
    ): MessageShowTypingResponse =
        showTyping(messageId, MessageShowTypingParams.none(), requestOptions)

    /**
     * A view of [MessageServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): MessageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/messages/{messageId}`, but is otherwise the same
         * as [MessageServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            messageId: String,
            params: MessageRetrieveParams = MessageRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageResponse> =
            retrieve(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: MessageRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            messageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageResponse> =
            retrieve(messageId, MessageRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages`, but is otherwise the same as
         * [MessageServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: MessageListParams = MessageListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListPageAsync>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<MessageListPageAsync> =
            list(MessageListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/{messageId}/attachments`, but is
         * otherwise the same as [MessageServiceAsync.listAttachments].
         */
        @MustBeClosed
        suspend fun listAttachments(
            messageId: String,
            params: MessageListAttachmentsParams = MessageListAttachmentsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListAttachmentsResponse> =
            listAttachments(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see listAttachments */
        @MustBeClosed
        suspend fun listAttachments(
            params: MessageListAttachmentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageListAttachmentsResponse>

        /** @see listAttachments */
        @MustBeClosed
        suspend fun listAttachments(
            messageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageListAttachmentsResponse> =
            listAttachments(messageId, MessageListAttachmentsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/{messageId}/reactions`, but is
         * otherwise the same as [MessageServiceAsync.react].
         */
        @MustBeClosed
        suspend fun react(
            messageId: String,
            params: MessageReactParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageResponse> =
            react(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see react */
        @MustBeClosed
        suspend fun react(
            params: MessageReactParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageResponse>

        /**
         * Returns a raw HTTP response for `post /v1/messages`, but is otherwise the same as
         * [MessageServiceAsync.send].
         */
        @MustBeClosed
        suspend fun send(
            params: MessageSendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageResponse>

        /**
         * Returns a raw HTTP response for `post /v1/messages/{messageId}/typing`, but is otherwise
         * the same as [MessageServiceAsync.showTyping].
         */
        @MustBeClosed
        suspend fun showTyping(
            messageId: String,
            params: MessageShowTypingParams = MessageShowTypingParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageShowTypingResponse> =
            showTyping(params.toBuilder().messageId(messageId).build(), requestOptions)

        /** @see showTyping */
        @MustBeClosed
        suspend fun showTyping(
            params: MessageShowTypingParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageShowTypingResponse>

        /** @see showTyping */
        @MustBeClosed
        suspend fun showTyping(
            messageId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageShowTypingResponse> =
            showTyping(messageId, MessageShowTypingParams.none(), requestOptions)
    }
}
