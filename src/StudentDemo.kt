fun main() {

    val university = University()

    while (true) {
        println()
        println("1. Add student")
        println("2. Search student by ID")
        println("3. Search students by name")
        println("4. Quit")
        print("Choose an option: ")

        when (readln()) {
            "1" -> {
                print("Enter student ID: ")
                val id = readln()

                print("Enter student name: ")
                val name = readln()

                print("Enter course: ")
                val course = readln()

                print("Enter mark (0-100): ")
                val mark = readln().toDoubleOrNull()

                if (mark == null || mark !in 0.0..100.0) {
                    println("Invalid mark.")
                    continue
                }

                print("Student type (u = Undergraduate, m = Masters): ")
                val type = readln().lowercase()

                val student: Student = when (type) {
                    "u" -> Undergraduate(id, name, course, mark)
                    "m" -> Masters(id, name, course, mark)
                    else -> {
                        println("Invalid student type.")
                        continue
                    }
                }

                university.enrolStudent(student)
                println("Student added successfully!")
            }

            "2" -> {
                print("Enter student ID: ")
                val id = readln()

                val student = university.findStudentById(id)

                if (student != null) {
                    println(student)
                } else {
                    println("Student not found.")
                }
            }

            "3" -> {
                print("Enter student name: ")
                val name = readln()

                val students = university.findStudentsByName(name)

                if (students.isEmpty()) {
                    println("No students found.")
                } else {
                    for (student in students) {
                        println(student)
                    }
                }
            }

            "4" -> {
                println("Program finished.")
                break
            }

            else -> println("Invalid option. Try again.")
        }
    }
}