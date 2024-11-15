package com.example.dictionaryappwsr_preparation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dictionaryappwsr_preparation.presentation.WordInfoViewModel
import com.example.dictionaryappwsr_preparation.ui.theme.DictionaryAppWSR_PreparationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: WordInfoViewModel = hiltViewModel()
            val state = viewModel.state.value
            DictionaryAppWSR_PreparationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TextField(
                        value = viewModel.searchQuery.value,
                        onValueChange = viewModel::onSearch
                    )

                    if (state.isLoading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}
