import { useState, useEffect } from 'react'

const usePost = (req) => {


    const [data, setData] = useState(null);
    // const [isPending, setIsPending] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const abortCont = new AbortController();
        if (req) {
            fetch(req.url, {
                method: 'POST',
                headers: { 'Content-type': 'application/json' },
                body: JSON.stringify(req)
            }).then(res => {
                // console.log(res)
                if (!res.ok) {
                    throw Error('Could not fetch data')
                }
                return res.json();
            }).then(data => {
                // console.log(data)
                setData(data);
                // setIsPending(false);
                setError(null)
            }).catch(err => {
                if (err.name === 'AbortError') {
                    console.log('fetch aborted')
                } else {
                    // setIsPending(false);
                    setError(err.message)
                }
            })
        }
        return () => abortCont.abort()
    }, [req])
    return { data, error }
}

export default usePost;