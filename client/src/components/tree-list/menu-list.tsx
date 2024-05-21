import MenuItem from "../image-slider/menu-item";
import './styles.css'


export default function MenuList({ list = [] }: { list: any[] }) {

    return <ol className="menu-list-container">
        {
            list && list.length ? list.map(element => <MenuItem item={element} />) : null
        }
    </ol>

}