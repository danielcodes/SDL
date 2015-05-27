public class BOStudent
{

    private final String lastName;
    private final String firstName;
    private final String inits;

    //added
    private final String occupation;
    private final String major;
    private final String age;

    private DSStudent dsStudent;

    public BOStudent(String text, String text1, String text2, String text3, String text4) {
        this.firstName = text;
        this.lastName = text1;

        //added
        this.occupation = text2;
        this.major = text3;
        this.age = text4;

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

    //added
    public String getOccupation() {
        return occupation;
    }

    public String getMajor() {
        return major;
    }

    public String getAge(){
        return age;
    }

    public String toString()
    {
        return  this.getInits() + ", " +
                this.getLastName() + ", " +
                this.getFirstName() + ", " +
                this.getOccupation() + ", " +
                this.getMajor() + ", " +
                this.getAge() + "\n";
    }

}
