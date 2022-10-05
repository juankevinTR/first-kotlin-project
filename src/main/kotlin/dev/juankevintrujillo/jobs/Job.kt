package dev.juankevintrujillo.jobs

import dev.juankevintrujillo.users.companies.Company

open class Job(
    jobDetails: JobDetails, company: Company
) : Careers(jobDetails, company) {

}