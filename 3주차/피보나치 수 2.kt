import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = bufferedReader.readLine().toInt()
    val list  = LongArray(95)

    list[0] = 0
    list[1] = 1
    list[2] = 1

    for (i in 3..n) {
        list[i] = list[i - 1] + list[i - 2]
    }

    bufferedWriter.write(list[n].toString())
    bufferedWriter.flush()
    bufferedWriter.close()
}
