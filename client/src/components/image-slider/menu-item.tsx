import { useState } from "react";
import MenuList from "../tree-list/menu-list";
import { FaPlus, FaMinus } from "react-icons/fa";


export default function MenuItem({ item }: { item: any }) {

    const [displayChildren, setDisplayChildren] = useState<{ [key: string]: boolean }>({})

    function handleToggleChildren(currentLabel: string) {
        setDisplayChildren({ [currentLabel]: !displayChildren[currentLabel] })
        console.log(JSON.stringify(displayChildren))
    }

    return <li style={{ color: "white" }}>
        <div style={{ color: "white", display: 'flex', gap: '20px' }}>
            <p>{item.label}</p>
            {
                item && item.children && item.children.length > 0 ? < span onClick={() => handleToggleChildren(item.label)}>
                    {displayChildren[item.label] ? <FaMinus color="white" size={25} /> : <FaPlus color="#0" size={25} />}
                </span> : null
            }
        </div>
        {
            item && item.children && item.children.length > 0 && displayChildren[item.label] ? <MenuList list={item.children} /> : null
        }
    </li >
}