package com.example.mvvmwithcoroutinesandretrofit1

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithcoroutinesandretrofit1.api.ApiInterface
import com.example.mvvmwithcoroutinesandretrofit1.api.RetrofitHelper
import com.example.mvvmwithcoroutinesandretrofit1.repositories.QuotesRepository
import com.example.mvvmwithcoroutinesandretrofit1.viewmodels.MainViewModelFactory
import com.example.mvvmwithcoroutinesandretrofit1.viewmodels.QuoteViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var quoteViewModel: QuoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiInterface = RetrofitHelper.getInstance().create(ApiInterface::class.java)
        val quotesRepository = QuotesRepository(apiInterface)
        val mainViewModelFactory = MainViewModelFactory(quotesRepository)
        quoteViewModel = ViewModelProvider(this,mainViewModelFactory).get(QuoteViewModel::class.java)

        quoteViewModel.quotesList.observe(this@MainActivity, Observer {
            Log.d(TAG, "onCreate: === " + it)
        })
    }
}