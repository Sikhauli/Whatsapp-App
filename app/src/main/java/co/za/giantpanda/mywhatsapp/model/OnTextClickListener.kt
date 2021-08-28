package co.za.giantpanda.mywhatsapp.model

interface OnTextClickListener {
  fun onMessageReceived(messagesList: List<MessageDetails>)
}
