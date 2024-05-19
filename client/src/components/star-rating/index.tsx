import { useState } from 'react'
import { FaStar } from 'react-icons/fa'
import './styles.css'

export default function StarRating({ rating = 5 }: { rating?: number }) {


    const [stars, setStars] = useState(0)
    const [hover, setHover] = useState(0)

    function handleClick(i: number) {
        setStars(i)
    }

    function handleMouseEnter(i: number) {
        setHover(i)
    }

    function handleMouseLeave(i: number) {
        setHover(stars)
    }

    return (
        <div className="start-rating">
            {[...Array(rating)].map((v, i) => {
                i = i + 1
                return <FaStar
                    key={i}
                    className={i <= (hover || stars) ? 'active' : 'inactive'}
                    onClick={() => handleClick(i)}
                    onMouseMove={() => handleMouseEnter(i)}
                    onMouseLeave={() => handleMouseLeave(i)}
                    size={40}
                />
            })}
        </div>
    )
}