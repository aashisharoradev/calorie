import React from 'react';

import Aux from '../../hoc/aux';

function Layout({ children }) { 
    return (
        <Aux>
            {children}
        </Aux>
    );
}

export default Layout;