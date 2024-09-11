import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = bufferedReader.readLine().split(" ").map { it.toInt() }

    val homes = mutableListOf<Pair<Int, Int>>()
    val chickens = mutableListOf<Pair<Int, Int>>()

    repeat(n) { row ->
        bufferedReader.readLine().split(" ").map { it.toInt() }.let { rows ->
            rows.forEachIndexed { col, city ->
                when (city) {
                    1 -> homes.add(Pair(row, col))
                    2 -> chickens.add(Pair(row, col))
                }
            }
        }
    }

    var ans = Int.MAX_VALUE
    val open = BooleanArray(chickens.size)

    fun dfs(start: Int, cnt: Int) {
        if (cnt == m) {
            var res = 0
            homes.forEach { home ->
                var temp = Int.MAX_VALUE
                chickens.forEachIndexed { index, chicken ->
                    if (open[index]) {
                        val c = chickens[index]
                        val distance = abs(home.first - chicken.first) + abs(home.second - chicken.second)
                        temp = min(temp, distance)
                    }
                }
                res += temp
            }
            ans = min(ans, res)
            return
        }

        for (i in start..<chickens.size) {
            open[i] = true
            dfs(i + 1, cnt + 1)
            open[i] = false
        }
    }

    dfs(0, 0)

    bufferedWriter.write(ans.toString())
    bufferedWriter.flush()
    bufferedWriter.close()
}
