package com.akvelon.dmytro.pychyk.dao;

public class SQLs {

    public static final String SELECT_MOST_POPULAR = "SELECT `product`.`productID`, `product`.`name`, `product`.`productNumber`, `product`.`color`, `product`.`standardCost`, `product`.`size`, `product`.`style`\n" +
            "FROM `adventureworks2014`.`product`\n" +
            "INNER JOIN `adventureworks2014`.`SalesOrderDetail` ON `adventureworks2014`.`Product`.`ProductID` = `adventureworks2014`.`SalesOrderDetail`.`ProductID` \n" +
            "WHERE `ProductSubcategoryID` = 1\n" +
            "GROUP BY `Product`.`ProductID`, `Product`.`Name`, `Product`.`ProductNumber`, `Product`.`Color`, `Product`.`StandardCost`, `Product`.`Size`, `Product`.`Style`\n" +
            "ORDER BY SUM(`adventureworks2014`.`SalesOrderDetail`.`OrderQty`) DESC\n" +
            "limit 5";

    public static final String SELECT_ALL = "SELECT *FROM `adventureworks2014`.`product`WHERE `ProductSubcategoryID` = 1";


    public static final String DELETE_BY_ID = "START TRANSACTION;\n" +
            "SET @ProductID_to_delete = 4;\n" +
            "\n" +
            "            DELETE FROM `adventureworks2014`.`billofmaterials`\n" +
            "                WHERE ProductAssemblyID = @ProductID_to_delete;\n" +
            "\n" +
            "            DELETE FROM billofmaterials\n" +
            "               USING billofmaterials, product\n" +
            "                WHERE `product`.`ProductID` = `billofmaterials`.`ComponentID`\n" +
            "                      AND product.ProductID = @ProductID_to_delete;\n" +
            "            DELETE FROM productcosthistory\n" +
            "                USING productcosthistory, product\n" +
            "                WHERE `product`.`ProductID` = `productcosthistory`.`ProductID`\n" +
            "                      AND product.ProductID = @ProductID_to_delete;\n" +
            "            DELETE FROM productdocument\n" +
            "                USING productdocument, product\n" +
            "                WHERE `product`.`ProductID` = `productdocument`.`ProductID`\n" +
            "                      AND product.ProductID = @ProductID_to_delete;\n" +
            "            DELETE FROM productinventory\n" +
            "                USING productinventory, product\n" +
            "                WHERE `product`.`ProductID` = `productinventory`.`ProductID`\n" +
            "                      AND product.ProductID = @ProductID_to_delete;\n" +
            "            DELETE FROM productlistpricehistory\n" +
            "                USING productlistpricehistory, product\n" +
            "                WHERE `product`.`ProductID` = `productlistpricehistory`.`ProductID`\n" +
            "                      AND product.ProductID = @ProductID_to_delete;\n" +
            "            DELETE FROM productproductphoto\n" +
            "                USING productproductphoto, product\n" +
            "                WHERE `product`.`ProductID` = `productproductphoto`.`ProductID`\n" +
            "                      AND product.ProductID = @ProductID_to_delete;\n" +
            "            DELETE FROM productreview\n" +
            "                USING productreview, product\n" +
            "                WHERE `product`.`ProductID` = `productreview`.`ProductID`\n" +
            "                      AND product.ProductID = @ProductID_to_delete;\n" +
            "            DELETE FROM productvendor\n" +
            "                USING productvendor, product\n" +
            "                WHERE `product`.`ProductID` = `productvendor`.`ProductID`\n" +
            "                      AND product.ProductID = @ProductID_to_delete;\n" +
            "            DELETE FROM purchaseorderdetail\n" +
            "                USING purchaseorderdetail, product\n" +
            "                WHERE `product`.`ProductID` = `purchaseorderdetail`.`ProductID`\n" +
            "                      AND product.ProductID = @ProductID_to_delete;\n" +
            "            DELETE FROM salesorderdetail\n" +
            "                USING specialofferproduct, salesorderdetail, product\n" +
            "                WHERE `product`.`ProductID` = `specialofferproduct`.`ProductID`\n" +
            "                      AND `specialofferproduct`.`SpecialOfferID` = `salesorderdetail`.`SpecialOfferID` AND `specialofferproduct`.`ProductID` = `salesorderdetail`.`ProductID`\n" +
            "                      AND product.ProductID = @ProductID_to_delete;\n" +
            "            DELETE FROM specialofferproduct\n" +
            "                USING specialofferproduct, product\n" +
            "                WHERE `product`.`ProductID` = `specialofferproduct`.`ProductID`\n" +
            "                      AND product.ProductID = @ProductID_to_delete;\n" +
            "            DELETE FROM shoppingcartitem\n" +
            "                USING shoppingcartitem, product\n" +
            "                WHERE `product`.`ProductID` = `shoppingcartitem`.`ProductID`\n" +
            "                      AND product.ProductID = @ProductID_to_delete;\n" +
            "            DELETE FROM transactionhistory\n" +
            "                USING transactionhistory, product\n" +
            "                WHERE `product`.`ProductID` = `transactionhistory`.`ProductID`\n" +
            "                      AND product.ProductID = @ProductID_to_delete;\n" +
            "            DELETE FROM workorderrouting\n" +
            "                USING workorder, workorderrouting, product\n" +
            "                WHERE `product`.`ProductID` = `workorder`.`ProductID`\n" +
            "                      AND `workorder`.`WorkOrderID` = `workorderrouting`.`WorkOrderID`\n" +
            "                      AND product.ProductID = @ProductID_to_delete;\n" +
            "            DELETE FROM workorder\n" +
            "                USING workorder, product\n" +
            "                WHERE `product`.`ProductID` = `workorder`.`ProductID`\n" +
            "                      AND product.ProductID = @ProductID_to_delete;\n" +
            "            DELETE FROM product\n" +
            "                USING product\n" +
            "                WHERE product.ProductID = @ProductID_to_delete;\n" +
            "            COMMIT;";


    public static final String ADD = "INSERT INTO `adventureworks2014`.`product`\n" +
            "(" +
            "`Name`," +
            " `ProductNumber`," +
            " `MakeFlag`," +
            " `FinishedGoodsFlag`," +
            " `Color`," +
            " `SafetyStockLevel`," +
            " `ReorderPoint`," +
            " `StandardCost`," +
            " `ListPrice`," +
            " `Size`," +
            " `SizeUnitMeasureCode`," +
            " `WeightUnitMeasureCode`," +
            " `Weight`," +
            " `DaysToManufacture`," +
            " `ProductLine`," +
            " `Class`," +
            " `Style`," +
            " `ProductSubcategoryID`," +
            " `ProductModelID`," +
            " `SellStartDate`," +
            " `rowguid`," +
            " `ModifiedDate`)\n" +



            "VALUES\n" +
            "(" +

            "?," +  //1 Name

            "?," +  //2 ProductNumber

            "0," +  //MakeFlag

            "0," +  //FinishedGoodsFlag

            "?," +  //3 Color

            "1000," + //SafetyStockLevel

            "750," +   //ReorderPoint

            "?," +    //4 StandardCost

            "348.7600," +    //ListPrice

            "?," +   //5 Size

            "'CM' ," + //SizeUnitMeasureCode

            "'LB' ," + //WeightUnitMeasureCode

            "null ," + //Weight

            "0," + //DaysToManufacture

            "null ," + //ProductLine

            "null ," + //Class

            "?," + //6 Style

            "1 ,"+ //ProductSubcategoryID

            "null ," + //ProductModelID

            "CURRENT_TIMESTAMP ," + //SellStartDate

            "?,"+  //7 rowguid

            "CURRENT_TIMESTAMP"  + //ModifiedDate

            ")";
}
