package com.example.dictionaryappwsr_preparation.data.remote

data class PhoneticDto(
    val audio: String,
    val license: LicenseDto,
    val sourceUrl: String,
    val text: String
)