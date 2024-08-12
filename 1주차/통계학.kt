import kotlin.math.roundToInt

fun main() {
    val bufferReader = System.`in`.bufferedReader()

    val repeatCount = bufferReader.readLine().toInt()
    val numbers = mutableListOf<Int>()

    repeat(repeatCount) {
        numbers.add(bufferReader.readLine().toInt())
    }
    numbers.sort()

    println(numbers.average().roundToInt())
    println(numbers[numbers.count() / 2])

    val count = numbers.groupingBy { it }.eachCount()
    val max = count.maxOf { it.value }
    val maxSorted = count.filter { it.value == max }.keys.sorted()
    println(if (maxSorted.size == 1) maxSorted.first() else maxSorted[1])
    println(numbers.max() - numbers.min())
}
