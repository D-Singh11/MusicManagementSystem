import React, { useState } from 'react'

function Login(props) {

    const [username, SetUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = (e) => {
        e.preventDefault();
        props.handleLogin({ username, password })
    }

    return (
        <div className="content">
            <div className='create'>
                <h1>Login</h1>
                <form onSubmit={handleLogin}>
                    <label>Username : </label>
                    <input
                        type="text"
                        minLength="3"
                        value={username}
                        onChange={(e) => SetUsername(e.target.value)}
                        required
                    />

                    <label>Password : </label>
                    <input
                        type="password"
                        minLength="5"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                    {username.length > 0 && <button>Login</button>}
                    {props.error && <div disabled>Login failed. Try Agian</div>}
                </form>
            </div>
        </div>
    )
}

export default Login
