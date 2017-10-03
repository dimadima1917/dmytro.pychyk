import React, {Component} from "react";
import BicycleList from "./Bicycle/BicycleList";
import {Button, Col, Grid, Row, Form} from "react-bootstrap";
import {loadAllBicyclesRequest, load5MostPopular, createBicyclesRequest, deleteBicyclesRequest} from "../api/bikes";
import {SHOW_ALL_BICYCLES, SHOW_TOP_FIVE_BICYCLES} from "../constants/bikeConstants";
import CreateBikeModal from "../modals/CreateBikeModal";
import InfoBicycleModal from "../modals/InfoBicycleModal";


class Container extends Component {

    constructor(props) {
        super(props);

        this.state = {
            bike: {},
            bikes: [],
            displayedBikes: [],
            isToogleOn: false,
            showCreateModal: false,
            showModalInfo: false
        }
        this.loadBicycleListBicycles = this.loadBicycleListBicycles.bind(this);
    }

    componentDidMount() {
        this.load5MostPopularBicycles();
    }


    reloadAllBicycles() {
        this.loadBicycleListBicycles();
    }

    reloadFiveMostPopularBicycles() {
        this.load5MostPopularBicycles();
    }


    loadBicycleListBicycles() {
        loadAllBicyclesRequest()
            .then((bicycles) => { //successCallback
                this.setState({
                    bikes: bicycles,
                    displayedBikes: bicycles
                });
                return null;
            })
            .catch((error) => { //errror callback
                console.error(error);
            });
    }

    load5MostPopularBicycles() {
        load5MostPopular()
            .then((bicycles) => { //successCallback
                this.setState({
                    bikes: bicycles,
                    displayedBikes: bicycles
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
        const searchQuery = e.target.value.toLowerCase().trim();
        const displayedBicycles = this.state.bikes.filter(function (el) {
            const searchValue = el.name.toLowerCase().trim();
            return searchValue.indexOf(searchQuery) !== -1;
        });
        this.setState({
            displayedBikes: displayedBicycles
        });
    }

    onCloseModal() {
        this.setState({
            showCreateModal: false,
            showModalInfo: false
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
            this.loadBicycleListBicycles()
        }
    }

    createBicycleHandler(bicycle) {
        if (bicycle) {
            createBicyclesRequest(bicycle)
                // .then((response)=>
                // {if(response !== -1){alert(response)}})
                .then((response) => this.reloadAllBicycles());
        }
    }

    deleteBicycleHandler(bicyclesId) {
        if (bicyclesId && this.state.isToogleOn) {
            deleteBicyclesRequest(bicyclesId)
                .then((response) => this.reloadAllBicycles());
        } else {
            deleteBicyclesRequest(bicyclesId)
                .then((response) => this.reloadFiveMostPopularBicycles());
        }
    }

    showModalInfo(bike) {
        this.setState({
            bike: bike,
            showModalInfo: true
        });
    }

    render() {
        return (

            <Grid fluid>
                <nav className="navbar navbar-default">
                    <div className="container-fluid">
                        <div className="navbar-header">
                            <div className="btn-group" role="group" aria-label="...">
                                <button type="button" className="btn btn-primary navbar-btn"
                                        onClick={this.showCreateModal.bind(this)}>
                                    CREATE NEW BICYCLES
                                </button>
                                <button type="button" className="btn btn-default navbar-btn" onClick={this.handleClick.bind(this)}>
                                    {this.state.isToogleOn ? SHOW_TOP_FIVE_BICYCLES : SHOW_ALL_BICYCLES}
                                </button>
                            </div>
                        </div>
                        <form className="navbar-form navbar-right">
                            <div className="form-group">
                                <input onChange={this.searchHandler.bind(this)} type="text" className="form-control"
                                       placeholder="Search"/>
                            </div>
                        </form>
                    </div>
                </nav>

                <CreateBikeModal showModal={this.state.showCreateModal}
                                 onClose={this.onCloseModal.bind(this)}
                                 createBicycleHandler={this.createBicycleHandler.bind(this)}/>

                <InfoBicycleModal showModalInfo={this.state.showModalInfo}
                                  onClose={this.onCloseModal.bind(this)}
                                  bicycle={this.state.bike}
                />

                <Row>
                    <Col md={12}>
                        <BicycleList displayedBicycles={this.state.displayedBikes}
                                     searchHandler={this.searchHandler.bind(this)}
                                     isToogleOn={this.state.isToogleOn}
                                     deleteBicycle={this.deleteBicycleHandler.bind(this)}
                                     showInfo={this.showModalInfo.bind(this)}
                        />
                    </Col>
                </Row>
            </Grid>
        )
    }
}

export default Container;