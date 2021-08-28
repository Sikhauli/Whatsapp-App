package co.za.giantpanda.mywhatsapp.model

import java.io.Serializable
//
//data class MessageDetails(
//    var firstName: String = "",
//    var id: String = "",
//    var lastName: String = "",
//    var subject: String = "",
//    var messageBody: String = "",
//    var createdAt: String = "",
//    var isImportant: Boolean = false
//) : Serializable

class MessageDetails : Serializable {

    var firstName: String? = null
    var id: String? = null
    var lastName: String? = null
    private var subject: String? = null
    var messageBody: String? = null
    var createdAt: String? = null
    private var email: String? = null
    private var isImportant = false

    fun messageDetails(firstName: String, lastName: String, subject: String, messageBody: String, email: String, createdAt: String, id: String, isImportant: Boolean) {
        this.firstName = firstName
        this.lastName = lastName
        this.messageBody = messageBody
        this.subject = subject
        this.id = id
        this.createdAt = createdAt
        this.email = email
        this.isImportant = isImportant
    }

    @JvmName("getFirstName1") fun getFirstName(): String? {
        return firstName
    }

    @JvmName("getLastName1") fun getLastName(): String? {
        return lastName
    }

    @JvmName("getSubject1") fun getSubject(): String? {
        return subject
    }

    @JvmName("getMessageBody1") fun getMessageBody(): String? {
        return messageBody
    }

    @JvmName("getEmail1") fun getEmail(): String? {
        return email
    }

    @JvmName("getId1") fun getId(): String? {
        return id
    }

    @JvmName("getCreatedAt1") fun getCreatedAt(): String? {
        return createdAt
    }

    @JvmName("isImportant1") fun isImportant(): Boolean {
        return isImportant
    }
}
