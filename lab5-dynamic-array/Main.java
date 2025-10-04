public class Main
{
    public static void main(String[] args)
    {
        Inventory inventory = new Inventory();

        inventory.addItem(new Item("Magic"));
        inventory.addItem(new Item("Magic"));
        inventory.addItem(new Item("Magic"));
        inventory.addItem(new Item("Staff"));
        inventory.display();

        inventory.combineItems("Magic","Staff");
        inventory.display();

        inventory.combineItems("Magic","Staff");
        inventory.display();
    }
}