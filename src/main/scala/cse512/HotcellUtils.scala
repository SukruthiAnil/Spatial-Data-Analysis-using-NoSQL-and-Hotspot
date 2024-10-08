package cse512

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Calendar

object HotcellUtils {
  val coordinateStep = 0.01

  def CalculateCoordinate(inputString: String, coordinateOffset: Int): Int =
  {
    // Configuration variable:
    // Coordinate step is the size of each cell on x and y
    var result = 0
    coordinateOffset match
    {
      case 0 => result = Math.floor((inputString.split(",")(0).replace("(","").toDouble/coordinateStep)).toInt
      case 1 => result = Math.floor(inputString.split(",")(1).replace(")","").toDouble/coordinateStep).toInt
      // We only consider the data from 2009 to 2012 inclusively, 4 years in total. Week 0 Day 0 is 2009-01-01
      case 2 => {
        val timestamp = HotcellUtils.timestampParser(inputString)
        result = HotcellUtils.dayOfMonth(timestamp) // Assume every month has 31 days
      }
    }
    return result
  }

  def timestampParser (timestampString: String): Timestamp =
  {
    val dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    val parsedDate = dateFormat.parse(timestampString)
    val timeStamp = new Timestamp(parsedDate.getTime)
    return timeStamp
  }

  def dayOfYear (timestamp: Timestamp): Int =
  {
    val calendar = Calendar.getInstance
    calendar.setTimeInMillis(timestamp.getTime)
    return calendar.get(Calendar.DAY_OF_YEAR)
  }

  def dayOfMonth (timestamp: Timestamp): Int =
  {
    val calendar = Calendar.getInstance
    calendar.setTimeInMillis(timestamp.getTime)
    return calendar.get(Calendar.DAY_OF_MONTH)
  }

  /*def computeAdjacentHotcell( minX: Int, minY: Int, minZ: Int, maxX: Int, maxY: Int, maxZ: Int, X: Int, Y: Int, Z: Int): Int = {
        var count = 0

        // Cell is on X-boundary
        if (X == minX || X == maxX) {
            count += 1
        }
        // Cell is on X-boundary and Y-boundary
        if (Y == minY || Y == maxY) {
            count += 1
        }
        // Cell is on X-boundary, Y-boundary, and Z-boundary
        if (Z == minZ || Z == maxZ) {
            count += 1
        }

        count match {
            case 1 => 18
            case 2 => 12
            case 3 => 8
            case _ => 27
        }
    }

    def GScore(numCells: Int, x: Int, y: Int, z: Int, adjacentHotcell: Int, cellNumber: Int , avg: Double, stdDev: Double): Double = {
        var adjHotCell: Double = adjacentHotcell.toDouble
        var numOfCells: Double = numCells.toDouble
        (cellNumber.toDouble - (avg * adjHotCell)) / (stdDev * math.sqrt((( adjHotCell * numOfCells) - (adjHotCell * adjHotCell)) / (numOfCells - 1.0)))
    }*/

  // YOU NEED TO CHANGE THIS PART
  // Calculate the number of adjacent hot cells
  def calculateAdjacentHotCells(minXCoordinate: Int, minYCoordinate: Int, minZCoordinate: Int, maxXCoordinate: Int, maxYCoordinate: Int, maxZCoordinate: Int, xCoordinate: Int, yCoordinate: Int, zCoordinate: Int): Int = {
    var boundarycount = 0

    // Cell is on X-boundary
    if (xCoordinate == minXCoordinate || xCoordinate == maxXCoordinate) {
        boundarycount += 1
    }
    // Cell is on Y-boundary
    if (yCoordinate == minYCoordinate || yCoordinate == maxYCoordinate) {
        boundarycount += 1
    }
    // Cell is on Z-boundary
    if (zCoordinate == minZCoordinate || zCoordinate == maxZCoordinate) {
        boundarycount += 1
    }

    boundarycount match {
      case 1 => 18
      case 2 => 12
      case 3 => 8
      case _ => 27
    }
  }

  // Calculate the G-score for a cell
  def calculateGScore(numCells: Int, xCoordinate: Int, yCoordinate: Int, zCoordinate: Int, adjacentHotCells: Int, cellCount: Int, mean: Double, standardDeviation: Double): Double = {
    val adjacentHotCellsDouble = adjacentHotCells.toDouble
    val totalCellsDouble = numCells.toDouble

    //(cellCount.toDouble - (mean * adjacentHotCellsDouble)) / (standardDeviation * math.sqrt(((adjacentHotCellsDouble * totalCellsDouble) - (adjacentHotCellsDouble * adjacentHotCellsDouble)) / (totalCellsDouble - 1.0)))
    val numerator = cellCount.toDouble - (mean * adjacentHotCellsDouble)
    val denominator = standardDeviation * math.sqrt(((adjacentHotCellsDouble * totalCellsDouble) - (adjacentHotCellsDouble * adjacentHotCellsDouble)) / (totalCellsDouble - 1.0))
    numerator / denominator
    
  }

// YOU NEED TO CHANGE THIS PART

}
