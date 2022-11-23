import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class UserMng {
    private List<Student> list = new ArrayList<Student>();

    private class Student {String Name = ""; int ID = 0; Student(String Name){this.Name = Name; ID = new Random().nextInt(32000);}void newId(){ID = new Random().nextInt(32000);}}
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