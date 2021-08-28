package co.za.giantpanda.mywhatsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import co.za.giantpanda.mywhatsapp.R
import co.za.giantpanda.mywhatsapp.R.layout
import co.za.giantpanda.mywhatsapp.model.MessageDetails

class MessageChatFragment : Fragment() {

  private val PARAMS = "params"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setHasOptionsMenu(true)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(layout.fragment_message_chat, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val senderNameTextView = view.findViewById<TextView>(R.id.Username)
    val bundle = arguments
    if (bundle != null) {
      val messageDetails = bundle.getSerializable(PARAMS) as MessageDetails?
      if (messageDetails != null) {
     senderNameTextView.text = java.lang.String.format("%s %s", messageDetails.getFirstName(), messageDetails.getLastName())
      }
    }
  }

}
