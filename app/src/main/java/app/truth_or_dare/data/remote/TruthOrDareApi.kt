package app.truth_or_dare.data.remote

import app.truth_or_dare.data.model.TruthOrDareResponse
import retrofit2.http.GET

interface TruthOrDareApi {

    @GET("truth")
    suspend fun getTruth(): TruthOrDareResponse

    @GET("dare")
    suspend fun getDare(): TruthOrDareResponse

}