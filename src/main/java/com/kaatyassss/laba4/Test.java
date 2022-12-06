package com.kaatyassss.laba4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static int getSumTime(List<Operation> operations) {
        int sumTime = 0;
        for (Operation operation : operations) {
            sumTime += operation.getTime();
        }
        return sumTime;
    }

    public static int getSumCost(List<Operation> operations) {
        int sumCost = 0;
        for (Operation operation : operations) {
            sumCost += operation.getCost();
        }
        return sumCost;
    }

    public static String getTimeTrace(List<Operation> operations) {
        return operations.stream()
                .map(Operation::getTime)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "{ ", " }"));
    }

    public static String getCostTrace(List<Operation> operations) {
        return operations.stream()
                .map(Operation::getCost)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "{ ", " }"));
    }

    public static List<Operation> getOperationsStat(List<Operation> operations) {
        List<Operation> uniqueOperations = new ArrayList<>();
        List<Integer> uniqueTime = operations.stream()
                .map(Operation::getTime)
                .distinct()
                .toList();

        int oldN = Operation.n;
        Operation.n = 0;
        for (Integer time : uniqueTime) {
            int sumTime = 0;
            int sumMoney = 0;
            Operation uniqueOperation;
            for (Operation operation : operations) {
                if (operation.getTime() == time) {
                    sumTime += operation.getTime();
                    sumMoney += operation.getCost();
                }
            }
            if (sumMoney == 0) {
                uniqueOperation = new FreeOperation(sumTime);
            } else {
                uniqueOperation = new Operation(sumTime, sumMoney);
            }
            uniqueOperations.add(uniqueOperation);

        }
        Operation.n = oldN;
        return uniqueOperations;
    }
}