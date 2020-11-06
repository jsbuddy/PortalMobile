package com.example.portal.di

import com.example.portal.data.dao.AuthDataSource
import com.example.portal.data.dao.ExamDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideExamDao() = ExamDao()

    @Singleton
    @Provides
    fun provideAuthDataSource() = AuthDataSource()
}