import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(-1, 1, 0, 0)

    val (n, m) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { bufferedReader.readLine().map { it.toString().toInt() }.toIntArray() }
    val visited = Array(2) { Array(n) { IntArray(m) { -1 } } }
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()

    visited[0][0][0] = 1
    queue.add(Triple(0, 0 , 0))

    while (queue.isNotEmpty()) {
        val top = queue.poll()

        for (i in dx.indices) {
            val next = Triple(top.first, top.second + dx[i], top.third + dy[i])

            if (next.second == n - 1 && next.third == m - 1) {
                bufferedWriter.write((visited[top.first][top.second][top.third] + 1).toString())
                bufferedWriter.flush()
                bufferedWriter.close()
                return
            }

            if (next.second < 0 || next.second >= n || next.third < 0 || next.third >= m) continue

            if (graph[next.second][next.third] == 0) {
                if (visited[next.first][next.second][next.third] == -1) {
                    visited[next.first][next.second][next.third] = visited[top.first][top.second][top.third] + 1
                    queue.add(next)
                }
            } else if (next.first == 0 && visited[next.first + 1][next.second][next.third] == -1) {
                visited[next.first + 1][next.second][next.third] = visited[top.first][top.second][top.third] + 1
                queue.add(next.copy(first = next.first + 1))
            }
        }
    }

    bufferedWriter.write(if (n == 1 && m == 1 && graph[0][0] == 0) "1" else "-1")
    bufferedWriter.flush()
    bufferedWriter.close()
}
