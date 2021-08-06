package co.za.giantpanda.mywhatsapp.model

import android.os.AsyncTask
import android.util.Log
import co.za.giantpanda.mywhatsapp.services.GetDataApi
import co.za.giantpanda.mywhatsapp.services.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class MessageAsyncTask(listener: MessageListener) : AsyncTask<Void?, Int?, Call<List<MessageDetails>>>() {

    var messageListener: MessageListener

    override fun doInBackground(vararg params: Void?): Call<List<MessageDetails>> {
        val client: GetDataApi = RetrofitClient.createClient()
        Log.d("TEST RESULTS", "Start service call")
        return client.getPosts()
    }

    override fun onPostExecute(response: Call<List<MessageDetails>>) {
        super.onPostExecute(response)
        Log.d("TEST RESULTS", "onPostExecute method")
        response.enqueue(object : Callback<List<MessageDetails>> {
            override fun onResponse(call: Call<List<MessageDetails>>, response: Response<List<MessageDetails>>) {
                Log.d("TEST RESULTS", response.message())
                Log.d("TEST RESULTS", response.isSuccessful.toString())
                if (response.isSuccessful) {
                    response.body()?.let { messageListener.onMessageReceived(it) }
                }
            }

            override fun onFailure(call: Call<List<MessageDetails>>, t: Throwable) {
                t.message?.let { Log.d("TEST RESULTS", it) }
                t.printStackTrace()
            }
        })
    }

    init {
        Log.d("TEST RESULTS", "MessageAsyncTask constructor")
        messageListener = listener
    }
}