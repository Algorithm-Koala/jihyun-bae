import kotlin.math.sqrt

fun main() {
    val bufferReader = System.`in`.bufferedReader()

    val max = 123456 * 2
    val isPrime = BooleanArray(max + 1)
    isPrime[0] = true
    isPrime[1] = true
    for (i in 2..sqrt(max.toDouble()).toInt()) {
        if (!isPrime[i]) {
            for (j in i * i..max step i)
                isPrime[j] = true
        }
    }

    while (true) {
        bufferReader.readLine().toInt().let { case ->
            if (case == 0) {
                return
            }

            print(isPrime.slice(case + 1..2 * case).count { !it })
            print("\n")
        }
    }

}
