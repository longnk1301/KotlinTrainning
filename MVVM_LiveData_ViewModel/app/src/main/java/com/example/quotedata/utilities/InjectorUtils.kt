package com.example.quotedata.utilities

import com.example.quotedata.data.FakeDatabase
import com.example.quotedata.data.QuoteRepository
import com.example.quotedata.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}