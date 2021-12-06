import React, { Component } from 'react';
import EmployeeTable from '../Component/data-table/EmployeeTable';
import Home from '../Component/home/Home';
import {
    Switch,
    Route,
  } from "react-router-dom";
import CompanyTable from '../Component/company-table/CompanyTable';
import StatTable from '../Component/stat-table/StatTable';
import Service from "../Component/building-service/Service";
import CleanedServiceComponent from "../Component/building-service/cleaned-service/CleanedServiceComponent";
import BuildingEmployee from "../Component/building-employee/BuildingEmployee";
import MaintenanceService from "../Component/building-service/maintenance-service/MaintenanceService";

class RouterSystem extends Component {
    render() {
        return (
            <div>
                <Switch>
                    <Route exact path="/"><Home/></Route>
                    <Route path="/company-employee"><EmployeeTable/></Route>
                    <Route path="/companies"><CompanyTable/></Route>
                    <Route path="/building-employee"><BuildingEmployee/></Route>
                    <Route path="/statTable"><StatTable/></Route>
                    <Route path={"/building-service"}> <Service/></Route>
                    <Route path={"/cleaned-service"}><CleanedServiceComponent/></Route>
                    <Route path={"/maintenance-service"}><MaintenanceService/></Route>
                </Switch>
            </div>
        );
    }
}

export default RouterSystem;
