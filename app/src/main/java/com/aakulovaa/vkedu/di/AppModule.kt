package com.aakulovaa.vkedu.di

import com.aakulovaa.vkedu.data.api.AppDetailsApi
import com.aakulovaa.vkedu.data.api.AppListApi
import com.aakulovaa.vkedu.data.mappers.AppDetailsMapper
import com.aakulovaa.vkedu.data.mappers.AppListMapper
import com.aakulovaa.vkedu.data.mappers.CategoryMapper
import com.aakulovaa.vkedu.data.repositoryImpl.AppDetailsRepositoryImpl
import com.aakulovaa.vkedu.data.repositoryImpl.AppListRepositoryImpl
import com.aakulovaa.vkedu.domain.repository.AppDetailsRepository
import com.aakulovaa.vkedu.domain.repository.AppListRepository
import com.aakulovaa.vkedu.domain.useCase.GetAppDetailsUseCase
import com.aakulovaa.vkedu.domain.useCase.GetAppListUseCase
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
    fun provideAppListApi(): AppListApi {
        return AppListApi()
    }

    @Provides
    @Singleton
    fun provideAppDetailsApi(): AppDetailsApi {
        return AppDetailsApi()
    }

    @Provides
    @Singleton
    fun provideCategoryMapper(): CategoryMapper {
        return CategoryMapper()
    }

    @Provides
    @Singleton
    fun provideAppListMapper(
        categoryMapper: CategoryMapper
    ): AppListMapper {
        return AppListMapper(categoryMapper)
    }

    @Provides
    @Singleton
    fun provideAppDetailsMapper(
        categoryMapper: CategoryMapper
    ): AppDetailsMapper {
        return AppDetailsMapper(categoryMapper)
    }

    @Provides
    @Singleton
    fun provideGetAppListUseCase(
        repository: AppListRepository
    ): GetAppListUseCase {
        return GetAppListUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetAppDetailsUseCase(
        repository: AppDetailsRepository
    ): GetAppDetailsUseCase {
        return GetAppDetailsUseCase(repository)
    }


    @Provides
    @Singleton
    fun provideAppListRepository(
        mapper: AppListMapper,
        api: AppListApi
    ): AppListRepository {
        return AppListRepositoryImpl(mapper, api)
    }

    @Provides
    @Singleton
    fun provideAppDetailsRepository(
        mapper: AppDetailsMapper,
        api: AppDetailsApi
    ): AppDetailsRepository {
        return AppDetailsRepositoryImpl(mapper, api)
    }

}