package N201911.N20191121.iterator;

public class FilmMenuIterator implements Iterator, java.util.Iterator {

    MenuItem[] menuItems;
    int position = 0;

    public FilmMenuIterator(MenuItem[] menuItems){
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (position > menuItems.length - 1 || menuItems[position] == null){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        MenuItem menuItem = menuItems[position];
        position++;
        return menuItem;
    }

    @Override
    public void remove() {

    }
}
