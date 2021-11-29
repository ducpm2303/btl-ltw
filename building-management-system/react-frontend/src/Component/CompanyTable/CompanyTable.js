import React, { Component } from 'react';
import CompanyService from './CompanyService';

class CompanyTable extends Component {
    constructor(props) {
        super(props);
        this.state = {
            company: []
        }
    }

    componentDidMount(){
        CompanyService.getAllCompany().then((response) => {
            console.log(response);
            this.setState({company: response.data.data})
        })
    }

    render() {
        return (
            <div>
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Companies Table</h1>
                        <div class="card mb-4">
                            <div class="card-body">
                                <button type="button" class="btn btn-lg btn-success">Add new Company</button>
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                DataTable Employee
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Code</th>
                                            <th>Authorized capital</th>
                                            <th>Activity</th>
                                            <th>Quantity</th>
                                            <th>Address</th>
                                            <th>Phone Number</th>
                                            <th>Area</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    {/* <tfoot>
                                        <tr>
                                            <th>Name</th>
                                            <th>Code</th>
                                            <th>Authorized capital</th>
                                            <th>Activity</th>
                                            <th>Quantity</th>
                                            <th>Address</th>
                                            <th>Phone Number</th>
                                            <th>Area</th>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot> */}
                                    <tbody>
                                        {
                                            this.state.company.map((company) =>(
                                                <tr key={company.id}>
                                                    <td> {company.name} </td>
                                                    <td> {company.taxCode} </td>
                                                    <td> {company.authorizedCapital} </td>
                                                    <td> {company.fieldOfActivity} </td>
                                                    <td> {company.numberOfEmployee} </td>
                                                    <td> {company.floor} </td>
                                                    <td> {company.hotline} </td>
                                                    <td> {company.area} </td>
                                                    <td>
                                                        <button type="button" className="btn btn-danger">Delete</button>
                                                        <button type="button" className="btn btn-primary">Edit</button>
                                                    </td>
                                                </tr>
                                            ))
                                        }
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        );
    }
}

export default CompanyTable;
