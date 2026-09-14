// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.zavudev.api.core.ClientOptions
import com.zavudev.api.core.RequestOptions
import com.zavudev.api.core.http.HttpResponse
import com.zavudev.api.core.http.HttpResponseFor
import com.zavudev.api.models.emaildomains.EmailDomainCreateParams
import com.zavudev.api.models.emaildomains.EmailDomainCreateResponse
import com.zavudev.api.models.emaildomains.EmailDomainDeleteParams
import com.zavudev.api.models.emaildomains.EmailDomainListParams
import com.zavudev.api.models.emaildomains.EmailDomainListResponse
import com.zavudev.api.models.emaildomains.EmailDomainRetrieveParams
import com.zavudev.api.models.emaildomains.EmailDomainRetrieveResponse
import com.zavudev.api.models.emaildomains.EmailDomainVerifyParams
import com.zavudev.api.models.emaildomains.EmailDomainVerifyResponse

interface EmailDomainServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): EmailDomainServiceAsync

    /**
     * Add a domain to send email from. Returns the DNS records to publish (DKIM CNAMEs are
     * required; SPF, DMARC, and MAIL FROM are recommended). Publish them at your DNS provider, then
     * verify.
     */
    suspend fun create(
        params: EmailDomainCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EmailDomainCreateResponse

    /** Fetch a domain with its DNS records and current status. */
    suspend fun retrieve(
        domainId: String,
        params: EmailDomainRetrieveParams = EmailDomainRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EmailDomainRetrieveResponse =
        retrieve(params.toBuilder().domainId(domainId).build(), requestOptions)

    /** @see retrieve */
    suspend fun retrieve(
        params: EmailDomainRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EmailDomainRetrieveResponse

    /** @see retrieve */
    suspend fun retrieve(
        domainId: String,
        requestOptions: RequestOptions,
    ): EmailDomainRetrieveResponse =
        retrieve(domainId, EmailDomainRetrieveParams.none(), requestOptions)

    /** List email domains */
    suspend fun list(
        params: EmailDomainListParams = EmailDomainListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EmailDomainListResponse

    /** @see list */
    suspend fun list(requestOptions: RequestOptions): EmailDomainListResponse =
        list(EmailDomainListParams.none(), requestOptions)

    /** Remove an email domain */
    suspend fun delete(
        domainId: String,
        params: EmailDomainDeleteParams = EmailDomainDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().domainId(domainId).build(), requestOptions)

    /** @see delete */
    suspend fun delete(
        params: EmailDomainDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see delete */
    suspend fun delete(domainId: String, requestOptions: RequestOptions) =
        delete(domainId, EmailDomainDeleteParams.none(), requestOptions)

    /** Re-check the domain's published DNS records and refresh its status. */
    suspend fun verify(
        domainId: String,
        params: EmailDomainVerifyParams = EmailDomainVerifyParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EmailDomainVerifyResponse =
        verify(params.toBuilder().domainId(domainId).build(), requestOptions)

    /** @see verify */
    suspend fun verify(
        params: EmailDomainVerifyParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EmailDomainVerifyResponse

    /** @see verify */
    suspend fun verify(
        domainId: String,
        requestOptions: RequestOptions,
    ): EmailDomainVerifyResponse = verify(domainId, EmailDomainVerifyParams.none(), requestOptions)

    /**
     * A view of [EmailDomainServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): EmailDomainServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/email-domains`, but is otherwise the same as
         * [EmailDomainServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: EmailDomainCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EmailDomainCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/email-domains/{domainId}`, but is otherwise the
         * same as [EmailDomainServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            domainId: String,
            params: EmailDomainRetrieveParams = EmailDomainRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EmailDomainRetrieveResponse> =
            retrieve(params.toBuilder().domainId(domainId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            params: EmailDomainRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EmailDomainRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        suspend fun retrieve(
            domainId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EmailDomainRetrieveResponse> =
            retrieve(domainId, EmailDomainRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/email-domains`, but is otherwise the same as
         * [EmailDomainServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: EmailDomainListParams = EmailDomainListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EmailDomainListResponse>

        /** @see list */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<EmailDomainListResponse> =
            list(EmailDomainListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/email-domains/{domainId}`, but is otherwise
         * the same as [EmailDomainServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            domainId: String,
            params: EmailDomainDeleteParams = EmailDomainDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().domainId(domainId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        suspend fun delete(
            params: EmailDomainDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        suspend fun delete(domainId: String, requestOptions: RequestOptions): HttpResponse =
            delete(domainId, EmailDomainDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/email-domains/{domainId}/verify`, but is
         * otherwise the same as [EmailDomainServiceAsync.verify].
         */
        @MustBeClosed
        suspend fun verify(
            domainId: String,
            params: EmailDomainVerifyParams = EmailDomainVerifyParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EmailDomainVerifyResponse> =
            verify(params.toBuilder().domainId(domainId).build(), requestOptions)

        /** @see verify */
        @MustBeClosed
        suspend fun verify(
            params: EmailDomainVerifyParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EmailDomainVerifyResponse>

        /** @see verify */
        @MustBeClosed
        suspend fun verify(
            domainId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EmailDomainVerifyResponse> =
            verify(domainId, EmailDomainVerifyParams.none(), requestOptions)
    }
}
