fun main() {
    val bufferReader = System.`in`.bufferedReader()

    val repeatCount = bufferReader.readLine().toInt()
    val numbers = mutableListOf<Int>()

    repeat(repeatCount) {
        bufferReader.readLine().toInt().let { number ->
            if (number == 0) {
                numbers.removeLast()
            } else {
                numbers.add(number)
            }
        }
    }

    print(numbers.sum())
}
