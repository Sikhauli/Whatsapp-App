package co.za.giantpanda.whatsapp1.ui

import MessageAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import co.za.giantpanda.whatsapp1.R
import co.za.giantpanda.whatsapp1.R.layout
import co.za.giantpanda.whatsapp1.model.MessageAsyncTask
import co.za.giantpanda.whatsapp1.model.MessageDetails
import co.za.giantpanda.whatsapp1.model.MessageListener
import java.util.ArrayList

class MainFragment : Fragment(), MessageListener {

  var messageAdapter: MessageAdapter? = null

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(layout.fragment_main, container, false)

 }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val messageRecyclerView: RecyclerView = view.findViewById(R.id.messageRecyclerView)
    messageAdapter = MessageAdapter(ArrayList())
    messageAdapter!!.setHasStableIds(true)
    messageRecyclerView.adapter = messageAdapter
    MessageAsyncTask(this).execute()
  }

  override fun onMessageReceived(messagesList: List<MessageDetails?>?) {
    messageAdapter?.addItems(messagesList as List<MessageDetails>?)
  }
}