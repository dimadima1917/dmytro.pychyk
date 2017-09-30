import React, {Component} from "react";
import {Button} from "react-bootstrap";


const BicycleTable = ({bicycle}) =>
    <tr>
        <td>{bicycle.productId}</td>
        <td>{bicycle.name}</td>
        <td>{bicycle.productNumber}</td>
        <td>{bicycle.color}</td>
        <td>{bicycle.standartCost}</td>
        <td>{bicycle.size}</td>
        <td>{bicycle.style}</td>

        <td>
            <Button bsStyle="success" onClick={() => addToCart(bicycle)}>Delete</Button>
        </td>
    </tr>


export default BicycleTable;