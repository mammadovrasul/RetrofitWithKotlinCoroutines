package com.dev.retrofitwithkotlincoroutines.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.dev.retrofitwithkotlincoroutines.R
import com.dev.retrofitwithkotlincoroutines.databinding.ActivityMainBinding
import com.dev.retrofitwithkotlincoroutines.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.vm = viewModel

        viewModel.responseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()
            if (albumsList != null) {
                while (albumsList.hasNext()) {
                    val albumsItem = albumsList.next()
                    val result = "Album Title : ${albumsItem.title}" + "\n" +
                             "Album id : ${albumsItem.id}" + "\n" +
                             "User id : ${albumsItem.userId}" + "\n\n\n"
                    binding.textView.append(result)

                }
            }
        })

    }
}
