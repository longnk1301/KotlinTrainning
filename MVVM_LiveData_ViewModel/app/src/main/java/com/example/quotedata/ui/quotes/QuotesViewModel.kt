package com.example.quotedata.ui.quotes

import android.arch.lifecycle.ViewModel
import com.example.quotedata.data.Quote
import com.example.quotedata.data.QuoteRepository

//QuoteRepository dependency will  again be passed in the
// constructor using dependency injection
class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}