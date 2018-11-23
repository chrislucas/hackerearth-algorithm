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
    for (l in 0 until lim) {
        /**
         * Verificar se eh possivel posicionar a rainha
         * na posicacao [l][c]
         * */
        var flag = true
        for (ci in 0 until  c) {
            // linha que a rainha esta na coluna ci
            val li = table[ci]
            // verificar se a linha|coluna que queremos colocar a rainha
            // nao esta sobe ataque ou na mesma linha ou na diagonal
            if (li == l || (abs(ci - c)) == abs(li - l)) {
                flag = false
                break
            }
        }
        if (flag) {
            table[c] = l
            if (c == table.size - 1) {
                showBoard(table)
            }
            else {
                sol2(table, c+1)
            }
        }
    }
    return
}

/**
 * Posicionando as rainhas linha a linha
 * */
fun sol3(table: Array<Int>, l: Int) {
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
            when (l) {
                table.size - 1 -> showBoard(table)
                else -> {
                    sol3(table, l+1)
                }
            }
        }
    }
}

fun exists(table: Array<Int>, l: Int): Boolean {
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
            if (exists(table, l+1))
                return true
        }
    }
    return false
}


fun testsol1() {
    val size = 8
    val table = Array(size) { Array(8) {false}}
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
}

fun showBoard(table: Array<Int>) {
    for ( i in 0 until table.size) {
        for (j in 0 until table.size) {
            print(String.format(if(j==0) "%c" else " %c", if (i == table[j]) 'q' else '-'))
        }
        println("")
    }
    println("")
}

fun testsol3() {
    val size  = 8
    val table = Array(size) {0}
    sol3(table, 0)
    println()
}

fun testExists() {
    val size  = 8
    val table = Array(size) {0}
    val exists = exists(table, 0)
    println(String.format("%dx%d: %s", size, size, exists))
    if (exists)
        showBoard(table)
}

fun main(args: Array<String>) {
    //testsol1()
    //testsol2()
    //testsol3()
    testExists()

}