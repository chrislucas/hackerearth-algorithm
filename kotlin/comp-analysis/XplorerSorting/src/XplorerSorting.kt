import kotlin.math.abs

class Point2D(val x: Double, val y: Double) {


    override fun toString(): String {
        return "P($x, $y)"
    }

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
    array.sortBy {
            it.x
    }

    array.forEach { println(it) }
}



fun main(args: Array<String>) {
    //println(Point2D.almostEquals(1.0000000003, 1.0000000002))
    testCompareBy()
}