package com.dev.retrofitwithkotlincoroutines.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dev.retrofitwithkotlincoroutines.repositories.AlbumsRepository
import com.dev.retrofitwithkotlincoroutines.model.Albums
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

/**
 * Created by Rasul Mamadov on 12/24/2020.
 */
class MainActivityViewModel : ViewModel() {
    private lateinit var albumsRepository: AlbumsRepository

    init {
        albumsRepository = AlbumsRepository()
    }

    val responseLiveData: LiveData<Response<Albums>> = liveData(Dispatchers.IO) {
        val response = albumsRepository.getAlbums()
        if (response != null) {
            emit(response)
        }

    }
}



