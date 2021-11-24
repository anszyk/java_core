package homework;

import homework.hero.Runner;
import homework.hero.Swimmer;
import homework.hero.Team;
import homework.obstacles.Course;
import homework.obstacles.ObstacleCourse;

public class HomeworkOne {

    public static void main(String[] args) {

        Squad[] teamPlayers = {new Runner(150, 500, "Алексей"), new Swimmer(600, 100, "Петр"), new Runner(600, 70, "Ольга"), new Swimmer(600, 200, "Мария")};
        ObstacleCourse[] obstacleCourses = {new Run(250), new Swim(150), new Run(200), new Swim(210), new Run(300), new Swim(190), new Run(170), new Swim(300)};

        Team team = new Team("Winners", teamPlayers);

        System.out.print("Команда: ");
        System.out.println(team.getNameTeam());

        System.out.println("Результаты игроков: ");
        team.showResults();

        Course course = new Course(obstacleCourses);

        System.out.println("Препятствия: ");
        course.doIt(team);
    }
}
