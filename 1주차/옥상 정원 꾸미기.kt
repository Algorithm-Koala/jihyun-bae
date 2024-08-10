import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val repeatCount = bufferedReader.readLine().toInt()
    val stack = Stack<Long>()
    var visibleCount = 0L

    repeat(repeatCount) {
        val building = bufferedReader.readLine().toLong()

        while (stack.isNotEmpty() && stack.peek() <= building) stack.pop()

        visibleCount += stack.size
        stack.push(building)
    }

    bufferedWriter.write(visibleCount.toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}
