import React, {Component} from "react";
import BicycleList from "./Bicycle/BicycleList";
import {Button, Col, Grid, Row, Form} from "react-bootstrap";
import {loadAllProductsRequest, load5MostPopular, createProductRequest} from "../api/bikes";
import {SHOW_ALL_BICYCLES, SHOW_TOP_FIVE_BICYCLES} from "../constants/bikeConstants";
import CreateBikeModal from "../modals/CreateBikeModal";


class Container extends Component {

    constructor(props) {
        super(props);

        this.state = {
            bikes: [],
            displayedBikes: [],
            isToogleOn: false,
            showCreateModal: false,
        }
        this.loadProductListProducts = this.loadProductListProducts.bind(this);
    }

    componentDidMount() {
        this.load5MostPopularBicycles();
    }


    reloadAllProducts() {
        this.loadProductListProducts();
    }


    loadProductListProducts() {
        loadAllProductsRequest()
            .then((products) => { //successCallback
                this.setState({
                    bikes: products,
                    displayedBikes: products
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
                    bikes: products,
                    displayedBikes: products
                });
                return null;
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

    searchHandler(e) {
        const searchQuery = e.target.value.toLowerCase();
        const displayedProducts = this.state.bikes.filter(function (el) {
            const searchValue = el.name.toLowerCase();
            return searchValue.indexOf(searchQuery) !== -1;
        });
        this.setState({
            displayedBikes: displayedProducts
        });
    }

    onCloseCreateModal(e) {
        this.setState({
            showCreateModal: false
        })
    }

    handleClick() {
        if (this.state.isToogleOn) {
            this.setState({
                    isToogleOn: false,
                    displayedBikes: this.state.bikes
                }
            );
            this.load5MostPopularBicycles()
        } else {
            this.setState({
                    isToogleOn: true,
                    displayedBikes: this.state.bikes

                }
            );
            this.loadProductListProducts()
        }
    }

    createBicycleHandler(bicycle) {
        if (bicycle) {
            createProductRequest(bicycle)
                .then((response) => this.reloadAllProducts());
        }
    }

    render() {
        return (

            <Grid fluid>
                <Row>
                    <Col md={7}>
                        <button type="button" className="btn btn-primary" onClick={this.handleClick.bind(this)}>
                            {this.state.isToogleOn ? SHOW_TOP_FIVE_BICYCLES : SHOW_ALL_BICYCLES}
                        </button>
                        <button type="button" className="btn btn-primary" onClick={this.showCreateModal.bind(this)}>
                            CREATE NEW BICYCLES
                        </button>

                        <CreateBikeModal showModal={this.state.showCreateModal}
                                         onClose={this.onCloseCreateModal.bind(this)}
                                         createBicycleHandler={this.createBicycleHandler.bind(this)}/>

                    </Col>
                </Row>
                <Row>
                    <Col>
                        <BicycleList displayedBicycles={this.state.displayedBikes}
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