package app.truth_or_dare.data.repo_impl

import app.truth_or_dare.data.remote.TruthOrDareApi
import app.truth_or_dare.domain.repository.TruthOrDareRepository
import javax.inject.Inject

class TruthOrDareRepositoryImpl @Inject constructor(
    private val api: TruthOrDareApi
) : TruthOrDareRepository {
    override suspend fun getTruth(): String = api.getTruth().question
    override suspend fun getDare(): String = api.getDare().question
}