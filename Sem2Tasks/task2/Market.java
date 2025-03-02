
import java.util.ArrayList;
import java.util.List;

public class Market implements QueueBehaviour, MarketBehaviour {

    private List<Actor> actorsInQueue = new ArrayList<>();
    private List<Actor> actorsFromQueue = new ArrayList<>();

    public Market() {

    }

    public void printActorsInMarket() {
        for (Actor actor : actorsInQueue) {
            System.out.println("Актор - " + actor.getName());
        }
    }

    @Override
    public void acceptToMarket(Actor actor) {
        // добовляет актора в магазин
        System.out.println("Актор " + actor.getName() + " зашел в магазин");
        takeInQueue(actor);

    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        // удаляет актора из магазина
        for (Actor actor : actors) {
            actorsInQueue.remove(actor);
            System.out.println("Актор " + actor.getName() + " вышел из магазина\n");
        }

    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }

    @Override
    public void takeInQueue(Actor actor) {
        actorsInQueue.add(actor);
    }

    @Override
    public void takeOrders() {
        for (Actor actor : actorsInQueue) {
            if (!!actor.isMakeOrder) {
                actor.setMakeOrder(true);
            }
        }

    }

    @Override
    public void giveOrders() {
        for (Actor actor : actorsInQueue) {
            if (actor.isMakeOrder) {
                actor.setTakeOrder(true);
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        // выйти из очереди
        for (Actor actor : actorsInQueue) {
            if (actor.isTakeOrder()) {
                actorsFromQueue.add(actor);
            }
        }
        releaseFromMarket(actorsFromQueue);

    }

}
