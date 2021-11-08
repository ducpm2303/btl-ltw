import React, { Component } from 'react';
import Header from '../header/Header';
import Menu from '../menu/Menu';

class CompanyTable extends Component {
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
                                            <tfoot>
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
                                            </tfoot>
                                            <tbody>
                                                <tr>
                                                    <td>Mincy</td>
                                                    <td>12345</td>
                                                    <td>20$</td>
                                                    <td>Font end</td>
                                                    <td>2</td>
                                                    <td>Ha Dong</td>
                                                    <td>0988405038</td>
                                                    <td>1000</td>
                                                    <td>
                                                        <button type="button" class="btn btn-primary">Delete</button>
                                                        <button type="button" class="btn btn-primary">Edit</button>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Mincy</td>
                                                    <td>12345</td>
                                                    <td>20$</td>
                                                    <td>Font end</td>
                                                    <td>2</td>
                                                    <td>Ha Dong</td>
                                                    <td>0988405038</td>
                                                    <td>1000</td>
                                                </tr><tr>
                                                    <td>Mincy</td>
                                                    <td>12345</td>
                                                    <td>20$</td>
                                                    <td>Font end</td>
                                                    <td>2</td>
                                                    <td>Ha Dong</td>
                                                    <td>0988405038</td>
                                                    <td>1000</td>
                                                </tr><tr>
                                                    <td>Mincy</td>
                                                    <td>12345</td>
                                                    <td>20$</td>
                                                    <td>Font end</td>
                                                    <td>2</td>
                                                    <td>Ha Dong</td>
                                                    <td>0988405038</td>
                                                    <td>1000</td>
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

export default CompanyTable;