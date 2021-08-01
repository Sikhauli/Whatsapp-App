package co.za.giantpanda.whatsapp1.services


import retrofit2.Call
import co.za.giantpanda.whatsapp1.model.MessageDetails
import retrofit2.http.GET

interface GetDataApi {

  @GET("messages") fun getPosts(): Call<List<MessageDetails?>?>
}