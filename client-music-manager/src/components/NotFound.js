import React from 'react'
import { Link } from 'react-router-dom'

function NotFound() {
    return (
        <div className="not-found">
            <h2>Error</h2>
            <p>Page cannot be found</p>
            <Link to='/'>back to homepage ...</Link>
        </div>
    )
}

export default NotFound
