import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import IspComponent from './components/IspComponent'
import IspListComponent from './components/IspListComponent'
import './App.css';

function App() {
  return (
    <div className="App">
      <Router>
        <HeaderComponent/>
        <Switch>
          <Route path="/" exact component={IspListComponent}></Route>
          <Route path="/isps/:id" component={IspComponent}></Route>
          <Route path="/isps" component={IspListComponent}></Route>
        </Switch>
        <FooterComponent/>
      </Router>
    </div>
  );
}

export default App;
