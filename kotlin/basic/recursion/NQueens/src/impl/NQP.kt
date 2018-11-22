package impl

import kotlin.math.abs

/**
 * N-Queens Problem
 **/


fun verify(table: Array<Array<Boolean>>, l: Int, c: Int): Boolean {
    val lim = table[0].size
    // verificar se ja tem uma rainha na mesma linha
    for (i in 0 until lim) {
        if (table[l][i])
            return false
    }
    // verificar se ja tem uma rainha na mesma diagona
    var i= l
    var j= c
    // diagonal esquerda acima de [l][c]
    while (i>=0 && j>=0) {
        if (table[i][j])
            return false
        i--
        j--
    }
    i = l
    j = c
    // diagonal esquerda abaixo de [l][c]
    while (i<lim && j>=0) {
        if (table[i][j])
            return false
        i++
        j--
    }
    return true
}

fun sol1(table: Array<Array<Boolean>>, c: Int) : Boolean {
    val lim = table.size
    if (c == lim)
        return true
    for (i in 0 until  lim) {
        if (verify(table, i, c)) {
            table[i][c] = true
            if (sol1(table, c+1))
                return true
            table[i][c] = false
        }
    }
    return false
}

/**
 * Posicionando as rainhas coluna a coluna
 * */
fun sol2(table: Array<Int>, c: Int) {
    val lim = table.size
    if (c == lim)
        return
    for (l in 0 until lim) {
        /**
         * Verificar se eh possivel posicionar a rainha
         * na posicacao [l][c]
         * */
        var flag = true
        for (ci in 0 until  c) {
            // linha que a rainha esta na coluna ci
            val li = table[ci]
            if (li == l || (abs(ci - c)) == abs(li - l)) {
                flag = false
                break
            }
        }
        if (flag) {
            table[c] = l
            sol2(table, c+1)
        }
    }
    return
}

/**
 * Posicionando as rainhas linha a linha
 * */
fun sol3(table: Array<Int>, l: Int) {
    val lim = table.size
    if (l == lim)
        return
    for (c in 0 until lim) {
        var flag = true
        // tentar po
        for (li in 0 until l) {
            // recuperar em qual coluna a rainha da li linha esta
            val ci = table[li]
            // se estuver ba nesna coluna ou na diagonal
            if (c == ci || (abs(li - l)) == abs(c - ci)) {
                flag = false
                break
            }
        }
        if (flag) {
            table[l] = c
            sol3(table, l+1)
        }
    }
}


fun testsol1() {
    val size = 8
    val table = Array(size) { it -> Array(8) {false}}
    println(sol1(table, 0))
    for (i in 0 until size) {
        for (j in 0 until size) {
            print(String.format(if (j > 0) " %c" else "%c", if (table[i][j]) 'q' else '-'))
        }
        println("")
    }
}

fun testsol2() {
    val size  = 4
    val table = Array(size) {0}
    sol2(table, 0)
    table.forEachIndexed { i, value -> print(String.format(if (i==0) "lc(%d %d)" else " lc(%d %d)", value, i) ) }
    println()
    for ( i in 0 until size) {
        for (j in 0 until size) {
            print(String.format(if(j==0) "%c" else " %c", if (i == table[j]) 'q' else '-'))
        }
        println("")
    }
}

fun testsol3() {
    val size  = 4
    val table = Array(size) {0}
    sol3(table, 0)
    table.forEachIndexed { i, value -> print(String.format(if (i==0) "lc(%d %d)" else " lc(%d %d)", value, i) ) }
    println()
    for ( i in 0 until size) {
        for (j in 0 until size) {
            print(String.format(if(j==0) "%c" else " %c", if (i == table[j]) 'q' else '-'))
        }
        println("")
    }
}

fun main(args: Array<String>) {
    //testsol1()
    //testsol2()
    testsol3()
}