import React, { Component } from 'react';
import EmployeeTable from '../Component/DataTable/EmployeeTable';
import Home from '../Component/home/Home';
import {
    Switch,
    Route,
  } from "react-router-dom";
import CompanyTable from '../Component/CompanyTable/CompanyTable';
import BuildingEmployee from '../Component/BuildingEmployee/BuildingEmployee';
import StatTable from '../Component/StatTable/StatTable';
import Service from "../Component/service/Service";

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
                    <Route path={"/cleaned-service"}></Route>
                </Switch>
            </div>
        );
    }
}

export default RouterSystem;
