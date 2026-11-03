class Masters(
    id: String,
    name: String,
    course: String,
    markIn: Double
) : Student(id, name, course, markIn) {

    // Override grading scheme for Masters students
    override fun getGrade(): String {
        return when {
            mark >= 70 -> "Distinction"
            mark >= 60 -> "Merit"
            mark >= 40 -> "Pass"
            else -> "Fail"
        }
    }
    // Display Masters student details
    override fun toString(): String {
        return "Masters: ID=$id, Name=$name, Course=$course, Mark=$mark, Grade=${getGrade()}"
    }
}

