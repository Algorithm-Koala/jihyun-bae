fun main() {
    val bufferReader = System.`in`.bufferedReader()

    val repeatCount = bufferReader.readLine().toInt()
    val person = mutableListOf<Pair<Int, Int>>()

    repeat(repeatCount) {
        person.add(bufferReader.readLine().split(" ").map { it.toInt() }.let { (x, y) ->
            Pair(x, y)
        })
    }

    for (i in 0..repeatCount - 1) {
        var count = 1
        for (j in 0 .. repeatCount - 1) {
            if (i != j && person[i].first < person[j].first && person[i].second < person[j].second) count += 1
        }

        print(count)
        print(" ")
    }
}
