import java.util.ArrayList;
import java.util.List;

public class RecordedObservations {
    private Student student;
    private List<Observation> observations;

    public RecordedObservations(Student student) {
        this.student = student;
        this.observations = new ArrayList<>();
    }

    public int photoObservation(String photoURL) {
        return photoObservation(photoURL,null, null);
    }

    public int photoObservation(String photoURL, Double dLat, Double dLong) {
        PhotoObservation photo = new PhotoObservation(photoURL, dLat, dLong);
        return addObservation(photo);
    }

    public int writeObervation(String summ) {
        return writeObservation(summ, summ);
    }

    public int writeObservation(String summ, String descr) {
        WrittenObservation note = new WrittenObservation(summ, descr);
        return addObservation(note);
    }

    public Student getStudent() {
        return this.student;
    }
    public List<Observation> getObservations() {
        return new ArrayList(this.observations);
    }

    public int getObservationCount() {
        return this.observations.size();
    }

    private int addObservation(Observation obs) {
        if (this.observations.size() < 7) {
            this.observations.add(obs);
            return this.observations.size();
        }
        else {
            throw new IndexOutOfBoundsException("Already recorded max observations");
        }
    }


}
