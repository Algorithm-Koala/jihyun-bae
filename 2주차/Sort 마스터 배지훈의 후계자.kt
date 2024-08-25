import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = bufferedReader.readLine().split(" ").map { it.toInt() }

    val elementList = IntArray(n) { bufferedReader.readLine().toInt() }.sortedArray()

    repeat(m) {
        var start = 0
        var end = elementList.size - 1
        var index = -1

        val target = bufferedReader.readLine().toInt()

        while(start <= end) {
            val mid = (start + end) / 2

            when {
                elementList[mid] == target && end == mid -> {
                    index = mid
                    break
                }

                elementList[mid] == target -> {
                    end = mid
                }

                elementList[mid] > target -> {
                    end = mid - 1
                }

                elementList[mid] < target -> {
                    start = mid + 1
                }
            }
        }

        bufferedWriter.write(index.toString())
        bufferedWriter.newLine()
    }


    bufferedWriter.flush()
    bufferedWriter.close()
}
