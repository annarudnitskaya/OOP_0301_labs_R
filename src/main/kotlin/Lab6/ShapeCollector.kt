package lab1.Lab6

class ShapeCollector {
    private val listFigure: MutableList<ColoredShape2d> = mutableListOf()

    fun addFigure(figure: ColoredShape2d) {
        listFigure.add(figure)
    }

    fun maxAreaF(): ColoredShape2d? {
        if (listFigure.isEmpty()) return null
        var figureMaxArea: ColoredShape2d? = null
        var maxArea: Double = Double.MIN_VALUE
        for (figure in listFigure) {
            if (figure.calcArea() > maxArea) {
                maxArea = figure.calcArea()
                figureMaxArea = figure
            }
        }
        return figureMaxArea
    }

    fun minAreaF(): ColoredShape2d? {
        if (listFigure.isEmpty()) return null
        var figureMinArea: ColoredShape2d? = null
        var minArea: Double = Double.MAX_VALUE
        for (figure in listFigure) {
            if (figure.calcArea() < minArea) {
                minArea = figure.calcArea()
                figureMinArea = figure
            }
        }
        return figureMinArea
    }

    fun sumOfAreas(): Double? {
        if (listFigure.isEmpty()) return null
        var sumArea: Double = 0.0
        for (figure in listFigure) sumArea += figure.calcArea()
        return sumArea
    }

    fun findByBorderColor(_borderColor: Color): List<ColoredShape2d>? {
        if (listFigure.isEmpty()) return null
        val listFigureByBorderColor: MutableList<ColoredShape2d> = mutableListOf()
        for (figure in listFigure) {
            if (figure.borderColor == _borderColor) listFigureByBorderColor.add(figure)
        }
        return listFigureByBorderColor
    }

    fun findByFillColor(_fillColor: Color): List<ColoredShape2d>? {
        if (listFigure.isEmpty()) return null
        val listFigureByFillColor: MutableList<ColoredShape2d> = mutableListOf()
        for (figure in listFigure) {
            if (figure.fillColor == _fillColor) listFigureByFillColor.add(figure)
        }
        return listFigureByFillColor
    }

    fun getListFigure(): List<ColoredShape2d>? {
        if (listFigure.isEmpty()) return null
        return listFigure
    }

    fun getSizeList(): Int {
        if (listFigure.isEmpty()) return 0
        return listFigure.size
    }

    fun groupedByBorderColor(): Map<Color, List<ColoredShape2d>>? {
        if (listFigure.isEmpty()) return null
        return listFigure.groupBy { it.borderColor }
    }

    fun groupedByFillColor(): Map<Color, List<ColoredShape2d>>? {
        if (listFigure.isEmpty()) return null
        return listFigure.groupBy { it.fillColor }
    }

    fun shapesByType(type: String): List<ColoredShape2d>? {
        if (listFigure.isEmpty()) return null
        val listFigureByType: MutableList<ColoredShape2d> = mutableListOf()
        for (figure in listFigure) {
            if (figure::class.simpleName == type) listFigureByType.add(figure)
        }
        return listFigureByType
    }
}