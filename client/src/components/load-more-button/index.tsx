import { useEffect, useState } from "react"
import './styles.css'

export default function LoadMoreData() {

    const [loading, setLoading] = useState(true)
    const [products, setProducts] = useState<any[]>([])
    const [count, setCount] = useState(0)
    const [buttonDisabled, setButtonDisabled] = useState(false)


    async function fetchProducts() {

        try {
            const response = await fetch(`https://dummyjson.com/products?limit=20&skip=${count === 0 ? 0 : count * 20}`)
            const result = await response.json()

            if (result && result.products && result.products.length > 0) {
                setProducts((prevData) => {
                    return [...prevData, ...result.products]
                })
                setLoading(false)
            }

        } catch (e) {
            setLoading(false)
        }

    }

    useEffect(() => {
        fetchProducts()
    }, [count])

    useEffect(() => {
        if (products.length >= 100) {
            setButtonDisabled(true)
        }
    }, [products])


    if (loading) {
        return <div>Loading Data... Please wait</div>
    }

    return (
        <div className="container">
            <div className="product-container">
                {
                    products && products.length ? products.map((element: any) => {
                        return <div className="product" key={element.id}>
                            <img src={element.thumbnail} alt={element.title} />
                            <p>{element.title}</p>
                        </div>
                    }) : null
                }
            </div>
            <div className="button-container">
                <button disabled={buttonDisabled} onClick={() => setCount(count + 1)}>Load more products</button>
                {buttonDisabled ? <p>게시물 100개에 도달했습니다</p> : null}
            </div>
        </div >
    )
}