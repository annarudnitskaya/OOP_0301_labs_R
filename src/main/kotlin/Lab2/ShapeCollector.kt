package lab1.Lab2

class ShapeCollector {
    private val listFigure: MutableList<ColoredShape2d> = mutableListOf()

    fun addFigure(figure: ColoredShape2d) {
        listFigure.add(figure)
    }

    /*fun minAreaF(): Double {

    }

    fun maxAreaF(): Double {

    }*/

    fun sumOfAreas(): Double {
        var sumArea: Double = 0.0
        for (figure in listFigure) sumArea += figure.calcArea()
        return sumArea
    }

    fun findByBorderColor(_borderColor: Color): List<ColoredShape2d> {
        val listFigureByBorderColor: MutableList<ColoredShape2d> = mutableListOf()
        for (figure in listFigure) {
            if (figure.borderColor == _borderColor) listFigureByBorderColor.add(figure)
        }
        return listFigureByBorderColor
    }

    fun findByFillColor(_fillColor: Color): List<ColoredShape2d> {
        val listFigureByFillColor: MutableList<ColoredShape2d> = mutableListOf()
        for (figure in listFigure) {
            if (figure.fillColor == _fillColor) listFigureByFillColor.add(figure)
        }
        return listFigureByFillColor
    }

    fun getListFigure(): List<ColoredShape2d> {
        return listFigure
    }

    fun getSizeList(): Int {
        return listFigure.size
    }

    fun groupedByBorderColor(): Map<Color, List<ColoredShape2d>> {
        return listFigure.groupBy { it.borderColor }
    }

    fun groupedByFillColor(): Map<Color, List<ColoredShape2d>> {
        return listFigure.groupBy { it.fillColor }
    }

    /*fun shapesByType(type: String): List<ColoredShape2d> {
       //get shapes by type of it
    }*/

    fun getFigure(index: Int): ColoredShape2d {
        return listFigure[index]
    }
}