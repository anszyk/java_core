package homework.hero;

import homework.Squad;

public class Team {

    private String nameTeam;
    Squad[] teamPlayers = new Squad[4];

    public Team(String nameTeam, Squad[] teamPlayers) {
        this.nameTeam = nameTeam;
        this.teamPlayers = teamPlayers;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public Squad[] getTeam() {
        return teamPlayers;
    }

    public void showResults() {
        for(Squad a : teamPlayers){
            a.showResults();

        }
    }

    public void showPlayersPassedObstacle() {
        for(Squad a : teamPlayers){
            if (a.isOnDistance())
                a.showResults();
        }
    }
}
