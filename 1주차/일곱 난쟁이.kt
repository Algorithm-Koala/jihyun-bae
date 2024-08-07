fun main() {
    val bufferReader = System.`in`.bufferedReader()

    val dwarf = mutableListOf<Int>()

    repeat(9) {
        dwarf.add(bufferReader.readLine().toInt())
    }

    dwarf.sort()
    val sum = dwarf.sum()

    for (i in 0..8) {
        for (j in 0..8) {
            if (i != j && sum - dwarf[i] - dwarf[j] == 100) {
                dwarf.forEachIndexed { index, k ->
                    if (index != i && index != j) {
                        print(k)
                        print("\n")
                    }
                }
                return
            }
        }
    }
}