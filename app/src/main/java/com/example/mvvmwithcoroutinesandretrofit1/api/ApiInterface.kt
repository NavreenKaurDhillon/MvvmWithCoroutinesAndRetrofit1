package com.example.mvvmwithcoroutinesandretrofit1.api

import com.example.mvvmwithcoroutinesandretrofit1.models.Quote
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

   @GET("quotes")
   suspend fun getQuotes() : Response<Quote>

}