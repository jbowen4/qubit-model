import java.util.Random;

public class Qubit {
    private float value;
    private int phase;
    Random rand = new Random();

    // DOES THE VALUE HAVE TO BE NEGATIVE AND THE PHASE ALSO BE NEGATIVE

    public Qubit()
    {
        value = 0;
        phase = 1;
    }

    public Qubit(float v)
    {
        if (v >= -1 && v <= 1) {
            this.value = Math.abs(v);
            this.phase = (v > 0) ? 1 : -1;
        } else {
            System.out.println("Invalid input. Please enter either white or black");
        }
    }

    public Qubit(String v)
    {
        if (v.equals("White")) {
            this.value = 0;
            this.phase = 1;
        } else if (v.equals("Black")) {
            this.value = 1;
            this.phase = 1;
        } else {
            System.out.println("Invalid input. Please enter either white or black");
        }
    }

    public void setValue(float v)
    {
        this.value = Math.abs(v);
        this.phase = (v > 0) ? 1 : -1;
    }

    public void setValue(String v)
    {
        if (v.equals("White")) {
            this.value = 0;
            this.phase = 1;
        } else if (v.equals("Black")) {
            this.value = 1;
            this.phase = 1;
        } else {
            System.out.println("Invalid input. Please enter either white or black");
        }
    }

    public float getValue()
    {
        return this.value;
    }

    public void setPhase(int phase)
    {
        this.phase = (phase > 0) ? 1 : -1;
    }

    public int getPhase(int phase) // DO NOT UNDERSTAND
    {
        int output = (phase > 0) ? 1 : -1;
        return output;
    }

    public void not()
    {
        this.value = 1 - this.value;
    }

    public void hgate()
    {
        float newValue =(float)((this.phase * this.value) - 0.5);
        this.phase = (newValue > 0) ? 1 : -1;
        this.value = Math.abs(newValue);
    }

    public void swap(Qubit q2)
    {
        System.out.println("method not implemented yet");
    }

    public void cnot(Qubit q2)
    {
        System.out.println("method not implemented yet");
    }

    public int measureValue()
    {
        int randint = rand.nextInt(100);

        if (randint <= (this.value * 100) && this.value != 0) {
            this.value = 1;
        } else {
            this.value = 0;
        }
        
        this.phase = 1;
        return (int)this.value;
    }

    public String toString()
    {
        return "" + value;
    }

    public static int compare (Object obj1, Object obj2)
    {
        Qubit q1 = (Qubit) obj1;
        Qubit q2 = (Qubit) obj2;

        if (((q1.getValue() - q2.getValue()) < 0.01) &&
                ((q2.getValue() - q1.getValue()) < 0.01) )
        {
            return 0;
        }
        else if (q1.getValue() > q2.getValue())
        {
            return 1;
        }
        else
        {
            return -1;
        }

    }
}
