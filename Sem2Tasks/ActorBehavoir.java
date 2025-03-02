
public interface ActorBehavoir {
    public boolean isMakeOrder(); // возвращает True если заказ создан

    public void setMakeOrder(); // этот метод создает заказ

    public void setTakeOrder(); // этим методом пользователю выдается заказ

    public boolean isTakeOrder(); // возвращает True если заказ забрали
}
