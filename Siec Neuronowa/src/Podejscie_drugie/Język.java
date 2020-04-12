package Podejscie_drugie;


import java.util.Vector;

public class Język {
    Vector<Double> WEKTOR_JEZYKA= new Vector<>();
    String NAZWA_JEZYKA;
    Double PROG_T;
    Język(String string)
    {
        this.NAZWA_JEZYKA=string;
        inicjujWektor(WEKTOR_JEZYKA);
        PROG_T=0.0;

    }
    public void inicjujWektor(Vector<Double> wektor)
    {
        for(int i=0;i<26;i++)
        {
            WEKTOR_JEZYKA.add(0.0);
        }
    }
    public String toString()
    {
        return  NAZWA_JEZYKA+"   "+WEKTOR_JEZYKA.toString()+" T: "+PROG_T;
    }
}
