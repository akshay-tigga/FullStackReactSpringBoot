import React, {Component} from 'react'
import {Link} from 'react-router-dom'
import {withRouter} from 'react-router'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faHome } from "@fortawesome/free-solid-svg-icons";

class HeaderComponent extends Component {
    render() {
        return (
            <nav className="navbar navbar-expand-sm navbar-dark bg-dark">
                <div className="container">
                    <Link className="navbar-brand" to="/"><FontAwesomeIcon icon={faHome} /> Home</Link>
                    <button className="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarCollapse">
                        <ul className="navbar-nav ml-auto">
                            <li className="nav-item px-2">
                                <a className="nav-link" href="https://www.linkedin.com/in/akshay-tigga-796a51128/">Akshay</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        )
    }

}

export default withRouter(HeaderComponent)