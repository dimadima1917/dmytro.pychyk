import React, {Component} from 'react'
import {Alert} from "react-bootstrap";

class Notifications extends Component {
    constructor(props) {
        super(props);
        this.state = {
            showNotifications: false
        }
    }

    componentWillReceiveProps(props) {
        if (this.state.showNotifications !== props.showNotifications) {
            this.setState({showNotifications: props.showNotifications})
        }
    }

    render() {
        if (this.state.showNotifications) {
            return (
                <Alert bsStyle="danger">Duplicate name or product number.</Alert>
            )
        } else {
            return (
                null
            )
        }
    }
}

export default Notifications;