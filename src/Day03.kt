fun main() {
    fun part1(input: List<String>): Int {
        val mostCommon = input[0].map { 0 }.toMutableList()
        val lessCommon = input[0].map { 0 }.toMutableList()
        input.forEach { line ->
            for (i in line.indices) {
                if (line[i] == '0')
                    mostCommon[i]--
                else
                    mostCommon[i]++
            }
        }
        for (i in mostCommon.indices) {
            if (mostCommon[i] > 0) {
                mostCommon[i] = 1
                lessCommon[i] = 0
            } else {
                mostCommon[i] = 0
                lessCommon[i] = 1
            }
        }

        val gammaBinary = mostCommon.joinToString("")
        val epsilonBinary = lessCommon.joinToString("")

        return gammaBinary.getIntFromBinary() * epsilonBinary.getIntFromBinary()
    }

    fun part2(input: List<String>): Int {
        val oxygenRating = getOxygenRating(input)
        println("oxygen rating: $oxygenRating")

        val CO2Rating = getCO2Rating(input)
        println("CO2 rating: $CO2Rating")
        return oxygenRating * CO2Rating
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day03_test")
//    check(part1(testInput) == 198)
//    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))

}

/**
 * keep the inputs with the most common value in the current bit position
 */
fun getOxygenRating(input: List<String>): Int {
    var currentBit = 0
    val valueLength = input[0].length
    var oxygenList = input
    while (currentBit < valueLength && oxygenList.size > 1) {
        val oneOccurrences = oxygenList.count { binary -> binary[currentBit] == '1' }
        val zeroOccurrences = oxygenList.count { binary -> binary[currentBit] == '0' }
        val mostCommonValue = if (oneOccurrences - zeroOccurrences >= 0) '1' else '0'
        oxygenList = oxygenList.filter { value -> value[currentBit] == mostCommonValue }
        currentBit++
    }
    return oxygenList[0].getIntFromBinary()
}

/**
 * keep the inputs with the less common value in the current bit position
 */
fun getCO2Rating(input: List<String>): Int {
    var currentBit = 0
    val valueLength = input[0].length
    var CO2List = input
    while (currentBit < valueLength && CO2List.size > 1) {
        val oneOccurrences = CO2List.count { binary -> binary[currentBit] == '1' }
        val zeroOccurrences = CO2List.count { binary -> binary[currentBit] == '0' }
        val lessCommonValue = if (zeroOccurrences - oneOccurrences <= 0) '0' else '1'
        CO2List = CO2List.filter { value -> value[currentBit] == lessCommonValue }
        currentBit++
    }
    return CO2List[0].getIntFromBinary()
}
