package lab1.Lab5
import lab1.Lab2.ColoredShape2d

class AreaComparator : Comparator<ColoredShape2d> {
    override fun compare(shape1: ColoredShape2d, shape2: ColoredShape2d): Int {
        return if (shape1.calcArea() == shape2.calcArea()) 0
        else if (shape1.calcArea() > shape2.calcArea()) 1
        else -1
    }
}
