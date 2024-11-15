package com.example.dictionaryappwsr_preparation.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordInfoList(infoList: List<WordInfoEntity>)

    @Query("DELETE FROM wordinfoentity WHERE word IN(:words)")
    suspend fun deleteWordInfoList(words: List<String>)

    @Query("SELECT * FROM WordInfoEntity WHERE word = :word")
    suspend fun getWordInfoList(word: String): List<WordInfoEntity>

    @Query("SELECT * FROM WordInfoEntity WHERE word LIKE '%' || :word || '%' ")
    suspend fun getWordLikeInfoList(word: String): List<WordInfoEntity>
}