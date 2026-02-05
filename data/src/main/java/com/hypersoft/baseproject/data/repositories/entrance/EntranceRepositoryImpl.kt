package com.hypersoft.baseproject.data.repositories.entrance

import com.hypersoft.baseproject.data.dataSources.storage.SharedPrefManager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EntranceRepositoryImpl @Inject constructor(
    private val sharedPrefManager: SharedPrefManager
) : EntranceRepository {

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun isFirstTime(): Boolean = withContext(ioDispatcher) {
        sharedPrefManager.isFirstTime
    }
}