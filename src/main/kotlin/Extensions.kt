import dev.juankevintrujillo.jobs.Careers

fun MutableSet<Careers>.mergeCareers(
    first: MutableSet<Careers>, second: MutableSet<Careers>
): MutableSet<Careers> {
    val result: MutableSet<Careers> = mutableSetOf()
    result.addAll(first)
    result.addAll(second)
    return result
}