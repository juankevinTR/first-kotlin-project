package dev.juankevintrujillo.users.companies

import dev.juankevintrujillo.jobs.Careers
import dev.juankevintrujillo.jobs.Job
import dev.juankevintrujillo.jobs.JobDetails
import dev.juankevintrujillo.jobs.JobStatus
import dev.juankevintrujillo.users.JobApplication
import dev.juankevintrujillo.users.User

class Company(
    name: String, email: String, var cif: String? = null, val careers: MutableSet<Careers> = mutableSetOf()
) : User(name, email), JobApplication {

    val isHiring: Boolean
        get() = careers.any { it.jobDetails.status == JobStatus.OPEN }

    fun addMissingCIF(missingCIF: String) {
        cif?.let { println("CIF could not be changed by the user") } ?: run { cif = missingCIF }
    }

    fun addJob(
        jobDetails: JobDetails
    ) {
        val job = Job(jobDetails, this)
        careers.add(job)
    }

    override fun discardJobApplication() {
        println("INFO: --> The profile user was discard by the company ($name). We hope see you again soon :)")
    }
}