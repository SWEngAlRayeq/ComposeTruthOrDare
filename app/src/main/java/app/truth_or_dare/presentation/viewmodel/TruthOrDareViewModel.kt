package app.truth_or_dare.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.truth_or_dare.domain.usecase.GetDareUseCase
import app.truth_or_dare.domain.usecase.GetTruthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TruthOrDareViewModel @Inject constructor(
    private val getTruthUseCase: GetTruthUseCase,
    private val getDareUseCase: GetDareUseCase
) : ViewModel() {

    var state by mutableStateOf("Start Game")
        private set

    var loading by mutableStateOf(false)
        private set

    fun fetchTruth() {
        viewModelScope.launch {
            loading = true
            state = getTruthUseCase()
            loading = false
        }
    }

    fun fetchDare() {
        viewModelScope.launch {
            loading = true
            state = getDareUseCase()
            loading = false
        }
    }

}