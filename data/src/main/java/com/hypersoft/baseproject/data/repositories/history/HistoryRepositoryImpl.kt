package com.hypersoft.baseproject.data.repositories.history

import com.hypersoft.baseproject.data.dataSources.inAppMemory.history.HistoryDataSource
import com.hypersoft.baseproject.data.dataSources.inAppMemory.history.entities.History
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    private val dataSource: HistoryDataSource
) : HistoryRepository {

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun getHistories(): List<History> = withContext(ioDispatcher) {
        dataSource.getHistories()
    }
}