import kotlin.math.log

fun main(args: Array<String>) {

    val listOne = arrayOf(1,2,-3,5,-6,-4)
    val listTwo = arrayOf(arrayOf("a", "b", "c"), arrayOf("d", "f", "g"))
    val numbers = (1..5).toList()

    println("Zad1: " + lambdaTry("a",3))
    println("Zad2: " + f("a"))
    println("Zad3: " + fibonacciMain(7))
    println("Zad4: " + log2(4))
    print("zad5 a): ")
    higherfunc1(4, ::log2)
    print("zad5 b): ")
    higherfunc2(7, ::fibonacciMain)
    println("Zad6 a): " + numbers.tail)
    println("Zad6 b): " + numbers.head)
    println("Zad7 a): " + isSorted(listOf(1, 2, 3, 4)) { i: Int, j: Int -> i < j })
    println("Zad7 b): " + isSorted(listOf(1, 1, 1, 1)) { i: Int, j: Int -> i == j })
    println("Zad7 c): " +isSorted(listOf("ahyyhh", "bkjn", "cnn", "duu")) { i: String, j: String -> i.first() < j.first() })
    println("Zad8: " + suma(listOne))
    println("Zad9: " + countElements(listTwo))
}

//zad1
val lambdaTry: (String, Int) -> String = { s, i -> s.repeat(i) } //Dlaczego z (0..i).forEach{ s } nie działa?
//zad2
val f : (String) -> String = { "$it!" }
//zad3
fun fibonacciMain(n: Int): Int {
    tailrec fun fibonacci(n: Int, a: Int = 0, b: Int = 1): Int {
        return if (n == 0) a else fibonacci(n - 1, b, a + b)
    }
    return fibonacci(n)
}
//zad4
fun log2(i: Int): Int {
    fun logTrue(): Double = log(i.toDouble(), 2.00)
    return logTrue().toInt()
}
//zad5
fun higherfunc1( value : Int, myfunc: (Int) -> Int) =  println(myfunc(value))

fun higherfunc2( value : Int, myfunc: (Int) -> Int) = println(myfunc(value))

//zad6
val <T> List<T>.head
    get() = first()

val <T> List<T>.tail
    get() = last()
//zad7
fun <A> isSorted(aa: List<A>, order: (A, A) -> Boolean): Boolean{
    for (x in 0..aa.size){
        for (y in x+1 until aa.size){
            return (order(aa[x],aa[y]))
        }
    }
    return true
}
//zad8
fun suma(a: Array<Int>): Int {
    a.map { it }
        .filter { it > 0 }
        .reduce { accumulator: Int, i -> accumulator + i  }
        .also { return it }
}
//zad9
fun <T> countElements(aa: Array<Array<T>>): Map<T, Int> = aa.flatten().map { it }.groupingBy { it }.eachCount()

