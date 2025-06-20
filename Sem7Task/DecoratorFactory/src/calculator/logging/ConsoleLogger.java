package calculator.logging;

public class ConsoleLogger implements ILoggableOnConsole{
    @Override
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
