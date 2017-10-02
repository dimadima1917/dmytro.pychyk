import React, {Component} from "react";
import {Table,} from "react-bootstrap";
import BicycleTable from "./BicycleTable";
import {SHOW_ALL_BICYCLES, SHOW_TOP_FIVE_BICYCLES} from "../../constants/bikeConstants";


const BicycleList = ({displayedBicycles, searchHandler, isToogleOn, deleteBicycle, showInfo}) =>


    <div>
        <h4>{isToogleOn ? SHOW_ALL_BICYCLES : SHOW_TOP_FIVE_BICYCLES}</h4>
        <Table striped bordered condensed hover>
            <thead>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Information</th>
                <th>Remove</th>
            </tr>
            </thead>
            <tbody>
            {
                displayedBicycles.map((item, index) => <BicycleTable key={index}
                                                                     bicycle={item}
                                                                     deleteBicycle={deleteBicycle}
                                                                     showInfo={showInfo}
                />)
            }
            </tbody>
        </Table>
    </div>
;

export default BicycleList;