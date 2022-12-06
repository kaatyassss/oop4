package com.kaatyassss.laba4;

import java.util.List;
import java.util.stream.Stream;

public class TaskRunner {

    public static void main(String[] args) {

        List<Operation> operations = List.of(
                new Operation(10, 100),
                new Operation(30, 300),
                new Operation(25, 400),
                new Operation(15, 100),
                new Operation(15, 100),
                new Operation(10, 100),
                new Operation(5, 20),
                new Operation(15, 100),
                new Operation(5, 20),
                new FreeOperation(300),
                new FreeOperation(99)
        );

        List<Employee> employee = List.of(
                new Employee("Рома"),
                new Employee("Витя"),
                new Employee("Рома"),
                new Employee("Андрей"),
                new Employee("Рома"),
                new Employee("Саша"),
                new Employee("Леша"),
                new Employee("Рома"),
                new Employee("Леша"),
                new Employee("Рома"),
                new Employee("Саша")
        );

        System.out.println(Test.getSumTime(operations));
        System.out.println(Test.getSumCost(operations));

        System.out.println(Test.getTimeTrace(operations));
        System.out.println(Test.getCostTrace(operations));

        for (Operation operation : Test.getOperationsStat(operations)) {
            System.out.println(operation.getInfo());
        }

        List<Printable> entities = Stream.concat(operations.stream(), employee.stream())
                .toList();

        for (Printable entity : entities) {
            System.out.println(entity.getInfo());
        }


        DataProcessor<Operation> dataProcessor = new DataProcessor<>(operations);

        System.out.println();
        System.out.println("""
                Задание: вывести операции, где время выполнения будет больше 10, но меньше 30,
                отсортированный поуменьшению времени выполнения с максимумом в 2 элемента.
                Сделать поиск по времени выполнения.""");
        System.out.println();
        try {
            List<AnotherOperation> anotherOperations = dataProcessor.getAnotherOperations(10, 30);
            if (anotherOperations.isEmpty()) {
                System.out.println("Нет данных");
            } else {
                for (AnotherOperation anotherOperation : anotherOperations) {
                    System.out.println(anotherOperation.getInfo());
                }
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        try {
            System.out.println(dataProcessor.searchTime(25));
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}