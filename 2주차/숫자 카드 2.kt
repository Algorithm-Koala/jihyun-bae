import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val hashMap = hashMapOf<Int, Int>()

    val n = bufferedReader.readLine().toInt()

    bufferedReader.readLine().split(" ").forEach {
        val num = it.toInt()
        hashMap[num] = hashMap.getOrDefault(num, 0) + 1
    }

    val m = bufferedReader.readLine().toInt()

    bufferedReader.readLine().split(" ").forEach {
        val num = it.toInt()
        bufferedWriter.write(hashMap.getOrDefault(num, 0).toString() + " ")
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}
