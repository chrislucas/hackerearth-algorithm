
/**
 * https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/practice-problems/algorithm/a-tryst-with-chess/
 * */

// movimentos do cavalo em ordem horaria
val moves = arrayOf(Pair(-1, -2), Pair(-2, -1)
        , Pair(-2, 1), Pair(-1, 2), Pair(1, 2), Pair(2, 1), Pair(2, -1), Pair(1, -2))




fun count(table: Array<Array<Boolean>>, i: Int, j: Int, acc:Int, c: Int) : Int {
    if (acc == c)
        return 0

    var counter = 0
    for (move in moves) {
        val ii = move.first + i
        val jj = move.second + j
        if ( (ii > -1 && jj < 10) || (jj > -1 && ii < 10) ) {

        }
    }
    return counter
}

fun main(args: Array<String>) {

    val enter = readLine()!!.split(" ")
            .map { it.toInt() }.toTypedArray()
    val table = Array(10) { it -> Array(10) {false} }
    val i = enter[0]
    val j = enter[1]
    val k = enter[2]
    table[i][j] = true

    println(count(table, i, j, 0, k))

}