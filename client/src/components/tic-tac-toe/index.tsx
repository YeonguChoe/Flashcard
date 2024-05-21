import { useEffect, useState } from 'react'
import './styles.css'

export default function TicTacToe() {

    const [squareList, setSquareList] = useState(Array(9).fill(''))
    const [xTurn, setXTurn] = useState(true)
    const [status, setStatus] = useState('')

    useEffect(() => {
        if (squareList.every(element => element !== '') && getWinner(squareList) === null) {
            return setStatus("Draw")
        }
        if (getWinner(squareList) !== null) {
            return setStatus(`${getWinner(squareList)} won!`)
        }
    }, [squareList, status]);

    function Square({ callback, value }: { callback: any, value: string }) {
        return <button onClick={() => callback()} className="square" > {value}</button >
    }

    function handleClick(i: number): any {
        let squareListCopy = [...squareList];
        if (squareList[i] !== '' || getWinner(squareList) !== null) return
        squareListCopy[i] = xTurn ? "O" : "X";
        setSquareList(squareListCopy)
        setXTurn(!xTurn)
    }

    function getWinner(squareList: string[]) {
        const winningPattern = [
            [0, 1, 2],
            [3, 4, 5],
            [6, 7, 8],
            [0, 3, 6],
            [1, 4, 7],
            [2, 5, 8],
            [0, 4, 8],
            [2, 4, 6]
        ]
        for (let i = 0; i < winningPattern.length; i++) {

            let [x, y, z] = winningPattern[i]
            if (squareList[x] !== '' && squareList[x] === squareList[y] && squareList[y] === squareList[z]) {
                return squareList[x]
            }
        }
        return null
    }



    return (
        <div className="tic-tac-toe-container">
            <div className="row">
                <Square value={squareList[0]} callback={() => squareList[0] === '' ? handleClick(0) : undefined} />
                <Square value={squareList[1]} callback={() => handleClick(1)} />
                <Square value={squareList[2]} callback={() => handleClick(2)} />
            </div>
            <div className="row">
                <Square value={squareList[3]} callback={() => handleClick(3)} />
                <Square value={squareList[4]} callback={() => handleClick(4)} />
                <Square value={squareList[5]} callback={() => handleClick(5)} />
            </div>
            <div className="row">
                <Square value={squareList[6]} callback={() => handleClick(6)} />
                <Square value={squareList[7]} callback={() => handleClick(7)} />
                <Square value={squareList[8]} callback={() => handleClick(8)} />
            </div>

            <h1>{status}</h1>

        </div>
    )
}