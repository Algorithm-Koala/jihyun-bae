import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val dx = arrayOf(1, 0, -1, 0)
    val dy = arrayOf(0, 1, 0, -1)

    val (m, n, k) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val list = Array(m) { BooleanArray(n) }
    val ans = mutableListOf<Int>()

    repeat(k) {
        val (startX, startY, endX, endY) = bufferedReader.readLine().split(" ").map { it.toInt() }

        for (i in startY..<endY) {
            for (j in startX..<endX) {
                list[i][j] = true
            }
        }
    }

    fun dfs(x: Int, y: Int) {
        list[x][y] = true
        ans[ans.size - 1]++

        for (i in 0 ..< 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue

            if (!list[nx][ny]) {
                dfs(nx, ny)
            }
        }
    }

    for (i in 0 ..< m) {
        for (j in 0 ..< n) {
            if (!list[i][j]) {
                ans.add(0)
                dfs(i, j)
            }
        }
    }

    ans.sort()

    bufferedWriter.write(ans.size.toString())
    bufferedWriter.newLine()

    ans.forEach { value ->
        bufferedWriter.write("$value ")
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}
