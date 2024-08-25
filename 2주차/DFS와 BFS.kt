import java.util.LinkedList
import java.util.Queue

lateinit var graph: Array<IntArray>
lateinit var visited: IntArray

fun main() {
    val bufferReader = System.`in`.bufferedReader()
    val (n, m, v) = bufferReader.readLine().split(" ").map { it.toInt() }

    graph = Array(n + 1) { IntArray(n + 1) }
    visited = IntArray(n + 1)

    repeat(m) {
        val (x, y) = bufferReader.readLine().split(" ").map { it.toInt() }
        graph[x][y] = 1
        graph[y][x] = 1
    }

    dfs(n, v)
    println()

    visited = IntArray(n + 1)

    bfs(n, v)
}

fun dfs(n: Int, v: Int) {
    visited[v] = 1
    print("$v ")

    for (i in 1..n) {
        if (graph[v][i] == 1 && visited[i] == 0)
            dfs(n, i)
    }
}

fun bfs(n: Int, v: Int) {
    val queue: Queue<Int> = LinkedList<Int>()
    queue.add(v)
    visited[v] = 1
    print("$v ")

    while (queue.isNotEmpty()) {
        val top = queue.poll()

        for (i in 1..n) {
            if (graph[top][i] == 1 && visited[i] == 0) {
                queue.add(i)
                visited[i] = 1
                print("$i ")
            }
        }
    }
    queue.clear()
}
