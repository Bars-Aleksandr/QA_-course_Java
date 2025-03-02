import java.util.Random;

public abstract class Actor implements ActorBehavoir {
    protected String name;
    protected boolean isMakeOrder; // готов сделать заказ
    protected boolean isTakeOrder; // забрал заказ

    public Actor(String name) {
        this.name = name;
    }

    public boolean generateBoolean() {
        Random random = new Random();
        return random.nextInt(2) == 1;
    }

    @Override
    // возвращает True если заказ создан False если нет
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    @Override
    // этот метод создает заказ
    public void setMakeOrder() {
        if (generateBoolean()) {
            this.isMakeOrder = true;
        } else {
            this.isMakeOrder = false;
        }

    }

    @Override
    // этим методом пользователь забирает заказ
    public void setTakeOrder() {
        this.isTakeOrder = true;

    }

    @Override
    // возвращает True если заказ забрали
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    abstract String getName();

}
