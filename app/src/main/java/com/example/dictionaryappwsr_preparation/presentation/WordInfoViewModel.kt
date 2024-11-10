package com.example.dictionaryappwsr_preparation.presentation

import androidx.lifecycle.ViewModel
import com.example.dictionaryappwsr_preparation.domain.repository.WordInfoRepository

class WordInfoViewModel(
    private val repository: WordInfoRepository
): ViewModel() {
}