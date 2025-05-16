// применяем принцип единственной ответственности: разбиваем ответственность одного класса Main в 
// котором  генерировались ФИО и ДР на отдельные классы генерации этих данных.
package Core.Infrastructure.generateInputDate;

import java.util.Random;

public abstract class InputDataGeneration{
    protected Random random = new Random();
    protected String[] names;
    
    public abstract String dataGenerator();
     
    
        
}
