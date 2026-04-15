package com.aakulovaa.vkedu.data.repositoryImpl

import com.aakulovaa.vkedu.data.api.AppDetailsApi
import com.aakulovaa.vkedu.data.local.AppDetailsDao
import com.aakulovaa.vkedu.data.local.AppDetailsEntityMapper
import com.aakulovaa.vkedu.data.mappers.AppDetailsMapper
import com.aakulovaa.vkedu.domain.model.AppDetails
import com.aakulovaa.vkedu.domain.repository.AppDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class AppDetailsRepositoryImpl(
    private val mapper: AppDetailsMapper,
    private val api: AppDetailsApi,
    private val dao: AppDetailsDao,
    private val entityMapper: AppDetailsEntityMapper
) : AppDetailsRepository {
    override suspend fun getAppDetails(id: String): AppDetails {
        val appDetailsEntity = dao.getAppDetails(id).first()

        return if (appDetailsEntity!= null) {
            entityMapper.toDomain(appDetailsEntity)
        } else {
            val dto = api.getAppDetails(id)
            val domain = mapper.appDetailsToDomain(dto)
            val entity = entityMapper.toEntity(domain)
            withContext(Dispatchers.IO) {
                dao.insertAppDetails(entity)
            }
            domain
        }
    }

    override fun observeAppDetails(id: String): Flow<AppDetails> {
        return dao.getAppDetails(id)
            .filterNotNull()
            .map { entityMapper.toDomain(it) }
    }

    override suspend fun toggleWishlist(id: String) {
        val currentEntity = dao.getAppDetails(id).first()
        currentEntity?.let {
            dao.updateWishlistStatus(id, !it.isInWishlist)
            }
        }
}