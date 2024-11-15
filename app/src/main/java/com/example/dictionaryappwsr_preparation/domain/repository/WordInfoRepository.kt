package com.example.dictionaryappwsr_preparation.domain.repository

import com.example.dictionaryappwsr_preparation.core.util.Resource
import com.example.dictionaryappwsr_preparation.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}