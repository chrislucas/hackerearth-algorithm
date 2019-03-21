import java.lang.StringBuilder

/**
 * https://www.hackerearth.com/practice/basic-programming/complexity-analysis/time-and-space-complexity/practice-problems/algorithm/vowel-game-f1a1047c/
 * */


fun geenerateAll(str: String) {
    val limit = 1 shl str.length
    var alpha = Regex("[aeiouAEIOU]")
    for (i in 1 until limit) {
        val auxStr = StringBuilder()
        for(j in (str.length-1) downTo 0) {
            if ( ( (1 shl j) and i) > 0) {
                auxStr.append(str[j])
            }
            //print(if ( ( (1 shl j) and i) > 0) "1" else "0")
        }
        //println("")
    }
}

fun process(str: String) : Int {
    val limit =  str.length
    var counter = 0
    val alpha = Regex("[aeiouAEIOU]")
    for (i in 0 until limit) {
        for (j in i until limit) {
            val substr = str.substring(i .. j )
            println(substr)
            for (k in 0 until substr.length) {
                if (substr[k].toString().matches(alpha))
                    counter++
            }
        }
    }
    return counter
}

fun process1(str: String) : Int {
    val alpha = Regex("[aeiouAEIOU]")
    var counter = 0
    val limit =  str.length
    for (i in 0 until limit) {
        if (str[i].toString().matches(alpha)) {
            /**
             *
             * */
            counter += (limit - i) * (i+1)
        }
    }
    return counter
}

fun main(args: Array<String>) {
    var cases = readLine()?.toInt()
    if (cases != null) {
        while (cases > 0) {
            val str = readLine()
            if (str != null) {
                println(process1(str))
            }
            cases-=1
        }
    }
}