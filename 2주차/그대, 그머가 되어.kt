import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (a, b) = bufferedReader.readLine().split(" ").map { it.toInt() - 1 }
    val (n, m) = bufferedReader.readLine().split(" ").map { it.toInt() }

    if (a == b) {
        bufferedWriter.write("0")
        bufferedWriter.flush()
        bufferedWriter.close()
        return
    }

    val graph = Array(n) { IntArray(n) }
    val visited = Array(n) { -1 }
    val queue: Queue<Int> = LinkedList()

    repeat(m) {
        val (x, y) = bufferedReader.readLine().split(" ").map { it.toInt() - 1 }
        graph[x][y] = 1
        graph[y][x] = 1
    }

    queue.add(a)
    visited[a] = 0

    while (queue.isNotEmpty()) {
        val top = queue.poll()

        repeat(n) { index ->
            if (graph[top][index] == 1 && visited[index] == -1) {
                if (index == b) {
                    bufferedWriter.write((visited[top] + 1).toString())
                    bufferedWriter.flush()
                    bufferedWriter.close()
                    return
                }
                queue.add(index)
                visited[index] = visited[top] + 1
            }
        }
    }

    bufferedWriter.write("-1")

    bufferedWriter.flush()
    bufferedWriter.close()
}
