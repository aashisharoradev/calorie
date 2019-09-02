import React from 'react';

import Aux from '../aux/aux';

import Header from '../../components/header/header'; 

function Layout({ children }) { 
    return (
        <Aux>
            <Header />
            {children}
        </Aux>
    );
}

export default Layout;