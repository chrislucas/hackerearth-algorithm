import kotlin.math.abs


fun Double.almostEquals(q: Double, eps: Double = 1E-9) = abs(this-q ) < eps



class Point2D(val x: Double, val y: Double) {
    override fun toString(): String =  "P($x, $y)"
    companion object {
        const val EPS = 1E-9
        private fun almostEquals(p: Double, q: Double) = abs(p-q ) < EPS
        fun compareByX() : Comparator<Point2D> {
            return Comparator { p, q ->
                when {
                    almostEquals(p.x, q.x) -> 0
                    p.x < q.x -> -1
                    else -> 1
                }
            }
        }
    }
}


fun testCompareX() {
    val array : Array<Point2D> = arrayOf(Point2D(10.0, 1.0)
            , Point2D(10.1, -1.0), Point2D(3.1, -1.0), Point2D(-1.1, -1.0))
    array.sortWith(Point2D.compareByX())
    array.forEach { println(it) }
}

fun testCompareBy() {
    val array : Array<Point2D> = arrayOf(Point2D(10.0, 1.0)
            , Point2D(10.1, -1.0), Point2D(3.1, -1.0), Point2D(-1.1, -1.0))

    // Ordena por alguma funcao que retorna um valor
    //array.sortBy { it.y }

    val comp = Comparator<Point2D> { p, q -> (p.x - q.x).toInt() }
    array.sortWith(comp)

    array.sortBy { it.x }

    array.forEach { println(it) }
}

fun testSort() {
    val list = run {
        val list = mutableListOf<Pair<Char, Int>>()
        for(i in 'a'..'z') {
            list.add((i to list.size))
        }
        list
    }

    println(list)


    list.sortWith(Comparator<Pair<Char, Int>> { p, q -> q.first - p.first })
    println(list)

    list.sortedWith(Comparator<Pair<Char, Int>> { p, q -> q.second - p.second })
    println(list)


    list.sortByDescending { p -> p.second }
    println(list)

    list.sortBy { p -> p.first }
    println(list)
}


class ExtPair<V , K>(private val value: V, val key: K) : Comparable<ExtPair<K, V>> {

    override fun compareTo(other: ExtPair<K, V>): Int {
        return 0
    }
}


fun testComparator() {
    val comp = { p: Point2D, q: Point2D -> compareValuesBy(p.x, q.x) }

    val c = ExtPair(1, 'c')


    val p = compareValues(1, 2)
    println(p)
}



fun main(args: Array<String>) {
    //println(Point2D.almostEquals(1.0000000003, 1.0000000002))
    //testCompareBy()
    testComparator()
}