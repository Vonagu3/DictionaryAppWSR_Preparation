package com.example.dictionaryappwsr_preparation.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionaryappwsr_preparation.domain.model.Meaning
import com.example.dictionaryappwsr_preparation.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    @PrimaryKey val id: Int? = null,
    val word: String,
    val phonetic: String,
    val meanings: List<Meaning>
) {

    fun toWordInfo(): WordInfo {
        return WordInfo(
            word = word,
            phonetic = phonetic,
            meanings = meanings
        )
    }
}
