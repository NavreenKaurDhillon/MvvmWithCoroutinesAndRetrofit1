package com.example.mvvmwithcoroutinesandretrofit1.api

import com.example.mvvmwithcoroutinesandretrofit1.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
       private const val BASE_URL = "https://type.fit/api/"

        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
}