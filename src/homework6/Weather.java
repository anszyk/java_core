package homework6;

public class Weather {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserInterface userInterface = new UserInterface();
        userInterface.runApplication();
        String jsonStudent = objectMapper.writeValueAsString();
        System.out.println(jsonStudent);
    }
}
