import React, { Component } from 'react';
import Header from '../header/Header';
import Menu from '../menu/Menu';

class BuildingService extends Component {
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
                                <h1 class="mt-4">Service Table</h1>
                                <div class="card mb-4">
                                    <div class="card-body">
                                        <button type="button" class="btn btn-lg btn-success">Add new Service</button>
                                    </div>
                                </div>
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-table me-1"></i>
                                        DataTable Service
                                    </div>
                                    <div class="card-body">
                                        <table id="datatablesSimple">
                                            <thead>
                                                <tr>
                                                    <th>Code</th>
                                                    <th>Name</th>
                                                    <th>Type</th>
                                                    <th>Price</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr>
                                                    <th>Code</th>
                                                    <th>Name</th>
                                                    <th>Type</th>
                                                    <th>Price</th>
                                                    <th>Action</th>
                                                </tr>
                                            </tfoot>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Electric</td>
                                                    <td>Electric-Water</td>
                                                    <td>3500</td>
                                                    <td>
                                                        <button type="button" class="btn btn-primary">Delete</button>
                                                        <button type="button" class="btn btn-primary">Edit</button>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Electric</td>
                                                    <td>Electric-Water</td>
                                                    <td>3500</td>
                                                    <td>
                                                        <button type="button" class="btn btn-primary">Delete</button>
                                                        <button type="button" class="btn btn-primary">Edit</button>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Electric</td>
                                                    <td>Electric-Water</td>
                                                    <td>3500</td>
                                                    <td>
                                                        <button type="button" class="btn btn-primary">Delete</button>
                                                        <button type="button" class="btn btn-primary">Edit</button>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Electric</td>
                                                    <td>Electric-Water</td>
                                                    <td>3500</td>
                                                    <td>
                                                        <button type="button" class="btn btn-primary">Delete</button>
                                                        <button type="button" class="btn btn-primary">Edit</button>
                                                    </td>
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

export default BuildingService;