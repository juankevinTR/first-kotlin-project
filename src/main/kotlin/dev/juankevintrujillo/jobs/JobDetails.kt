package dev.juankevintrujillo.jobs

data class JobDetails(
    val title: String,
    val description: String? = "",
    val minSalary: Int,
    val maxSalary: Int,
    val status: JobStatus? = JobStatus.HIDDEN
)