import React, {} from "react";
import {Table} from "react-bootstrap";
import Bicycle from "./Bicycle";

const BicycleList = ({bicycles, searchHandler, deleteBicycle, showInfo}) =>

    <div>
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
                bicycles.map((item, index) => <Bicycle key={index}
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