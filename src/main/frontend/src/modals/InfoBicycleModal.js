import React, {Component} from "react";
import {Button, Modal, ModalBody, ModalFooter, ModalHeader, ModalTitle} from "react-bootstrap";

class InfoBicycleModal extends Component {
    constructor(props) {
        super(props);
        this.baseState = this.state = {
            showModal: false
        }
    }

    componentWillUpdate(props) {
        if (this.state.showModal !== props.showModal) {
            this.setState({showModal: props.showModal});
        }
    }

    closeModal() {
        this.setState({showModal: false});
        if (this.props.onClose) {
            this.props.onClose()
        }
    }

    render() {
        return (
            <Modal show={this.state.showModal} onHide={this.closeModal.bind(this)}>
                <ModalHeader closeButton>
                    <ModalTitle>Information about &quot;{this.props.bicycle.name}&quot;</ModalTitle>
                </ModalHeader>
                <ModalBody>
                    <h4>Bicycle Number </h4>{this.props.bicycle.productNumber}
                    <h4>Color</h4>{this.props.bicycle.color}
                    <h4>Standard Cost</h4>{this.props.bicycle.standardCost}
                    <h4>Size</h4>{this.props.bicycle.size}
                    <h4>Style</h4>{this.props.bicycle.style}<h4/>
                </ModalBody>
                <ModalFooter>
                    <Button bsStyle="default" onClick={this.closeModal.bind(this)}>Cancel</Button>
                </ModalFooter>
            </Modal>
        );
    }
}

export default InfoBicycleModal;
