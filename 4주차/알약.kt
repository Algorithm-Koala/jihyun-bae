import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val medicine = Array(31) { LongArray(31) { 0 } }

    for (h in medicine.indices) {
        medicine[0][h] = 1
    }

    for (w in 1..<medicine.size) {
        for (h in w..<medicine.size) {
            medicine[w][h] = medicine[w - 1][h] + medicine[w][h - 1]
        }
    }

    while (true) {
        val input = bufferedReader.readLine().toInt()

        if (input == 0) break

        bufferedWriter.write(medicine[input][input].toString())
        bufferedWriter.newLine()
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}
