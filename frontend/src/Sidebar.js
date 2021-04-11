import React, { useState } from 'react';
import { ProSidebar, Menu, MenuItem, SubMenu } from 'react-pro-sidebar';
import 'react-pro-sidebar/dist/css/styles.css';
import { FaTachometerAlt, FaGem, FaList, FaGithub, FaRegLaughWink, FaHeart } from 'react-icons/fa';
import App from './App'
import Home from './component/Home'
import Trend from './component/Trend'
import { BrowserRouter as Router, Route, Switch, IndexRoute , Link } from 'react-router-dom';

const Sidebar = () => {

return (
    <div>
      <Router>
        <ProSidebar>
          <Menu iconShape="square">
            <MenuItem icon={<FaGem />}><Link to="/">Dashboard</Link></MenuItem>
            <SubMenu title="Components" icon={<FaHeart />}>
              <MenuItem><Link to="/trend">Trend Analysis</Link></MenuItem>
              <MenuItem><Link to="/app">Traceability</Link></MenuItem>
            </SubMenu>
          </Menu>
        </ProSidebar>

        <Switch>
            <Route path="/app">
                <App/>
            </Route>


            <Route path="/trend">
                <Trend/>
            </Route>

            <Route path="/">
                <Home/>
            </Route>
        </Switch>

      </Router>
    </div>
    );
};

export default Sidebar;
