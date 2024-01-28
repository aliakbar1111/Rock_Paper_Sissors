var comWinCount = 0
var userWinCount = 0
fun main() {

    val finalResult :String
    val options = arrayOf("Rock", "Paper", "Scissors")
    for (i in 1..5) {
        val gameChoice = getGameChoice(options)
        val userChoice = getUserChoice(options)
        printResult(userChoice, gameChoice)

    }
    finalResult = if (comWinCount == userWinCount) "Finally Tie "
    else if (comWinCount > userWinCount) "Finally You Lose"
    else "Finally You Win"
    println(" $finalResult Your score is $userWinCount My score is $comWinCount")
}

fun getGameChoice(optionsParam: Array<String>) = optionsParam[(Math.random() * optionsParam.size).toInt()]


fun getUserChoice(optionsParam: Array<String>): String {

    var userChoice = ""
    var isValidChoice = false
//    Loop until user enter a valid choice
    while (!isValidChoice) {
// Ask users for their choice
        print("please enter the one of the following")
        for (item in optionsParam) print(" $item")
        println(".")
// Read the user choice
        val userInput = readln().capitalize()
//        Validate the user choice
        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoice = userInput
//            if the user choice is invalid
        } else println(" You must enter a valid choice ")

    }
    return userChoice

}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String
    if (userChoice == gameChoice) result = "Tie! "
    else if ((userChoice == "Rock" && gameChoice == "Scissors")
        || (userChoice == "Paper" && gameChoice == "Rock") ||
        (userChoice == "Scissors" && gameChoice == "Paper")
    ) {
        result = "You Win! "
        userWinCount++
    } else {
        result = "You lose !"
        comWinCount++
    }
    println("You chose $userChoice I chose $gameChoice result is $result")
}