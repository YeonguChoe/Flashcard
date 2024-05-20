import { useState } from 'react'
import { FaStar } from 'react-icons/fa'
import './styles.css'

export default function StarRating({ rating = 5 }: { rating?: number }) {


    const [clicked, setClicked] = useState(0)
    const [hover, setHover] = useState(0)

    function handleClick(i: number) {
        setClicked(i)
    }

    function handleMouseEnter(i: number) {
        setHover(i)
    }

    function handleMouseLeave(i: number) {
        setHover(clicked)
    }

    return (
        <div className="start-rating">
            {[...Array(rating)].map((v, i) => {
                return <FaStar
                    key={i}
                    className={i <= hover ? 'active' : 'inactive'}
                    onClick={() => handleClick(i)}
                    onMouseMove={() => handleMouseEnter(i)}
                    onMouseLeave={() => handleMouseLeave(i)}
                    size={100}
                />
            })}
        </div>
    )
}