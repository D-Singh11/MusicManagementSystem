import React from 'react'
import { Link } from 'react-router-dom'


const Navbar = (props) => {
    return (
        <nav className='navbar'>
            <h1>Music Management System</h1>
            <div className="links">
                <Link to='/'>Catalogue</Link>
                <Link to='/artists'>Singers</Link>
                <Link to='/create'>Add Album</Link>
                <Link to='/singer'>Add Singer</Link>
                <Link to='/user'>Add User</Link>
                {/* <Link to='/catalogue'>Catalogue</Link> */}

                <button onClick={() => props.handleLogout()}>Logout</button>
            </div>
        </nav>
    )
}

export default Navbar
