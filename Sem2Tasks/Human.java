
public class Human extends Actor {

    public Human(String name) {
        super(name);
        this.isMakeOrder = generateBoolean(); // готовность сделать заказ
        this.isTakeOrder = false; // заказ забрал

    }

    @Override
    String getName() {
        return super.name;
    }

    // возвращает готов сделать заказ или нет
    public boolean getMakeOrder() {
        return generateBoolean();
    }

}
