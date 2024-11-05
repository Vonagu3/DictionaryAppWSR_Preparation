package com.example.dictionaryappwsr_preparation.data.remote

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val example: String,
    val synonyms: List<String>
)