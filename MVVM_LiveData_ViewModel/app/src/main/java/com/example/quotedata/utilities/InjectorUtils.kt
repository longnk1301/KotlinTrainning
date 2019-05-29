package com.example.quotedata.utilities

import com.example.quotedata.data.FakeDatabase
import com.example.quotedata.data.QuoteRepository
import com.example.quotedata.ui.quotes.QuotesViewModelFactory

//Finally a singleton which doesn't need anything passed to the constructor
object InjectorUtils {

    //this will be called from QuotesActivity
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        //ViewModelFactory needs a repository, which in turn needs a DAO from a database
        //The whole dependency tree is constructed right here, in one place
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}