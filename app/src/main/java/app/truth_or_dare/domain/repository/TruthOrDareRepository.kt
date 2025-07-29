package app.truth_or_dare.domain.repository

interface TruthOrDareRepository {

    suspend fun getTruth(): String
    suspend fun getDare(): String

}