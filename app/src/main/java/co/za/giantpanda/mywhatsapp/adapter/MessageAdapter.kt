package co.za.giantpanda.mywhatsapp.adapter

import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.za.giantpanda.mywhatsapp.ui.MainActivity
import co.za.giantpanda.mywhatsapp.ui.MainFragment
import co.za.giantpanda.mywhatsapp.R
import co.za.giantpanda.mywhatsapp.model.MessageDetails
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

class MessageAdapter(messageDetails: MutableList<MessageDetails>) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
  private val messageLists: MutableList<MessageDetails> = messageDetails

  class MessageViewHolder(itemView: View) : ViewHolder(itemView) {
    var container: ConstraintLayout = itemView.findViewById(R.id.container)
    var senderNameTextView: TextView = itemView.findViewById(R.id.senderNameTextView)

    var messageBodyTextView: TextView = itemView.findViewById(R.id.messageBodyTextView)
    var dateTimeTextView: TextView = itemView.findViewById(R.id.dateTimeTextView)
    //var isImportantImageView: ImageButton

    init {
      //subjectTextView = itemView.findViewById(R.id.subjectTextView)
      //isImportantImageView = itemView.findViewById(R.id.isImportantImageView)
    }
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
    try {
      val date = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(currentItem.createdAt)
      if (date != null) {
        holder.dateTimeTextView.text = DateUtils.getRelativeTimeSpanString(date.time)
      }
    } catch (e: ParseException) {
      e.printStackTrace()
    }
    holder.senderNameTextView.text = String.format("%s %s", currentItem.firstName, currentItem.lastName)
    //holder.subjectTextView.setText(currentItem.getSubject())
    holder.messageBodyTextView.text = currentItem.messageBody
   // holder.isImportantImageView.setImageResource(if (currentItem.isImportant()) R.drawable.ic_star_dark else R.drawable.ic_star_outline)
    holder.container.setOnClickListener { v: View -> (v.context as MainActivity).replaceFragment(MainFragment.newInstance(currentItem)) }
  }

  override fun getItemCount(): Int {
    return messageLists.size
  }
}