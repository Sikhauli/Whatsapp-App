package co.za.giantpanda.mywhatsapp.model

interface MessageListener {
  fun onMessageReceived(messagesList: List<MessageDetails>)
}
