import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, q) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val elementList = bufferedReader.readLine().split(" ").map { it.toInt() }.sorted()
    val sum = IntArray(n)

    sum[0] = elementList[0]
    for (i in 1..n - 1) {
        sum[i] = sum[i - 1] + elementList[i]
    }

    repeat(q) {
        val (l, r) = bufferedReader.readLine().split(" ").map { it.toInt() - 1 }
        bufferedWriter.write((if(l == 0) sum[r] else sum[r] - sum[l - 1]).toString())
        bufferedWriter.newLine()
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}
