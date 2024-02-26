package com.xcheko51x.youtubeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xcheko51x.youtubeapp.response.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    private var _listaVideos = MutableLiveData<List<Item>>()
    val listaVideos: LiveData<List<Item>> get() = _listaVideos

    fun obtenerVideos() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.obtenerVideos()
            withContext(Dispatchers.Main) {
                _listaVideos.value = response.body()!!.items
            }
        }
    }

}