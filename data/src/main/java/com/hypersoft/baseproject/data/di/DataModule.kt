package com.hypersoft.baseproject.data.di

import android.content.Context
import com.hypersoft.baseproject.data.dataSources.inAppMemory.history.HistoryDataSource
import com.hypersoft.baseproject.data.dataSources.inAppMemory.languages.LanguageDataSource
import com.hypersoft.baseproject.data.dataSources.mediaStore.AudioDataSource
import com.hypersoft.baseproject.data.dataSources.mediaStore.ImageDataSource
import com.hypersoft.baseproject.data.dataSources.mediaStore.VideoDataSource
import com.hypersoft.baseproject.data.dataSources.mediaStore.contentObservers.MediaStoreObserver
import com.hypersoft.baseproject.data.dataSources.storage.SharedPrefManager
import com.hypersoft.baseproject.data.repositories.entrance.EntranceRepositoryImpl
import com.hypersoft.baseproject.data.repositories.history.HistoryRepositoryImpl
import com.hypersoft.baseproject.data.repositories.language.LanguageRepositoryImpl
import com.hypersoft.baseproject.data.repositories.media.MediaRepositoryImpl
import com.hypersoft.baseproject.data.repositories.entrance.EntranceRepository
import com.hypersoft.baseproject.data.repositories.history.HistoryRepository
import com.hypersoft.baseproject.data.repositories.language.LanguageRepository
import com.hypersoft.baseproject.domain.media.repositories.MediaRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    // In-app memory data sources
    @Provides
    @Singleton
    fun provideLanguageDataSource(): LanguageDataSource = LanguageDataSource()

    @Provides
    @Singleton
    fun provideHistoryDataSource(): HistoryDataSource = HistoryDataSource()

    // MediaStore data sources & observers
    @Provides
    @Singleton
    fun provideMediaStoreObserver(@ApplicationContext context: Context): MediaStoreObserver = MediaStoreObserver(context.contentResolver)

    @Provides
    @Singleton
    fun provideAudioDataSource(@ApplicationContext context: Context): AudioDataSource = AudioDataSource(context.contentResolver)

    @Provides
    @Singleton
    fun provideImageDataSource(@ApplicationContext context: Context): ImageDataSource = ImageDataSource(context.contentResolver)

    @Provides
    @Singleton
    fun provideVideoDataSource(@ApplicationContext context: Context): VideoDataSource = VideoDataSource(context.contentResolver)

    // Storage
    @Provides
    @Singleton
    fun provideSharedPrefManager(@ApplicationContext context: Context): SharedPrefManager = SharedPrefManager(context)
}

@Module
@InstallIn(SingletonComponent::class)
abstract class DataBindModule {

    @Binds
    @Singleton
    abstract fun bindEntranceRepository(impl: EntranceRepositoryImpl): EntranceRepository

    @Binds
    @Singleton
    abstract fun bindLanguageRepository(impl: LanguageRepositoryImpl): LanguageRepository

    @Binds
    @Singleton
    abstract fun bindHistoryRepository(impl: HistoryRepositoryImpl): HistoryRepository

    @Binds
    @Singleton
    abstract fun bindMediaRepository(impl: MediaRepositoryImpl): MediaRepository
}