import React, { Component } from 'react';
import Header from '../header/Header.js';
import Footer from '../footer/Footer.js';
import Menu from '../menu/Menu.js';
import MainBody from '../mainBody/MainBody.js';

class Home extends Component {
    render() {
        return (
            <div>
                <Header/>
                <div class="row">
                    <div class="col-lg-2">
                        <Menu/>
                    </div>
                    <div class="col-lg-10 mt-5">
                        <MainBody/>
                    </div>
                </div>
                <Footer/>
            </div>
        );
    }
}

export default Home;