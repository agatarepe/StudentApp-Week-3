fun main() {

    val students = mutableListOf<Student>()

    while (true) {

        print("Enter student ID: ")
        val id = readln()

        print("Enter student name (or type 'quit' to stop): ")
        val name = readln()

        if (name.equals("quit", ignoreCase = true)) {
            break
        }

        print("Enter course: ")
        val course = readln()

        print("Enter mark (0-100): ")
        val markInput = readln().toDoubleOrNull()

        if (markInput == null || markInput !in 0.0..100.0) {
            println("Invalid mark. Please try again.")
            continue
        }

        print("Enter student type (u = Undergraduate, m = Masters): ")
        val type = readln().lowercase()

        val student: Student = when (type) {
            "u" -> Undergraduate(id, name, course, markInput)
            "m" -> Masters(id, name, course, markInput)
            else -> {
                println("Invalid student type. Defaulting to Undergraduate.")
                Undergraduate(id, name, course, markInput)
            }
        }

        students.add(student)

        println("Student added successfully!")
    }

    println()
    println("All Students")
    println("------------")

    for (student in students) {
        println(student)
    }

    println("Program finished.")
}