package java_core.homework9.lesson;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

// Демонстрация лямбды
public class Demo2 {

    /*
    Из предыдущего примера свернуть анонимный класс в лямбду

    Лямбды = Анонимные функции
    1. Указывать тип можно, но компилятор приводит к нужному типу самостоятельно
    2. Если выражение в одну строку, не обязательно писать return и ставить {}

    Продемонстрировать лямбды на остальных примерах
    */

    public static void main(String[] args) {
        UnaryOperator<Integer> getCube =
            (Integer integer) -> {
                return integer * integer * integer;
            };
//аналогичная запись
        UnaryOperator<Integer> getCube_1 =
                /*(Integer*/ integer /*)*/ -> integer * integer * integer;

        System.out.println(getCube_1.apply(10));

//две записи снизу индентичны
        Consumer<Object> printObject = it -> System.out.println(it);
//        Consumer<Object> printObject = System.out::println;

        printObject.accept(new Object());
    }


}
