import java.io.File
import kotlin.random.Random

fun main() {
    readFromFile("D:\\WstepDoProg_Kotlin\\k2\\src\\main\\kotlin\\slowa.txt")
    hangMan()
}
val words = mutableListOf<String>()
var lives = 6
var dic = mutableListOf(" +---+", "     |", "     |", "     |", "    ===")

fun readFromFile(fileName: String) = File(fileName).forEachLine { words.add(it) }

fun takeRandomKey( myList: MutableList<String>): String {
    val random = Random.nextInt(0, words.size)
    for (x in myList){
        return  myList[random]
    }
    return "xxx"
}

fun drawing(){
    when (lives){
        5 -> dic[1] = " 0   |"
        4 -> dic[2] = " |   |"
        3 -> dic[2] = "/|   |"
        2 -> dic[2] = "/|\\ |"
        1 -> dic[3] = "/    |"
        0 -> dic[3] = "/ \\ |"
    }
    for (i in dic)
        println(i)
}

fun hangMan(){
    val password = takeRandomKey(words)
    val usedLetters = mutableListOf<Char>()
    var copyPassword = ""

    println("Word length: ${password.length}")

    for (element in password){
        copyPassword += "-"
    }

    while (true){
        drawing()
        println("Password: $copyPassword")
        println("Lives: $lives")

        if (usedLetters.size > 0)
            println("Used letters: ${usedLetters.distinct()}")

        print("Enter the letter: ")

        val variableName: Char? = try {
            readLine()?.get(0)
        } catch (e: StringIndexOutOfBoundsException) { null }

        if (variableName in usedLetters){
            println("That letter was already used ")
        }

        for (element in password.indices) {
            if (variableName != null) {
                if (password[element].uppercaseChar() == variableName.uppercaseChar()) {
                    copyPassword = copyPassword.substring(0, element) + variableName.uppercaseChar() + copyPassword.substring(element + 1)
                    usedLetters.add(variableName.uppercaseChar())
                }
            }
        }

        if (variableName != null) {
            if (variableName.lowercaseChar() !in password)
                lives--
        }

        if (password.uppercase() == copyPassword.uppercase()) {
            println("Congratulations you won")
            break
        }

        if (lives == 0) {
            drawing()
            println("Password: $copyPassword")
            println("Lives: $lives")
            println("Used letters: ${usedLetters.distinct()}")
            println()
            println("YOU LOST")
            println("ANSWER: $password")
            break
        }
    }
}