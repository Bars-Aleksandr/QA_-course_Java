// применяем принцип единственной ответственности: ФИО и ДР на отдельные классы генерации этих данных.
//O — Open-Closed (Принцип открытости-закрытости) 
//D — Dependency Inversion (Принцип инверсии зависимостей)
package Core.Infrastructure.generateInputDate;

import java.util.Random;

public abstract class InputDataGeneration{
    protected Random random = new Random();
    protected String[] names;
    
    public abstract String dataNamesGenerator();
     
    
        
}
