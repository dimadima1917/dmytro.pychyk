import React, {Component} from "react";
import BicycleList from "./Bicycle/BicycleList";
import {Button, Col, Grid, Row, Form} from "react-bootstrap";
import CreateProductModal from "../modals/CreateProductModal";
import {loadAllProductsRequest,load5MostPopular} from "../api/bikes";


class Container extends Component {

    constructor(props) {
        super(props);

        this.state = {
            products: [],
            displayedProducts: [],
            isToogleOn: false,
            showCreateModal: false,
        }
        this.loadProductListProducts = this.loadProductListProducts.bind(this);
    }

    loadProductListProducts() {
        loadAllProductsRequest()
            .then((products) => { //successCallback
                this.setState({
                    products: products,
                    displayedProducts: products
                });
                return null;
            })
            .catch((error) => { //errror callback
                console.error(error);
            });
    }

    load5MostPopularBicycles() {
        load5MostPopular()
            .then((products) => { //successCallback
                this.setState({
                    products: products,
                    displayedProducts: products
                });
                return null;
            })
            .catch((error) => { //errror callback
                console.error(error);
            });
    }

    componentDidMount() {
        this.load5MostPopularBicycles();
    }

    showCreateModal(e) {
        this.setState({
            showCreateModal: true
        });
    }

    searchHandler(e) {
        const searchQuery = e.target.value.toLowerCase();
        const displayedProducts = this.state.products.filter(function (el) {
            const searchValue = el.name.toLowerCase();
            return searchValue.indexOf(searchQuery) !== -1;
        });
        this.setState({
            displayedProducts: displayedProducts
        });
        console.log(displayedProducts);
    }

    handleClick() {
        if (this.state.isToogleOn) {
            console.log(this.state.isToogleOn)
            this.setState({
                    isToogleOn: false,
                    displayedProducts: this.state.products
                }
            );
            this.load5MostPopularBicycles()
        } else {
            this.setState({
                    isToogleOn: true,
                    displayedProducts: this.state.products

                }
            );
            console.log(this.state.isToogleOn)
            this.loadProductListProducts()
        }

    }

    render() {
        return (

            <Grid fluid>
                <Row>
                    <Col md={7}>
                        <button type="button" className="btn btn-primary" onClick={this.handleClick.bind(this)}>
                            {this.state.isToogleOn ? 'SHOW TOP 5' : 'SHOW ALL BICYCLES'}
                        </button>
                    </Col>
                </Row>
                <Row>
                    <Col>
                        <BicycleList displayedProducts={this.state.displayedProducts}
                                     searchHandler={this.searchHandler.bind(this)}
                                     isToogleOn={this.state.isToogleOn}
                        />
                    </Col>
                </Row>
            </Grid>
        )
    }
}

export default Container;