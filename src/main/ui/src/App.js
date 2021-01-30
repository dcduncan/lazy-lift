import React, {useState} from 'react';
import logo from './logo.svg';
import './App.css';
const axios = require('axios');

function App() {
  const [routines, setRoutines] = useState('');
  axios.get('/api/routines').then(response => setRoutines(response.data));
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <p>
        Routines: {routines}
        <div></div>
        </p>
      </header>
    </div>
  );
}

export default App;
