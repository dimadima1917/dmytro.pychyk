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

    public static final String FIND_BY_ID = "select * from product WHERE ProductID = ? and ProductSubcategoryID = 1;";

    public static final String FIND_BY_NAME = "select * from product WHERE name = ? and ProductSubcategoryID = 1;";

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

            "1 ," + //ProductSubcategoryID

            "null ," + //ProductModelID

            "CURRENT_TIMESTAMP ," + //SellStartDate

            "?," +  //7 rowguid

            "CURRENT_TIMESTAMP" + //ModifiedDate

            ")";


    /**
     * SQL query field - delete the bike by index (DELETE)
     */
    protected static final String delBillofmaterials = "DELETE FROM `adventureworks2014`.`billofmaterials` " +
            "WHERE ProductAssemblyID = ?";
    protected static final String delb2Billofmaterials = "DELETE FROM billofmaterials\n" +
            "    USING billofmaterials, product\n" +
            "    WHERE `product`.`ProductID` = `billofmaterials`.`ComponentID`\n" +
            "          AND product.ProductID = ?;\n";
    protected static final String delProductcosthistory = "DELETE FROM productcosthistory\n" +
            "    USING productcosthistory, product\n" +
            "    WHERE `product`.`ProductID` = `productcosthistory`.`ProductID`\n" +
            "          AND product.ProductID = ?;\n";
    protected static final String delProductdocument = "DELETE FROM productdocument\n" +
            "    USING productdocument, product\n" +
            "    WHERE `product`.`ProductID` = `productdocument`.`ProductID`\n" +
            "          AND product.ProductID = ?;\n";
    protected static final String delProductinventory = "DELETE FROM productinventory\n" +
            "    USING productinventory, product\n" +
            "    WHERE `product`.`ProductID` = `productinventory`.`ProductID`\n" +
            "          AND product.ProductID = ?;\n";
    protected static final String delProductlistpricehistory = "DELETE FROM productlistpricehistory\n" +
            "    USING productlistpricehistory, product\n" +
            "    WHERE `product`.`ProductID` = `productlistpricehistory`.`ProductID`\n" +
            "          AND product.ProductID = ?;\n";
    protected static final String delProductproductphoto = "DELETE FROM productproductphoto\n" +
            "    USING productproductphoto, product\n" +
            "    WHERE `product`.`ProductID` = `productproductphoto`.`ProductID`\n" +
            "          AND product.ProductID = ?;\n";
    protected static final String delProductreview = "DELETE FROM productreview\n" +
            "    USING productreview, product\n" +
            "    WHERE `product`.`ProductID` = `productreview`.`ProductID`\n" +
            "          AND product.ProductID = ?;\n";
    protected static final String delProductvendor = "DELETE FROM productvendor\n" +
            "    USING productvendor, product\n" +
            "    WHERE `product`.`ProductID` = `productvendor`.`ProductID`\n" +
            "          AND product.ProductID = ?;\n";
    protected static final String delPurchaseorderdetail = "DELETE FROM purchaseorderdetail\n" +
            "    USING purchaseorderdetail, product\n" +
            "    WHERE `product`.`ProductID` = `purchaseorderdetail`.`ProductID`\n" +
            "          AND product.ProductID = ?;\n";
    protected static final String delSalesorderdetail = "DELETE FROM salesorderdetail\n" +
            "    USING specialofferproduct, salesorderdetail, product\n" +
            "    WHERE `product`.`ProductID` = `specialofferproduct`.`ProductID`\n" +
            "          AND `specialofferproduct`.`SpecialOfferID` = `salesorderdetail`.`SpecialOfferID` AND `specialofferproduct`.`ProductID` = `salesorderdetail`.`ProductID`\n" +
            "          AND product.ProductID = ?;\n";
    protected static final String delSpecialofferproduct = "DELETE FROM specialofferproduct\n" +
            "    USING specialofferproduct, product\n" +
            "    WHERE `product`.`ProductID` = `specialofferproduct`.`ProductID`\n" +
            "          AND product.ProductID = ?;\n";
    protected static final String delShoppingcartitem = "DELETE FROM shoppingcartitem\n" +
            "    USING shoppingcartitem, product\n" +
            "    WHERE `product`.`ProductID` = `shoppingcartitem`.`ProductID`\n" +
            "          AND product.ProductID = ?;\n";
    protected static final String delTransactionhistory = "DELETE FROM transactionhistory\n" +
            "    USING transactionhistory, product\n" +
            "    WHERE `product`.`ProductID` = `transactionhistory`.`ProductID`\n" +
            "          AND product.ProductID = ?;\n";
    protected static final String delWorkorderrouting = "DELETE FROM workorderrouting\n" +
            "    USING workorder, workorderrouting, product\n" +
            "    WHERE `product`.`ProductID` = `workorder`.`ProductID`\n" +
            "          AND `workorder`.`WorkOrderID` = `workorderrouting`.`WorkOrderID`\n" +
            "          AND product.ProductID = ?;\n";
    protected static final String delWorkorder = "DELETE FROM workorder\n" +
            "    USING workorder, product\n" +
            "    WHERE `product`.`ProductID` = `workorder`.`ProductID`\n" +
            "          AND product.ProductID = ?;\n";
    protected static final String delProduct = "DELETE FROM product\n" +
            "    USING product\n" +
            "    WHERE product.ProductID = ?;\n";

}
