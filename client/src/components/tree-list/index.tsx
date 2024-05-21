import MenuList from "./menu-list";

export default function TreeView({ menus = [] }: { menus: any[] }) {

    return (
        <div className="tree-view-container">
            <MenuList list={menus} />        </div>
    )
}