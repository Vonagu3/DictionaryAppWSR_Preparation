package com.example.dictionaryappwsr_preparation.di

import android.app.Application
import androidx.room.Room
import com.example.dictionaryappwsr_preparation.data.local.Converter
import com.example.dictionaryappwsr_preparation.data.local.WordInfoDatabase
import com.example.dictionaryappwsr_preparation.data.remote.DictionaryApi
import com.example.dictionaryappwsr_preparation.data.utils.GsonParser
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            HttpLoggingInterceptor.Level.BODY
        }
        val httpClient = OkHttpClient.Builder().apply {
            addInterceptor(httpLoggingInterceptor)
        }
        return Retrofit.Builder()
            .baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(DictionaryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room
            .databaseBuilder(app, WordInfoDatabase::class.java, "word_db")
            .addTypeConverter(Converter(GsonParser(Gson())))
            .build()

    }
}