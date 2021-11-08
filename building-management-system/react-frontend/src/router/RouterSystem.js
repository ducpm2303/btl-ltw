import React, { Component } from 'react';
import EmployeeTable from '../Component/DataTable/EmployeeTable';
import Home from '../Component/home/Home';
import {
    BrowserRouter as Router,
    Switch,
    Route,
  } from "react-router-dom";
import CompanyTable from '../Component/CompanyTable/CompanyTable';
import BuildingEmployee from '../Component/BuildingEmployee/BuildingEmployee';
import StatTable from '../Component/StatTable/StatTable';
import BuildingService from '../Component/BuildingService/BuildingService';

class RouterSystem extends Component {
    render() {
        return (
            <div>
                <Router>
                    <Switch>
                        <Route exact path="/"><Home/></Route>
                        <Route path="/companyEmployee"><EmployeeTable/></Route>
                        <Route path="/companies"><CompanyTable/></Route>
                        <Route path="/buildingEmployee"><BuildingEmployee/></Route>
                        <Route path="/statTable"><StatTable/></Route>
                        <Route path="/buildingService"><BuildingService/></Route>

                    </Switch>
                </Router>
            </div>
        );
    }
}

export default RouterSystem;