package co.za.giantpanda.mywhatsapp.model

import java.io.Serializable

data class MessageDetails(
    var firstName: String = "",
    var id: String = "",
    var lastName: String = "",
    var subject: String = "",
    var messageBody: String = "",
    var createdAt: String = "",
    var isImportant: Boolean = false
) : Serializable