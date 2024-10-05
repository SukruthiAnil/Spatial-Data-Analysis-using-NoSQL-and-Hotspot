package cse512

object HotzoneUtils {

  def ST_Contains(queryRectangle: String, pointString: String ): Boolean = {
    // YOU NEED TO CHANGE THIS PART
    if (queryRectangle == null || queryRectangle.isEmpty() || pointString == null || pointString.isEmpty())
            return false

        val pointCoords = pointString.split(",")
        var pointX = pointCoords(0).toDouble
        var pointY = pointCoords(1).toDouble

        val rectCoords = queryRectangle.split(",")
        var rectX1 = rectCoords(0).toDouble
        var rectY1 = rectCoords(1).toDouble
        var rectX2 = rectCoords(2).toDouble
        var rectY2 = rectCoords(3).toDouble

        /*val rectangleArr = queryRectangle.split(",")
        var x1 = rectangleArr(0).toDouble
        var y1 = rectangleArr(1).toDouble
        var x2 = rectangleArr(2).toDouble
        var y2 = rectangleArr(3).toDouble

        val pointArr = pointString.split(",")
        var x = pointArr(0).toDouble
        var y = pointArr(1).toDouble

        if (x >= x1 && x <= x2 && y >= y1 && y <= y2)
            return true
        else if (x >= x2 && x <= x1 && y >= y2 && y <= y1)
            return true
        else
            return false*/

        // Check if the point lies within the rectangle
        if ((pointX >= rectX1 && pointX <= rectX2 && pointY >= rectY1 && pointY <= rectY2) || (pointX >= rectX2 && pointX <= rectX1 && pointY >= rectY2 && pointY <= rectY1))
            return true
        else
            return false
    }
    //return true // YOU NEED TO CHANGE THIS PART
  }

  // YOU NEED TO CHANGE THIS PART

