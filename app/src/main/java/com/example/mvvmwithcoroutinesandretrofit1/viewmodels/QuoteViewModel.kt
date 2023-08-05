package com.example.mvvmwithcoroutinesandretrofit1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmwithcoroutinesandretrofit1.models.Quote
import com.example.mvvmwithcoroutinesandretrofit1.repositories.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteViewModel(private val quotesRepository: QuotesRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
                quotesRepository.getQuotes()
        }
    }
    val quotesList : LiveData<Quote>
        get() = quotesRepository.quotes
}