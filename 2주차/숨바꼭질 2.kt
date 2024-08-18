import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, k) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val visited = IntArray(100001) { -1 }
    val queue: Queue<Int> = LinkedList()
    var count = 0

    queue.add(n)
    visited[n] = 0

    while (queue.isNotEmpty()) {
        val top = queue.poll()
        val move = intArrayOf(top + 1, top - 1, top * 2)

        for (next in move) {
            if (next < 0 || next >= 100001 || (visited[next] != -1 && visited[top] + 1 > visited[next])) continue

            visited[next] = visited[top] + 1
            queue.add(next)

            if (next == k) count++
        }
    }

    bufferedWriter.write(if (n == k) "0" else visited[k].toString())
    bufferedWriter.newLine()
    bufferedWriter.write(if (n == k) "1" else count.toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}
