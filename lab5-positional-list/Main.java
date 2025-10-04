public class Main {
    public static void main(String[] args) {
        LinkedPositionalList<String> travelItinerary = new LinkedPositionalList<>();
        Position<String> p = travelItinerary.addFirst("Mexico");
        Position<String> q = travelItinerary.addFirst("Disneyland");
        Position<String> r = travelItinerary.addLast("Cancun");
        Position<String> s = travelItinerary.addBefore(q,"Honduras");

        System.out.println("----- Travel Itinerary -----");
        for(String e : travelItinerary){
            System.out.println(e);
        }
        System.out.println();

        Position<String> t = travelItinerary.addAfter(q,"Haiti");
        travelItinerary.set(p,"Nicaragua");
        travelItinerary.remove(s);

        System.out.println("----- Travel Itinerary -----");
        for(String e : travelItinerary){
            System.out.println(e);
        }
    }
}