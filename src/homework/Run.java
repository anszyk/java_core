package homework;

import homework.obstacles.ObstacleCourse;

public class Run extends ObstacleCourse {

    private int lengthObstacle;

    public Run (int lengthObstacle) {
        this.lengthObstacle = lengthObstacle;
    }

    @Override
    public void doIt(Squad s) {
        s.run(500);
    }
}
