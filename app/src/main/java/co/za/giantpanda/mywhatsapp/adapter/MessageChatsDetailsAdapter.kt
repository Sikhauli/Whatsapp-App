package co.za.giantpanda.mywhatsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.za.giantpanda.mywhatsapp.R
import co.za.giantpanda.mywhatsapp.model.MessageDetails
import co.za.giantpanda.mywhatsapp.ui.MainActivity
import co.za.giantpanda.mywhatsapp.ui.MainFragment
import co.za.giantpanda.mywhatsapp.ui.MessageChatFragment
import java.util.Calendar.getInstance
import java.util.Currency.getInstance
import kotlin.coroutines.EmptyCoroutineContext.get

class MessageChatsDetailsAdapter(messageDetails: MutableList<MessageDetails>) : RecyclerView.Adapter<MessageChatsDetailsAdapter.MessageViewHolder>() {
  private var messageLists: MutableList<MessageDetails> = messageDetails

  class MessageViewHolder(itemView: View) : ViewHolder(itemView) {
    var container: ConstraintLayout = itemView.findViewById(R.id.chatsContainer)
    var senderNameTextView: TextView = itemView.findViewById(R.id.senderNameTextView)
  }

  fun addItems(messageDetails: List<MessageDetails>?) {
    messageLists.clear()
    messageLists.addAll(messageDetails!!)
    notifyDataSetChanged()
  }

  fun addItem(messageDetail: MessageDetails) {
    messageLists.add(messageDetail)
    notifyItemChanged(messageLists.size - 1)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
    val v: View = LayoutInflater.from(parent.context).inflate(R.layout.message_items, parent, false)
    return MessageViewHolder(v)
  }

  override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {


    val currentItem: MessageDetails = messageLists[position]

    holder.senderNameTextView.text = String.format("%s %s", currentItem.firstName, currentItem.lastName)
    holder.container.setOnClickListener { v: View -> (v.context as MainActivity).replaceFragment(MainFragment.newInstance(currentItem)) }
  }

    override fun getItemCount(): Int {
      return messageLists.size

    }
}

