package com.example.quotedata.ui.quotes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.quotedata.R
import com.example.quotedata.data.Quote
import com.example.quotedata.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi() {
        //Get the QuotesViewModelFactory with all of itls dependencies constricted
        val factory = InjectorUtils.provideQuotesViewModelFactory()

        //Use ViewModelProviders class to create / get already created QuotesViewModel
        //for this view (activity)
        val viewModel = ViewModelProviders.of(this, factory).get(QuotesViewModel::class.java)

        //Observing LiveData from the QuotesViewModel which in turn observes
        // LiveData from the repository, which observes LiveData from the DAO
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            if (quotes != null) {
                quotes.forEach{ quote ->
                    stringBuilder.append("$quote\n\n")
                }
            }
            textView_quotes.text = stringBuilder.toString()
        })

        // When button is clicked, instantiate a Quote and add it to DB through the ViewModel
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
