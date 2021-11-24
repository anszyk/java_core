package homework;

import homework.obstacles.ObstacleCourse;

public class Swim extends ObstacleCourse{

    private int lengthObstacle;

    public Swim (int lengthObstacle) {
        this.lengthObstacle = lengthObstacle;
    }

    @Override
    public void doIt(Squad s) {
        s.swim(300);
    }
}
