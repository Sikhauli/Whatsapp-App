package co.za.giantpanda.mywhatsapp.services


import retrofit2.Call
import co.za.giantpanda.mywhatsapp.model.MessageDetails
import retrofit2.http.GET

interface GetDataApi {
  @GET("messages") fun getPosts(): Call<List<MessageDetails>>
}