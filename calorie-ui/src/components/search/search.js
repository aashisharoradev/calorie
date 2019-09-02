import React from 'react';

import './search.css'

const Search = function ({ textSearch, foods }) { 
    let foodList = '';
    if (foods.length > 0) { 
        foodList = <ul className="list-group dropdown-menu listWidth">
            {foods.map(food => (<li className="list-group-item" key={food.foodId}>{food.foodId} : {food.foodName}</li>))}
        </ul>;
    }
    return (
        <div className="form-group input-group input-group-lg">
            <input className="form-control" onChange={textSearch} />
                {foodList}
        </div>
    );
}

export default Search;