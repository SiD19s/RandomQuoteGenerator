package com.example.randomquotegenerator

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    private val _quote = MutableLiveData<Quote>()
    val quote: LiveData<Quote> = _quote

    init {
        fetchRandomQuote()
    }

    fun fetchRandomQuote() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getRandom()
                // Extract quote content and author from response
                val quoteText = response.content ?: "No quote available"
                val authorName = response.author ?: "Unknown"
                _quote.value = Quote(quoteText, authorName)
            } catch (e: Exception) {
                Log.e("QuoteViewModel", "Error fetching quote", e)
                // Handle network errors here, and provide fallback or default quote
                _quote.value = Quote("Failed to fetch quote", "Unknown")
            }
        }
    }
}

