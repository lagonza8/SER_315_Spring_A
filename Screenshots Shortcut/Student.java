public class Student extends Person{
    private String major;
    private String favColor;

    public Student(String name, String email, String major, String color) {
        this.name = name;
        this.email = email;
        this.major = major;
        this.favColor = color;
    }

    public Student(String name, String email, String major) {
        this(name, email, major, null);
    }

    public Student(String name, String email) {
        this(name, email, null, null);
    }

    public String getMajor() {
        if (this.major != null)
            return this.major;
        else
            return "What is a Major?";
    }

    public String getFavColor() {
        if (this.favColor != null)
            return this.favColor;
        else
            return "purkle";
    }

    public String toString() {
        StringBuilder builder;
        try {
            String str = super.toString();
            int length = str.length();
            builder = new StringBuilder(str.substring(1, length - 1));
        }
        catch(IndexOutOfBoundsException ex) {
            builder = new StringBuilder();
        }

        builder.insert(0, "{");
        builder.append(", \"major\": \"");
        builder.append(getMajor());
        builder.append("\", \"favorite_color\": \"");
        builder.append(getFavColor());
        builder.append("\"}");
        return builder.toString();
    }
}
