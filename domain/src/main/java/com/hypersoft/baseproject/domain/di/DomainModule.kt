package com.hypersoft.baseproject.domain.di

import com.hypersoft.baseproject.domain.media.repositories.MediaRepository
import com.hypersoft.baseproject.domain.media.useCases.GetAudiosUseCase
import com.hypersoft.baseproject.domain.media.useCases.GetImageFoldersUseCase
import com.hypersoft.baseproject.domain.media.useCases.GetImagesUseCase
import com.hypersoft.baseproject.domain.media.useCases.GetVideosUseCase
import com.hypersoft.baseproject.domain.media.useCases.contentObserver.ObserveMediaChangesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideGetAudiosUseCase(mediaRepository: MediaRepository): GetAudiosUseCase = GetAudiosUseCase(mediaRepository)

    @Provides
    fun provideGetImageFoldersUseCase(mediaRepository: MediaRepository): GetImageFoldersUseCase = GetImageFoldersUseCase(mediaRepository)

    @Provides
    fun provideGetImagesUseCase(mediaRepository: MediaRepository): GetImagesUseCase = GetImagesUseCase(mediaRepository)

    @Provides
    fun provideGetVideosUseCase(mediaRepository: MediaRepository): GetVideosUseCase = GetVideosUseCase(mediaRepository)

    @Provides
    fun provideObserveMediaChangesUseCase(mediaRepository: MediaRepository): ObserveMediaChangesUseCase = ObserveMediaChangesUseCase(mediaRepository)
}