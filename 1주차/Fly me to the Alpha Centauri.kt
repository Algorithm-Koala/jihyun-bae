import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val repeatCount = bufferedReader.readLine().toInt()

    repeat(repeatCount) {
        val (start, end) = bufferedReader.readLine().split(" ").map { it.toInt() }
        val distance = end - start
        var flyCount = sqrt(distance.toDouble()).toInt()
        flyCount = when {
            distance == flyCount * flyCount -> flyCount * 2 - 1
            distance <= flyCount * flyCount + flyCount -> flyCount * 2
            else -> flyCount * 2 + 1
        }
        bufferedWriter.write(flyCount.toString())
        bufferedWriter.newLine()
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}
