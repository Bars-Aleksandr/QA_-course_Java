import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {

    private static void pause() {
        try {
            Thread.sleep(3000); // Задержка на 3000 миллисекунд (3 секунды)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // public static List<Human> generateActorNames(int countAction) {
    // List<Human> actorList = new ArrayList<>();
    // for (int i = 0; i < countAction; i++) {
    // String tempName = "user" + i;
    // Human actorName = new Human(tempName);
    // actorList.add(i, actorName);
    // }
    // return actorList;

    // }

    // public static void printHumans(List<Human> humans) {
    // for (Human human : humans) {
    // System.out.println(human.getName());
    // pause();

    // }
    // }
    // public static boolean generateBoolean() {
    // Random random = new Random();
    // return random.nextInt(2) == 1;
    // }

    public static void main(String[] args) {
        // int limitCountActor = 5; // задаем максимальное количество акторов в очереди
        // printHumans(generateActorNames(limitCountActor));

        Human human1 = new Human("Boss");
        Human human2 = new Human("Hoss");
        Human human3 = new Human("Mimi");
        Human human4 = new Human("Josy");

        while (!human1.isTakeOrder || !human2.isTakeOrder || !human3.isTakeOrder || !human4.isTakeOrder) {
            if (!human1.isTakeOrder) {
                if (human1.isMakeOrder) {
                    System.out.println(human1.getName() + " готов сделать заказ");
                    pause();
                    if (human1.getMakeOrder()) {
                        System.out.println("Заказ для " + human1.getName() + "- создан");
                        pause();
                        System.out.println(human1.getName() + " забирает заказ");
                        pause();
                        human1.setTakeOrder();
                    } else {
                        System.out.println("Заказ для " + human1.getName() + " не создан");
                        pause();
                    }

                } else {
                    System.out.println(human1.getName() + " не готов сделать заказ");
                    pause();
                    human1.isMakeOrder = human1.generateBoolean();
                }
            }
            if (!human2.isTakeOrder) {
                if (human2.isMakeOrder) {
                    System.out.println(human2.getName() + " готов сделать заказ");
                    pause();
                    if (human2.getMakeOrder()) {
                        System.out.println("Заказ для " + human2.getName() + " - создан");
                        pause();
                        System.out.println(human2.getName() + " забирает заказ");
                        pause();
                        human2.setTakeOrder();
                    } else {
                        System.out.println("Заказ для " + human2.getName() + " не создан");
                        pause();
                    }
                } else {
                    System.out.println(human2.getName() + " не готов сделать заказ");
                    pause();
                    human2.isMakeOrder = human2.generateBoolean();
                }
            }
            if (!human3.isTakeOrder) {
                if (human3.isMakeOrder) {
                    System.out.println(human3.getName() + " готов сделать заказ");
                    pause();
                    if (human3.getMakeOrder()) {
                        System.out.println("Заказ для " + human3.getName() + " - создан");
                        pause();
                        System.out.println(human3.getName() + " забирает заказ");
                        pause();
                        human3.setTakeOrder();
                    } else {
                        System.out.println("Заказ для " + human3.getName() + " не создан");
                        pause();
                    }
                } else {
                    System.out.println(human3.getName() + " не готов сделать заказ");
                    pause();
                    human3.isMakeOrder = human3.generateBoolean();
                }
            }
            if (!human4.isTakeOrder) {
                if (human4.isMakeOrder) {
                    System.out.println(human4.getName() + " готов сделать заказ");
                    pause();
                    if (human4.getMakeOrder()) {
                        System.out.println("Заказ для " + human4.getName() + " - создан");
                        pause();
                        System.out.println(human4.getName() + " забирает заказ");
                        pause();
                        human4.setTakeOrder();
                    } else {
                        System.out.println("Заказ для " + human4.getName() + " не создан");
                        pause();
                    }
                } else {
                    System.out.println(human4.getName() + " не готов сделать заказ");
                    pause();
                    human4.isMakeOrder = human4.generateBoolean();
                }
            }
        }

    }
}