public class BOStudent
{

    private final String lastName;
    private final String firstName;
    private final String inits;
    private DSStudent dsStudent;

    public BOStudent(String text, String text1) {
        this.firstName = text;
        this.lastName = text1;
        inits = firstName.charAt(0) + "" + lastName.charAt(0);
        dsStudent = new DSStudent();
        dsStudent.setBOStudent(this);
    }

    public void write() {
        dsStudent.write();
    }

    public String getLastName() {
        return lastName;
    }

    public Object getFirstName() {
        return firstName;
    }

    public String getInits() {
        return inits;
    }

}
