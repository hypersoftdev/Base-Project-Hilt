package com.hypersoft.baseproject.di

import com.hypersoft.baseproject.core.info.AppInfoProvider
import com.hypersoft.baseproject.info.AppInfoProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppInfoProvider(): AppInfoProvider = AppInfoProviderImpl()
}