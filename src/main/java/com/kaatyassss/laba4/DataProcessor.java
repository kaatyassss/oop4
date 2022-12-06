package com.kaatyassss.laba4;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DataProcessor<T extends Operation> {
    List<T> operations;

    public DataProcessor(List<T> operations) {
        this.operations = operations;
    }

    public List<AnotherOperation> getAnotherOperations(int from, int to) throws MyException {
        if (from > to) {
            throw new MyException("Нижняя граница больше верхней");
        }
        return operations.stream()
                .filter(operation -> operation.getTime() > from && operation.getTime() < to)
                .sorted(Comparator.comparing(Operation::getTime).reversed())
                .limit(2)
                .map(operation -> new AnotherOperation(operation.getId(), operation.getTime()))
                .toList();
    }

    public String searchTime(int currentTime) throws MyException {
        if (currentTime < 0) {
            throw new MyException("Время меньше 0");
        }
        Optional<AnotherOperation> operationOptional = operations.stream()
                .map(operation -> new AnotherOperation(operation.getId(), operation.getTime()))
                .filter(operation -> operation.getTime() == currentTime)
                .findFirst();

        if (operationOptional.isPresent()) {
            return operationOptional.get().getInfo();
        } else {
            return "Нет данных";
        }
    }

}
