import React, { Component } from 'react';
import axios from 'axios';

import Search from '../components/search/search';


class CalorieBuilder extends Component {
    
    state = {
        foods: []
    }

    /**
     * this function part of react lifecycle hook, will be called when
     * html is traversed rendering dom
     */
    componentDidMount() {
        
    }
    searchString = (e) => {
        axios.get('http://localhost:8081/calculator/all/' + e.target.value).then(response => {
            this.setState({ foods: response.data });
        });
    }
    render() {
        const foodList = this.state.foods.map(food => (<li key={food.foodId}>{food.foodId} : {food.foodName}</li>));
        return (
            <div>
                <Search textSearch={this.searchString}/>
                <ul>
                    {foodList}
                </ul>
            </div>
        );
        
    }
}

export default CalorieBuilder;