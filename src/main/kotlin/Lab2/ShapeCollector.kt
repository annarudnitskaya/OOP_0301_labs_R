package lab1.Lab2

import kotlin.reflect.KClass

class ShapeCollector<T: ColoredShape2d>(_listFigure: List<T>) {
    private val listFigure: MutableList<T>

    init{
        listFigure = _listFigure.toMutableList()
    }

    fun addFigure(figure: T) {
        listFigure.add(figure)
    }

    fun maxAreaF(): List<T> {
        return if (listFigure.isNotEmpty()){
            val maxArea = listFigure.maxOf {it.calcArea()}
            listFigure.filter {it.calcArea() == maxArea}
        } else emptyList()
    }

    fun minAreaF(): List<T> {
        return if (listFigure.isNotEmpty()){
            val minArea = listFigure.minOf {it.calcArea()}
            listFigure.filter {it.calcArea() == minArea}
        } else emptyList()
    }

    fun sumOfAreas(): Double? {
        if (listFigure.isEmpty()) return null
        var sumArea: Double = 0.0
        for (figure in listFigure) sumArea += figure.calcArea()
        return sumArea
    }

    fun findByBorderColor(_borderColor: Color): List<ColoredShape2d> {
        if (listFigure.isEmpty()) return emptyList()
        val listFigureByBorderColor: MutableList<ColoredShape2d> = mutableListOf()
        for (figure in listFigure) {
            if (figure.borderColor == _borderColor) listFigureByBorderColor.add(figure)
        }
        return listFigureByBorderColor
    }

    fun findByFillColor(_fillColor: Color): MutableList<ColoredShape2d>  {
        val listFigureByFillColor: MutableList<T> = mutableListOf()
        for (figure in listFigure) {
            if (figure.fillColor == _fillColor) listFigureByFillColor.add(figure)
        }
        return listFigureByFillColor.toMutableList()
    }


    fun getListFigure(): List<T> {
        if (listFigure.isEmpty()) return emptyList()
        return listFigure
    }

    fun getSizeList(): Int {
        if (listFigure.isEmpty()) return 0
        return listFigure.size
    }

    fun groupedByBorderColor(): Map<Color, List<T>> {
        if (listFigure.isEmpty()) return emptyMap()
        return listFigure.groupBy { it.borderColor }
    }

    fun groupedByFillColor(): Map<Color, List<T>> {
        if (listFigure.isEmpty()) return emptyMap()
        return listFigure.groupBy { it.fillColor }
    }

    fun shapesByType(type: Class<out Shape2d>): List<Shape2d> {
        return listFigure.filterIsInstance(type)
    }

    fun addAll(newListFigure: List<T>){
        newListFigure.forEach{
            listFigure.add(it)
        }
    }

    fun getSorted(typeOfSorting: Comparator<T>): List<T> {
        return listFigure.sortedWith(typeOfSorting)
    }
}