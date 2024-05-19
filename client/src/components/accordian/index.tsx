import { useState } from "react"
import data from "./data"
import "./styles.css"


export default function Accordian() {

    const [selected, setSelected] = useState(100)
    const [multiselectionEnabled, setMultiSelectionEnabled] = useState(false)
    const [multiple, setMultiple] = useState<number[]>([])

    const handleSingleSelection = (id: number) => {
        setSelected(id === selected ? 100 : id)
    }

    function handleMultiSelection(id: number) {
        let copy = [...multiple]

        let containsID = copy.indexOf(id)

        if (containsID === -1) {
            copy.push(id)
        } else {
            copy.splice(containsID, 1)
        }
        setMultiple(copy)
    }

    console.log(selected, multiple)
    return (
        <div className="wrapper">
            <button onClick={() => setMultiSelectionEnabled(!multiselectionEnabled)}>Enable multi selection</button>
            <div className="accordian">
                {
                    data && data.length > 0 ? (
                        data.map(dataItem => (
                            <div className="item">

                                <div onClick={multiselectionEnabled ? () => handleMultiSelection(dataItem.id) : () => handleSingleSelection(dataItem.id)} className="title">{dataItem.question}</div>
                                <span>+</span>

                                {
                                    selected === dataItem.id || multiple.indexOf(dataItem.id) !== -1 ?
                                        <div className="content">{dataItem.answer}</div> : null
                                }
                            </div>
                        ))
                    ) : <div>데이터가 없습니다! </div>
                }
            </div>
        </div >
    )
}