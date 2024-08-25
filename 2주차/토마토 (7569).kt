import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val dx = arrayOf(0, 0, 0, 0, -1, 1)
    val dy = arrayOf(0, 0, -1, 1, 0, 0)
    val dz = arrayOf(1, -1, 0, 0, 0, 0)

    val (m, n, h) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val graph = Array(h) { Array(n) { bufferedReader.readLine().split(" ").map { it.toInt() }.toIntArray() } }
    val queue : Queue<Triple<Int, Int, Int>> = LinkedList()

    for (i in graph.indices) {
        for (j in graph[i].indices) {
            for (k in graph[i][j].indices) {
                if (graph[i][j][k] == 1) queue.add(Triple(i, j, k))
            }
        }
    }

    while (queue.isNotEmpty()) {
        val top = queue.poll()

        for (index in dx.indices) {
            val next = Triple(top.first + dz[index], top.second + dy[index], top.third + dx[index])

            if (next.first < 0 || next.first >= h || next.second < 0 || next.second >= n || next.third < 0 || next.third >= m) continue

            if (graph[next.first][next.second][next.third] == 0) {
                queue.add(next)
                graph[next.first][next.second][next.third] = graph[top.first][top.second][top.third] + 1
            }
        }
    }


    bufferedWriter.write((graph.flatten().map { it.toList() }.flatten().let { if(it.contains(0)) "-1" else (it.max() - 1).toString() }))

    bufferedWriter.flush()
    bufferedWriter.close()
}
