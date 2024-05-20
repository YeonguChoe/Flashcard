import { useEffect, useState } from "react"
import { BsArrowLeftCircleFill, BsArrowRightCircleFill } from "react-icons/bs"
import './styles.css'

export default function ImageSlider({ url, page, limit }: { url: string, page: number, limit: number }) {

    const [images, setImages] = useState([])
    const [visibleImage, setVisibleImage] = useState(0)
    const [errorMessage, setErrorMessage] = useState(null)
    const [loading, setLoading] = useState(false)

    async function fetchImages(inputURL: string) {
        try {
            // console.log(inputURL)
            const response = await fetch(inputURL)
            const data = await response.json()

            console.log(data)

            if (data !== null) {
                setImages(data)
                setLoading(false)
            }

        } catch (e: any) {
            setErrorMessage(e.message)
            setLoading(false)
        }
    }

    function handlePrevious() {
        setVisibleImage(visibleImage === 0 ? limit - 1 : visibleImage - 1)
    }

    function handleNext() {
        setVisibleImage(visibleImage === limit - 1 ? 0 : visibleImage + 1)
    }

    useEffect(() => {
        if (url !== '') {
            fetchImages(`${url}?page=${page}&limit=${limit}`)
        }
    }, [url])


    if (loading) {
        return <div>Loading data! Please wait!</div>
    }

    if (errorMessage !== null) {
        return <div>Error occured {errorMessage}</div>
    }

    return (<div className="container">
        <BsArrowLeftCircleFill onClick={() => handlePrevious()} className="arrow arrow-left" />


        {images !== null ? images.length > 0 ? images.map((element: any, index: number) => {
            return <img
                key={element.id}
                src={element.download_url}
                alt={element.download_url}
                className={index === visibleImage ? "current-image" : "current-image hide-current-image"} />
        }) : null : null}


        <BsArrowRightCircleFill onClick={() => handleNext()} className="arrow arrow-right" />

        <span className="circle-indicators">
            {
                images && images.length ? images.map((_, i) => {
                    return (
                        <button key={i} className={i === visibleImage ? "current-indicator" : "current-indicator inactive-indicator"}
                            onClick={() => setVisibleImage(i)}>
                        </button>
                    )
                }) : null
            }
        </span>
    </div>)
}