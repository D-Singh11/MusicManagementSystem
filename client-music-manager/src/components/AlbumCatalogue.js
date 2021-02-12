import React, { useState } from 'react'
import SearchResult from './SearchResult';
import useFetch from '../hooks/useFetch';

function AlbumCatalogue({ title }) {
    const [url, seturl] = useState('http://localhost:8080/album/all?pageNo=0')
    const [search, setsearch] = useState('');
    const [sortBy, SetSortBy] = useState("");
    const { data: albums, isPending, error } = useFetch(url + sortBy)
    const table_header = { "c2": "Singer", "c3": "Year" }

    const handleSortBy = (sortBy) => {
        SetSortBy(`&sortBy=${sortBy}`)
    }

    return (
        <div className='home'>
            <h1>Albums Catalogue</h1>
            <input
                type="search"
                value={search}
                onChange={(e) => setsearch(e.target.value.toLowerCase())}
                required
            />
            <button onClick={() => seturl(`http://localhost:8080/album/${search.trim()}?pageNo=0`)}>Search by album</button>
            <button onClick={() => seturl(`http://localhost:8080/album/singer/${search.trim()}?pageNo=0`)}>Search by singer</button><br />
            <button onClick={() => {
                seturl(`http://localhost:8080/album/all?pageNo=0`)
                SetSortBy("")
                setsearch("")
            }}>Clear</button>
            {error && <div>{error}</div>}
            {isPending && <div>... Loading</div>}
            {albums && albums.empty && < div >... No Results found</div>}
            {
                albums && albums.content.length > 0 && (
                    <>
                        <SearchResult data={albums.content} type="albums" title={title} handleSortBy={handleSortBy} th={table_header} />
                        <p>Viewing page {albums.pageable.pageNumber + 1} of {albums && albums.totalPages} </p>
                        <button disabled={albums.pageable.pageNumber === 0}
                            onClick={() => {
                                seturl(`${url.replace(`?pageNo=${albums.pageable.pageNumber}`, `?pageNo=${albums.pageable.pageNumber - 1}`)}`)
                            }}>previous</button>
                        <button disabled={albums.pageable.pageNumber === albums.totalPages - 1}
                            onClick={() => {
                                seturl(`${url.replace(`?pageNo=${albums.pageable.pageNumber}`, `?pageNo=${albums.pageable.pageNumber + 1}`)}`)
                            }}>next</button>
                    </>
                )
            }
        </div >
    )
}

export default AlbumCatalogue
