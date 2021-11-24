package homework.hero;

import homework.Squad;

public class Players implements Squad {

    private int maxRun;
    private int maxSwim ;
    private String playerName;
    boolean onDistance;

    public Players(int maxRun, int maxSwim, String playerName) {
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.playerName = playerName;
        this.onDistance = onDistance;
    }

    @Override
    public void run(int lengthObstacle) {
        if(maxRun >= lengthObstacle){
            System.out.println(playerName + " пробежал всю дистанцию");
            onDistance = true;
        } else if(lengthObstacle > maxRun){
            System.out.println(playerName + " не сможет добежать " + (lengthObstacle > maxRun) + "м до конца дистанции");
            onDistance = false;
        }
    }

    @Override
    public void swim(int lengthObstacle) {
        if(maxSwim >= lengthObstacle){
            System.out.println(playerName + " проплыл всю дистанцию");
            onDistance = true;
        } else if(lengthObstacle > maxSwim){
            System.out.println(playerName + " не сможет проплыть " + (lengthObstacle - maxSwim) + "м до конца дистанции");
            onDistance = false;
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    public void showResults() {
        System.out.println(playerName + " : " + onDistance);
    }
}
