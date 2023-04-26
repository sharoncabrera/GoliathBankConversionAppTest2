package com.example.goliathbankconversionapptest2.transaction_feature.data.di

import android.content.Context
import androidx.room.Room
import com.example.goliathbankconversionapptest2.transaction_feature.data.local.GoliathDatabase
import com.example.goliathbankconversionapptest2.transaction_feature.data.local.RateDao
import com.example.goliathbankconversionapptest2.transaction_feature.data.local.TransactionDao
import com.example.goliathbankconversionapptest2.transaction_feature.data.repository.TransactionRepositoryImpl
import com.example.goliathbankconversionapptest2.transaction_feature.domain.repository.TransactionRepository
import com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case.GetAllTransactionUseCase
import com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case.GetDetailedTransactionUseCase
import com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case.GetRatesFromApiUseCase
import com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case.GetRatesUseCase
import com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case.GetTransactionsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TransactionModule {

    @Singleton
    @Provides
    fun provideApi(): HttpClient {
        return HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }

    @Provides
    @Singleton
    fun provideTransactionDao(database: GoliathDatabase): TransactionDao {
        return database.transactionDao()
    }


    @Provides
    @Singleton
    fun provideRateDao(database: GoliathDatabase): RateDao {
        return database.rateDao()
    }

    @Provides
    @Singleton
    fun provideTransactionRepository(
        transactionDao: TransactionDao,
        rateDao: RateDao,
        client: HttpClient
    ): TransactionRepository {
        return TransactionRepositoryImpl(transactionDao = transactionDao,rateDao = rateDao, httpClient = client)
    }

    @Singleton
    @Provides
    fun provideGoliathDatabase(@ApplicationContext context: Context): GoliathDatabase {
        return Room.databaseBuilder(
            context,
            GoliathDatabase::class.java,
            "goliath_db"
        )
            .build()
    }

    @Provides
    @Singleton
    fun prodvideGetAllTransactionUseCase(repository: TransactionRepository): GetAllTransactionUseCase {
        return GetAllTransactionUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetDetailedTransactionUseCase(repository: TransactionRepository): GetDetailedTransactionUseCase {
        return GetDetailedTransactionUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetTransactionsUseCase(repository: TransactionRepository): GetTransactionsUseCase {
        return GetTransactionsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetRatesUseCase(repository: TransactionRepository): GetRatesUseCase {
        return GetRatesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetRatesFromApiUseCase(repository: TransactionRepository): GetRatesFromApiUseCase {
        return GetRatesFromApiUseCase(repository)
    }


}