import React, { useState } from 'react';
import logo from '../logo.svg';
import './App.css';
import CreateRoutine from './CreateRoutine';
import FetchRoutinesButton from './FetchRoutinesButton'

function App() {
  const [routines, setRoutines] = useState('');
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/main/App.jsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <CreateRoutine />
        {
          routines === ''
            ? <FetchRoutinesButton onClick={setRoutines} text="Fetch Routines" />
            :
            <p>
              Routines: {routines}
              <div></div>
            </p>
        }
      </header>
    </div>
  );
}

export default App;
