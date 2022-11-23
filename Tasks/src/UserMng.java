import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class UserMng {
    private List<Student> list = new ArrayList<Student>();

    private class Student {private char gender = 'd';private String Name = ""; private int ID = 0; void setGender(char g){gender = g;} char getGender() {return gender;}Student(String Name){this.Name = Name; ID = new Random().nextInt(32000);}void newId(){ID = new Random().nextInt(32000);}void setName(String name){this.Name = name;} int getId(){return ID;}}
    private int index(){return list.size();}
    Student[] getByName(String name) {
        Student[] h = new Student[0];
        int i = 0;
        for ( Student s : list) {
            if (s.Name == name) {
                i++;
                Student[] t = new Student[i];
                System.arraycopy(h, 0, t, 0, i-1);
                h = t;
                h[i-1] = s;
            }
        }
        return h;
    }
    Student getById(int Id) {
        for (Student s : list) {
            if (s.ID == Id) {return s;}
        }
        return null;
    }
    void addStudent(Student s){list.add(s);}
}