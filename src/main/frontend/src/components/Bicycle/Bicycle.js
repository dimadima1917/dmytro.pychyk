import React, {} from "react";
import {Button} from "react-bootstrap";


const Bicycle = ({bicycle, deleteBicycle, showInfo}) =>

    <tr>
        <td>{bicycle.productId}</td>
        <td>{bicycle.name}</td>
        <td>
            <Button bsStyle="info" onClick={() => showInfo(bicycle)}>Info</Button>
        </td>
        <td>
            <Button bsStyle="danger" onClick={() => deleteBicycle(bicycle.productId)}>Delete</Button>
        </td>
    </tr>
;

export default Bicycle;