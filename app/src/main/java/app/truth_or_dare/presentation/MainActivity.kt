package app.truth_or_dare.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import app.truth_or_dare.presentation.viewmodel.TruthOrDareViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewmodel: TruthOrDareViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TruthOrDareScreen(
                getTruth = viewmodel::fetchTruth,
                getDare = viewmodel::fetchDare,
                state = viewmodel.state,
                loading = viewmodel.loading
            )
        }
    }
}

