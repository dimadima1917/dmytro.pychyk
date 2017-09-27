import React, {Component} from "react";
import BicycleList from "./Bicycle/BicycleList";
import {Button, Col, Grid, Row} from "react-bootstrap";
import CreateProductModal from "../modals/CreateProductModal";
import {loadAllProducts} from "../api/cart";


class Container extends Component{

    constructor(props) {
        super(props);

        this.state = {
            products: [],
            showCreateModal: false,
        }
    }

    componentDidMount() {
        loadAllProducts()
            .then((response) => { //successCallback
                let products = response;

                this.setState({
                    products: products,
                })
            })
            .catch((error) => { //errror callback
                console.error(error);
            });
    }

    showCreateModal(e) {
        this.setState({
            showCreateModal: true
        });
    }

    render(){
        return(
            <Grid fluid>
                <Row>
                    <Col md={7}>
                        <BicycleList products={this.state.products}/>
                    </Col>
                </Row>

                <Button bsStyle="primary" onClick={this.showCreateModal.bind(this)}>Create new product</Button>

            </Grid>
        )
    }
}

export default Container;