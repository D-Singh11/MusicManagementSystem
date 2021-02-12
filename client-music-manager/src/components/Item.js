import React from 'react'

function Item(props) {

    const item = props.album;
    return (
        <tr key={props.title === 'Albums' ? item.albumId : item.singerId}>
            <td>{item.name}</td>
            <td>{props.title === 'Albums' ? item.singer : item.gender}</td>
            <td>{props.title === 'Albums' ? item.year : item.dob}</td>
            <td>{item.company}</td>
        </tr>
    )
}

export default Item
