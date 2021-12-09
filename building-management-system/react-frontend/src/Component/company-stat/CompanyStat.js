import React, { Component } from 'react';

class CompanyStat extends Component {
    render() {
        return (
            <div>
                <div class="col-lg-12 ml-auto" id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4">
                            <h1 class="mt-1">Company Statitic Table</h1>
                            <br/>
                            <div class="card mb-4">
                                <div class="card-body">
                                    <button type="button" class="btn btn-lg btn-warning">Month Statitic</button>
                                    <button type="button" class="btn btn-lg btn-danger">Year Statitic</button>
                                </div>
                            </div>
                            <div class="card mb-4">
                                <div class="card-header">
                                    <i class="fas fa-table me-1"></i>
                                    DataTable Company Statitics
                                </div>
                                <div class="card-body">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>Date</th>
                                                <th>Name</th>
                                                <th>Area</th>
                                                <th>Rented Price</th>
                                                <th>Service Price</th>
                                                <th>Total Price</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            {/* {
                                                this.state.salaries.map((Salary) => (
                                                    <tr key={Salary.id} >
                                                        <td> {Salary.level}</td>
                                                        <td> {Salary.position}</td>
                                                        <td> {Salary.salary}</td>
                                                        <td>
                                                            <button type="button" className="btn btn-warning badge-pill" onClick={() => this.deleteSalary(Salary.id)}>Delete</button>
                                                            <button type="button" className="btn btn-primary" data-bs-toggle="modal" data-bs-target="#formEmployee" onClick={() => this.getSalary(Salary)}>Edit</button>
                                                            
                                                        </td>
                                                    </tr>
                                                ))

                                            } */}
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

export default CompanyStat;
