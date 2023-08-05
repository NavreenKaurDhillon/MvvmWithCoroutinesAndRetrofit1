package com.example.mvvmwithcoroutinesandretrofit1.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmwithcoroutinesandretrofit1.api.ApiInterface
import com.example.mvvmwithcoroutinesandretrofit1.models.Quote

class QuotesRepository(private val apiInterface: ApiInterface) {

    private var quoteMutableLD = MutableLiveData<Quote>()
    val quotes : LiveData<Quote>
        get() = quoteMutableLD

    suspend fun getQuotes() {
        val result = apiInterface.getQuotes()
        if (result.body()!=null){
            quoteMutableLD.postValue(result.body())
        }
    }
}