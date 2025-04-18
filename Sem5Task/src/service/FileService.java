package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.Teacher;
import model.Type;
import model.User;

public class FileService {
    private String path;

    public FileService(String path) {
        this.path = path;
        
    }

    public List<User> load() {
        Type typeStudent = Type.STUDENT;
        Type typeTeacher = Type.TEACHER;
        List<User> usersList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                currentLine = currentLine.trim();
                if (currentLine.isEmpty()) {
                    continue;
                }
                String[] partsLine = currentLine.split("\\s+");
                if (partsLine.length == 6) {
                    if (partsLine[5].equals(typeStudent.getTypeValueString())) {
                        usersList.add(Student.createStudent(Long.parseLong(partsLine[0]), partsLine[1], partsLine[2],
                                partsLine[3], partsLine[4]));
                    } else if (partsLine[5].equals(typeTeacher.getTypeValueString())) {
                        usersList.add(Teacher.createTeacher(Long.parseLong(partsLine[0]), partsLine[1], partsLine[2],
                                partsLine[3], partsLine[4]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public void save(List<User> usersList) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            } 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try (FileWriter writer = new FileWriter(path, false)) {
 
           for (User user : usersList) {
                if (user instanceof Student) {
                    writer.append(user.toString() + " " + Type.STUDENT.getTypeValueString());
                } else if (user instanceof Teacher) {
                    writer.append(user.toString() + " " + Type.TEACHER.getTypeValueString());
                }
                writer.append("\n");
            }
            writer.flush();
        } catch (IOException ex) {
                System.out.println(ex.getMessage());
        }
            
    }
    
}
