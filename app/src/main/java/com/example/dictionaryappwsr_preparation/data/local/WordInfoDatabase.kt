package com.example.dictionaryappwsr_preparation.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [WordInfoEntity::class.java],
    version = 1
)
@TypeConverters(Converter::class)
abstract class WordInfoDatabase: RoomDatabase() {

    abstract val dao: WordInfoDao
}