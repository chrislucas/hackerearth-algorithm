
const val limitInt : Int = (1 shl 31) - 1

fun test(q: Long) : Int {
    return if (q > limitInt) {
        (q - limitInt).toInt()
    } else {
        q.toInt()
    }
}

fun main(args: Array<String>) {
    println(test(1L shl 31))
    println(limitInt)
}