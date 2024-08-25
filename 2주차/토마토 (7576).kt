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

    val (m, n) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { bufferedReader.readLine().split(" ").map { it.toInt() }.toIntArray() }

    val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()

    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (graph[i][j] == 1) queue.add(Pair(i, j))
        }
    }

    while (queue.isNotEmpty()) {
        val top = queue.poll()

        for (index in dx.indices) {
            val next = Pair(top.first + dx[index], top.second + dy[index])

            if (next.first < 0 || next.first >= n || next.second < 0 || next.second >= m) continue

            if (graph[next.first][next.second] == 0) {
                queue.add(next)
                graph[next.first][next.second] = graph[top.first][top.second] + 1
            }
        }
    }

    bufferedWriter.write(if (graph.any { row -> row.any { it == 0} }) "-1" else (graph.map { it.toList() }.flatten().max() - 1).toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}
