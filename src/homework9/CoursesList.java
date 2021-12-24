package java_core.homework9;

public class CoursesList implements Course {
    private String name;

    CoursesList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
