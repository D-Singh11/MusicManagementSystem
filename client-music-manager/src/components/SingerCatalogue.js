import React, { useState } from 'react'
import SearchResult from './SearchResult';
import useFetch from '../hooks/useFetch';

function SingerCatalogue({ title }) {
    const [url, seturl] = useState('http://localhost:8080/singer/all?pageNo=0')
    const [search, setsearch] = useState('');
    const [sortBy, SetSortBy] = useState("");
    const { data: singers, isPending, error } = useFetch(url + sortBy)
    const table_header = { "c3": "Dob", "c2": "Gender" }

    const handleSortBy = (sortBy) => {
        SetSortBy(`&sortBy=${sortBy}`)
    }

    return (
        <div className='home'>
            <h1>Singers Catalogue</h1>
            <input type="search"
                value={search}
                onChange={(e) => setsearch(e.target.value.toLowerCase())}
                required
            />
            <button
                onClick={() => seturl(`http://localhost:8080/singer/${search.trim()}?pageNo=0`)}
            >Search Singer</button>
            <button onClick={() => {
                seturl(`http://localhost:8080/singer/all?pageNo=0`)
                SetSortBy("")
                setsearch("")
            }}>Clear</button>
            {error && <div>{error}</div>}
            {isPending && <div>... Loading</div>}
            {singers && singers.empty && < div >... No Results found</div>}
            {singers && singers.content.length > 0 && (
                <>
                    <SearchResult data={singers.content} title={title} handleSortBy={handleSortBy} th={table_header} />
                    <p>Viewing page {singers.pageable.pageNumber + 1} of {singers && singers.totalPages} </p>
                    <button disabled={singers.pageable.pageNumber === 0}
                        onClick={() => {
                            seturl(`${url.replace(`?pageNo=${singers.pageable.pageNumber}`, `?pageNo=${singers.pageable.pageNumber - 1}`)}`)
                        }}>previous</button>
                    <button disabled={singers.pageable.pageNumber === singers.totalPages - 1}
                        onClick={() => {
                            seturl(`${url.replace(`?pageNo=${singers.pageable.pageNumber}`, `?pageNo=${singers.pageable.pageNumber + 1}`)}`)
                        }}>next</button>
                </>
            )}
        </div>
    )
}

export default SingerCatalogue
