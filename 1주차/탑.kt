import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val count = bufferedReader.readLine().toInt()
    val lasers = bufferedReader.readLine().split(" ").map { it.toInt() }
    val stack = Stack<Int>()

    repeat(count) { index ->
        val laser = lasers[index]

        while (stack.isNotEmpty() && lasers[stack.peek()] <= laser) stack.pop()

        bufferedWriter.write((if (stack.isEmpty()) 0 else (stack.peek() + 1)).toString() + " ")

        stack.push(index)
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}
