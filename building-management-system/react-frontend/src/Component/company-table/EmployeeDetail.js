import React, { Component, useEffect, useState } from 'react';
import CompanyEmployeeService from './CompanyEmployeeService';
// import {} from 'react-router-dom';

class EmployeeDetail extends Component{

    constructor(props) {
        super(props);
        this.state={
            companyEmployees: [],
            companyId: props.match.params.companyId
        }
    }
    

    componentDidMount(){
        CompanyEmployeeService.getEmployeeByCompanyId(this.state.companyId).then((response) => {
            console.log(response);
            this.setState({companyEmployees: response.data.data})
        })
    };
    render() {
        return (
            <div>
                <div class="col-lg-12 ml-auto">
                    <main>
                        <div class="container-fluid px-4">
                            <h1 class="mt-1">Salary Detail</h1>
                            <br/>
                            <div class="card mb-4">
                                <div class="card-header">
                                    <i class="fas fa-table me-1"></i>
                                    DataTable Company Employee
                                </div>
                                <div class="card-body">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>Code</th>
                                                <th>Name</th>
                                                <th>Date Of Birth</th>
                                                <th>Identification</th>
                                                <th>Phone</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        {
                                            this.state.companyEmployees.map((companyEmployee) => (
                                                <tr key={companyEmployee.id} >
                                                    <td> {companyEmployee.code}</td>
                                                    <td> {companyEmployee.name}</td>
                                                    <td> {companyEmployee.dateOfBirth}</td>
                                                    <td> {companyEmployee.identification}</td>
                                                    <td> {companyEmployee.phone}</td>

                                                    <td>
                                                        <button type="button" className="btn btn-warning badge-pill">Delete</button>
                                                        <button type="button" className="btn btn-primary" data-bs-toggle="modal" data-bs-target="#formEmployee">Edit</button>
                                                        
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
            </div>
            
        );
    }
}

export default EmployeeDetail;