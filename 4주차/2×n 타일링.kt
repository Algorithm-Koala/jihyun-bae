import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = bufferedReader.readLine().toInt()

    val tile = IntArray(1001) { 0 }

    tile[1] = 1
    tile[2] = 2

    for (i in 3..n) {
        tile[i] = (tile[i - 1] + tile[i - 2]) % 10007
    }

    bufferedWriter.write(tile[n].toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}
