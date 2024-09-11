import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = bufferedReader.readLine().toInt()
    val works = Array(n) {
        bufferedReader.readLine().split(" ").map { it.toInt() }.let { (t, s) -> Pair(t, s) }
    }.sortedArrayWith { first, second ->
        second.second.compareTo(first.second)
    }

    var min = Int.MAX_VALUE

    for (i in works) {
        min = min(min, i.second) - i.first
    }

    bufferedWriter.write(if (min >= 0) min.toString() else "-1")
    bufferedWriter.flush()
    bufferedWriter.close()
}
