# Spatial-Data-Analysis-using-NoSQL-and-Hotspot

This repository contains two individual projects focused on spatial data analysis, leveraging NoSQL databases and Apache Spark for hotspot analysis.

## Project 1: NoSQL Business Finder
This project implements two functions to perform operations on business data using a NoSQL database. The functions include:
- **FindBusinessBasedOnCity:** Searches for businesses in a specific city and saves results.
- **FindBusinessBasedOnLocation:** Searches for businesses within a specified distance from a given location and saves results.

### Technologies:
- Python
- NoSQL (Sample Database)

### Features:
- Distance calculation using Haversine formula.
- Filtering businesses based on city and location.
  
### Files:
- `NoSQL_BusinessFinder.ipynb`: Jupyter Notebook implementation of NoSQL queries.

---

## Project 2: Hot Spot Analysis (using Apache Spark)
This project is focused on spatial hotspot analysis of NYC taxi data. It includes two main tasks:
1. **Hot Zone Analysis:** Performs a range join operation on a rectangle and point dataset, determining how many points fall within each rectangle.
2. **Hot Cell Analysis:** Implements the Getis-Ord G* statistic to identify hot spots in spatio-temporal big data.

### Technologies:
- Apache Spark
- Hadoop
- Scala
- NYC Taxi Data (2009-2012)

### Files:
- `HotspotAnalysis.jar`: The compiled JAR file that contains the Spark implementation for both hot zone and hot cell analysis.
- `HotzoneAnalysis.scala`: Source code for hot zone analysis.
- `HotcellAnalysis.scala`: Source code for hot cell analysis.

