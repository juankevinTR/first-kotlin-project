import dev.juankevintrujillo.jobs.Careers
import dev.juankevintrujillo.jobs.JobDetails
import dev.juankevintrujillo.jobs.JobStatus
import dev.juankevintrujillo.users.companies.Company
import dev.juankevintrujillo.users.seekers.Seeker
import dev.juankevintrujillo.users.seekers.SeekerStatus

fun main() {
    val seeker = Seeker("Pepe", "hello@world.com", "")
    with(seeker) {
        println("##########-- Working with Seeker --##########")
        addMissingNIF("11111111H")
        updateCV("Android Developer")
        println("\t-> Name: $name, CV: $cv, Status: $status")
        updateStatus(SeekerStatus.LISTENINGOFFERS)
        println("\t-> Name: $name, CV: $cv, Status: $status")
        contactCard()
        seeker.discardJobApplication()
    }

    val spegcCompany = Company("SPEGC", "info@spegc.org", "A-35483221")
    val spegcJob1 = JobDetails(
        "Android Developer", "None", 28000, 33000
    )
    val spegcJob2 = JobDetails(
        "iOS Developer (Junior)", "None", 30000, 35000, JobStatus.OPEN
    )
    val spegcJob3 = JobDetails(
        "Web Developer", "None", 24000, 28000, JobStatus.CLOSE
    )
    with(spegcCompany) {
        println("\n##########-- Working with Company --##########")
        addJob(spegcJob1)
        addJob(spegcJob2)
        addJob(spegcJob3)
        println("\t-> Is the company $name hiring: $isHiring")
    }

    val myCompany = Company("JKCompany", "info@helloworld.com", "12345678Z")
    val myCompanyJob1 = JobDetails(
        "iOS Developer (Senior)", "None", 45000, 50000, JobStatus.OPEN
    )
    with(myCompany) {
        addJob(myCompanyJob1)
        println("\t-> Is the company $name hiring: $isHiring")
        seeker.discardJobApplication()
    }

    println("\n##########-- Working with All Careers --##########")
    val allCareers: MutableSet<Careers> = mutableSetOf<Careers>().mergeCareers(
            spegcCompany.careers, myCompany.careers
        )
    allCareers.filter { it.jobDetails.status == JobStatus.OPEN }.forEach { it.showJobInfo() }

}