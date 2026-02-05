package com.hypersoft.baseproject.core.di

import android.content.Context
import com.hypersoft.baseproject.core.network.InternetManager
import com.hypersoft.baseproject.core.observers.GeneralObserver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideInternetManager(@ApplicationContext context: Context): InternetManager = InternetManager(context)

    @Provides
    @Singleton
    fun provideGeneralObserver(): GeneralObserver = GeneralObserver()
}