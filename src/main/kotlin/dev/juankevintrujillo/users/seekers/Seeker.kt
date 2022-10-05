package dev.juankevintrujillo.users.seekers

import dev.juankevintrujillo.users.JobApplication
import dev.juankevintrujillo.users.User

class Seeker(
    name: String,
    email: String,
    private var nif: String? = null,
    var cv: String? = null,
    var status: SeekerStatus? = SeekerStatus.NOSEEKING
) : User(name, email), JobApplication {

    fun addMissingNIF(missingNIF: String) {
        nif?.let { println("\tERROR: --> NIF could not be changed") } ?: run { nif = missingNIF }
    }

    fun updateCV(cvText: String) {
        cv = cvText.also {
            println("INFO: --> CV was updated")
        }
    }

    fun updateStatus(newStatus: SeekerStatus) {
        status = newStatus.also {
            println("INFO: --> Status was updated")
        }
    }

    override fun discardJobApplication() {
        println("INFO: --> Seeker ($name) has remove his/her application")
    }
}