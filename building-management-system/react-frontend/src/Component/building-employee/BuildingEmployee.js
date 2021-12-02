import React, { Component } from 'react';
import BuildingEmployeeService from './BuildingEmployeeService';

class BuildingEmployee extends Component {
    constructor(props) {
        super(props);
        this.state = {
            buildingEmployees: [],
            id: 0,
            code: "",
            name: "",
            dateOfBirth: "",
            address: "",
            phone: "",
            position: "",
            level: "",
            salary: ""
        }
    }

    isChange = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        console.log(name);
        console.log(value);
        this.setState({
            [name]: value
        })

    }
    getName = (nameLike) => {
        const name = nameLike.target.name;
        const value = nameLike.target.value;
        // console.log(name);
        // console.log(value);
        this.setState({
            name: value
        })

    }

    changeButton = (id) => {
        if (id === 0) {
            return <button type="button" class="btn btn-primary" data-bs-dismiss="modal" onClick={(code, name, dateOfBirth, address, phone, position, level, salary) => this.addNewBuildingEmployee(
                code = this.state.code,
                name = this.state.name,
                dateOfBirth = this.state.dateOfBirth,
                address = this.state.address,
                phone = this.state.phone,
                position = this.state.position,
                level = this.state.level,
                salary = this.state.salary)}>Add New</button>
        } else {
            return <button type="button" class="btn btn-warning" data-bs-dismiss="modal" onClick={(id, code, name, dateOfBirth, address, phone, position, level, salary) => this.editBuildingEmployee(
                id = this.state.id,
                code = this.state.code,
                name = this.state.name,
                dateOfBirth = this.state.dateOfBirth,
                address = this.state.address,
                phone = this.state.phone,
                position = this.state.position,
                level = this.state.level,
                salary = this.state.salary)}>Update</button>
        }
    }

    addNewBuildingEmployee = (code, name, dateOfBirth, address, phone, position, level, salary) => {
        var buildingEmployee = {};
        buildingEmployee.code = code;
        buildingEmployee.name = name;
        buildingEmployee.dateOfBirth = dateOfBirth;
        buildingEmployee.address = address;
        buildingEmployee.phone = phone;
        buildingEmployee.position = position;
        buildingEmployee.level = level;
        buildingEmployee.salary = parseFloat(salary);
        BuildingEmployeeService.createBuildingEmployee(buildingEmployee).then(() => {
            this.componentDidMount();
        });
        this.setState({
            id: 0,
            code: "",
            name: "",
            dateOfBirth: "",
            address: "",
            phone: "",
            position: "",
            level: "",
            salary: ""
        });
    }

    getBuildingEmployee = (buildingEmployee) => {
        this.setState({
            id: buildingEmployee.id,
            code: buildingEmployee.code,
            name: buildingEmployee.name,
            dateOfBirth: buildingEmployee.dateOfBirth,
            address: buildingEmployee.address,
            phone: buildingEmployee.phone,
            position: buildingEmployee.salaryResponse.position,
            level: buildingEmployee.salaryResponse.level,
            salary: buildingEmployee.salaryResponse.salary
        });

    }
    editBuildingEmployee = (id, code, name, dateOfBirth, address, phone, position, level, salary) => {
        var buildingEmployee = {};
        var idUpdate = parseInt(id);
        var salaryUpdate = parseFloat(salary);
        buildingEmployee.id = idUpdate;
        buildingEmployee.code = code;
        buildingEmployee.name = name;
        buildingEmployee.dateOfBirth = dateOfBirth;
        buildingEmployee.address = address;
        buildingEmployee.phone = phone;
        buildingEmployee.position = position;
        buildingEmployee.level = level;
        buildingEmployee.salary = salaryUpdate;
        BuildingEmployeeService.updateBuildingEmployee(idUpdate, buildingEmployee).then(() => {
            this.componentDidMount();
        });
        this.setState({
            id: 0,
            code: "",
            name: "",
            dateOfBirth: "",
            address: "",
            phone: "",
            level: "",
            position: "",
            salary: ""
        });
    }

    deleteBuildingEmployee = (id) => {
        var idDelete = parseInt(id);
        BuildingEmployeeService.deleteBuildingEmployee(idDelete).then(() => {
            this.componentDidMount();
        });
    }

    searchName = (value) => {
        console.log(value);
        console.log(this.state)
        BuildingEmployeeService.searchByName(this.state.name).then((response) => {
            this.setState({ buildingEmployees: response.data.data })
        });
    }

    componentDidMount() {
        BuildingEmployeeService.getAllBuildingEmployee().then((response) => {
            this.setState({ buildingEmployees: response.data.data });
            console.log(response.data);
        });
    }


    render() {
        return (
            <div>

                {/* form add new Employee */}
                <div class="modal fade" id="formEmployee" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Building Employee Infomation</h5>
                                <br/>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="mb-3">
                                        <label for="code" class="form-label">Code</label>
                                        <input value={this.state.code} type="text" onChange={(event) => this.isChange(event)} name="code" class="form-control" id="code" />
                                    </div>
                                    <div class="mb-3">
                                        <label for="name" class="form-label">Name</label>
                                        <input value={this.state.name} type="text" onChange={(event) => this.isChange(event)} name="name" class="form-control" id="name" />
                                    </div>
                                    <div class="mb-3">
                                        <label for="dateOfBirth" class="form-label">Date Of Birth</label>
                                        <input value={this.state.dateOfBirth} type="text" onChange={(event) => this.isChange(event)} name="dateOfBirth" class="form-control" id="dateOfBirth" />
                                    </div>
                                    <div class="mb-3">
                                        <label for="address" class="form-label">Address</label>
                                        <input value={this.state.address} type="text" onChange={(event) => this.isChange(event)} name="address" class="form-control" id="address" />
                                    </div>
                                    <div class="mb-3">
                                        <label for="phone" class="form-label">Phone</label>
                                        <input value={this.state.phone} type="text" onChange={(event) => this.isChange(event)} name="phone" class="form-control" id="phone" />
                                    </div>
                                    <div class="mb-3">
                                        <label for="position" class="form-label">Position</label>
                                        <input value={this.state.position} type="text" onChange={(event) => this.isChange(event)} name="position" class="form-control" id="position" />
                                    </div>
                                    <div class="mb-3">
                                        <label for="level" class="form-label">Level</label>
                                        <input value={this.state.level} type="text" onChange={(event) => this.isChange(event)} name="level" class="form-control" id="level" />
                                    </div>
                                    <div class="mb-3">
                                        <label for="level" class="form-label">Salary</label>
                                        <input value={this.state.salary} type="text" onChange={(event) => this.isChange(event)} name="salary" class="form-control" id="salary" />
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                {this.changeButton(this.state.id)}
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-lg-12 ml-auto" id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4">
                            <h1 class="mt-1">Building Employee Table</h1>
                            <div class="card mb-4">
                                <div class="card-body">
                                    <div className="row">
                                        <div class="col-xs-7 col-sm-7 col-md-7 col-lg-7">
                                            <button type="button" class="btn btn btn-success" data-bs-toggle="modal" data-bs-target="#formEmployee">Add new Employee</button>
                                        </div>
                                        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                            <form className="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0" >
                                                <div class="input-group">
                                                    <input onChange={(event) => this.getName(event)} class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                                                    <button onClick={() => this.searchName(this.state.value)} class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
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
                                                <th>Salary</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            {
                                                this.state.buildingEmployees.map((buildingEmployee) => (
                                                    <tr key={buildingEmployee.id}>
                                                        <td> {buildingEmployee.code}</td>
                                                        <td> {buildingEmployee.name}</td>
                                                        <td> {buildingEmployee.dateOfBirth}</td>
                                                        <td> {buildingEmployee.address}</td>
                                                        <td> {buildingEmployee.phone}</td>
                                                        <td> {buildingEmployee.salaryResponse.level}</td>
                                                        <td> {buildingEmployee.salaryResponse.position}</td>
                                                        <td> {buildingEmployee.salaryResponse.salary}</td>
                                                        <td>
                                                            <button type="button" className="btn btn-warning badge-pill" onClick={() => this.deleteBuildingEmployee(buildingEmployee.id)}>Delete</button>
                                                            <button type="button" className="btn btn-primary" data-bs-toggle="modal" data-bs-target="#formEmployee" onClick={() => this.getBuildingEmployee(buildingEmployee)}>Edit</button>
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

export default BuildingEmployee;