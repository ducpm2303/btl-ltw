import React, { Component } from 'react';
import Header from '../header/Header';
import Menu from '../menu/Menu';

class BuildingEmployee extends Component {
    render() {
        return (
            <div className="container-fluid">
                <div class="row">
                    <Header />
                </div>
                <div class="row mt-5">
                    <div class="col-lg-2">
                        <Menu />
                    </div>
                    <div class="col-lg-10 ml-auto" id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Building Employee Table</h1>
                                <div class="card mb-4">
                                    <div class="card-body">
                                        <button type="button" class="btn btn-lg btn-success">Add new Employee</button>
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
                                            <tfoot>
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
                                            </tfoot>
                                            <tbody>
                                                <tr>
                                                    <td>12345</td>
                                                    <td>Mincy</td>
                                                    <td>21/11/2000</td>
                                                    <td>Ha dong</td>
                                                    <td>0988405038</td>
                                                    <td>2</td>
                                                    <td>Protector</td>
                                                    <td>
                                                        <button type="button" class="btn btn-primary">Delete</button>
                                                        <button type="button" class="btn btn-primary">Edit</button>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>12345</td>
                                                    <td>Mincy</td>
                                                    <td>21/11/2000</td>
                                                    <td>Ha dong</td>
                                                    <td>0988405038</td>
                                                    <td>2</td>
                                                    <td>Protector</td>
                                                </tr>
                                                <tr>
                                                    <td>12345</td>
                                                    <td>Mincy</td>
                                                    <td>21/11/2000</td>
                                                    <td>Ha dong</td>
                                                    <td>0988405038</td>
                                                    <td>2</td>
                                                    <td>Protector</td>
                                                </tr>
                                                <tr>
                                                    <td>12345</td>
                                                    <td>Mincy</td>
                                                    <td>21/11/2000</td>
                                                    <td>Ha dong</td>
                                                    <td>0988405038</td>
                                                    <td>2</td>
                                                    <td>Protector</td>
                                                </tr>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </main>
                    </div>
                </div>
            </div>
        );
    }
}

export default BuildingEmployee;