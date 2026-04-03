package com.aakulovaa.vkedu.di

import com.aakulovaa.vkedu.data.api.AppListApi
import com.aakulovaa.vkedu.data.mappers.AppListMapper
import com.aakulovaa.vkedu.data.mappers.CategoryMapper
import com.aakulovaa.vkedu.data.repositoryImpl.AppListRepositoryImpl
import com.aakulovaa.vkedu.domain.repository.AppListRepository
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
    fun provideGetAppListUseCase(
        repository: AppListRepository
    ): GetAppListUseCase {
        return GetAppListUseCase(repository)
    }


    @Provides
    @Singleton
    fun provideAppListRepository(
        mapper: AppListMapper,
        api: AppListApi
    ): AppListRepository {
        return AppListRepositoryImpl(mapper, api)
    }

}