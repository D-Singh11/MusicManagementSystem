import React, { useState } from 'react'
import { useHistory } from 'react-router-dom'

function CreateUser() {

    const [username, SetUsername] = useState('');
    const [password, setPassword] = useState('');
    const [isPending, setIsPending] = useState(false);
    const history = useHistory();


    const handleSubmit = (e) => {
        e.preventDefault();

        setIsPending(true);
        const user = {
            username,
            password,
        }

        fetch('http://localhost:8080/user/create', {
            method: 'POST',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(user)
        }).then(() => {
            setIsPending(false);
            history.push('/')       // go to homepage
        })
    }

    return (
        <div className='create'>
            <h2>Add new user</h2>
            <form onSubmit={handleSubmit}>
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

                {!isPending && username.length > 0 && <button>Register</button>}
                {isPending && <button disabled>... Adding</button>}
            </form>
        </div>
    )
}

export default CreateUser
