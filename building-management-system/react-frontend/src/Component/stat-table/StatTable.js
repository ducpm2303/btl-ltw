import React, { Component } from 'react';
import Header from '../home/header/Header';
import Menu from '../home/menu/Menu';

class StatTable extends Component {
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
                                <h1 class="mt-4">Statitic Table</h1>
                                <div class="card mb-4">
                                    <div class="card-body">
                                        <button type="button" class="btn btn-lg btn-success">Week Statitic</button>
                                        <button type="button" class="btn btn-lg btn-success">Month Statitic</button>
                                        <button type="button" class="btn btn-lg btn-success">Year Statitic</button>
                                    </div>
                                </div>
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-table me-1"></i>
                                        DataTable Statitic
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
                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr>
                                                    <th>Code</th>
                                                    <th>Identification</th>
                                                    <th>Name</th>
                                                    <th>Birthday</th>
                                                    <th>PhoneNumber</th>
                                                </tr>
                                            </tfoot>
                                            <tbody>
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
                </div>
            </div>
        );
    }
}

export default StatTable;
