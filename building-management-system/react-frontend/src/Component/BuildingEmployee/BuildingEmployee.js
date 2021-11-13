import React, { Component } from 'react';
import Header from '../header/Header';
import Menu from '../menu/Menu';
import BuildingEmployeeService from './BuildingEmployeeService';

class BuildingEmployee extends Component {
    constructor(props) {
        super(props);
        this.state = {
            buildingEmployees: []
        }
    }

    componentDidMount() {
        BuildingEmployeeService.getAllBuildingEmployee().then((response) => {
            // console.log(response)
            this.setState({ buildingEmployees: response.data.data })

        });
    }

    // mappingBuildingEmployee = () => {
    //     this.state.buildingEmployee.map((value,key) => (

    //     ))
    // }
    render() {
        return (
            <div>

                <div className="container-fluid">
                    <div class="row">
                        <Header />
                    </div>
                    <div class="row mt-5">
                        <div class="col-lg-2">
                            <Menu />
                        </div>

                        {/* form add new Employee */}
                        <div class="modal fade" id="addNewEmployee" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Add New Building Employee</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <form>
                                            <div class="mb-3">
                                                <label for="code" class="form-label">Code</label>
                                                <input type="text" class="form-control" id="code" />
                                            </div>
                                            <div class="mb-3">
                                                <label for="name" class="form-label">Name</label>
                                                <input type="text" class="form-control" id="name" />
                                            </div>
                                            <div class="mb-3">
                                                <label for="dateOfBirth" class="form-label">Date Of Birth</label>
                                                <input type="text" class="form-control" id="dateOfBirth" />
                                            </div>
                                            <div class="mb-3">
                                                <label for="address" class="form-label">Address</label>
                                                <input type="text" class="form-control" id="address" />
                                            </div>
                                            <div class="mb-3">
                                                <label for="phone" class="form-label">Phone</label>
                                                <input type="text" class="form-control" id="phone" />
                                            </div>
                                            <div class="mb-3">
                                                <label for="position" class="form-label">Position</label>
                                                <input type="text" class="form-control" id="position" />
                                            </div>
                                            <div class="mb-3">
                                                <label for="level" class="form-label">Level</label>
                                                <input type="text" class="form-control" id="level" />
                                            </div>

                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary">Add new</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-10 ml-auto" id="layoutSidenav_content">
                            <main>
                                <div class="container-fluid px-4">
                                    <h1 class="mt-4">Building Employee Table</h1>
                                    <div class="card mb-4">
                                        <div class="card-body">
                                            <button type="button" class="btn btn-lg btn-success" data-bs-toggle="modal" data-bs-target="#addNewEmployee">Add new Employee</button>

                                        </div>
                                    </div>
                                    <div class="card mb-4">
                                        <div class="card-header">
                                            <i class="fas fa-table me-1"></i>
                                            DataTable Employee
                                        </div>
                                        <div class="card-body">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>Code</th>
                                                        <th>Name</th>
                                                        <th>Birthday</th>
                                                        <th>Address</th>
                                                        <th>PhoneNumber</th>
                                                        <th>Level</th>
                                                        <th>Position</th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    {
                                                        this.state.buildingEmployees.map((buildingEmployee) => (
                                                            <tr key={buildingEmployee.code}>
                                                                <td> {buildingEmployee.code}</td>
                                                                <td> {buildingEmployee.name}</td>
                                                                <td> {buildingEmployee.dateOfBirth}</td>
                                                                <td> {buildingEmployee.address}</td>
                                                                <td> {buildingEmployee.phone}</td>
                                                                <td> {buildingEmployee.level}</td>
                                                                <td> {buildingEmployee.position}</td>
                                                                <td>
                                                                    <button type="button" className="btn btn-warning badge-pill">Delete</button>
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
                    </div>
                </div>

            </div>
        );
    }
}

export default BuildingEmployee;