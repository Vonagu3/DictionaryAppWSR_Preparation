package com.example.dictionaryappwsr_preparation.data.repository

import android.database.sqlite.SQLiteException
import com.example.dictionaryappwsr_preparation.core.util.Resource
import com.example.dictionaryappwsr_preparation.data.local.WordInfoDao
import com.example.dictionaryappwsr_preparation.data.remote.DictionaryApi
import com.example.dictionaryappwsr_preparation.domain.model.WordInfo
import com.example.dictionaryappwsr_preparation.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
): WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())
        if (word.isBlank()) {
            return@flow
        }
        try {
            val remoteWordInfoList = api.getWordInfo(word)
            dao.deleteWordInfoList(remoteWordInfoList.map { it.word })
            dao.insertWordInfoList(remoteWordInfoList.map { it.toWordInfoEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(message = " Ошибка на стороне сервера "))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Сервер не доступен"))
        } catch (e: SQLiteException) {
            emit(Resource.Error(message = "Ошибка кэша"))
        }

        val newWordInfoList = dao.getWordInfoList(word).map { it.toWordInfo() }
        emit(Resource.Success(data = newWordInfoList))
    }
}