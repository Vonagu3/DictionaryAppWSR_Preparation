package com.example.dictionaryappwsr_preparation.domain.model


data class WordInfo(
    val word: String,
    val phonetic: String,
    val meanings: List<Meaning>
)
