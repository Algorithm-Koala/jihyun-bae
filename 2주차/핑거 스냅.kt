import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val max = 1000000
    val isPrime = BooleanArray(max + 1) { true }
    isPrime[0] = false
    isPrime[1] = false
    for (i in 2..sqrt(max.toDouble()).toInt()) {
        if (isPrime[i]) {
            for (j in i * i..max step i) {
                isPrime[j] = false
            }
        }
    }

    val t = bufferedReader.readLine().toInt()

    repeat(t) {
        val (n, a, b) = bufferedReader.readLine().split(" ").map { it.toInt() }
        val primes =
            isPrime.slice(a..b).withIndex().filter { it.value }.map { it.index + a }.toList()

        var output = -1

        if (n in primes) output = 0
        else if (primes.isNotEmpty() && n !in primes) {
            val queue: Queue<Int> = LinkedList()
            val visited = IntArray(max + 1) { -1 }

            queue.add(n)
            visited[n] = 0

            loop@ while (queue.isNotEmpty()) {
                val top = queue.poll()
                val changes = intArrayOf(top / 2, top / 3, min(max, top + 1), max(top - 1, 0))

                for (index in changes) {
                    if (index in primes) {
                        output = visited[top] + 1
                        break@loop
                    } else if (visited[index] == -1) {
                        visited[index] = visited[top] + 1
                        queue.add(index)
                    }
                }
            }
        }
        bufferedWriter.write(output.toString())
        bufferedWriter.newLine()
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}
