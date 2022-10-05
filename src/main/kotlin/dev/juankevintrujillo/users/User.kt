package dev.juankevintrujillo.users

open class User(
    var name: String, var email: String
) {

    fun contactCard() {
        println("INFO: --> Contact $name by sending a message to $email")
    }

}