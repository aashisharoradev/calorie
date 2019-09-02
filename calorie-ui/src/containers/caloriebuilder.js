import React, { Component } from 'react';
import axios from 'axios';

import Search from '../components/search/search';


class CalorieBuilder extends Component {
    
    state = {
        foods: []
    }

    searchString = (e) => {
        const value = e.target.value;
        if (value === '' || value == null) {
            this.setState({ foods: [] });
        } else { 
            axios.get('http://localhost:8081/calculator/all/' + e.target.value).then(response => {
            this.setState({ foods: response.data });
            }).catch(err => { 
                this.setState({ foods: [] });
            });
        }
        
    }
    render() {
        return (
            <div className="jumbotron">
                <h3>Enter Food Name</h3>
                <Search textSearch={this.searchString} foods={this.state.foods} />
            </div>
        );
        
    }
}

export default CalorieBuilder;