package com.dev.retrofitwithkotlincoroutines.repositories

import com.dev.retrofitwithkotlincoroutines.data.AlbumService
import com.dev.retrofitwithkotlincoroutines.data.RetrofitInstance
import com.dev.retrofitwithkotlincoroutines.model.Albums
import retrofit2.Response

/**
 * Created by Rasul Mamadov on 12/24/2020.
 */
class AlbumsRepository {
    suspend fun getAlbums(): Response<Albums>? {
        val retService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)
        val response = retService.getAlbums()
        return response
    }
}