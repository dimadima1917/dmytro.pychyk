import React, {Component} from "react";
import {Table,} from "react-bootstrap";
import BicycleTable from "./BicycleTable";
import {SHOW_ALL_BICYCLES, SHOW_TOP_FIVE_BICYCLES} from "../../constants/bikeConstants";





const BicycleList = ({displayedBicycles,searchHandler,isToogleOn}) =>

    <div>
        <input type="text" className="search-query mac-style" placeholder="Search"onChange={(e) => searchHandler(e, displayedBicycles)}/>
        <h4>{isToogleOn ? SHOW_ALL_BICYCLES : SHOW_TOP_FIVE_BICYCLES}</h4>
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
                displayedBicycles.map((item, index) => <BicycleTable key={index}
                                                            bicycle={item}
                                                            />)
            }
            </tbody>
        </Table>
    </div>
;

export default BicycleList;