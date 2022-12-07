package com.kaatyassss.laba4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestClassTest {
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

    @Test
    void getSumTime() {
        assertEquals(529, TestClass.getSumTime(operations));
    }

    @Test
    void getSumCost() {
        assertEquals(1240, TestClass.getSumCost(operations));
    }

    @Test
    void getTimeTrace() {
        assertEquals("{ 10, 30, 25, 15, 15, 10, 5, 15, 5, 300, 99 }", TestClass.getTimeTrace(operations));
    }

    @Test
    void getCostTrace() {
        assertEquals("{ 100, 300, 400, 100, 100, 100, 20, 100, 20, 0, 0 }", TestClass.getCostTrace(operations));
    }

    @Test
    void getOperationsStat() {
        List<Operation> operations = List.of(
                new Operation(20, 200),
                new Operation(30, 300),
                new Operation(25, 400),
                new Operation(45, 300),
                new Operation(10, 40),
                new FreeOperation(300),
                new FreeOperation(99));
        assertEquals(operations, TestClass.getOperationsStat(operations));
    }
}