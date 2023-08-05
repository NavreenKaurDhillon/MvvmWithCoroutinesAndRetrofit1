package com.example.mvvmwithcoroutinesandretrofit1.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithcoroutinesandretrofit1.repositories.QuotesRepository

class MainViewModelFactory(private val quotesRepository: QuotesRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuoteViewModel(quotesRepository) as T
    }
}