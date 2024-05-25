import { useState } from 'react';
import './styles.css'
import { IoMdArrowRoundBack } from "react-icons/io";
import { GoGraph } from "react-icons/go";
import { FaCheck } from "react-icons/fa";

export default function SideBar() {

    const [open, setOpen] = useState(false);

    const menu: any[] = [
        { title: "Account" },
        { title: "login", gap: true },
        { title: "Dashboard" },
        { title: "Inbox" },
    ]

    return (
        <div className="text-left flex">
            <div className={`${open ? "w-72" : "w-20"} duration-500 h-screen bg-purplely relative`}>
                <IoMdArrowRoundBack className={`absolute  bg-white cursor-pointer right-3 top-9 w-10 h-10 border-2 rounded-full ${!open ? "rotate-180" : ""}`} onClick={() => setOpen(!open)} />
                <div className="flex gap-x-4 items-center">
                    <GoGraph
                        className={`bg-white w-20 h-10 cursor-pointer ${open && "rotate-360"}`}
                    />
                    <h1 className={`bg-white text-4xl duration-500 ${!open ? "scale-0" : ""}`}>그래프</h1>
                </div>

                <ul className='pt-6'>
                    {menu.map((element, index) => {
                        return (
                            <div>

                                <li className={`text-gray-300 text-sm flex item-center gap-x-4 cursor-pointer p-3
                                hover:bg-whitely rounded-md ${element.gap ? "mb-9" : "mb-1"}`} key={index}>
                                    <FaCheck className='w-10 h-10 text-white' />
                                    <span className={`${!open && "hidden"} origin-left duration-300`}>{element.title}</span>
                                </li>
                            </div>)
                    })}
                </ul>

            </div >



            <div className="p-7 text-2xl font-semibold flex-1 h-screen">
                <h1>홈페이지</h1>

            </div>

        </div >
    )

}