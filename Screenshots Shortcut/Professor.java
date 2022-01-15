public class Professor extends Person{
    private String phone;
    private String hobby;

    public Professor(String name, String email, String phone, String hobby) {
        this.name = name;
        this.email = email;
        setPhone(phone);
        this.hobby = hobby;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getHobby() {
        return this.hobby;
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
        builder.append(", \"phone_number\": \"");
        builder.append(getPhone());
        builder.append("\", \"hobby\": \"");
        builder.append(getHobby());
        builder.append("\"}");

        return builder.toString();
    }

    private void setPhone(String phoneNumber) throws IllegalArgumentException {
        String strippedNumber = phoneNumber.replaceAll("[^0-9]","");
        if (strippedNumber.length() == 10)
            this.phone = strippedNumber;
        else
            throw new IllegalArgumentException("Phone number must be 10 digits");
    }



}
