package com.example.randomquotegenerator


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun QuoteScreen(viewModel: QuoteViewModel,modifier: Modifier) {
    val quoteData: Quote by viewModel.quote.observeAsState(Quote("Initial Quote", "Initial Author"))



    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.End // Aligns content to the left
        ) {
            Text(
                text = quoteData.content,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left, // Aligns text to the start (left)
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "- ${quoteData.author}",
                style = MaterialTheme.typography.titleSmall,
            )
        }

        Button(
            onClick = {
                viewModel.fetchRandomQuote()
                println("QuoteScreen Fetching new quote...")
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth().height(80.dp)
                .padding(bottom = 36.dp)
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = "New Quote",
            )
        }
    }
}

