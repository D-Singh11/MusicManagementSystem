import React, { useState } from 'react'
import { useHistory } from 'react-router-dom'

function AddSinger() {

    const [name, setName] = useState('');
    const [gender, setGender] = useState('');
    const [dob, setDob] = useState('');
    const [company, setCompany] = useState('');
    const [isPending, setIsPending] = useState(false);
    const history = useHistory();


    const handleSubmit = (e) => {
        e.preventDefault();

        setIsPending(true);
        const singer = {
            name,
            gender,
            dob,
            company,
            "albums": []
        }

        fetch('http://localhost:8080/singer/create', {
            method: 'POST',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(singer)
        }).then(() => {
            setIsPending(false);
            // history.go(-1);      // takes back to last route
            history.push('/artists')       // go to homepage
        })
    }

    return (
        <div className='create'>
            <h2>Add Singer</h2>
            <form onSubmit={handleSubmit}>
                <label>Name : </label>
                <input
                    type="text"
                    maxLength="40"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    required
                />

                <label>Gender : </label>
                <select
                    value={gender}
                    onChange={(e) => setGender(e.target.value)}
                    required
                >
                    <option value="" disabled>Select singer</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>

                <label>Dob : </label>
                <input type="date"
                    value={dob}
                    onChange={(e) => setDob(e.target.value)}
                    max="2020-01-01"
                    required
                />

                <label>Company : </label>
                <input type="text"
                    value={company}
                    onChange={(e) => setCompany(e.target.value)}
                    required
                />

                {!isPending && <button>Add Singer</button>}
                {isPending && <button disabled>... Adding</button>}
            </form>
        </div>
    )
}

export default AddSinger
