package com.example.dictionaryappwsr_preparation.data.remote

import com.google.gson.annotations.SerializedName

data class WordInfoDto(
    val license: LicenseDto,
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val sourceUrls: List<String>,
    @SerializedName("word")
    val word: String
)