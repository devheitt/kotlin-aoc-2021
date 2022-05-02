import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import kotlin.math.pow

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

fun String.getIntFromBinary(): Int {
    val reversed = this.reversed()
    var exp = 0
    var value = 0
    while (exp < this.length) {
        val digit = reversed[exp].digitToInt()
        value += digit * 2.0.pow(exp.toDouble()).toInt()
        exp++
    }
    return value
}
