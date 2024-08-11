import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack
import kotlin.math.max

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))
    val output = mutableListOf<Long>()

    while (true) {
        val input = bufferedReader.readLine().split(" ").map { it.toInt() }.toMutableList()

        if (input.removeAt(0) == 0) break

        val stack = Stack<Int>()
        var maxValue = 0L

        repeat(input.size) { index ->
            while (stack.isNotEmpty() && input[stack.peek()] >= input[index]) {
                val highIndex = stack.pop()
                val weight = if (stack.isEmpty()) index else (index - stack.peek() - 1)
                maxValue = max(maxValue, input[highIndex] * weight.toLong())
            }
            stack.push(index)
        }

        while (stack.isNotEmpty()) {
            val highIndex = stack.pop()
            val weight = if (stack.isEmpty()) input.size else (input.size - stack.peek() - 1)
            maxValue = max(maxValue, input[highIndex] * weight.toLong())
        }

        output.add(maxValue)
    }

    repeat(output.size) { index ->
        bufferedWriter.write(output[index].toString())
        bufferedWriter.newLine()
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}
