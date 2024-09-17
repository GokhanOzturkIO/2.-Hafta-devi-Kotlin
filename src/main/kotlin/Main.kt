package src.main.kotlin

fun main() {
  val smileyEmoji = "\\uD83D\\uDE0A"  // 😊 emoji

  println("Hello, welcome! $smileyEmoji")

  startProcessAgain()

}

fun startProcessAgain() {
  val number1 = getNumber("first")

  val operation = getOperation()

  val number2 = getNumber("second")

  calculateResult(number1, operation, number2)
}

fun getNumber(numberName: String): String {
  print("Please enter the $numberName number: ")
  val number1 = readlnOrNull()
  return number1.toString()
}

fun getOperation(): String {
  print("Please enter the operation (+, -, *, /, %): ")
  var operation =  readlnOrNull()
  operation = checkOperation(operation.toString())
  return  operation.toString()
}

fun checkOperation(operation: String): String {
  var operation = operation

  if (operation != "+" && operation != "-" && operation != "*" && operation != "/" && operation != "%") {
    println("Ops!. Invalid operation please try again.")
    operation = getOperation()
  }

  return  operation
}
fun calculateResult(number1: String, operation: String, number2: String) {

  val number1 = number1.toDouble()
  val number2 = number2.toDouble()

  when(operation) {
    "+" -> {
      print("The result is: ${number1.plus(number2)}")
    }
    "-" -> {
      print("The result is: ${number1.minus(number2)}")
    }
    "*" -> {
      print("The result is: ${number1.times(number2)}")
    }
    "/" -> {
      if (number2.toInt() == 0) {
        println("Ops!. Cannot divide by zero.")
      } else {
        print("The result is: ${number1.div(number2)}")
      }
    }
    "%" -> {
      if (number2.toInt() == 0) {
        println("Ops!. Cannot rem by zero.")
      } else {
        print("The result is: ${number1.rem(number2)}")
      }
    } else -> {
      println("Ops!. Invalid operation.")
    }
  }

  checkRestartAnswer()
}

fun checkRestartAnswer() {
  println("\nDo you want to start again? y/n")
  val answer = readlnOrNull()

  if(answer == "y" || answer == "Y" || answer == "Yes" || answer == "yes")  {
    startProcessAgain()
  } else if (answer == "n" || answer == "N" || answer == "No" || answer == "no") {
    println("Thank you for using the calculator. Goodbye!")
  } else {
    println("Ops! Wrong input. Please try again")
    checkRestartAnswer()
  }
}