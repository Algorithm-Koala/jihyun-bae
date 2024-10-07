import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val dx = intArrayOf(0, 0, -1, 1)
    val dy = intArrayOf(1, -1, 0, 0)

    val (r, c) = bufferedReader.readLine().split(" ").map { it.toInt() }

    val board =
        Array(r) { bufferedReader.readLine().toCharArray() }

    val visited = BooleanArray(26) { false }

    visited[board[0][0] - 'A'] = true

    var maxDepth = -1

    fun dfs(input: Pair<Int, Int>, depth: Int) {
        maxDepth = max(maxDepth, depth)

        for (i in dx.indices) {
            if (input.first + dx[i] in 0..<r && input.second + dy[i] in 0..<c && !visited[board[input.first + dx[i]][input.second + dy[i]] - 'A']) {
                visited[board[input.first + dx[i]][input.second + dy[i]] - 'A'] = true
                dfs(Pair(input.first + dx[i], input.second + dy[i]), depth + 1)
                visited[board[input.first + dx[i]][input.second + dy[i]] - 'A'] = false
            }
        }
    }

    dfs(input = Pair(0, 0), depth = 1)

    bufferedWriter.write(maxDepth.toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}
