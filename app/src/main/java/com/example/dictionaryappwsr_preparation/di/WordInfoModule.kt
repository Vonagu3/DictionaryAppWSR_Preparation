package com.example.dictionaryappwsr_preparation.di

import com.example.dictionaryappwsr_preparation.data.remote.DictionaryApi
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
}