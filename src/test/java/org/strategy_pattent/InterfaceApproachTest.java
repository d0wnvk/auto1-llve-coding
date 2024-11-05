package org.strategy_pattent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.strategy_pattent.A.INTERFACE_LOGIC_A;
import static org.strategy_pattent.A.INTERFACE_LOGIC_C;
import static org.strategy_pattent.B.INTERFACE_LOGIC_B;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class InterfaceApproachTest {

    @Test
    void givenAWhenProceedThenReturnA() {
        Map<String, Logic> logics = new HashMap<>();
        logics.put("A", new A());
        logics.put("B", new B());

        InterfaceApproach interfaceApproachTest = new InterfaceApproach(logics);

        String result = interfaceApproachTest.interfaceApproachTest("A");
        assertEquals(result, INTERFACE_LOGIC_A);
    }

    @Test
    void givenBWhenProceedThenReturnB() {
        Map<String, Logic> logics = new HashMap<>();
        logics.put("A", new A());
        logics.put("B", new B());

        InterfaceApproach interfaceApproach = new InterfaceApproach(logics);

        String result = interfaceApproach.interfaceApproachTest("B");
        assertEquals(result, INTERFACE_LOGIC_B);
    }

    // use lambda instead of real objects
    @Test
    void givenAAsLambdaWhenProceedThenReturnA() {
        Map<String, Logic> logics = new HashMap<>();
        logics.put("A", () -> INTERFACE_LOGIC_A);

        InterfaceApproach interfaceApproach = new InterfaceApproach(logics);

        String result = interfaceApproach.interfaceApproachTest("A");
        assertEquals(result, INTERFACE_LOGIC_A);
    }

    @Test
    void givenCasLambdaWhenProceedThenReturnC() {
        Map<String, Logic> logics = new HashMap<>();
        logics.put("C", () -> {
            System.out.println(INTERFACE_LOGIC_C);
            return INTERFACE_LOGIC_C;
        });

        InterfaceApproach interfaceApproach = new InterfaceApproach(logics);

        String result = interfaceApproach.interfaceApproachTest("C");
        assertEquals(result, INTERFACE_LOGIC_C);
    }

}
