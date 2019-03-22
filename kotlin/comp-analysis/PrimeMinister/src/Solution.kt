import java.lang.StringBuilder
//import kotlin.math.ceil
//import kotlin.math.sqrt

class Erathostenes {

    /**
     *  *                  n     Primes <= n
     *  ---------------------------------
     *                 10               4
     *                100              25
     *              1,000             168
     *             10,000           1,229
     *            100,000           9,592
     *          1,000,000          78,498
     *         10,000,000         664,579
     *        100,000,000       5,761,455
     *      1,000,000,000      50,847,534
     * */
    companion object {
        fun crive(lim: Int): Pair<Long, Array<Boolean>> {
            var counter = 0L
            val values : Array<Boolean> = Array(lim) { true }
            values[0] = false
            values[1] = false
            var i = 2
            /**
             * I algoritmo abaixo parte do presuposto que todos os numeros
             * sao primos, entao a partir de um numero i, marcamos todos
             * os seus multiplos como nao primos (por motivos obvios)
             * Se quisermos saber quantos primos existem de 0 a N
             * podemos criar um array com N elementos, marca-los como primos
             * e posteriormente marcar como nao primos todos os multiplos de 2 < i < sqrt(N)
             *
             * Se um numero N nao tiver divisores entre 2 e sqrt(N) ele eh primo
             **/
            while (i<Math.ceil(Math.sqrt(lim.toDouble())).toInt()) {
                if (values[i]) {
                    /**
                     * Comecando a partir do primo 'i' vamos marcar todos os seus
                     * multiplos como nao primos ate q um multiplo N seja menor que o valor
                     * limite (lim) definido pela funcao
                     * */
                    var j = i
                    while (j*i < lim) {
                        values[j*i] = false
                        j++
                    }
                }
                i++
            }
            values.forEach {
                if (it)
                    counter++
            }
            return Pair(counter, values)
        }
    }
}
/**
 * https://www.hackerearth.com/practice/basic-programming/complexity-analysis/time-and-space-complexity/practice-problems/algorithm/prime-ministers-number/
 * */

fun sumDigit(p: Int) : Int {
    var acc = 0
    var p = p
    while (p>0) {
        acc += p % 10
        p /= 10
    }
    return acc
}

fun process() : Pair<Long, Array<Boolean>> = Erathostenes.crive(10000000)


fun test() {
    var i = 10
    while (i <= 100000000) {
        print("Para $i numeros: ${Erathostenes.crive(i)}\n")
        i *= 10
    }
}


/**
 * DONE
 * */
fun solver() {
    val p = process()
    val line = readLine()?.split(" ")?.map { it.toInt() }?.toTypedArray()
    if (line != null) {
        val r = p.second
        val str = StringBuilder()
        var first = true
        for(i in line[0] .. line[1]) {
            if ((i and 1) == 1 && r[i] && r[sumDigit(i)]) {
                str.append(if (first) i.toString() else " " + i.toString())
                first = false
            }
        }
        println(str.toString())
    }
}

fun main(args: Array<String>) {
    solver()
}