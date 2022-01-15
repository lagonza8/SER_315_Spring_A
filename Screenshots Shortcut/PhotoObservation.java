public class PhotoObservation extends Observation {
    private String imageURL;
    private Double latitude;
    private Double longitude;


    public PhotoObservation(String photo) {
        this.imageURL = photo;
    }

    public PhotoObservation(String photo, Double dLat, Double dLong) {
        this(photo);
        this.latitude = dLat;
        this.longitude = dLong;
    }

    @Override
    public String read() {
        StringBuilder builder;
        try {
            String str = super.read();
            int length = str.length();
            builder = new StringBuilder(str.substring(1, length - 1));
        }
        catch(IndexOutOfBoundsException ex) {
            builder = new StringBuilder();
        }

        builder.insert(0, "{");
        builder.append(", \"image\": \"");
        builder.append(getImageURL());
        builder.append("\", \"latitude\": ");
        builder.append(getLatitude());
        builder.append(", \"longitude\": ");
        builder.append(getLongitude());
        builder.append("}");

        return builder.toString();
    }

    public String getImageURL() {
        return this.imageURL;
    }

    private String getLatitude() {
        if (this.latitude != null) {
            return this.latitude.toString();
        }
        else {
            return "null";
        }

    }

    private String getLongitude() {
        if (this.longitude != null) {
            return this.longitude.toString();
        }
        else {
            return "null";
        }
    }
}
