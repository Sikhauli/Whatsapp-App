package co.za.giantpanda.mywhatsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.za.giantpanda.mywhatsapp.R
import co.za.giantpanda.mywhatsapp.R.layout
import co.za.giantpanda.mywhatsapp.adapter.StatusAdapter
import co.za.giantpanda.mywhatsapp.model.MessageAsyncTask
import co.za.giantpanda.mywhatsapp.model.MessageDetails
import co.za.giantpanda.mywhatsapp.model.MessageListener
import java.util.ArrayList


class StatusFragment : Fragment(), MessageListener {

  private lateinit var messageAdapter: StatusAdapter

  companion object {
    private const val MESSAGE_DETAILS = "MESSAGE_DETAILS"

    fun newInstance(messageDetails: MessageDetails): MainFragment? {
      val bundle = Bundle().apply { putSerializable(MESSAGE_DETAILS, messageDetails) }
      return MainFragment().apply { arguments = bundle }
    }


  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(layout.fragment_status, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val messageRecyclerView: RecyclerView = view.findViewById(R.id.statusRecyclerView)
    messageAdapter = StatusAdapter(ArrayList())
    messageAdapter.setHasStableIds(true)
    messageRecyclerView.adapter = messageAdapter
    MessageAsyncTask(this).execute()
  }

  override fun onMessageReceived(messagesList: List<MessageDetails>) {
    messageAdapter.addItems(messagesList)
  }
}