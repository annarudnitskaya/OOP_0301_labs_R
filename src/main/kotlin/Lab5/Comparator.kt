package lab1.Lab5


class AreaComparator : Comparator<ColoredShape2d> {
    override fun compare(shape1: ColoredShape2d, shape2: ColoredShape2d): Int {
            return if (shape1.calcArea() == shape2.calcArea()) 0
            else if (shape1.calcArea() > shape2.calcArea()) 1
            else -1
    }
}
