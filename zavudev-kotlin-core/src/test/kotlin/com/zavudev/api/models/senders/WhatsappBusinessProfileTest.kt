// File generated from our OpenAPI spec by Stainless.

package com.zavudev.api.models.senders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.zavudev.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WhatsappBusinessProfileTest {

    @Test
    fun create() {
        val whatsappBusinessProfile =
            WhatsappBusinessProfile.builder()
                .about("Succulent specialists!")
                .address("1 Hacker Way, Menlo Park, CA 94025")
                .description(
                    "At Lucky Shrub, we specialize in providing a diverse range of high-quality succulents."
                )
                .email("contact@example.com")
                .profilePictureUrl("https://pps.whatsapp.net/v/t61.24...")
                .vertical(WhatsappBusinessProfileVertical.UNDEFINED)
                .addWebsite("https://www.example.com/")
                .build()

        assertThat(whatsappBusinessProfile.about()).isEqualTo("Succulent specialists!")
        assertThat(whatsappBusinessProfile.address())
            .isEqualTo("1 Hacker Way, Menlo Park, CA 94025")
        assertThat(whatsappBusinessProfile.description())
            .isEqualTo(
                "At Lucky Shrub, we specialize in providing a diverse range of high-quality succulents."
            )
        assertThat(whatsappBusinessProfile.email()).isEqualTo("contact@example.com")
        assertThat(whatsappBusinessProfile.profilePictureUrl())
            .isEqualTo("https://pps.whatsapp.net/v/t61.24...")
        assertThat(whatsappBusinessProfile.vertical())
            .isEqualTo(WhatsappBusinessProfileVertical.UNDEFINED)
        assertThat(whatsappBusinessProfile.websites()).containsExactly("https://www.example.com/")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val whatsappBusinessProfile =
            WhatsappBusinessProfile.builder()
                .about("Succulent specialists!")
                .address("1 Hacker Way, Menlo Park, CA 94025")
                .description(
                    "At Lucky Shrub, we specialize in providing a diverse range of high-quality succulents."
                )
                .email("contact@example.com")
                .profilePictureUrl("https://pps.whatsapp.net/v/t61.24...")
                .vertical(WhatsappBusinessProfileVertical.UNDEFINED)
                .addWebsite("https://www.example.com/")
                .build()

        val roundtrippedWhatsappBusinessProfile =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(whatsappBusinessProfile),
                jacksonTypeRef<WhatsappBusinessProfile>(),
            )

        assertThat(roundtrippedWhatsappBusinessProfile).isEqualTo(whatsappBusinessProfile)
    }
}
