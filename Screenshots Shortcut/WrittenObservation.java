public class WrittenObservation extends Observation {
    String summary;
    String description;

    public WrittenObservation(String summary) {
        this.summary = summary;
        this.description = summary;
    }

    public WrittenObservation(String summary, String descr) {
        this.summary = summary;
        this.description = descr;
    }

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
        builder.append(", \"summary\": \"");
        builder.append(getSummary());
        builder.append("\", \"description\": \"");
        builder.append(getDescription());
        builder.append("\"}");

        return builder.toString();

    }

    public String getSummary() {
        return this.summary;
    }

    public String getDescription() {
        return this.description;
    }



}
