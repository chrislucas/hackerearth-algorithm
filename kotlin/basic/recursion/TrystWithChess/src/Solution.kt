
/**
 * https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/practice-problems/algorithm/a-tryst-with-chess/
 * DONE
 * */

// movimentos do cavalo em ordem horaria
val moves = arrayOf(Pair(-2, -1), Pair(-1, -2), Pair(1, -2), Pair(2, -1), Pair(2, 1), Pair(1, 2), Pair(-1, 2), Pair(-2, 1))

fun count(table: Array<Array<Boolean>>, i: Int, j: Int, acc:Int, c: Int) : Int {
    if (acc == c && table[i][j]) {
        return 0
    }
    else if (acc == c) {
        table[i][j] = true
        return 1
    }
    var counter = 0
    for (move in moves) {
        val ii = move.first + i
        val jj = move.second + j
        if ( (ii > -1 && jj < 10) && (jj > -1 && ii < 10)) {
            counter += count(table, ii, jj, acc + 1, c)
        }
    }
    return counter
}

fun main(args: Array<String>) {
    val enter = readLine()!!.split(" ")
            .map { it.toInt() }.toTypedArray()
    val table = Array(10) { it -> Array(10) {false} }
    val i = enter[0] - 1
    val j = enter[1] - 1
    val k = enter[2]
    println(count(table, i, j, 0, k))

}