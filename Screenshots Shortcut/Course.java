import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Course {
    private int number;
    private String dept;
    private String description;
    private int credits;
    private Professor prof;
    private Roster roster;
    private FieldTrip[] trips;

    public Course(String department, int classNumber, int credits, String description, Professor prof) {
        this.number = classNumber;
        this.dept = department;
        this.description = description;
        this.credits = credits;
        this.prof = prof;

        this.roster = new Roster(this);
        this.trips = new FieldTrip[]{new FieldTrip(this), new FieldTrip(this)};
    }

    public Course(String department, int classNumber, int credits, String description) {
        this(department, classNumber, credits, description, null);
    }

    public String getName() {
        return this.dept + Integer.toString(this.number);
    }

    public int getCredits() {
        return this.credits;
    }

    public boolean addProfessor(Professor prof) {
        if (this.prof != null) {
            return false;
        }
        else {
            this.prof = prof;
            return true;
        }
    }

    public Professor getProfessor() {
        return this.prof;
    }

    public boolean enrollStudent(Student student) {
        return roster.addStudent(student);
    }

    public List<String> getStudentNames() {
        List<String> studentNames = new ArrayList<>();
        for (Student student: this.roster.getStudents()) {
            studentNames.add(student.getName());
        }
        return studentNames;
    }

    public FieldTrip getFieldTrip(int number) {
        try {
            return this.trips[number];
        }
        catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException("No such field trip numbered: " + number);
        }
    }








}
