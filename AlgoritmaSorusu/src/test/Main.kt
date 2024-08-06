fun main() {

    println("Hello. Welcome to my first terminal application")

    print("Can you write me your name: ")

    val name = readLine()

    if (name !=null && name.isNotBlank()) {

        println("Hello, $name! How are you today?")
    } else {
        println("you did not enter your name")
    }

           println("Enter the mathematical operation you want to perform (+, -, *, /):")
        val operation = readLine()

        if (operation != null) {
            when (operation) {
                "+" -> println("You selected addition.")
                "-" -> println("You selected subtraction.")
                "*" -> println("You selected multiplication.")
                "/" -> println("You selected division.")
                else -> println("Invalid operation.")
            }
        } else {
            println("Invalid input")
        }
        val firstNumber = readLine()?.toDoubleOrNull()
        if (firstNumber != null) {
            println("Second Number Enter:")
            val secondNumber = readLine()?.toDoubleOrNull()
            if (secondNumber != null) {
                println("Firs Number: $firstNumber")
                println("Second Number: $secondNumber")

            } else {
                println("invalid second number.")
            }

        } else {
            println("invalid first number.")
        }
        var continuation = true

        while (continuation) {
            println("First Number Enter:")
            val firstNumber = readLine()?.toDoubleOrNull()

            if (firstNumber != null) {
                println("Second Number Enter:")
                val secondNumber= readLine()?.toDoubleOrNull()

                if (secondNumber != null) {
                    val result = firstNumber + secondNumber
                    println("result: $result")
                } else {
                    println("invalid second number.")
                    continue
                }
            } else {
                println("invalid first number.")
                continuation
            }

            println("do you want to continue? (Y/N):")
            val answer = readLine()?.trim()?.toUpperCase()

            continuation = answer == "Y"
        }

        println("END")
    }

