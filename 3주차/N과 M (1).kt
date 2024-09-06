fun main() {
    val bufferReader = System.`in`.bufferedReader()

    val (n, m) = bufferReader.readLine().split(" ").map { it.toInt() }

    val array = Array(m) { i -> i }
    val visit = Array(n + 1) { false }

    fun find(len: Int) {
        if (len == m) {
            array.forEach { print("$it ") }
            println()
            return
        }

        for (i in 1..n) {
            if (! visit[i]) {
                visit[i] = true
                array[len] = i
                find(len + 1)
                visit[i] = false
            }
        }
    }

    find(0)
}
