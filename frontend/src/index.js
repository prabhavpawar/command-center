import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import Sidebar from './Sidebar';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<Sidebar />, document.getElementById('root'));
registerServiceWorker();
