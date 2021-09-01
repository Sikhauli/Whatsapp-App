package co.za.giantpanda.mywhatsapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import co.za.giantpanda.mywhatsapp.R.layout
import co.za.giantpanda.mywhatsapp.adapter.MessageChatsDetailsAdapter
import co.za.giantpanda.mywhatsapp.model.MessageDetails
import co.za.giantpanda.mywhatsapp.model.MessageListener
import kotlinx.android.synthetic.main.fragment_message_chat.*

class MessageChatFragment : Fragment(layout.fragment_message_chat), MessageListener {

    private lateinit var messageChatAdapter: MessageChatsDetailsAdapter

    companion object {
        private const val PARAMS = "params"

        fun getInstance(messageDetails: MessageDetails?): MessageChatFragment {
            val fragment = MessageChatFragment()
            val bundle = Bundle()
            bundle.putSerializable(PARAMS, messageDetails)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val messageDetails = arguments?.getSerializable(PARAMS) as MessageDetails?
        messageDetails?.let {
            Username.text = java.lang.String.format("%s %s", it.firstName, it.lastName)
        }
    }

    override fun onMessageReceived(messagesList: List<MessageDetails>) {
        messageChatAdapter.addItems(messagesList)
    }
}
