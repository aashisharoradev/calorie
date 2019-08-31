import React, { Component } from 'react';
import axios from 'axios';

class CalorieBuilder extends Component {
    
    state = {
        foods: []
    }

    /**
     * this function part of react lifecycle hook, will be called when
     * html is traversed rendering dom
     */
    componentDidMount() {
        axios.get('http://localhost:8081/calculator/all/name').then(response => {
            this.setState({ foods: response.data });
        });

    }
    render() {
        const foodList = this.state.foods.map(food => (<li key={food.foodId}>{food.foodId} : {food.foodName}</li>));
        return (
            <ul>
                {foodList}
            </ul>
        );
        
    }
}

export default CalorieBuilder;