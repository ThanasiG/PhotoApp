package ca.thanasi.photoapp.api

import ca.thanasi.photoapp.models.PhotoList
import retrofit2.Call
import retrofit2.http.GET

interface PhotoAPI {
    @GET("?key=10945623-c184873117af74187484031f9&q=nature&image_type=photo")
    fun getPhotos() : Call<PhotoList>
}