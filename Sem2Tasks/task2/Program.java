public class Program {
    public static void main(String[] args) {
        Human actor1 = new Human("actor1");
        Human actor2 = new Human("actor2");
        Human actor3 = new Human("actor3");
        Human actor4 = new Human("actor4");
        Market market = new Market();
        market.acceptToMarket(actor1);
        market.acceptToMarket(actor2);
        market.acceptToMarket(actor3);
        market.acceptToMarket(actor4);
        market.update();
    }
}