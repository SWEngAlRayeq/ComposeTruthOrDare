package app.truth_or_dare.di

import app.truth_or_dare.data.remote.TruthOrDareApi
import app.truth_or_dare.data.repo_impl.TruthOrDareRepositoryImpl
import app.truth_or_dare.domain.repository.TruthOrDareRepository
import app.truth_or_dare.domain.usecase.GetDareUseCase
import app.truth_or_dare.domain.usecase.GetTruthUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.truthordarebot.xyz/v1/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideTruthOrDareApi(retrofit: Retrofit): TruthOrDareApi =
        retrofit.create(TruthOrDareApi::class.java)


    @Provides
    @Singleton
    fun provideTruthOrDareRepository(api: TruthOrDareApi): TruthOrDareRepository =
        TruthOrDareRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideGetTruthUseCase(repository: TruthOrDareRepository): GetTruthUseCase =
        GetTruthUseCase(repository)

    @Provides
    @Singleton
    fun provideGetDareUseCase(repository: TruthOrDareRepository): GetDareUseCase =
        GetDareUseCase(repository)

}