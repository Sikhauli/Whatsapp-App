package co.za.giantpanda.whatsapp1.model

import java.io.Serializable

  class MessageDetails : Serializable
  {

    var firstName: String? = null
    var id: String? = null
    var lastName: String? = null
    var subject: String? = null
    var messageBody: String? = null
    var createdAt: String? = null
    var isImportant = false

    fun MessageDetails(firstName: String, lastName: String, subject: String, messageBody: String, createdAt: String, id: String, isImportant: Boolean) {
      this.firstName = firstName
      this.lastName = lastName
      this.messageBody = messageBody
      this.subject = subject
      this.id = id
      this.createdAt = createdAt
      this.isImportant = isImportant
    }

    @JvmName("getFirstName1") fun getFirstName(): String? {
      return firstName
    }

    @JvmName("getLastName1") fun getLastName(): String? {
      return lastName
    }

   @JvmName("getSubject1")
    fun getSubject(): String? {
      return subject
    }

    @JvmName("getMessageBody1")
     fun getMessageBody(): String? {
      return messageBody
    }

    @JvmName("getId1")
     fun getId(): String? {
      return id
    }

    @JvmName("getCreatedAt1")
     fun getCreatedAt(): String? {
      return createdAt
    }

    @JvmName("isImportant1")
     fun isImportant(): Boolean {
      return isImportant
    }

  }