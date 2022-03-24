fun main() {
    println(convertToRoman(984))
    println(convertFromRoman("CMXC"))
    println(isCyclic("1429857"))
}

val romanNumbers = mapOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
)

fun convertToRoman(number: Int): String {

        var num = number
        var result = ""
        for ((value, key) in romanNumbers) {
                while (num >= value) {
                        num -= value
                        result += key
                }
        }
        return result
}

fun convertFromRoman(number: String): Int {

        var result = 0
        var before = 'n'
        for (char in number) {
                when (char) {
                        'I' -> result += 1
                        'V' -> result += if (before == 'I') 3 else 5
                        'X' -> result += if (before == 'I') 8 else 10
                        'L' -> result += if (before == 'X') 30 else 50
                        'C' -> result += if (before == 'X') 80 else 100
                        'D' -> result += if (before == 'C') 300 else 500
                        'M' -> result += if (before == 'C') 800 else 1000
                }
                before = char
        }
        return result
}

fun isCyclic(i: String): Boolean {
        var x = 1
        val convert = i.toInt()
        while (x < i.length){
                val multiple = (x * convert).toString()
                for (number in i) {
                        if (number in multiple) continue else return false
                }
                x++
        }
        return true
}