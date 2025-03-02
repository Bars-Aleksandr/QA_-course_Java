
public interface ActorBehavoir {
    public boolean isMakeOrder(); // возвращает True если заказ создан

    public void setMakeOrder(boolean makeOrder); // этот метод создает заказ

    public void setTakeOrder(boolean makeOrder); // этим методом пользователю выдается заказ

    public boolean isTakeOrder(); // возвращает True если заказ забрали
}
