package homework3;

import java.util.ArrayList;

public class Box<T>{

    ArrayList<T> fruits = new ArrayList<>();
    private double weightFruit = 0.0;;

    public <T extends Fruit> Box(double weightFruit) {
            this.weightFruit = weightFruit;
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        double boxWeight = fruits.size() * weightFruit;
        return boxWeight;
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void addFruits(Box<T> box) {
        System.out.println("Ящик 1 до : " + fruits.size() + " фруктов");
        System.out.println("Ящик 2 до : " + box.fruits.size() + " фруктов");
        fruits.addAll(box.fruits);
        box.fruits.clear();
        box.fruits.trimToSize();
        System.out.println("Ящик 1 после перекладывания: " + fruits.size());
        System.out.println("Ящик 2 после перекладывания: " + box.fruits.size());

    }
}

