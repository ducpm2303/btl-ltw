import React, { Component } from 'react';
import './CleanedService.css';
import CleanedServiceService from "./CleanedServiceService";

class CleanedServiceComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            currentCleanedService: {
                name: "",
                price: 0,
                timesPerWeek: 0,
            },
            newCleanedService : {
                name: "",
                price: 0,
                timesPerWeek: 0,
            },
        }
    }
    componentDidMount() {
        CleanedServiceService.getCurrentCleanedService().then((response) => {
            this.setState({ currentCleanedService: response.data.data});
        });
    }

    handleChanged = (event) =>{
        let cleanedService = this.state.newCleanedService;
        const name = event.target.name;
        const value = event.target.value;
        if(name == "name") {
            cleanedService.name = value;
        } else if(name == "price"){
            cleanedService.price = value;
        }
        else if(name == "timesPerWeek"){
            cleanedService.timesPerWeek = value;
        }
        this.setState( {
            newCleanedService: cleanedService
        })
    }


    addNewCleanedService() {
        CleanedServiceService.createCleanedService(this.state.newCleanedService)
            .then(() => this.componentDidMount());
    }

    render() {
        return (
            <div>
                <div className="modal fade" id="formCleanedService" tabIndex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="exampleModalLabel">Building Employee Infomation</h5>
                                <button type="button" className="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div className="modal-body">
                                <form>
                                    <div className="mb-3">
                                        <label htmlFor="name" className="form-label">Tên</label>
                                        <input type="text" onChange={event => this.handleChanged(event)} className="form-control" name="name" id="name"/>
                                    </div>
                                    <div className="mb-3">
                                        <label htmlFor="price" className="form-label">Giá</label>
                                        <input type="number" onChange={event => this.handleChanged(event)} className="form-control"  name="price" id="price"/>
                                    </div>
                                    <div className="mb-3">
                                        <label htmlFor="times" className="form-label">Tần suất</label>
                                        <input type="number"  onChange={event => this.handleChanged(event)} className="form-control"  name="timesPerWeek" id="times"/>
                                    </div>
                                </form>
                            </div>
                            <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close
                                </button>
                                <button type="button" className="btn btn-primary" data-bs-dismiss="modal"
                                        onClick={(event) => this.addNewCleanedService(event)}>Update
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <main>
                    <div className="container-fluid px-4">
                        <h1 className="mt-4">Cleaned Service</h1>
                        <div className="card mb-4">
                            <div className="card-body">
                                <button type="button" className="btn btn btn-success" data-bs-toggle="modal"
                                        data-bs-target="#formCleanedService">Update
                                </button>
                            </div>
                        </div>
                        <div className="card mb-4">
                            <div className="card-header">
                                Thông tin dịch vụ
                            </div>
                            <div className="card-body">
                                <table className="table table-bordered text-center">
                                    <tbody>
                                        <tr>
                                            <td> <b>Tên:</b></td>
                                            <td>{this.state.currentCleanedService.name}</td>
                                        </tr>
                                        <tr>
                                            <td><b>Giá:</b></td>
                                            <td>{this.state.currentCleanedService.price} vnđ</td>
                                        </tr>
                                        <tr>
                                            <td><b>Tần suất:</b></td>
                                            <td>{this.state.currentCleanedService.timesPerWeek} lần/tuần</td>
                                        </tr>
                                        <tr>
                                            <td><b>Bắt buộc:</b></td>
                                            <td>Có</td>
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

export default CleanedServiceComponent;
