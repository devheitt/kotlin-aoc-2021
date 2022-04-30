fun main() {
    fun part1(input: List<String>): Int {
        var depth = 0
        var horizontal = 0

        for (line in input) {
            val (direction, distance) = line.split(' ')

            when (direction) {
                "forward" -> horizontal += distance.toInt()
                "down" -> depth += distance.toInt()
                "up" -> depth -= distance.toInt()
            }

        }
        return depth * horizontal
    }

    fun part2(input: List<String>): Int {
        var depth = 0
        var horizontal = 0
        var aim = 0

        for (line in input) {
            val (command, distance) = line.split(' ')

            when (command) {
                "forward" -> {
                    horizontal += distance.toInt()
                    depth += aim * distance.toInt()
                }
                "down" -> aim += distance.toInt()
                "up" -> aim -= distance.toInt()
            }

        }
        return depth * horizontal
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))

}
