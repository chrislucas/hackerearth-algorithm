package problems.hackerearth


//import kotlin.math.abs

/**
 * https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/practice-problems/algorithm/n-queensrecursion-tutorial/
 * */


fun abs(i: Int) : Int = if(i < 0) -i else  i

fun valid(table: Array<Array<Boolean>>, l: Int, c: Int): Boolean {
    // verificar se nao tem uma rainha na mesma coluca
    for (cc in 0 until table.size) {
        if (table[cc][c])
            return false
    }
    // verificar diagonal esquerda superior
    var ll = l
    var cc = c
    while (ll >= 0 && cc >= 0) {
        if (table[ll--][cc--])
            return false
    }
    // verificar diagonal esquerda inferior
    ll = l
    cc = c
    while (ll < table.size && cc >= 0) {
        if (table[ll++][cc--])
            return false
    }
    return true
}

fun solver(table: Array<Array<Boolean>>, l: Int) : Boolean {
    val lim = table.size
    if (lim < 4)
        return false
    else if (l == lim)
        return true
    for (i in 0 until  lim) {
        if (valid(table, l, i)) {
            table[l][i] = true
            if (solver(table, l+1))
                return true
            table[l][i] = false
        }
    }
    return false
}

fun exists1(table: Array<Int>, l: Int): Boolean {
    if (l == table.size)
        return true
    for (c in 0 until table.size) {
        var flag = true
        // tentar po
        for (li in 0 until l) {
            // recuperar em qual coluna a rainha da li linha esta
            val ci = table[li]
            // se estuver ba nesna coluna ou na diagonal
            if (c == ci || abs(li - l) == abs(c - ci)) {
                flag = false
                break
            }
        }
        if (flag) {
            table[l] = c
            if (exists1(table, l+1))
                return true
        }
    }
    return false
}

fun sol1() {
    val n = readLine()!!.toInt()
    val table = Array(n) { it -> Array(n) {false}}
    if (solver(table, 0)) {
        for (i in 0 until  n) {
            for (j in 0 until n)
                print(String.format(if (j == 0) "%c" else " %c", if (table[i][j]) '1' else '0'))
            println()
        }
    }
    else {
        println("Not possible")
    }
}

fun sol2() {
    val n = readLine()!!.toInt()
    val table = Array(n) { 0 }
    if (exists1(table, 0)) {
        for ( i in 0 until table.size) {
            for (j in 0 until table.size) {
                print(String.format(if(j==0) "%c" else " %c", if (i == table[j]) '1' else '0'))
            }
            println("")
        }
        println("")
    }
    else {
        println("Not possible")
    }
}

fun main(args: Array<String>) {
    sol1()
}