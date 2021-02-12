import React, { useState } from 'react'
import { useHistory } from 'react-router-dom'
import useFetch from '../hooks/useFetch';

function Create() {

    const [name, setName] = useState('');
    const [singer, setSinger] = useState('');
    const [year, setYear] = useState('');
    const [company, setCompany] = useState('');
    const [isPending, setIsPending] = useState(false);
    const history = useHistory();
    const { data: singers } = useFetch('http://localhost:8080/singer/ids')


    const handleSubmit = (e) => {
        e.preventDefault();

        setIsPending(true);
        const album = {
            name,
            singer,
            year,
            company
        }

        fetch('http://localhost:8080/album/create', {
            method: 'POST',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(album)
        }).then(() => {
            setIsPending(false);
            // history.go(-1);      // takes back to last route
            history.push('/')       // go to homepage
        })
    }

    return (
        <div className='create'>
            <h2>Add new album</h2>
            <form onSubmit={handleSubmit}>
                <label>Name : </label>
                <input
                    type="text"
                    maxLength="60"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    required
                />

                <label>Singer : </label>
                <select name="singer" id="singer"
                    value={singer}
                    onChange={(e) => setSinger(e.target.value)}
                >
                    <option value="">Select singer</option>
                    {singers && singers.map(item => <option value={item.singerId} key={item.singerId}>{item.name}</option>)}
                </select>

                <label>Year : </label>
                <input type="number"
                    maxLength="4"
                    min="1900"
                    max="2021"
                    value={year}
                    onChange={(e) => setYear(e.target.value)}
                    required
                />

                <label>Company : </label>
                <input type="text"
                    value={company}
                    onChange={(e) => setCompany(e.target.value)}
                    required
                />
                {!isPending && <button>Add album</button>}
                {isPending && <button disabled>... Adding</button>}
            </form>
        </div>
    )
}

export default Create
