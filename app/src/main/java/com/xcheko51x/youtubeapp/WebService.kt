package com.xcheko51x.youtubeapp

import com.xcheko51x.youtubeapp.response.ResponseAPI
import retrofit2.Response
import retrofit2.http.GET

interface WebService {

    @GET("search?part=snippet&eventtype=live&q=music&type=video&key=AIzaSyDo1TfoSUqRtUZA7o7ATM_fnInIi5FwV6E")
    suspend fun obtenerVideos(): Response<ResponseAPI>

}