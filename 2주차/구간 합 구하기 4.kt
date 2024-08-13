import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val prefixSums = IntArray(n)
    val sums = IntArray(m)

    bufferedReader.readLine().split(" ").forEachIndexed { index, input ->
        prefixSums[index] = when (index) {
            0 -> input.toInt()
            else -> prefixSums[index - 1] + input.toInt()
        }
    }

    repeat(m) { index ->
        val (start, end) = bufferedReader.readLine().split(" ").map { it.toInt() }
        sums[index] = prefixSums[end - 1] - if (start - 2 < 0) 0 else prefixSums[start - 2]
    }

    for (sum in sums) {
        bufferedWriter.write(sum.toString())
        bufferedWriter.newLine()
    }

    bufferedWriter.flush()
    bufferedWriter.close()
    bufferedReader.close()
}
