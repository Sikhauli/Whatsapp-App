package co.za.giantpanda.mywhatsapp.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    fun createClient(): GetDataApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://6094f7f594009e00176b61d7.mockapi.io/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(GetDataApi::class.java)
    }
}