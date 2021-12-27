package java_core.homework9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class HomeworkApp9 {

    public static void main(String args[]) {
        List<ListOfStudents> students = new ArrayList<ListOfStudents>();
        for (int i = 0; i < 10; i++) {
            ListOfStudents student = new ListOfStudents();
            student.setName("Name" + i);
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k < j; k++) {
                    Course course = new CoursesList("Course" + j);
                    student.setCourse(course);
                }
            }
            students.add(student);
        }

        List<String> uniqueCourses =uniqCourses(students);
        System.out.println("Список уникальных курсов: "+ uniqueCourses.toString());

        System.out.println("Три самых любознательных студента: ");
        topThreeStudents(students).stream()
                .map(stud -> stud.getName())
                .forEach(System.out::println);

        Course course = new Course() {
            @Override
            public String getName() {
                return null;
            }
        };
//        System.out.printf("Студенты на курсе %s: \n", course.getName());
//        getStudentsFromCourse(students, course).stream()
//                .map(stud -> stud.getName())
//                .forEach(System.out::println);
    }

    static List<String> uniqCourses(List<ListOfStudents> students) {
        List<String> uniqueCourses =
                students.stream()
                        .map(stud -> stud.getAllCourses())
                        .flatMap(Collection::stream)
                        .map(c -> c.getName())
                        .distinct()
                        .collect(Collectors.toList());
        return uniqueCourses;
    }

    static List<Student> topThreeStudents(List<ListOfStudents> students) {
        List<Student> topThree = students.stream()
                        .sorted((stud1, stud2) -> stud2.getAllCourses().size() - stud1.getAllCourses().size())
                        .limit(3)
                        .collect(Collectors.toList());
        return topThree;
    }

//    static List<Student> getStudentsFromCourse(List<ListOfStudents> students, Course course) {
//        System.out.println("Ищем студентов проходящих курс " + course);
//        return students.stream()
//                .filter(student -> student.getAllCourses().contains(course))
//                .collect(Collectors.toList());
//
//    }
}
