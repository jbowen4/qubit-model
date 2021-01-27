import java.math.BigDecimal;
import java.util.Random;

public class Qubit {
    private float value;
    private int phase;
    Random rand = new Random();

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
        this.phase = (v >= 0) ? 1 : -1;
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
        return (this.value * this.phase);
    }

    public void setPhase(int phase)
    {
        this.phase = (phase > 0) ? 1 : -1;
    }

    public int getPhase()
    {
        return this.phase;
    }

    public void not()
    {
        this.value = 1 - this.value;
    }

    public void hgate()
    {
        float newValue = (float)(0.5 - (this.phase * this.value));
        this.phase = (newValue >= 0) ? 1 : -1;
        this.value = Math.abs(newValue);
    }

    public void swap(Qubit q2)
    {
        float temp = this.getValue();
        this.setValue(q2.getValue());
        q2.setValue(temp);
    }

    public void cnot(Qubit q2)
    {
        if (Math.abs(q2.getValue()) == 1){
            not();
        }
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

    public String toBraKet()
    {
        if (this.value > 0 && this.value < 1) {

            String blackAmp = String.format( "%.2f", new BigDecimal(Math.sqrt(this.value)).stripTrailingZeros());
            String whiteAmp = String.format( "%.2f", new BigDecimal(Math.sqrt(1 - this.value)).stripTrailingZeros());
            char sign = (this.phase == 1) ? '+' : '-';

            String s = whiteAmp + "|0> " + sign + " " + blackAmp + "|1>";

            return s;
        }
        else if (this.value == 0) { return "|0>"; }
        else if (this.value == 1) { return "|1>"; }
        else { return "There was an error with your qubit value. Please try again."; }
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
