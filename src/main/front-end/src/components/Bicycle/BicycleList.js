import React, {Component} from "react";
import {Table,} from "react-bootstrap";
import BicycleTable from "./BicycleTable";





const BicycleList = ({displayedProducts,searchHandler,isToogleOn}) =>

    <div>
        <input type="text" className="search-query mac-style" placeholder="Search"onChange={(e) => searchHandler(e, displayedProducts)}/>
        <h4>{isToogleOn ? 'All BICYCLES' : 'TOP 5'}</h4>
        <Table striped bordered condensed hover>
            <thead>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Product Number</th>
                <th>Color</th>
                <th>Standart Cost</th>
                <th>Size</th>
                <th>Style</th>
                <th>{/*empty*/}</th>
            </tr>
            </thead>
            <tbody>
            {
                displayedProducts.map((item, index) => <BicycleTable key={index}
                                                            product={item}
                                                            />)
            }
            </tbody>
        </Table>
    </div>
;

export default BicycleList;