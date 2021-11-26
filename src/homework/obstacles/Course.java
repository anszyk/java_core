package homework.obstacles;

import homework.Squad;
import homework.hero.Team;

public class Course {

    ObstacleCourse[] obstacleCourses;

    public Course(ObstacleCourse[] obstacleCourses) {
        this.obstacleCourses = obstacleCourses;
    }

    public void doIt(Team players){
        Squad teamPlayers[] = players.getTeam();
        if(teamPlayers.length > 0){
            for (Squad a: teamPlayers){
                for (ObstacleCourse oC: obstacleCourses){
                    oC.doIt(a);
                    if (!a.isOnDistance())
                        break;
                }
            }
        }
    }

}
