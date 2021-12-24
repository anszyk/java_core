package java_core.homework9.lesson;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

// Слайд "Функциональные интерфейсы"
public class Demo1 {

    static class Person {
        int age;

        public Person(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        unaryOperatorGetCube_1();
    }

    // Демонстрация предиката
    private static void verifyUserToBeerPub() {
        // Анонимный класс
//        Predicate<Person> personPredicate = new Predicate<Person>() {
//            @Override
//            public boolean test(Person person) {
//                return person.age >= 18;
//            }
//        };
// аналогичная запись
        Predicate<Person> personPredicate_1 = person -> person.age >= 18;

        Person valid = new Person(19);
        Person tooYoung = new Person(14);

        System.out.println(personPredicate_1.test(valid));
        System.out.println(personPredicate_1.test(tooYoung));
    }

    // Демонстрация функции
    private static void functionExample() {
        Function<String, Integer> strToInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                try {
                    return Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        };
// аналогичная запись
        Function<String, Integer> strToInt_1 = s ->{
                try {
                    return Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    return null;
                }
        };

        System.out.println(strToInt.apply("5"));
        System.out.println(strToInt.apply("5s"));
    }

    // Демонстрация unaryoperator, функция, вычисляющая куб
    private static void unaryOperatorGetCube() {
        UnaryOperator<Integer> getCube = new UnaryOperator<Integer>() {
                @Override
                public Integer apply(Integer integer) {
                    return integer * integer * integer;
                }
            };

        System.out.println(getCube.apply(10));
    }
// аналогичная запись
    private static void unaryOperatorGetCube_1() {
        UnaryOperator<Integer> getCube = integer -> integer * integer * integer;

        System.out.println(getCube.apply(10));
    }
}