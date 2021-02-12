import "./App.css";
import React, { useState } from "react";
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import Navbar from "./components/Navbar";
import Create from "./components/CreateAlbum";
import NotFound from "./components/NotFound";
import AddSinger from "./components/CreateSinger";
import CreateUser from "./components/CreateUser";
import Login from "./components/Login";
import AlbumCatalogue from "./components/AlbumCatalogue";
import SingerCatalogue from "./components/SingerCatalogue";


function App() {
  const [loggedIn, SetLoggedIn] = useState(true);
  const [error, SetError] = useState(false);

  const validateLogin = (user) => {
    fetch('http://localhost:8080/user', {
      method: 'POST',
      headers: { 'Content-type': 'application/json' },
      body: JSON.stringify(user)
    }).then(res => {
      if (!res.ok) {
        throw Error('Could not fetch data')
      }
      return res.json();
    })
      .then(data => {
        if (!data) {
          SetError(true);
        }
        else {
          SetError(false);
        }
        SetLoggedIn(data);
      })
      .catch(err => {
        if (err.name === 'AbortError') {
          console.log('fetch aborted')
        }
      })
  }


  const handleLogout = () => {
    SetLoggedIn(false);
  }


  return (
    <Router>
      {!loggedIn ? <Login handleLogin={validateLogin} error={error} /> : (
        <div className="App">
          <Navbar handleLogout={handleLogout} />
          {/* <h1>Welcome music manager</h1> */}
          <div className="content">
            <Switch>
              <Route path="/" exact>
                <AlbumCatalogue title={'Albums'} />
              </Route>
              <Route path="/create">
                <Create />
              </Route>
              <Route path="/singer">
                <AddSinger />
              </Route>
              <Route path="/user">
                <CreateUser />
              </Route>
              <Route path="/artists">
                <SingerCatalogue title={'Singers'} />
              </Route>
              <Route path="/update/:id">
                <Create />
              </Route>
              <Route path="*">
                <NotFound />
              </Route>
            </Switch>
          </div>
        </div>
      )}
    </Router>
  );
}

export default App;
