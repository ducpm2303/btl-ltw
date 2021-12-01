import React, { Component } from 'react';

class EmployeeTable extends Component {
    render() {
        return (
            <div>
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Company Employee</h1>
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
                                            <th>Identification</th>
                                            <th>Name</th>
                                            <th>Birthday</th>
                                            <th>PhoneNumber</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Code</th>
                                            <th>Identification</th>
                                            <th>Name</th>
                                            <th>Birthday</th>
                                            <th>PhoneNumber</th>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <tr>
                                            <td>12345</td>
                                            <td>1234456</td>
                                            <td>Mincy</td>
                                            <td>21/11/2000</td>
                                            <td>0988405038</td>
                                            <td>
                                                <button type="button" class="btn btn-primary">Delete</button>
                                                <button type="button" class="btn btn-primary">Edit</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>12345</td>
                                            <td>1234456</td>
                                            <td>Mincy</td>
                                            <td>21/11/2000</td>
                                            <td>0988405038</td>
                                        </tr>
                                        <tr>
                                            <td>12345</td>
                                            <td>1234456</td>
                                            <td>Mincy</td>
                                            <td>21/11/2000</td>
                                            <td>0988405038</td>
                                        </tr>

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

export default EmployeeTable;
