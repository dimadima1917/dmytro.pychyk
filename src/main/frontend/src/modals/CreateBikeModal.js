import React, {Component} from "react";
import Modal from "react-bootstrap/es/Modal";
import ModalTitle from "react-bootstrap/es/ModalTitle";
import ModalHeader from "react-bootstrap/es/ModalHeader";
import FormGroup from "react-bootstrap/es/FormGroup";
import ControlLabel from "react-bootstrap/es/ControlLabel";
import Col from "react-bootstrap/es/Col";
import FormControl from "react-bootstrap/es/FormControl";
import Form from "react-bootstrap/es/Form";
import ModalFooter from "react-bootstrap/es/ModalFooter";
import Button from "react-bootstrap/es/Button";

class CreateBikeModal extends Component {

    constructor(props) {
        super(props);
        this.baseState = this.state = {
            name: '',
            productNumber: '',
            color: '',
            standardCost: '',
            size: '',
            style: '',
            showModal: false
        }
    }

    componentWillUpdate(props) {
        if (this.state.showModal !== props.showModal) {
            this.setState({showModal: props.showModal});
        }
    }

    showModal() {
        this.setState({showModal: true});
    }

    closeModal() {
        this.setState({showModal: false});
        if (this.props.onClose) {
            this.props.onClose()
        }
    }

    onCreate(e) {
        let formData = {
            name: this.state.nameRef.value || '',
            productNumber: this.state.NumberRef.value || '',
            color: this.state.colorRef.value || '',
            standardCost: this.state.standardCostRef.value || 0,
            size: this.state.sizeRef.value || '',
            style: this.state.styleRef.value || '',
        };

        this.props.createBicycleHandler(formData);
        this.closeModal(e);
    }

    render() {
        return (
            <Modal show={this.state.showModal} onHide={this.closeModal.bind(this)}>
                <ModalHeader closeButton>
                    <ModalTitle>Create New Bicycle</ModalTitle>
                    <Form horizontal>
                        <FormGroup>
                            <Col smOffset={2} sm={3}>
                                <ControlLabel>Name</ControlLabel>
                            </Col>
                            <Col sm={6}>
                                <FormControl id="name"
                                             type="text"
                                             placeholder="Name"
                                             maxLength="50"
                                             inputRef={ref => this.state.nameRef = ref}/>
                            </Col>
                        </FormGroup>
                        <FormGroup>
                            <Col smOffset={2} sm={3}>
                                <ControlLabel>Number</ControlLabel>
                            </Col>
                            <Col sm={6}>
                                <FormControl id="productNumber"
                                             type="text"
                                             placeholder="Number"
                                             maxLength="25"
                                             inputRef={ref => this.state.NumberRef = ref}
                                />
                            </Col>
                        </FormGroup>
                        <FormGroup>
                            <Col smOffset={2} sm={3}>
                                <ControlLabel>Color</ControlLabel>
                            </Col>
                            <Col sm={6}>
                                <FormControl id="color"
                                             type="text"
                                             placeholder="Color"
                                             maxLength="15"
                                             inputRef={ref => this.state.colorRef = ref}
                                />
                            </Col>
                        </FormGroup>
                        <FormGroup>
                            <Col smOffset={2} sm={3}>
                                <ControlLabel>Standart Cost</ControlLabel>
                            </Col>
                            <Col sm={6}>
                                <FormControl id="standardCostRef"
                                             type="number"
                                             placeholder="Standart Cost"
                                             min="0"
                                             inputRef={ref => this.state.standardCostRef = ref}
                                />
                            </Col>
                        </FormGroup>
                        <FormGroup>
                            <Col smOffset={2} sm={3}>
                                <ControlLabel>Size</ControlLabel>
                            </Col>
                            <Col sm={6}>
                                <FormControl id="size"
                                             type="text"
                                             placeholder="Size"
                                             maxLength="5"
                                             inputRef={ref => this.state.sizeRef = ref}
                                />
                            </Col>
                        </FormGroup>
                        <FormGroup>
                            <Col smOffset={2} sm={3}>
                                <ControlLabel>Style</ControlLabel>
                            </Col>
                            <Col sm={6}>
                                <FormControl id="style"
                                             type="text"
                                             placeholder="Style"
                                             maxLength="2"
                                             inputRef={ref => this.state.styleRef = ref}
                                />
                            </Col>
                        </FormGroup>
                        <ModalFooter>
                            <Button bsStyle="default" onClick={this.closeModal.bind(this)}>Cancel</Button>
                            <Button bsStyle="primary" onClick={this.onCreate.bind(this)}>Create</Button>
                        </ModalFooter>
                    </Form>
                </ModalHeader>
            </Modal>
        );
    }
}

export default CreateBikeModal;