package com.kaatyassss.laba4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {

    private DataProcessor<Operation> dataProcessor;

    @BeforeEach
    void setUp() {
        Operation.n = 0;
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

        dataProcessor = new DataProcessor<>(operations);
    }

    @Test
    void searchTime() throws MyException {
        assertEquals("Нет данных", dataProcessor.searchTime(500));

        AnotherOperation operation = new AnotherOperation(2, 30);
        assertEquals(operation.getInfo(), dataProcessor.searchTime(30));

        MyException exception = assertThrows(MyException.class, () -> dataProcessor.searchTime(-10));
        assertEquals("Время меньше 0", exception.getMessage());
    }

    @Test
    void getAnotherOperations() throws MyException {
        MyException exception = assertThrows(MyException.class, () -> dataProcessor.getAnotherOperations(30, 10));
        assertEquals("Нижняя граница больше верхней", exception.getMessage());

        List<AnotherOperation> anotherOperations = List.of(
                new AnotherOperation(3, 25),
                new AnotherOperation(4, 15));
        assertIterableEquals(anotherOperations, dataProcessor.getAnotherOperations(10, 30));
    }
}