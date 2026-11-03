class University {

    private val students = mutableListOf<Student>()

    fun enrolStudent(student: Student) {
        students.add(student)
    }

    fun findStudentById(id: String): Student? {
        return students.find { it.id == id }
    }

    fun findStudentsByName(name: String): MutableList<Student> {
        return students.filter {
            it.name.equals(name, ignoreCase = true)
        }.toMutableList()
    }
}
