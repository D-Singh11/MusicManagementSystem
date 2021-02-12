import React from 'react'
import PropTypes from 'prop-types'
import Item from './Item';

const SearchResult = (props) => {

    const { data, th } = props;

    const handleChange = (e) => {
        props.handleSortBy(e.target.value.toLowerCase())
    }

    return (
        <>
            <h2>Results</h2>
            <div className="sort" >
                <label htmlFor="">Sort by : </label>
                <select onChange={handleChange}>
                    <option value="Name">Name</option>
                    <option value={th.c2}>{th.c2}</option>
                    <option value={th.c3}>{th.c3}</option>
                    <option value="Company">Company</option>
                </select>
            </div>
            {data.length > 0 ? (
                <table id="resultsTable">
                    <thead key={'header'}>
                        <tr>
                            <th>Name</th>
                            <th>{th.c2}</th>
                            <th>{th.c3}</th>
                            <th>Company</th>
                        </tr>
                    </thead>
                    <tbody>
                        {data.map(item => <Item album={item} title={props.title} key={props.title === 'Albums' ? item.albumId : item.singerId} />)}
                    </tbody>
                </table>
            ) : <div>0 {props.title} in system</div>}
        </>
    )
}

SearchResult.propTypes = {
    data: PropTypes.array.isRequired,
    title: PropTypes.string.isRequired
}

export default SearchResult
