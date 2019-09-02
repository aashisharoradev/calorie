import React from 'react';

import Layout from './hoc/layout/layout';
import CalorieBuilder from './containers/caloriebuilder';

function App() {
  return (
    <Layout>
      <CalorieBuilder />
    </Layout>
  );
}

export default App;
