package com.kaatyassss.laba4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {
    private List<Operation> operations = List.of(
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

    private DataProcessor<Operation> = dataProcessor
    }

    @Test
    void searchTime() {
    }
}