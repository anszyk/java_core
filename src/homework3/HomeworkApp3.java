package homework3;

public class HomeworkApp3{

    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>(1);
        Box<Orange> orangeBox = new Box<>(1.5);
        Box<Apple> temporaryBox = new Box<>(1);

        for (int i = 0; i < 3; i++) {
            appleBox.add(new Apple());
            orangeBox.add(new Orange());
            temporaryBox.add(new Apple());
        }

        appleBox.add(new Apple());
        appleBox.add(new Apple());
        temporaryBox.add(new Apple());

        System.out.println("Масса ящика с яблоками: " + appleBox.getWeight());
        System.out.println("Масса ящика с апельсинами: " + orangeBox.getWeight());
        System.out.println("Массы ящиков равны? " + appleBox.compare(orangeBox));
        appleBox.addFruits(temporaryBox);

    }

}
