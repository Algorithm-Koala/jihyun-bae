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
    val visited = Array(n) { IntArray(m) }
    val graph = Array(n) { bufferedReader.readLine().map { it.toString().toInt() }.toIntArray() }

    val queue: Queue<Pair<Int, Int>> =  LinkedList<Pair<Int, Int>>()
    queue.add(Pair(0, 0))
    visited[0][0] = 1

    while (queue.isNotEmpty()) {
        val top = queue.poll()

        for (index in dx.indices) {
            val nextX = top.first + dx[index]
            val nextY = top.second + dy[index]
            if (0 > nextX ||nextX >= n || 0 > nextY || nextY >= m) continue

            if (graph[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
                queue.add(Pair(nextX, nextY))
                visited[nextX][nextY] = visited[top.first][top.second] + 1
            }
        }
    }

    bufferedWriter.write(visited[n - 1][m - 1].toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}
