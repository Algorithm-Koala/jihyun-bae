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

    val board = Array(5) { bufferedReader.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visited = Array(5) { IntArray(5) {-1} }
    val (r, c) = bufferedReader.readLine().split(" ").map { it.toInt() }

    val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()

    queue.add(Pair(r, c))
    visited[r][c] = 0

    while (queue.isNotEmpty()) {
        val top = queue.poll()

        for (i in dx.indices) {
            val next = Pair(top.first + dx[i], top.second + dy[i])
            if (0 > next.first || next.first >= 5 || 0 > next.second || next.second >= 5) continue

            if (board[next.first][next.second] == 1) {
                bufferedWriter.write((visited[top.first][top.second] + 1).toString())
                bufferedWriter.flush()
                bufferedWriter.close()
                return
            }

            if (board[next.first][next.second] != -1 && visited[next.first][next.second] == -1) {
                queue.add(next)
                visited[next.first][next.second] = visited[top.first][top.second] + 1
            }
        }
    }

    bufferedWriter.write("-1")

    bufferedWriter.flush()
    bufferedWriter.close()
}
