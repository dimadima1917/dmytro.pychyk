import React, {Component} from "react";
import BicycleList from "./Bicycle/BicycleList";
import {Button, ButtonToolbar, Col, FormControl, FormGroup, Grid, Navbar, Row} from "react-bootstrap";
import CreateBikeModal from "../modals/CreateBikeModal";
import InfoBicycleModal from "../modals/InfoBicycleModal";
import Notifications from "./Notifications";

import {
    loadFiveMostPopularBicycles,
    loadOfFoundBicycles,
    deleteBicycle,
    createBicycle
} from './Bicycle/actions/bicycles';
import {connect} from "react-redux";

class Container extends Component {

    constructor(props) {
        super(props);

        this.state = {
            bicycle: {},
            bicycles: [],
            showCreateModal: false,
            showModalInfo: false,
        };
    }

    componentDidMount() {
        this.props.loadFiveMostPopularBicycles();
    }

    componentWillReceiveProps(nextProps) {
        if (nextProps.bicyclesShouldBeReloaded && !this.props.bicyclesShouldBeReloaded) {
            this.reloadBicycles();
        }
    }

    reloadBicycles() {
        this.props.loadFiveMostPopularBicycles();
    }

    showCreateModal() {
        this.setState({
            showCreateModal: true
        });
    }

    onCloseModal() {
        this.setState({
            showCreateModal: false,
            showModalInfo: false
        })
    }

    showModalInfo(bike) {
        this.setState({
            bicycle: bike,
            showModalInfo: true
        });
    }

    searchHandler() {
        const substring = this.state.SubstringRef.value.trim();
        if (substring) {
            this.props.loadOfFoundBicycles(substring);
        }
    }

    showTopFive() {
        this.props.loadFiveMostPopularBicycles();
    }

    createBicycleHandler(bicycle) {
        if (bicycle) {
            this.props.createBicycle(bicycle);
        }
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
                            <Button bsStyle="default" onClick={this.showTopFive.bind(this)}>TOP 5</Button>
                        </ButtonToolbar>
                    </Navbar.Header>
                    <Navbar.Form pullRight>
                        <FormGroup>
                            <FormControl type="text" placeholder="Text"
                                         inputRef={ref => this.state.SubstringRef = ref}/>
                            <Button type="submit" onClick={this.searchHandler.bind(this)}>Search</Button>
                        </FormGroup>
                    </Navbar.Form>
                </Navbar>

                <Notifications showNotifications={this.props.showNotifications}/>

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
                        <BicycleList bicycles={this.props.bicycles}
                                     showInfo={this.showModalInfo.bind(this)}
                                     deleteBicycle={this.props.deleteBicycle}
                        />
                    </Col>
                </Row>
            </Grid>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        bicycles: state.bicyclesReducers.bicycles,
        bicyclesShouldBeReloaded: state.bicyclesReducers.bicyclesShouldBeReloaded,
        showNotifications:state.bicyclesReducers.showNotifications
    };
};

const mapDispatchToProps = (dispatch) => {
    return {
        loadFiveMostPopularBicycles: () => dispatch(loadFiveMostPopularBicycles()),
        loadOfFoundBicycles: (substring) => dispatch(loadOfFoundBicycles(substring)),
        deleteBicycle: (bicycleID) => dispatch(deleteBicycle(bicycleID)),
        createBicycle: (bicycle) => dispatch(createBicycle(bicycle))
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(Container);