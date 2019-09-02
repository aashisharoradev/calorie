import React, { Component } from 'react';


class Header extends Component{
    state = { 
        collapse: false
    }

    collapseHandler = () => {
        this.setState({ collapse: !this.state.collapse });
    }
    render() {
        return (
            <header>
            <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                <a className="navbar-brand" href="#">Calorie Calculator</a>
                    <button className="navbar-toggler" type="button" onClick={this.collapseHandler}>
                <span className="navbar-toggler-icon"></span>
                </button>
                    <div className={[!this.state.collapse? "collapse": null, "navbar-collapse"]. join(' ')}>
                    <ul className="navbar-nav ml-auto">
                        <li className="nav-item active">
                        <a className="nav-link" href="#">Home<span className="sr-only">(current)</span></a>
                        </li>
                        <li className="nav-item">
                        <a className="nav-link" href="#">Sign Up</a>
                        </li>
                        <li className="nav-item">
                        <a className="nav-link" href="#">Sign In</a>
                        </li>
                    </ul>
                
                </div>
            </nav>
    </header>
    );
    }
    
}

export default Header;