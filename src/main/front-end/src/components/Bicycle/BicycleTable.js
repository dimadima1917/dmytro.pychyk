import React, {Component} from "react";
import {Button} from "react-bootstrap";


const BicycleTable = ({product}) =>
    <tr>
        <td>{product.id}</td>
        <td>{product.name}</td>
        <td>{product.price}</td>
        <td>
            <Button bsStyle="success" onClick={() => addToCart(product)}>Delete</Button>
        </td>
    </tr>


export default BicycleTable;