package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var restart: Boolean = false
    println("Hello")

    fun isNumeric(input: String): Boolean {
        return try {
            input.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    fun calc(){
        println("Enter first number")
        val num = readLine()
        println("Enter calc method (+, -, /, *)")
        val method: String = readln()
        println("Enter second number")
        val num2= readLine()
        var result: Int? = null
        var answer: String

        if(isNumeric(num.toString()) && isNumeric(num2.toString()) && num != null && num2 != null){
            if(method.equals("+")){
                result = num2.toInt() + num.toInt()
                println(result)
            }else if(method.equals("-")){
                result = num.toInt() - num2.toInt()
                println(result)
            }else if(method.equals("*")){
                result = num2.toInt() * num.toInt()
                println(result)
            }else if(method.equals("/")){
                result = num.toInt() + num2.toInt()
                println(result)
            }else{
                println("it's not a calc method")
            }
        }else{
            println("The value you entered is not valid")
        }



        println("Do you wanna play again? (Y/N)")
        answer = readln()
        if(answer.equals("Y")){
            restart = true;
        }else if(answer.equals("N")){
            restart = false
        }else{
            println("Please enter a valid value")
        }
    }

    calc()
    while(restart){
        calc()
    }

}