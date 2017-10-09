import React, {Component} from "react";
import BicycleList from "./Bicycle/BicycleList";
import {Button, ButtonToolbar, Col, FormControl, FormGroup, Grid, Navbar, Row,} from "react-bootstrap";
import {loadAllBicyclesRequest, load5MostPopularBicyclesRequest, createBicycleRequest, deleteBicycleRequest} from "../api/bikes";
import {SHOW_ALL_BICYCLES, SHOW_TOP_FIVE_BICYCLES} from "../constants/bikeConstants";
import CreateBikeModal from "../modals/CreateBikeModal";
import InfoBicycleModal from "../modals/InfoBicycleModal";
import Notifications from "./Notifications";

class Container extends Component {

    constructor(props) {
        super(props);

        this.state = {
            bicycle: {},
            bicycles: [],
            displayedBicycles: [],
            toggleShowAllBicycles: false,
            showCreateModal: false,
            showModalInfo: false,
            showNotifications: false
        };
        this.loadAllBicycles = this.loadAllBicycles.bind(this);
    }

    componentDidMount() {
        this.load5MostPopularBicycles();
    }

    reloadAllBicycles() {
        this.loadAllBicycles();
    }

    reloadFiveMostPopularBicycles() {
        this.load5MostPopularBicycles();
    }

    loadAllBicycles() {
        loadAllBicyclesRequest()
            .then((bicycles) => { //successCallback
                this.setState({
                    bicycles: bicycles,
                    displayedBicycles: bicycles
                });
                return null;
            })
            .catch((error) => { //error callback
                console.error(error);
            });
    }

    load5MostPopularBicycles() {
        load5MostPopularBicyclesRequest()
            .then((bicycles) => { //successCallback
                this.setState({
                    bicycles: bicycles,
                    displayedBicycles: bicycles
                });
                return null;
            })
            .catch((error) => { //error callback
                console.error(error);
            });
    }

    showCreateModal() {
        this.setState({
            showCreateModal: true
        });
    }

    searchBikes(searchQuery) {
        if (this.state.bicycle) {
            return this.state.bicycles.filter(function (el) {
                const searchValue = el.name.toLowerCase().trim();
                return searchValue.indexOf(searchQuery) !== -1;
            });
        } else {
            return [];
        }
    }

    searchHandler(e) {
        const searchQuery = e.target.value.toLowerCase().trim();
        this.setState({
            displayedBicycles: this.searchBikes(searchQuery)
        });
    }

    onCloseModal() {
        this.setState({
            showCreateModal: false,
            showModalInfo: false
        })
    }

    handleClick() {
        if (this.state.toggleShowAllBicycles) {
            this.setState({
                    toggleShowAllBicycles: false,
                    displayedBicycles: this.state.bicycles
                }
            );
            this.load5MostPopularBicycles()
        } else {
            this.setState({
                    toggleShowAllBicycles: true,
                    displayedBicycles: this.state.bicycles
                }
            );
            this.loadAllBicycles()
        }
    }

    createBicycleHandler(bicycle) {
        if (bicycle) {
            createBicycleRequest(bicycle)
                .then((response) => {
                    if (response === -1) {
                        this.setState(
                            {
                                showNotifications: true,
                            }
                        )
                    } else {
                        this.setState(
                            {
                                showNotifications: false
                            })
                        this.reloadAllBicycles()
                    }
                })
        }
    }

    deleteBicycleHandler(bicyclesId) {
        if (this.state.toggleShowAllBicycles) {
            deleteBicycleRequest(bicyclesId)
                .then((response) => this.reloadAllBicycles());
        } else {
            deleteBicycleRequest(bicyclesId)
                .then((response) => this.reloadFiveMostPopularBicycles());
        }
    }

    showModalInfo(bike) {
        this.setState({
            bicycle: bike,
            showModalInfo: true
        });
    }

    render() {
        return (
            <Grid fluid>
                <Navbar fluid inverse>
                    <Navbar.Header>
                        <ButtonToolbar>
                            <Button bsStyle="primary" type="button"
                                    onClick={this.showCreateModal.bind(this)}>
                                CREATE NEW BICYCLES
                            </Button>
                            <Button bsStyle="default" type="button"
                                    onClick={this.handleClick.bind(this)}>
                                {this.state.toggleShowAllBicycles ? SHOW_ALL_BICYCLES : SHOW_TOP_FIVE_BICYCLES}
                            </Button>
                        </ButtonToolbar>
                    </Navbar.Header>
                    <Navbar.Form pullRight>
                        <FormGroup>
                            <FormControl type="text" placeholder="Search" onChange={this.searchHandler.bind(this)}/>
                        </FormGroup>
                    </Navbar.Form>
                </Navbar>

                <Notifications showNotifications={this.state.showNotifications}/>

                <CreateBikeModal showModal={this.state.showCreateModal}
                                 onClose={this.onCloseModal.bind(this)}
                                 createBicycleHandler={this.createBicycleHandler.bind(this)}
                />

                <InfoBicycleModal showModal={this.state.showModalInfo}
                                  onClose={this.onCloseModal.bind(this)}
                                  bicycle={this.state.bicycle}
                />
                <Row>
                    <Col md={12}>
                        <BicycleList displayedBicycles={this.state.displayedBicycles}
                                     searchHandler={this.searchHandler.bind(this)}
                                     toggleShowAllBicycles={this.state.toggleShowAllBicycles}
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