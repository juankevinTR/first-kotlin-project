package dev.juankevintrujillo.jobs

import dev.juankevintrujillo.users.companies.Company

open class Careers(val jobDetails: JobDetails, val company: Company) {

    private fun getSalaryAverage(): Double {
        with(jobDetails) {
            return listOf(minSalary, maxSalary).average()
        }
    }

    fun showJobInfo() {
        println("INFO: --> ${company.name} is hiring for ${jobDetails.title} with an average salary of ${getSalaryAverage()}")
    }

}