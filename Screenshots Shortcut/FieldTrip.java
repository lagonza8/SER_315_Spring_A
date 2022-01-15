import java.util.ArrayList;
import java.util.List;

public class FieldTrip {
    private Course course;
    private List<RecordedObservations> observations;

    public FieldTrip(Course course) {
        this.course = course;
        this.observations = new ArrayList<>();
    }

    public int makeWrittenObservation(Student stu, String summ, String descr) {
        RecordedObservations sObservations = getRecordedObservations(stu);
        return sObservations.writeObservation(summ, descr);
    }

    public int makePhotoObservation(Student stu, String imgURL, Double dLat, Double dLong) {
        RecordedObservations sObservations = getRecordedObservations(stu);
        return sObservations.photoObservation(imgURL, dLat, dLong);
    }

    public List<String> getStudentNames() {
        List<String> studentNames = new ArrayList<>();
        for (RecordedObservations obs: this.observations) {
            studentNames.add(obs.getStudent().getName());
        }
        return studentNames;
    }

    public List<RecordedObservations> getObservations() {
        return new ArrayList(this.observations);
    }

    public int getObservationCount() {
        int count = 0;
        for (RecordedObservations obs: this.observations) {
            count += obs.getObservationCount();
        }
        return count;
    }

    private RecordedObservations getRecordedObservations(Student stu) {
        RecordedObservations studentObs = null;
        for (RecordedObservations obs: this.observations) {
            if (obs.getStudent().equals(stu)) {
                studentObs = obs;
                break;
            }
        }
        if (studentObs == null) {
            studentObs = new RecordedObservations(stu);
            this.observations.add(studentObs);
        }
        return studentObs;
    }

}
