package logging;

import java.io.BufferedWriter;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileLogger implements ILogger {

    private String filename;

    public FileLogger(String filename) {
        this.filename = filename;
    }

    @Override
    public void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filename, true), "UTF-8"))) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
