package com.example.quotedata.ui.quotes

import android.arch.lifecycle.ViewModel
import com.example.quotedata.data.Quote
import com.example.quotedata.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}