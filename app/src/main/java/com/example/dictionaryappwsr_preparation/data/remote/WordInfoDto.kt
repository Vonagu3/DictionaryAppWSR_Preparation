package com.example.dictionaryappwsr_preparation.data.remote

import com.example.dictionaryappwsr_preparation.data.local.WordInfoEntity
import com.google.gson.annotations.SerializedName

data class WordInfoDto(
    val license: LicenseDto,
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val sourceUrls: List<String>,
    @SerializedName("word")
    val word: String
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            word = word,
            phonetic = phonetic,
            meanings = meanings.map { it.toMeaning() }
        )
    }
}