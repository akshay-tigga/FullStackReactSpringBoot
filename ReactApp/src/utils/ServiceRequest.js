import Axios from "axios";
import {LOCALHOST_URL} from './Constants'

class ServiceRequest {
    getIsps() {
        return Axios.get(`${LOCALHOST_URL}/isps`)
    }

    getIspById(id) {
        return Axios.get(`${LOCALHOST_URL}/isps/${id}`)
    }
}

export default new ServiceRequest()