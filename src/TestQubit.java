public class TestQubit
{
    /* TestsetValue
     * receives user input for testing one call of setValue
     * on a Qubit with a float input
     *
     * inputs:
     *  Qubit start - the starting state of a sprite to test on
     *  Qubit expected - the expected end state of the sprite
     *  string[] args - it contains {"float"}
     * outputs:
     *  returns 1 for success, 0 for failure
     *  also prints results to the console
     */
    public static int TestsetValueFloat(Qubit start, Qubit expected,
                                        String[] args)
    {
        float val;
        // make sure the degrees input is there
        if (args.length < 4)
        {
            System.out.println("Too few arguments for "+
                    "TestsetValueFloat: " +args.length);
            System.out.println("Missing value input");
            System.out.println("Test FAILED");
            return 0;
        }

        // read the command-line argument
        val = Float.parseFloat(args[3]);
        // perform the operation
        start.setValue(val);

        // check the result and report
        if (Qubit.compare(start, expected) == 0)
        {
            System.out.println("Qubit setValue("+val+
                    "): Success!");
            return 1;
        }
        else
        {
            System.out.println("Qubit setValue("+val+
                    "): FAIL!");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+start);
            return 0;
        }
    }

    public static int TestsetValueString(Qubit start, Qubit expected,
                                         String[] args)
    {
        String val;

        if (args.length < 4)
        {
            System.out.println("Too few arguments for "+
                    "TestsetValueString: " +args.length);
            System.out.println("Missing value input");
            System.out.println("Test FAILED");
            return 0;
        }

        val = args[3];

        start.setValue(val);

        // check the result and report
        if (Qubit.compare(start, expected) == 0)
        {
            System.out.println("Qubit setValue("+val+
                    "): Success!");
            return 1;
        }
        else
        {
            System.out.println("Qubit setValue("+val+
                    "): FAIL!");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+start);
            return 0;
        }
    }

    public static int TestgetValue(Qubit start, Qubit expected,
                                    String[] args)
    {
        float startVal, val;

        startVal = start.getValue();
        val = Integer.parseInt(args[3]);

        if (Float.compare(start.getValue(), expected.getValue()) == 0 && startVal == val)
        {
            System.out.println("Qubit setValue("+val+
                    "): Success!");
            return 1;
        }
        else
        {
            System.out.println("Qubit setValue("+val+
                    "): FAIL!");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+start);
            return 0;
        }
    }

    public static int TestStringConstructor(Qubit start, Qubit expected,
                                    String[] args)
    {
        String val;

        if (args.length < 4)
        {
            System.out.println("Too few arguments for "+
                    "TestStringConstructor: " +args.length);
            System.out.println("Missing value input");
            System.out.println("Test FAILED");
            return 0;
        }

        val = args[3];

        Qubit qubit = new Qubit(val);

        // check the result and report
        if (Qubit.compare(qubit, expected) == 0)
        {
            System.out.println("Qubit setValue("+val+
                    "): Success!");
            return 1;
        }
        else
        {
            System.out.println("Qubit setValue("+val+
                    "): FAIL!");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+start);
            return 0;
        }
    }

    public static int TestNot(Qubit start, Qubit expected)
    {
        start.not();

        if (Qubit.compare(start, expected) == 0)
        {
            System.out.println("Qubit setValue("+expected.getValue()+
                    "): Success!");
            return 1;
        }
        else
        {
            System.out.println("Qubit setValue("+expected.getValue()+
                    "): FAIL!");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+start);
            return 0;
        }
    }

    public static int TestsetPhase(Qubit start, Qubit expected,
                                   String[] args)
    {
        int val;

        if (args.length < 4)
        {
            System.out.println("Too few arguments for "+
                    "TestsetPhase: " +args.length);
            System.out.println("Missing value input");
            System.out.println("Test FAILED");
            return 0;
        }

        val = Integer.parseInt(args[3]);

        start.setPhase(val);

        if (Qubit.compare(start, expected) == 0)
        {
            System.out.println("Qubit setValue("+val+
                    "): Success!");
            return 1;
        }
        else
        {
            System.out.println("Qubit setValue("+val+
                    "): FAIL!");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+start);
            return 0;
        }
    }

    public static int TestgetPhase(Qubit start, Qubit expected,
                                   String[] args)
    {
        float startPhase, phase;

        startPhase = start.getPhase();
        phase = Integer.parseInt(args[3]);

        if (Float.compare(start.getPhase(), expected.getPhase()) == 0 && startPhase == phase)
        {
            System.out.println("Qubit setPhase("+phase+
                    "): Success!");
            return 1;
        }
        else
        {
            System.out.println("Qubit setPhase("+phase+
                    "): FAIL!");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+start);
            return 0;
        }
    }

    public static int Testhgate(Qubit start, Qubit expected)
    {
        start.hgate();

        if (Qubit.compare(start, expected) == 0)
        {
            System.out.println("Qubit setValue("+expected.getValue()+
                    "): Success!");
            return 1;
        }
        else
        {
            System.out.println("Qubit setValue("+expected.getValue()+
                    "): FAIL!");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+start);
            return 0;
        }
    }

    public static int Testswap(Qubit first, Qubit second, String[] args) {
        float firstExpect, secondExpect;

        if (args.length < 5)
        {
            System.out.println("Too few arguments for "+
                    "Testswap: " +args.length);
            System.out.println("Missing value input");
            System.out.println("Test FAILED");
            return 0;
        }

        firstExpect = Float.parseFloat(args[3]);
        secondExpect = Float.parseFloat(args[4]);

        first.swap(second);

        if (secondExpect == second.getValue() && firstExpect == first.getValue())
        {
            System.out.println("Qubit swap("+second.getValue()+", "+first.getValue()+
                    "): Success!");
            return 1;
        }
        else
        {
            System.out.println("Qubit setValue("+second.getValue()+", "+first.getValue()+
                    "): FAIL!");
            System.out.println("Expected: "+firstExpect+ ", " + secondExpect);
            System.out.println("Actual: "+first.getValue()+ ", " + second.getValue());
            return 0;
        }
    }

    public static int Testcnot(Qubit target, Qubit control, String[] args) {
        float targetExpect, controlExpect;

        if (args.length < 5)
        {
            System.out.println("Too few arguments for "+
                    "Testcnot: " +args.length);
            System.out.println("Missing value input");
            System.out.println("Test FAILED");
            return 0;
        }

        controlExpect = Float.parseFloat(args[4]);
        targetExpect = Float.parseFloat(args[3]);

        target.cnot(control);

        if (targetExpect == target.getValue() && controlExpect == control.getValue())
        {
            System.out.println("Qubit swap("+control.getValue()+", "+target.getValue()+
                    "): Success!");
            return 1;
        }
        else
        {
            System.out.println("Qubit setValue("+control.getValue()+", "+target.getValue()+
                    "): FAIL!");
            System.out.println("Expected: "+controlExpect+ ", " + targetExpect);
            System.out.println("Actual: "+control.getValue()+ ", " + target.getValue());
            return 0;
        }
    }

    public static int Testmeasure() {
        return 1;
    }

    public static String TesttoBraKet(Qubit start) {
        String brakNotation = start.toBraKet();

        System.out.println(brakNotation);
        return brakNotation;
    }

    public static void main(String[] args)
    {
        int testNumber = 2;
        Qubit testQubit = new Qubit();
        Qubit expectedQubit = new Qubit();
        // make sure there are enough arguments
        if (args.length < 3)
        {
            System.out.println("Too few arguments: "+args.length);
            System.out.println("Usage: TestQubit.exe start_state "
                    +"expected_end_state testNumber inputs "
                    +"expected_ret_val");
            System.exit(0);
        }

        // get the starting state, ending state, and test number
        testQubit.setValue( Float.parseFloat(args[0]));
        expectedQubit.setValue( Float.parseFloat(args[1]));
        testNumber = Integer.parseInt(args[2]);

        // use the testnumber to choose a test function
        switch (testNumber)
        {
            case (0):
                TestStringConstructor(testQubit, expectedQubit, args);
                break;
            case (1):
                TestsetValueFloat(testQubit, expectedQubit, args);
                break;
            case (2):
                TestsetValueString(testQubit, expectedQubit, args);
                break;
            case (3):
                TestgetValue(testQubit, expectedQubit, args);
                break;
            case (4):
                TestNot(testQubit, expectedQubit);
                break;
            case (5):
                TestsetPhase(testQubit, expectedQubit, args);
            case (6):
                TestgetPhase(testQubit, expectedQubit, args);
            case (7):
                Testhgate(testQubit, expectedQubit);
            case (8):
                Testswap(testQubit, expectedQubit, args);
            case (9):
                Testcnot(testQubit, expectedQubit, args);
            case (10):
                Testmeasure();
            case (11):
                TesttoBraKet(testQubit);
            default:
                System.out.println("Test " + testNumber + " not supported");
        }
    }
}