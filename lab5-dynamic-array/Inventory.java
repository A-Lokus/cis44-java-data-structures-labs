import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory(){
        items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        items.add(item);
    }
    public void display(){
        System.out.println("----- Inventory -----");
        for(Item e : items){
            System.out.println(e);
        }
        System.out.println();
    }

    public void combineItems(String name1, String name2){
        System.out.println("Attempting to combine items...");
        boolean item1 = false;
        boolean item2 = false;

        for(Item e : items){
            if(e.getName().equals(name1)){item1 = true;}
            if(e.getName().equals(name2)){item2 = true;}
        }
        if(!item1 || !item2){
            System.out.println("ERROR: Could not find items: "+name1 + " and "+name2);
        }
        else{
            Iterator<Item> iter = items.iterator();
            while(iter.hasNext() && (item1 || item2)){
                Item curr = iter.next();
                if(curr.getName().equals(name1) && item1){
                    item1 = false;
                    iter.remove();
                }
                if(curr.getName().equals(name2) && item2){
                    item2 = false;
                    iter.remove();
                }
            }
            items.add(new Item(name1 + " " + name2));
        }
        System.out.println();
    }
}