package com.example.dictionaryappwsr_preparation.presentation

import com.example.dictionaryappwsr_preparation.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
