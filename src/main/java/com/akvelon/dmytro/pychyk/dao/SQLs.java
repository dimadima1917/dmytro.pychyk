package com.akvelon.dmytro.pychyk.dao;

public class SQLs {

    public static final String SELECT_MOST_POPULAR = "SELECT TOP 5 Product.ProductID, Product.Name, Product.ProductNumber, Product.Color, Product.StandardCost, Product.Size, Product.Style\n" +
            "FROM Production.Product\n" +
            "INNER JOIN Sales.SalesOrderDetail ON Production.Product.ProductID = Sales.SalesOrderDetail.ProductID \n" +
            "WHERE ProductSubcategoryID = 1\n" +
            "GROUP BY Product.ProductID, Product.Name, Product.ProductNumber, Product.Color, Product.StandardCost, Product.Size, Product.Weight, Product.ProductLine, Product.Class, Product.Style\n" +
            "ORDER BY SUM(Sales.SalesOrderDetail.OrderQty) DESC";

    public static final String SELECT_ALL = "SELECT * FROM Production.Product WHERE Product.ProductSubcategoryID = 1";

    public static final String ADD = "INSERT INTO Production.Product (Product.Name,Product.ProductNumber,Product.Color,Product.StandardCost,Product.Size,Product.Style," +
            "Product.ProductSubcategoryID)" +
            "VALUES (?,?,?,?,?,?,?)";
}
