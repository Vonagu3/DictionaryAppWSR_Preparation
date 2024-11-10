package com.example.dictionaryappwsr_preparation.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionaryappwsr_preparation.data.utils.JsonParser
import com.example.dictionaryappwsr_preparation.domain.model.Meaning
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converter(
    private val jsonParser: JsonParser
) {
    private val type = object: TypeToken<List<Meaning>>(){}.type
    @TypeConverter
    fun fromMeaningJson(json: String): List<Meaning> {
        return jsonParser.fromJson<List<Meaning>>(
            json,
            type
        ).orEmpty()
    }

    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>): String {
        return jsonParser.toJson(
            meanings,
            type
        ) ?: "[]"
    }


}