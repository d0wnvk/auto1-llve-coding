package org.strategy_patterns;

import java.util.Map;

public class StrategyPatten {

    /**
     * Let's have a classic if- and switch-related solutions.
     * Not covered with tests.
     * */
    void ifAndSwitchCase(String text) {
        if (text.equals("A")) {
            System.out.println("if A");
        }

        if (text.equals("B")) {
            System.out.println("if B");
        }

        switch (text) {
            case "A":
                System.out.println("switch A");
                break;
            case "B":
                System.out.println("switch b");
                break;
            default:
                throw new RuntimeException("switch defaultl case");
        }
    }

}

/**
 * Now let's have an interface-related solution.
 * Covered with tests.
 * */
interface Logic {

    String process();
}

class A implements Logic {

    public static final String INTERFACE_LOGIC_A = "interface Logic: A";
    public static final String INTERFACE_LOGIC_C = "interface (lambda) Logic: C";

    @Override
    public String process() {
        System.out.println(INTERFACE_LOGIC_A);
        return INTERFACE_LOGIC_A;
    }
}

class B implements Logic {

    public static final String INTERFACE_LOGIC_B = "interface Logic: B";

    @Override
    public String process() {
        System.out.println(INTERFACE_LOGIC_B);
        return INTERFACE_LOGIC_B;
    }
}

/**
 * Main class to handle an interface-related solutions.
 * */
class InterfaceApproach {

    public Map<String, Logic> logics;

    public InterfaceApproach(Map<String, Logic> logics) {
        this.logics = logics;
    }

    public String interfaceApproachTest(String text) {
        Logic logic = logics.get(text);
        String process = logic.process();
        return process;
    }
}




