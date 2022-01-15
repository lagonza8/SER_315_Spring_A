import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Geology Field Trip Simulation...\n");

        // Create Students
        Student stu1 = new Student("Jeremy", "jwdouble@asu.edu");
        Student stu2 = new Student("Jacob", "jlabrec@asu.edu", "Software Engineering", "Blue");
        Student stu3 = new Student("Joe", "jcreyno5@asu.edu", "Software Engineering", "Green");
        Student stu4 = new Student("David", "dswelbor@asu.edu", "Business Administration", "Forty-two");
        Student[] students = new Student[]{stu1, stu2, stu3, stu4};
        System.out.println("The following students were created:");
        for (Student stu: students){
            System.out.println(stu.toString());
        }

        // Create Teacher
        Professor prof = new Professor("Dr. Mehlhase", "amehlhas@asu.edu", "480-884-1525", "martial arts");
        System.out.println("The following teachers were created:");
        System.out.println(prof.toString());

        // Create class and activities
        Course glg104 = new Course("GLG", 104, 1, "Writing songs about rocks, like geodes.");
        glg104.addProfessor(prof);
        System.out.println("\n" + prof.getName() + " was added as an instructor  to: "
                + glg104.getName());

        // Enrollment
        for (Student stu: students) {
            glg104.enrollStudent(stu);
            System.out.println(stu.getName() + " enrolled in " + glg104.getName());
        }

        // Simulate Fieldtip
        FieldTrip ft1 = glg104.getFieldTrip(0);
        ft1.makePhotoObservation(stu1, "https://pbs.twimg.com/media/EDjfimoW4AEibDx.jpg", 34.04, 111.09);
        ft1.makeWrittenObservation(stu1, "There is a hill", "It has some rocks exposing some andesite that's been uplifted");
        ft1.makeWrittenObservation(stu2, "Some of the layers are missing", "In the exposed rock layers, some of the layers are missing creating an disconformity");
        ft1.makePhotoObservation(stu3, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Andesitic_dyke_Morro_Solar.jpg/1024px-Andesitic_dyke_Morro_Solar.jpg", 9.09, 75.01);
        ft1.makeWrittenObservation(stu4, "Everything is brown", "No matter how long I look, I can't see any fossils");
        ft1.makePhotoObservation(stu4, "https://www.nps.gov/mora/planyourvisit/images/sunrise_columnar-lava_sml.jpg?maxwidth=650&autorotate=false", 49.8, -121.7);

        List<RecordedObservations> observations = ft1.getObservations();
        System.out.println("\nThe following observations were made by students:");
        for (RecordedObservations rObservation: observations) {
            List<Observation> listObs = rObservation.getObservations();
            String student = rObservation.getStudent().getName();
            System.out.println(student + " made the following observations:");
            for (Observation obs: listObs) {
                System.out.println("\t" + obs.read());
            }
        }
        System.out.println("There were " + ft1.getObservationCount() + " observations");
    }

}
