package org.sopt.boj

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    var (n, k, i) = bufferedReader.readLine().split(" ").map { it.toInt() }

    var count = 0
    while (k != i) {
        count += 1
        k -= k / 2
        i -= i / 2
    }

    bufferedWriter.write(count.toString())
    bufferedWriter.flush()
    bufferedWriter.close()
}
