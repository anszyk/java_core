package homework8;

import java.io.IOException;
import java.sql.SQLException;


public class Weather {

    public static void main(String[] args) throws SQLException, IOException {
        UserInterface userInterface = new UserInterface();
        userInterface.runApplication();
    }
}