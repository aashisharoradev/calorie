import React from 'react';

const Search = function ({ textSearch }) { 
    return (
        <div>
            <input type="text" onChange={textSearch}/>
        </div>
    );
}

export default Search;