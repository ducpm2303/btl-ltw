import React, { Component } from 'react';
import CompanyService from './CompanyService';

class CompanyTable extends Component {
    constructor(props) {
        super(props);
        this.state = {
            company: [],
            id: 0,
            name: "",
            taxCode: "",
            authorizedCapital: 0.0,
            fieldOfActivity: "",
            floor: "",
            hotline: "",
            area: 0.0,
            numberOfEmployee: 0
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
    changeButton = (id) => {
        if (id === 0) {
            return <button type="button" class="btn btn-primary" data-bs-dismiss="modal" onClick={(name, taxCode, authorizedCapital, fieldOfActivity, floor, hotline, area, numberOfEmployee) => this.addNewCompany(
                name = this.state.name,
                taxCode = this.state.taxCode,
                authorizedCapital = this.state.authorizedCapital,
                fieldOfActivity = this.state.fieldOfActivity,
                floor = this.state.floor,
                hotline = this.state.hotline,
                area = this.state.area,
                numberOfEmployee = this.state.numberOfEmployee)
            }>Add New</button>
        } else {
            return <button type="button" class="btn btn-warning" data-bs-dismiss="modal" onClick={(id, name, taxCode, authorizedCapital, fieldOfActivity, floor, hotline, area, numberOfEmployee) => this.editCompany(
                id = this.state.id,
                name = this.state.name,
                taxCode = this.state.taxCode,
                authorizedCapital = this.state.authorizedCapital,
                fieldOfActivity = this.state.fieldOfActivity,
                floor = this.state.floor,
                hotline = this.state.hotline,
                area = this.state.area,
                numberOfEmployee = this.state.numberOfEmployee)}>Update</button>
        }
    }

    addNewCompany = (name, taxCode, authorizedCapital, fieldOfActivity, floor, hotline, area, numberOfEmployee) => {
        var company = {};
        company.name = name;
        company.taxCode = taxCode;
        company.authorizedCapital = parseFloat(authorizedCapital);
        company.fieldOfActivity = fieldOfActivity;
        company.floor = floor;
        company.hotline = hotline;
        company.area = parseFloat(area);
        company.numberOfEmployee = parseInt(numberOfEmployee);
        CompanyService.createCompany(company).then(() => {
            this.componentDidMount();
        })

        this.setState({
            id: 0,
            name: "",
            taxCode: "",
            authorizedCapital: 0.0,
            fieldOfActivity: "",
            floor: "",
            hotline: "",
            area: 0.0,
            numberOfEmployee : 0
        });
    }

    editCompany = (id, name, taxCode, authorizedCapital, fieldOfActivity, floor, hotline, area, numberOfEmployee) => {
        var company = {};
        company.id = parseInt(id);
        company.name = name;
        company.taxCode = taxCode;
        company.authorizedCapital = parseFloat(authorizedCapital);
        company.fieldOfActivity = fieldOfActivity;
        company.floor = floor;
        company.hotline = hotline;
        company.area = parseFloat(area);
        company.numberOfEmployee = parseInt(numberOfEmployee);
        CompanyService.updateCompany(company.id, company).then(() => {
            this.componentDidMount();
        })

        this.setState({
            id: 0,
            name: "",
            taxCode: "",
            authorizedCapital: 0.0,
            fieldOfActivity: "",
            floor: "",
            hotline: "",
            area: 0.0,
            numberOfEmployee : 0
        });
    }

    getCompany = (company) =>{
        this.setState({
            id: company.id,
            name: company.name,
            taxCode: company.taxCode,
            authorizedCapital: company.authorizedCapital,
            fieldOfActivity: company.fieldOfActivity,
            floor: company.floor,
            hotline: company.hotline,
            area: company.area,
            numberOfEmployee: company.numberOfEmployee
        });
    }

    deleteCompany = (id) =>{
        CompanyService.deleteCompany(parseInt(id)).then( () =>{
            this.componentDidMount();
        })
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
                    {/* form add new Company */}
                    <div class="modal fade" id="formCompany" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Company Infomation</h5>
                                    <br/>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <form>
                                        <div class="mb-3">
                                            <label for="code" class="form-label">Name</label>
                                            <input value={this.state.name} type="text" onChange={(event) => this.isChange(event)} name="name" class="form-control" id="name" />
                                        </div>
                                        <div class="mb-3">
                                            <label for="name" class="form-label">Tax Code</label>
                                            <input value={this.state.taxCode} type="text" onChange={(event) => this.isChange(event)} name="taxCode" class="form-control" id="taxCode" />
                                        </div>
                                        <div class="mb-3">
                                            <label for="dateOfBirth" class="form-label">Authorized Capital</label>
                                            <input value={this.state.authorizedCapital} type="text" onChange={(event) => this.isChange(event)} name="authorizedCapital" class="form-control" id="authorizedCapital" />
                                        </div>
                                        <div class="mb-3">
                                            <label for="address" class="form-label">Field Of Activity</label>
                                            <input value={this.state.fieldOfActivity} type="text" onChange={(event) => this.isChange(event)} name="fieldOfActivity" class="form-control" id="fieldOfActivity" />
                                        </div>
                                        <div class="mb-3">
                                            <label for="phone" class="form-label">Floor</label>
                                            <input value={this.state.floor} type="text" onChange={(event) => this.isChange(event)} name="floor" class="form-control" id="floor" />
                                        </div>
                                        <div class="mb-3">
                                            <label for="position" class="form-label">Hotline</label>
                                            <input value={this.state.hotline} type="text" onChange={(event) => this.isChange(event)} name="hotline" class="form-control" id="hotline" />
                                        </div>
                                        <div class="mb-3">
                                            <label for="level" class="form-label">Area</label>
                                            <input value={this.state.area} type="text" onChange={(event) => this.isChange(event)} name="area" class="form-control" id="area" />
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
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Companies Table</h1>
                        <div class="card mb-4">
                            <div class="card-body">
                                <div className="row">
                                    <div class="col-xs-7 col-sm-7 col-md-7 col-lg-7">
                                        <button type="button" class="btn btn btn-success" data-bs-toggle="modal" data-bs-target="#formCompany">Add new Employee</button>
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
                                DataTable Company
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
                                                        <button type="button" className="btn btn-danger" onClick={() => this.deleteCompany(company.id)}>Delete</button>
                                                        <button type="button" className="btn btn-primary" data-bs-toggle="modal" data-bs-target="#formCompany" onClick={() => this.getCompany(company)}>Edit</button>
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
