import React, { Component } from 'react';
import './Menu.css';
class Menu extends Component {
    render() {
        return (
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark menu" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Home View</div >
                            <a class="nav-link" href="/">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Home
                            </a>
                            <div class="sb-sidenav-menu-heading">Manager</div>
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseCompany" aria-expanded="false" aria-controls="collapseCompany">
                                        Companies
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="collapseCompany" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="/companies">Company Table</a>
                                            <a class="nav-link" href="/companyEmployee">Company Employee</a>
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseBuilding" aria-expanded="false" aria-controls="collapseBuilding">
                                        Building
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="collapseBuilding" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="/buildingEmployee">Building Employee</a>
                                            <a class="nav-link" href="/buildingService">Building Service</a>
                                        </nav>
                                    </div>
                                </nav>
                            
                            <div class="sb-sidenav-menu-heading">Statitics</div>
                            <a class="nav-link" href="charts.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Company Stat
                            </a>
                            <a class="nav-link" href="/statTable">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Employee Stat
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Admin
                    </div>
                </nav>
            </div>
        );
    }
}

export default Menu;