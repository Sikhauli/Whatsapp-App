package co.za.giantpanda.whatsapp1.model

import android.os.AsyncTask
import android.util.Log
import co.za.giantpanda.whatsapp1.services.GetDataApi
import co.za.giantpanda.whatsapp1.services.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Boolean
import java.util.Objects

open class MessageAsyncTask(listener: MessageListener) : AsyncTask<Void?, Int?, Call<List<MessageDetails>>>() {

  var messageListener: MessageListener

   override fun doInBackground(vararg params: Void?): Call<List<MessageDetails?>?> {
    val client: GetDataApi = RetrofitClient.createClient()
    Log.d("TEST RESULTS", "Start service call")
    return client.getPosts()
  }

  override fun onPostExecute(response: Call<List<MessageDetails>>) {
    super.onPostExecute(response)
    Log.d("TEST RESULTS", "onPostExecute method")
    response.enqueue(object : Callback<List<MessageDetails?>?> {
      override fun onResponse(call: Call<List<MessageDetails?>?>, response: Response<List<MessageDetails?>?>) {
        Log.d("TEST RESULTS", response.message())
        Log.d("TEST RESULTS", Boolean.toString(response.isSuccessful))
        if (response.isSuccessful) {
          messageListener.onMessageReceived(response.body())
        }
      }

      override fun onFailure(call: Call<List<MessageDetails?>?>, t: Throwable) {
        Objects.requireNonNull(t.message)?.let { Log.d("TEST RESULTS", it) }
        t.printStackTrace()
      }
    })
  }

  init {
    Log.d("TEST RESULTS", "MessageAsyncTask constructor")
    messageListener = listener
  }
}

private fun <T> Call<T>.enqueue(callback: Callback<List<MessageDetails?>?>) {

}
