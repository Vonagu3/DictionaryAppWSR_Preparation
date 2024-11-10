package com.example.dictionaryappwsr_preparation.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionaryappwsr_preparation.domain.model.Meaning

@Entity
data class WordInfoEntity(
    @PrimaryKey val id: Int? = null,
    val word: String,
    val phonetic: String,
    val meanings: List<Meaning>
)
