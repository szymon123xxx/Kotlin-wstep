fun main() {

    println(listOfNumbers(listOf(1, 2, 3.5, 5, -6, 1, 1)))
    println(listOfStrings(listOf("cherry", "blueberry", "citrus", "apple", "apricot", "banana", "coconut")))
    println(permutations(listOf(1,2,3)))
    println(preambula(5, listOf(35, 25, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)))
}

fun listOfNumbers(list: List<Any>): List<Any> {
    val returnList = mutableListOf<Any>()

    for (item in list.filterIndexed { index, any -> (index % 2 == 1) && !(any.toString()).contains("-") }){
        when(item){
            is Int -> returnList.add(item * item)
            is Double -> returnList.add(item * item)
            is Float -> returnList.add(item * item)
            else -> continue
        }
    }
    return returnList
}

fun listOfStrings(list: List<String>): MutableList<Pair<Char, MutableList<String>>> {
    val duplicate = list.sortedBy { it.take(1) }.sortedBy { it.length % 2 == 0 }
    val listX: MutableMap<Char, Int> = mutableMapOf()
    val listY = mutableListOf<Pair<Char, MutableList<String>>>()

    for (x in list){
        for (j in x) {
            if (j == x[0])
                listX[j] = 0
        }
    }

    for ((key, value) in listX.toSortedMap()){
        val listZ = mutableListOf<String>()
        for (x in duplicate.indices){
            if (key.toString() == duplicate[x].take(1) && duplicate[x].length % 2 == 0)
                listZ.add(duplicate[x])
            if (x == duplicate.size-1) {
                listY.add(Pair(key,listZ))
            }
        }
    }

    return listY
}

fun permutations(vararg input: List<Int>): Set<List<Int>> {
    val input2 = mutableListOf<Int>()
    for (x in input)
        input2 += x

    if (input2.isEmpty()) return setOf(emptyList())

    val result: MutableSet<List<Int>> = mutableSetOf()
    for (i in input2.indices) {
        permutations(input2 - input2[i]).forEach{
                item -> result.add(item + input2[i])
        }
    }
    return result
}

fun preambula(n: Int, list: List<Int>): Int {
    val splitData = mutableListOf<List<Int>>()
    val sumSplitData = mutableListOf<List<Int>>()

    list.windowed(n, 1).forEach {
        splitData.add(it)
        val sum = mutableListOf<Int>()
        for (i in it.indices){
            for (p in i+1 until it.size){
                sum.add(it[i] + it[p])
            }
        }
        sumSplitData.add(sum)
    }

    var endValue = 0
    for (a in 1 until splitData.size){
        val e = sumSplitData.elementAt(a-1)
        if (!e.contains(splitData.elementAt(a).last())) {
            endValue = splitData.elementAt(a).last()
            break
        }
    }
    return endValue
}

