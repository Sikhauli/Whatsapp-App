package co.za.giantpanda.whatsapp1.model

interface MessageListener {
  fun onMessageReceived(messagesList: List<MessageDetails?>?)
}
