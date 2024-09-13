package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.practice.di.CoffeeViewModel
import com.example.practice.di.navigation.CoffeeNavigation
import com.example.practice.ui.common.ProgressLoader
import com.example.practice.ui.theme.PracticeTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    val viewModel = viewModel(modelClass = CoffeeViewModel::class.java)
//                    val state by viewModel.state.collectAsState()
//                    if(state.isEmpty()){
//                        ProgressLoader()
//                    }else{
//                        CoffeeNavigation()
//                    }
                    CoffeeNavigation()
                }
            }
        }
    }
}


