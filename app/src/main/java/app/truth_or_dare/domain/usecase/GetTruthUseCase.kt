package app.truth_or_dare.domain.usecase

import app.truth_or_dare.domain.repository.TruthOrDareRepository
import javax.inject.Inject

class GetTruthUseCase @Inject constructor(
    private val repository: TruthOrDareRepository
) {
    suspend operator fun invoke(): String = repository.getTruth()
}