
public abstract class Actor implements ActorBehavoir {
    protected String name;
    protected boolean isMakeOrder; // кто заказ не сделал заказ
    protected boolean isTakeOrder; // забрал заказ

    public Actor(String name) {
        this.name = name;
    }

    @Override
    // этот метод создает заказ
    public void setMakeOrder(boolean makeOrder) {
        this.isMakeOrder = makeOrder;
    }

    @Override
    // этим методом пользователь забирает заказ
    public void setTakeOrder(boolean makeOrder) {
        this.isTakeOrder = makeOrder;

    }

    @Override
    // возвращает True если заказ создан False если нет
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    @Override
    // возвращает True если заказ забрали
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    abstract String getName();

}
