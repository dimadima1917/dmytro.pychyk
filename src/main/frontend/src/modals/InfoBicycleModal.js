import React, {Component} from "react";
import {Button, Modal, ModalFooter, ModalHeader, ModalTitle} from "react-bootstrap";

class InfoBicycleModal extends Component {
    constructor(props) {
        super(props);
        this.baseState = this.state = {
            showModalInfo: false
        }
    }

    componentWillUpdate(props) {
        if (this.state.showModalInfo !== props.showModalInfo) {
            this.setState({showModalInfo: props.showModalInfo});
        }
    }

    closeModal() {
        this.setState({showModalInfo: false});
        if (this.props.onClose) {
            this.props.onClose()
        }
    }

    render() {
        return (
            <Modal show={this.state.showModalInfo} onHide={this.closeModal.bind(this)}>
                <ModalHeader closeButton>
                            <ModalTitle>Information about &quot;{this.props.bicycle.name}&quot;</ModalTitle>
                </ModalHeader>
                <div className="modal-body">
                    <h4>Bicycle Number {this.props.bicycle.productNumber}</h4>
                </div>
                <div className="modal-body">
                    <h4>Color</h4>{this.props.bicycle.color}
                </div>
                <div className="modal-body">
                    <h4>Standard Cost</h4>{this.props.bicycle.standardCost}
                </div>
                <div className="modal-body">
                    <h4>Size</h4>{this.props.bicycle.size}
                </div>
                <div className="modal-body">
                    <h4>Style</h4>{this.props.bicycle.style}<h4/>
                </div>
                <ModalFooter>
                    <Button bsStyle="default" onClick={this.closeModal.bind(this)}>Cancel</Button>
                </ModalFooter>
            </Modal>
        );
    }
}

export default InfoBicycleModal;
