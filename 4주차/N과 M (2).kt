import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = bufferedReader.readLine().split(" ").map { it.toInt() }

    val array = Array(m) { i -> i }
    val visit = Array(n + 1) { false }

    fun find(idx: Int, len: Int) {
        if (len == m) {
            array.forEach { bufferedWriter.write("$it ") }
            bufferedWriter.newLine()
            return
        }

        for (i in idx..n) {
            if (!visit[i]) {
                visit[i] = true
                array[len] = i
                find(i, len + 1)
                visit[i] = false
            }
        }
    }

    find(1, 0)

    bufferedWriter.flush()
    bufferedWriter.close()
}
