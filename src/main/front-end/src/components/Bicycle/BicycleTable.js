import React, {Component} from "react";
import {Button} from "react-bootstrap";


const BicycleTable = ({product}) =>
    <tr>
        <td>{product.productId}</td>
        <td>{product.name}</td>
        <td>{product.productNumber}</td>
        <td>{product.color}</td>
        <td>{product.standartCost}</td>
        <td>{product.size}</td>
        <td>{product.style}</td>

        <td>
            <Button bsStyle="success" onClick={() => addToCart(product)}>Delete</Button>
        </td>
    </tr>


export default BicycleTable;