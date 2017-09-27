import React, {Component} from "react";
import {Table} from "react-bootstrap";
import BicycleTable from "./BicycleTable";


const BicycleList = ({products}) =>
    <div>
        <h4>Top 5</h4>
        <Table striped bordered condensed hover>
            <thead>
            <tr>
                <th>#</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>{/*empty*/}</th>
            </tr>
            </thead>
            <tbody>
            {
                products.map((item, index) => <BicycleTable key={index}
                                                            product={item}/>)
            }
            </tbody>
        </Table>
    </div>
;

export default BicycleList;