package com.dev.retrofitwithkotlincoroutines.data

import com.dev.retrofitwithkotlincoroutines.model.Albums
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Rasul Mamadov on 12/23/2020.
 */
interface AlbumService {
    @GET("albums")//url endpoint
    suspend fun getAlbums() :Response<Albums>
}