package jobagency;

import java.util.Random;

public class Junior implements Observer{
    private String name;

    public Junior(String name) {
        this.name = name;
    }

    @Override
    public void receiveOffer(String nameCompany, int salary) {
        if (new Random().nextBoolean()){
            System.out.println("Junior accept the offer! Company? salary" + nameCompany + salary + "Junior: " + name);
        } else {
            System.out.println("Junior don't accept the offer! Company? salary" + nameCompany + salary + "Junior: " + name);
        }
    }
}
