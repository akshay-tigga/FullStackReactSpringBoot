import React, {Component} from 'react'
import BootstrapTable from 'react-bootstrap-table-next'
import ServiceRequest from '../utils/ServiceRequest'
import ToolkitProvider, { Search } from 'react-bootstrap-table2-toolkit';

class IspListComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            isps: []
        }
    }

    componentDidMount() {
        ServiceRequest.getIsps()
        .then(response => {
            this.setState({
                isps: response.data
            });
        })
        .catch(error => {
            alert('Error fetching data. See console.')
            console.log(error)
        })
    }

    render() {
        const {isps} = this.state
        const ispList = isps.map(isp => { 
            return {
                id: isp.id,
                name: isp.name,
                lowestPrice: isp.lowestPrice,
                rating: isp.rating,
                maxSpeed: isp.maxSpeed
            }
        })

        const { SearchBar, ClearSearchButton } = Search;
        const columns = [{
            dataField: 'id',
            text: '#',
            sort: true
        }, {
            dataField: 'name',
            text: 'Name',
            sort: true
        }, {
            dataField: 'lowestPrice',
            text: 'Starting Price',
            sort: true
        }, {
            dataField: 'rating',
            text: 'Rating',
            sort: true
        }, {
            dataField: 'maxSpeed',
            text: 'Max Speed (Mbps)',
            sort: true
        }, {
            dataField: 'details',
            text: 'Details',
            formatter: detailsButton,
            events: { onClick: (e, column, columnIndex, row, rowIndex) => this.props.history.push(`/isps/${row.id}`) }
        }];

        return (
            <div className="container">
                <div className="row">
                    <div className="col">
                        <header id="main-header" className="py-2">
                            <h1 className="display-4">Internet Service Providers</h1>
                        </header>
                    </div>
                </div>
                <ToolkitProvider
                    keyField="id"
                    data={ispList}
                    columns={columns}
                    striped
                    search
                >
                    {
                        props => (
                            <div>
                                <span>
                                <SearchBar {...props.searchProps} />
                                <ClearSearchButton className="btn btn-outline-primary ml-2 mb-1" { ...props.searchProps } />

                                </span>
                                
                                
                                <BootstrapTable
                                    {...props.baseProps}
                                />
                            </div>
                        )
                    }
                </ToolkitProvider>

                {/*<BootstrapTable keyField='id' data={ispList} columns={columns} striped />*/}
            </div >
        )
    }

}

function detailsButton(cell, row, rowIndex, formatExtraData) {
    return (
      <button className="btn btn-secondary">Details</button>
    );
}

export default IspListComponent