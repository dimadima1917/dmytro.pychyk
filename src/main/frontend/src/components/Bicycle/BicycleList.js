import React, {} from "react";
import {Table,} from "react-bootstrap";
import Bicycle from "./Bicycle";
import {SHOW_ALL_BICYCLES, SHOW_TOP_FIVE_BICYCLES} from "../../constants/bikeConstants";

const BicycleList = ({displayedBicycles, searchHandler, toggleShowAllBicycles, deleteBicycle, showInfo}) =>

    <div>
        <h4>{toggleShowAllBicycles ? SHOW_TOP_FIVE_BICYCLES : SHOW_ALL_BICYCLES}</h4>
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
                displayedBicycles.map((item, index) => <Bicycle key={index}
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