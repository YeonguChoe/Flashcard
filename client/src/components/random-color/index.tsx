import { useEffect, useState } from "react"


export default function RandomColor() {

    const [typeOfColor, setTypeOfColor] = useState('hex')
    const [color, setColor] = useState("#000000")


    const getRandomInt = (max: number) => {
        return Math.floor(Math.random() * max)
    }

    function handleCreateRandomHexColor() {
        const hex = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F']

        let hexValue: string = "#"
        for (let i = 0; i < 6; i++) {
            hexValue += hex[getRandomInt(16)]
        }
        setColor(hexValue)
    }

    function handleCreateRandomRGBColor() {

        let r = getRandomInt(255)
        let g = getRandomInt(255)
        let b = getRandomInt(255)

        setColor(`rgb(${r},${g},${b})`)
        console.log("RGB 사용")

    }

    useEffect(() => {
        typeOfColor === 'hex' ? handleCreateRandomHexColor() : handleCreateRandomRGBColor()
    }, [typeOfColor])

    return (
        <div style={
            {
                width: "100vw",
                height: "100vh",
                background: color
            }
        }>
            <button onClick={() => setTypeOfColor('rgb')}>RGB 색상 사용</button>
            <button onClick={() => setTypeOfColor('hex')}>Hex 색상 사용</button>
            <button onClick={typeOfColor == 'hex' && handleCreateRandomHexColor || handleCreateRandomRGBColor}>랜덤 색상 생성</button>

            <div style={{
                display: 'flex',
                justifyContent: 'center',
                alignItems: "center",
                color: "white",
                fontSize: '60px',
                marginTop: '50px',
                flexDirection: 'column',
                gap: '20px'
            }}>
                <h1>{typeOfColor === 'hex' ? "Hex Color" : "RGB Color"}</h1>
                <h2>{color}</h2>

            </div>
        </div>
    )

}