import React, {Component} from 'react'
import ServiceRequest from '../utils/ServiceRequest'
import {getAttachmentUrl} from '../utils/Constants'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTwitter, faFacebook } from '@fortawesome/free-brands-svg-icons'

class IspComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id : this.props.match.params.id,
            name : '',
            lowestPrice : '',
            rating : '',
            maxSpeed : '',
            description : '',
            contact : '',
            email : '',
            image : '',
            ispUrl : ''
        }
    }

    componentDidMount() {
        ServiceRequest.getIspById(this.state.id)
        .then(response => {
            this.setState({
                name : response.data.name,
                lowestPrice : response.data.lowestPrice,
                rating : response.data.rating,
                maxSpeed : response.data.maxSpeed,
                description : response.data.description,
                contact : response.data.contact,
                email : response.data.email,
                image : response.data.image,
                ispUrl : response.data.ispUrl,
            })
        })
        .catch(error => {
            alert('Error fetching data. See console.')
            console.log(error)
        })
    }

    render() {
        const attachmentUrl = getAttachmentUrl(this.state.id);
        const currentUrl = window.location.href;
        const facebookUrl = `https://www.facebook.com/sharer/sharer.php?u=${currentUrl}`;
        const twitterUrl = `https://twitter.com/intent/tweet?url=${currentUrl}`
        
        return (
            <div className="container">
                <div className="row">
                    <div className="col">
                        <div className="card text-left">
                            <div className="card-header">
                                <h4 className="display-4 p-0">{this.state.name}</h4>
                            </div>
                            {this.state.image !== '' && <img className="card-img-top img-fluid" src={this.state.image} alt="" ></img>}
                            <div className="card-body">
                                <h4 className="card-title">{`${this.state.email} ${this.state.contact}`}</h4>
                                <h6 className="card-subtitle text-muted">{`Rating - ${this.state.rating}`}</h6>
                                <p className="card-text mb-0">{`Starting price - ${this.state.lowestPrice}`}</p>
                                <p className="card-text mb-0">{`Max Speed - ${this.state.maxSpeed}`}</p>
                                <p className="card-text">{this.state.description}</p>
                                <div className="row mb-2">
                                    <div className="col-6">
                                    <a className="btn btn-primary btn-block" href={this.state.ispUrl}>Website</a>
                                    </div>
                                    <div className="col-6">
                                    <a className="btn btn-success btn-block" href={attachmentUrl} target="_blank">Download</a>
                                    </div>
                                </div>
                                <div className="row">
                                    <div className="col-6">
                                    <a className="btn btn-dark btn-block" href={facebookUrl} target="_blank"><FontAwesomeIcon icon={faFacebook} /></a>
                                    </div>
                                    <div className="col-6">
                                    <a className="btn btn-dark btn-block" href={twitterUrl} target="_blank"><FontAwesomeIcon icon={faTwitter} /></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

}

export default IspComponent