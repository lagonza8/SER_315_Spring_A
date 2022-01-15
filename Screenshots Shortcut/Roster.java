import java.util.ArrayList;
import java.util.List;

public class Roster {
    Course course;
    private List<Student> students;

    public Roster(Course course) {
        this.students = new ArrayList<>();
    }

    public boolean addStudent(Student student) {
        if (this.students.size() >= 30) {
            return false;
        }
        else if (this.students.contains(student)) {
            return false;
        }
        else {
            return this.students.add(student);
        }
    }

    public List<Student> getStudents() {
        return new ArrayList(this.students);
    }

    public int getStudentCount() {
        return this.students.size();
    }
}
