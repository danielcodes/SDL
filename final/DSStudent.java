import java.io.FileOutputStream;
import java.io.IOException;

public class DSStudent
{
    private BOStudent boStudent;

    public void setBOStudent( BOStudent boStudent)
    {
        this.boStudent = boStudent;
    }

    public void write() {
        try {
            FileOutputStream dataBase = new FileOutputStream("database.csv", true);
            String writeString = boStudent.toString();
            dataBase.write(writeString.getBytes());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    


}
